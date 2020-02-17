package com.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Formatters.Enums.IntegerFormat;
import Formatters.IntegerFormatter;
import Formatters.IntegerList;

@RestController
public class IntegerFormatterController {
//    @RequestMapping("/")
//    public @ResponseBody String

    @PostMapping("/format")
    public String[][] format(
            @RequestBody IntegerList[] integerLists) {
        IntegerFormat format;
        int[] unformattedList;
        String[] formattedList;
        String[][] formattedLists = new String[integerLists.length][];

        for(int j = 0; j < integerLists.length; j++) {
            format = integerLists[j].getFormat();
            unformattedList = integerLists[j].getUnformattedList();
            formattedList = new String[unformattedList.length];

            for (int i = 0; i < unformattedList.length; i++) {
                formattedList[i] = IntegerFormatter.format(unformattedList[i], format);
            }

            formattedLists[j] = formattedList;
        }

        return formattedLists;
    }
}
