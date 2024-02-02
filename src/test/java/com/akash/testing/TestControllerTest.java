package com.akash.testing;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    ObjectMapper objectMapper; /* This ObjectMapper object is used to convert the pojo's to JSON using jackson.
    But here its use with the configuration spring does. It can configure manually also.*/

    @MockBean
    private TestService testService;

    private  TestService testServiceObj ;

    @BeforeEach
    void beforeEachTest(){
        testServiceObj = new TestService();
    }

    @Test
    void getNameWithWish() throws Exception {
        mockMvc.perform(get("/api/v1/test/getNameWithWish/"+"Akash")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void getNameWithWishAndAlsoCheckTheContentType() throws Exception {

        String name = "Akash";
        given(testService.getNameWithWish(any(String.class))).willReturn("Hello "+ name);

        mockMvc.perform(get("/api/v1/test/getNameWithWish/"+name)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getNameWithWishAndAssertTheValueGettingFromController() throws Exception {

        String name = "Akash";
        given(testService.getNameWithWish(name)).willReturn("Hello "+ name);

        mockMvc.perform(get("/api/v1/test/getNameWithWish/"+name)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",is("Hello "+name)));
    }


    @Test
    void saveNameTest() throws Exception {

        String name = testServiceObj.getArrayList().get(2);
        given(testService.saveString(name)).willReturn(name);

        mockMvc.perform(post("/api/v1/test/saveName")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(name)))
                .andExpect(status().isCreated());
    }





}
