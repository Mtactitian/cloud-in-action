package com.alexb.auth.model;

import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_client")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "secret")
    private String secret;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Role> roles = new ArrayList<>();

    @Transient
    private String scopes = StringUtils.arrayToCommaDelimitedString(new String[]{"openid"});

    @Transient
    private String authorizedGrantTypes = "authorization_code,refresh_token,password";

    @Transient
    private String autoApproveScopes = "*.";

}
