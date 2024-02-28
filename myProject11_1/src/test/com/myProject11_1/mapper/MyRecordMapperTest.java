package com.myProject11_1.mapper;

import com.myProject11_1.entity.MyRecord;
import com.myProject11_1.models.dto.MyRecordDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyRecordMapperTest {

    @Autowired
    MyRecordMapper myRecordMapper;

    @Test
    public  void initTree(){
        MyRecord root=MyRecord.builder().data("根节点").build();
        myRecordMapper.insertMyRecord(root);
        Long rootId=root.getId();
        MyRecord record1_1=MyRecord.builder().data("1_1").parentId(rootId).build();
        MyRecord record1_2=MyRecord.builder().data("1_2").parentId(rootId).build();
        MyRecord record1_3=MyRecord.builder().data("1_3").parentId(rootId).build();
        myRecordMapper.insertMyRecord(record1_1);
        myRecordMapper.insertMyRecord(record1_2);
        myRecordMapper.insertMyRecord(record1_3);
        Long record1_1_Id=record1_1.getId();
        MyRecord record2_1=MyRecord.builder().data("2_1").parentId(record1_1_Id).build();
        MyRecord record2_2=MyRecord.builder().data("2_2").parentId(record1_1_Id).build();
        myRecordMapper.insertMyRecord(record2_1);
        myRecordMapper.insertMyRecord(record2_2);

    }

    @Test
    public void queryMyRecordDto(){
        Long id=1L;
        List<MyRecordDto> myRecordDto = myRecordMapper.getChildLayer(id);
        myRecordDto.stream().forEach(t-> System.out.println(t));
    }

    @Test
    public void getTree(){
        Long id=1L;
        MyRecordDto myRecordDto = myRecordMapper.getTree(id);
        System.out.println(myRecordDto);
    }

}