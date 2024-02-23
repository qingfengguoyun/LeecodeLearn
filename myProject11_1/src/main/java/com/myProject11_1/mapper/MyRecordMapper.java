package com.myProject11_1.mapper;

import com.myProject11_1.entity.MyRecord;
import com.myProject11_1.models.dto.MyRecordDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyRecordMapper {

    public Integer insertMyRecord(MyRecord myRecord);

    public List<MyRecordDto> getChildLayer(Long id);

    public MyRecordDto getTree(Long id);
}
