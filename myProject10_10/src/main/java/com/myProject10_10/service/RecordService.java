package com.myProject10_10.service;

import com.myProject10_10.dao.RecordMapper;
import com.myProject10_10.dao.RecordMapper2;
import com.myProject10_10.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    RecordMapper2 recordMapper2;

    @Autowired
    RecordMapper recordMapper;

    public Integer insertRecord(Record record){
        return recordMapper.insert(record);
    }

    public Integer insertRecordInBatch(List<Record> records){
        return recordMapper2.insertRecordsInBatch(records);
    }
}
