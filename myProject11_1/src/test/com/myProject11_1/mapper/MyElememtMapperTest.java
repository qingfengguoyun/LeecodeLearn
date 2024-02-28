package com.myProject11_1.mapper;

import com.myProject11_1.entity.MyElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyElememtMapperTest {

    @Autowired
    MyElememtMapper myElememtMapper;

    @Test
    public void insertTest(){
        MyElement myElement = MyElement.builder().elementName("qwe").build();
        myElememtMapper.insert(myElement);
        System.out.println(myElement.getId());
//        myElememtMapper.insert();
    }

    @Test
    public void insertTest2(){
        MyElement myElement = MyElement.builder().elementName("qwe2").build();
        myElememtMapper.insertMyElement(myElement);
        System.out.println(myElement.getId());
//        myElememtMapper.insert();
    }
}