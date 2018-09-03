package com.alexb.auth.config;

import com.alexb.auth.model.Role;
import com.alexb.auth.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class ClientConfiguration {

    private final LoadBalancerClient loadBalancerClient;

    @Bean
    public ClientDetailsService clientDetailsService(ClientRepository clientRepository) {
        return clientId -> clientRepository
                .findByClientId(clientId)
                .map(client -> {
                            BaseClientDetails baseClientDetails = new BaseClientDetails(client.getClientId(),
                                    null,
                                    client.getScopes(),
                                    client.getAuthorizedGrantTypes(),
                                    client.getRoles().stream().map(Role::getRole).collect(Collectors.joining(",")));
                            baseClientDetails.setClientSecret(client.getSecret());

                            String greetingsClientRedirectUri = Optional
                                    .ofNullable(this.loadBalancerClient.choose("greetings-client"))
                                    .map(si -> "http://" + si.getHost() + ':' + si.getPort() + '/')
                                    .orElseThrow(() -> new ClientRegistrationException(
                                            "couldn't find and bind a greetings-client IP"));
                            baseClientDetails.setRegisteredRedirectUri(Collections
                                    .singleton(greetingsClientRedirectUri));
                            return baseClientDetails;
                        }
                )
                .orElseThrow(() -> new ClientRegistrationException((String.format(
                        "no client %s registered", clientId))));
    }
}
