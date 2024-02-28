package com.myProject11_24.mapper;

import com.myProject11_24.entity.Connector;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConnectorMapper {

    public Integer insertConnector(Connector con);
}
