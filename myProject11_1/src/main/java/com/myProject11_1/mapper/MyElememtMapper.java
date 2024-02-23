package com.myProject11_1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myProject11_1.entity.MyElement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyElememtMapper extends BaseMapper<MyElement> {

    public Integer insertMyElement(MyElement myElement);


}
