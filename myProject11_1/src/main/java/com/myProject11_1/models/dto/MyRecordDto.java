package com.myProject11_1.models.dto;

import com.myProject11_1.entity.MyRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyRecordDto extends MyRecord {

    private Long id;

    private String data;

    private Long parentId;

    private List<MyRecord> childs;

}
