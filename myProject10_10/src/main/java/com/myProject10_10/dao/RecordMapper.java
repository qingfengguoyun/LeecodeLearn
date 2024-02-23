package com.myProject10_10.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myProject10_10.entity.Record;
import com.myProject10_10.entity.User;
import com.myProject10_10.models.dto.RecordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecordMapper extends BaseMapper<Record> {


    @Select("select t.id as id ,t.name as name,t.name as name2,t.tag as tag from record t where t.id=#{id}")
    public RecordDto selectRecordDto(Record record);

//    public Integer insertRecordsInBatch(List<Record> records);
//
//    public List<Record> selectALL();

}
