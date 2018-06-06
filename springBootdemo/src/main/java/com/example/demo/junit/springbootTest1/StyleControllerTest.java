//package com.example.demo.junit.springbootTest1;
//
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.example.demo.AppleApplication;
//import com.fasterxml.jackson.databind.ObjectMapper;
///*
// * 单元测试：教程https://blog.csdn.net/sosfnima/article/details/51993700
//*/
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = AppleApplication.class)//这里的Application是springboot的启动类名
//@WebAppConfiguration
//public class StyleControllerTest {
//
//    @Autowired
//    private WebApplicationContext context;//启动web容器
//
//    private MockMvc mockMvc;
//
//    private ObjectMapper mapper = new ObjectMapper();
//    
//    @Autowired  
//    private TestServices testServices;  
//
//    @Before
//    public void setupMockMvc() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Test
//    public void testSend() throws Exception {
//        Long id =1l;
//        //调用接口，传入添加的用户参数
//   /*     mockMvc.perform(MockMvcRequestBuilders.get("/style/listStyleById")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(mapper.writeValueAsString(id)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andDo(MockMvcResultHandlers.print());*/
//
//    }
//
//}