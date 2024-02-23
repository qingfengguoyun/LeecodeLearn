package com.myProject11_24.service;

import com.myProject11_24.annotations.MyAnnotation1;
import com.myProject11_24.entity.Connector;
import com.myProject11_24.mapper.ConnectorMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ConnectorServiceImpl implements ConnectorService {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class TermIns{
        Integer Id;
        String insName;
    }

    @Autowired
    ConnectorMapper connectorMapper;

    @Override
    public Integer insertConnector() {
        List<Connector> connecotrs=new LinkedList<>();
        for(int i=0;i<3;i++){
            Connector build = Connector.builder().connectorName("connector" + i).connectorDesc("desc" + i).build();
            connectorMapper.insertConnector(build);
            connecotrs.add(build);
        }
        return 1;
    }

    @MyAnnotation1
    public List<Long> testService(){
        LinkedList<Long> longs = new LinkedList<Long>() {{
            add(1L);
        }};
        return longs;
    }
}
