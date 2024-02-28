package com.myProject10_10.controller;

import com.myProject10_10.dao.RecordMapper;
import com.myProject10_10.dao.RecordMapper2;
import com.myProject10_10.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/record")
public class RecordController {
    @Autowired
    RecordMapper2 recordMapper2;

    @GetMapping("/selectAll")
    public void selectAll(){
        List<Record> records=recordMapper2.selectALL();
        for(Record record:records){
            System.out.println(record);
        }
    }
}
