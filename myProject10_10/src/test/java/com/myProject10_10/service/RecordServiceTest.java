package com.myProject10_10.service;

import com.baomidou.mybatisplus.annotation.TableField;
import com.myProject10_10.dao.RecordMapper;
import com.myProject10_10.dao.RecordMapper2;
import com.myProject10_10.entity.Record;
import com.myProject10_10.models.dto.RecordDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordServiceTest {

    @Autowired
    RecordService recordService;

    @Autowired
    RecordMapper recordMapper;

    @Autowired
    RecordMapper2 recordMapper2;

    @Test
    public void insertRecord() {
        Record record=Record.builder().name("123").tag(0).build();
        recordService.insertRecord(record);
        System.out.println(record.getId());

        //和hibernate不同，mybatisPlus对一个对象插入后，其主键值被填充。再次插入时不执行update而会报错
//        record.setName("234");
//        recordService.insertRecord(record);
//        System.out.println(record.getId());
    }

    @Test
    public void dtoQuery(){
        Record record=Record.builder().name("asd").tag(2).build();
        recordMapper.insert(record);
        RecordDto result=recordMapper.selectRecordDto(record);
        System.out.println(result);
    }


    @Test
    public void insertRecordsInBatch(){
        List<Record> records=new LinkedList<Record>(){{
            add(Record.builder().name("zxc").tag(3).id(5L).build());
            add(Record.builder().name("fff").tag(2).id(6L).build());
            add(Record.builder().name("zvcx").tag(1).id(7L).build());
        }};
        recordMapper2.insertRecordsInBatch(records);
        for(Record record:records){
            System.out.println(record.getId());
        }
    }

    @Test
    public void selectAll2(){
        List<Record>records=recordMapper2.selectALL();
        for(Record record:records){
            System.out.println(record);
        }
    }
}