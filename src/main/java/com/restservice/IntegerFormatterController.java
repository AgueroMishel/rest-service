package com.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Formatters.Enums.IntegerFormat;
import Formatters.IntegerFormatter;
import Formatters.IntegerList;

@RestController
public class IntegerFormatterController {
    @PostMapping("/format")
    public List<List<String>> format(
            @RequestBody List<IntegerList> integerLists) {
        IntegerFormat format;
        List<Integer> unformattedList;
        List<String> formattedList;
        List<List<String>> formattedLists = new ArrayList<>();


        for(IntegerList currentIntegerList : integerLists) {
            format = currentIntegerList.getFormat();
            unformattedList = currentIntegerList.getUnformattedList();
            formattedList = new ArrayList<>();

            for(int currentInteger : unformattedList) {
                formattedList.add(IntegerFormatter.format(currentInteger, format));
            }

            formattedLists.add(formattedList);
        }

        return formattedLists;
    }
}
