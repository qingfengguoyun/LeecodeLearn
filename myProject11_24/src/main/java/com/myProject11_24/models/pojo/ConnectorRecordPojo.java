package com.myProject11_24.models.pojo;

import com.myProject11_24.entity.Connector;
import com.myProject11_24.entity.Pin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConnectorRecordPojo {

    Connector connector;
    List<Pin>  pins;
}
