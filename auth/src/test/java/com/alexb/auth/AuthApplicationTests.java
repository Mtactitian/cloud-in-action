package com.alexb.auth;

import com.alexb.auth.model.Client;
import com.alexb.auth.repository.ClientRepository;
import org.assertj.core.api.Condition;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=local")
@DataJpaTest(excludeAutoConfiguration = AutoConfigureTestDatabase.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthApplicationTests {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @Ignore
    public void contextLoads() {

        Client client = new Client();
        client.setClientId("CLIENT");

        testEntityManager.persistAndFlush(client);

        testEntityManager.clear();

        assertThat(clientRepository.findByClientId("CLIENT"))
                .isNotEmpty()
                .get()
                .has(new Condition<>(cl -> cl.getClientId().equals("CLIENT"), null));
    }

}
