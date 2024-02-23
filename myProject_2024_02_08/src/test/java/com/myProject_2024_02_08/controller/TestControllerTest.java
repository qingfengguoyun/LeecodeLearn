package com.myProject_2024_02_08.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class TestControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Before
    public void setup() {
        // 实例化方式一
//		mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
        // 实例化方式二
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Autowired
    TestController testController;

    @Test
    public void test1() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/test/user")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print());
    }
}