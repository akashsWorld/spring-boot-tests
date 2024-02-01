package com.akash.testing;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String getNameWithWish(String name) {
        return "Hello "+name;
    }
}
