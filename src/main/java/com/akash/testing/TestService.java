package com.akash.testing;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class TestService {

    ArrayList<String> arrayList = new ArrayList<>(List.of("Akash","Anisha","Guru","Nelson"));
    public String saveString(String string){
        arrayList.add(string);
        return string;
    }

    public String getNameWithWish(String name) {
        return "Hello "+name;
    }

    public void updateName(String name, Integer id) {
        arrayList.set(id,name);
    }

    public void deleteName(Integer id) {
        arrayList.remove(id);
    }
}
