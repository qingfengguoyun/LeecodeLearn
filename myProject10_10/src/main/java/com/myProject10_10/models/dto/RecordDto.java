package com.myProject10_10.models.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.persistence.Column;

@Data
public class RecordDto {

    private Long id;

    private String name;

    private String name2;

    private Integer tag;


}
