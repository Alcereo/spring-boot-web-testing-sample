package ru.alcereo.integr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.alcereo.app.Application;
import ru.alcereo.app.DataKeeper;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by alcereo on 06.01.18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {Application.class, InterfaceClassTest.TestConfigClass.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
public class InterfaceClassTest {

    @TestConfiguration
    static class TestConfigClass {
        @Bean
        public InterfaceClass interServ(@Autowired TestRestTemplate restTemplate){
            return new InterfaceClass(restTemplate.getRestTemplate(),"");
        }
    }

    @MockBean
    DataKeeper dataKeeper;

    @Autowired
    private InterfaceClass interServ;

    @Test
    public void makeTestRequest(){
        when(dataKeeper.getData()).thenReturn("OK");

        String testString = interServ.getTestString();

        assertEquals(
                "OK",
                testString
        );
    }
}
