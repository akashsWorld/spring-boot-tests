package com.akash.testing;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping(value = "api/v1/test")
@RequiredArgsConstructor
public class TestController {


    private final TestService testService;

    @GetMapping("getNameWithWish/{name}")
    public String getNameWithWish(@PathVariable String name){
        return testService.getNameWithWish(name);
    }

    @PostMapping("saveName")
    public ResponseEntity<String> saveName(@RequestBody String str){
        return ResponseEntity.status(HttpStatus.CREATED).body(testService.saveString(str));
    }

    @PutMapping("updateName/{id}")
    public ResponseEntity updateName(@RequestBody String name, @PathVariable Integer id){
        testService.updateName(name,id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("deleteName/{id}")
    public ResponseEntity updateName(@PathVariable Integer id){
        testService.deleteName(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
