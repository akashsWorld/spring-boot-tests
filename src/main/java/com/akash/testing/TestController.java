package com.akash.testing;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/test")
@RequiredArgsConstructor
public class TestController {




    private final TestService testService;


    @GetMapping("getNameWithWish/{name}")
    public String getNameWithWish(@PathVariable String name){
        return testService.getNameWithWish(name);
    }

}
