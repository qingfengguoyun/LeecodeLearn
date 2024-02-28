package com.myProject10_10.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myProject10_10.entity.Record;
import com.myProject10_10.models.dto.RecordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface RecordMapper2 extends BaseMapper<Record> {


    public Integer insertRecordsInBatch(List<Record> records);

    public List<Record> selectALL();

}
