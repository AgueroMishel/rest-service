package com.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    @GetMapping("/convert")
    public Convert convert(
            @RequestParam(value="integer") int number) {
        return new Convert(number);
    }
}
