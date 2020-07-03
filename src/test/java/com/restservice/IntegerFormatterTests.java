package com.restservice;

import java.util.ArrayList;
import java.util.List;

import Formatters.Enums.IntegerFormat;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import Formatters.IntegerList;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class IntegerFormatterTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void convertNumberMoreThanOneThousand() {
        String resourceUrl = "http://localhost:" + port + "/format";
        List<List<String>> responseList;
        List<String> numbersList;

        List<Integer> numbers = new ArrayList();
        numbers.add(3450);
        numbers.add(1000);
        numbers.add(534435);
        numbers.add(42345);
        IntegerList integerList = new IntegerList(IntegerFormat.COMMA, numbers);
        List<IntegerList> integerLists = new ArrayList();
        integerLists.add(integerList);

        responseList = this.restTemplate.postForObject(resourceUrl, integerLists, List.class);
        Assert.assertTrue(responseList.size() == 1);

        numbersList = responseList.get(0);
        Assert.assertTrue(numbersList.size() == 4);

        Assert.assertTrue(numbersList.contains("3,450"));
        Assert.assertTrue(numbersList.contains("1,000"));
        Assert.assertTrue(numbersList.contains("534,435"));
        Assert.assertTrue(numbersList.contains("42,345"));
    }

    private boolean findValue(List<String> formattedLIst, String stringValue) {
        for(String currentValue : formattedLIst) {
            if(stringValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }
}
