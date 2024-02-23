package com.myProject11_24.controller;

import com.myProject11_24.entity.Connector;
import com.myProject11_24.service.ConnectorService;
import com.myProject11_24.service.IOService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.MyResult;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/connector")
public class ConncetorController {


    @Autowired
    ConnectorService connectorService;

    @Autowired
    IOService ioService;


    @GetMapping("/insertTest")
    public MyResult insertConnector(){
        connectorService.insertConnector();
        return MyResult.success("");
    }

    @GetMapping("/aopTest")
    public MyResult aopTest(){
        List<Long> longs = connectorService.testService();
        return MyResult.success(longs);
    }

    @GetMapping("/exportTest")
    public MyResult exportExcelTest(){
        ioService.exportExcel();
        return MyResult.success("");
    }
}
