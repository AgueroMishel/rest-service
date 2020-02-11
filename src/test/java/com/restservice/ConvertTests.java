package com.restservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class ConvertTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void convertNumberMoreThanOneThousand() {
        Convert convert;

        int firstNumber = 3450;
        convert = this.restTemplate.getForObject("http://localhost:" + port + "/convert?integer=" + firstNumber,
                Convert.class);
        assertThat(convert.getStringNumber().contains("3,450"));

        int secondNumber = 1000;
        convert = this.restTemplate.getForObject("http://localhost:" + port + "/convert?integer=" + secondNumber,
                Convert.class);
        assertThat(convert.getStringNumber().contains("1,000"));

        int thirdNumber = 534435;
        convert = this.restTemplate.getForObject("http://localhost:" + port + "/convert?integer=" + thirdNumber,
                Convert.class);
        assertThat(convert.getStringNumber().contains("534,435"));

        int fourthNumber = 42345;
        convert = this.restTemplate.getForObject("http://localhost:" + port + "/convert?integer=" + fourthNumber,
                Convert.class);
        assertThat(convert.getStringNumber().contains("42,345"));
    }

}
