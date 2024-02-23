package com.models.mapStruct;

import com.models.vo.UserVo;
import com.myProject_2024_02_08.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapConstructMappper {

    MapConstructMappper INSTANCE = Mappers.getMapper(MapConstructMappper.class);

    UserVo toUserVo(User user);
}
