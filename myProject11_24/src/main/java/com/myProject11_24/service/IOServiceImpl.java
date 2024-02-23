package com.myProject11_24.service;

import com.myProject11_24.entity.Connector;
import com.myProject11_24.entity.Pin;
import com.myProject11_24.models.pojo.ConnectorRecordPojo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class IOServiceImpl implements IOService {


    @Override
    public void outPutTest() {
        ConnectorRecordPojo connectorRecordPojo=new ConnectorRecordPojo();
        Connector connector=Connector.builder().connectorName("连接器1").connectorDesc("连接器描述1").build();
        connectorRecordPojo.setConnector(connector);
        List<Pin> pins=new LinkedList<>();
        for(int i=0;i<3;i++){
            Pin p = Pin.builder().pinName("针脚" + i).pinDesc("针脚描述" + i).build();
            pins.add(p);
        }
        connectorRecordPojo.setPins(pins);




    }

    public ConnectorRecordPojo getTestPojo(){
        ConnectorRecordPojo connectorRecordPojo=new ConnectorRecordPojo();
        Connector connector=Connector.builder().connectorName("连接器1").connectorDesc("连接器描述1").build();
        connectorRecordPojo.setConnector(connector);
        List<Pin> pins=new LinkedList<>();
        for(int i=0;i<3;i++){
            Pin p = Pin.builder().pinName("针脚" + i).pinDesc("针脚描述" + i).build();
            pins.add(p);
        }
        connectorRecordPojo.setPins(pins);
        return connectorRecordPojo;
    }

    public void exportExcel(){
        XSSFWorkbook workbook =new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sheet1");
        ConnectorRecordPojo pojo = getTestPojo();

        setData(sheet,0,0,3,pojo.getPins(),Pin.class);

        String storagePath="out/";
        File storage=new File(storagePath);
        storage.mkdir();
        if(storage.isDirectory()&&!storage.exists()){
            storage.mkdir();
        }
        try {
            File file=new File(storagePath+"/test.xlsx");
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fileOut=new FileOutputStream(file);
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setData(XSSFSheet sheet,Integer startRow,Integer startColumn,List datas,Class classa){
        Integer rowNum=startRow;
        for(Object obj:datas){

            XSSFRow row=null;
            if(ObjectUtils.isEmpty(row=sheet.getRow(rowNum))){
                row=sheet.createRow(rowNum);
            }
            rowNum+=1;

            Integer columnNum=startColumn;
            Field[] fields = classa.getDeclaredFields();
            for(Field field:fields){
                field.setAccessible(true);
                XSSFCell cell=null;
                if(ObjectUtils.isEmpty(cell=row.getCell(columnNum))){
                    cell=row.createCell(columnNum);
                }
                try {
                    if(!ObjectUtils.isEmpty(field.get(obj))){
                        cell.setCellValue(field.get(obj).toString());
                    }
                    log.info(field.getName());

                } catch (Exception e) {
                }
                columnNum+=1;
            }
        }
    }

    public void setData(XSSFSheet sheet,Integer startRow,Integer startColumn,Integer rowHeight,List datas,Class classa){
        Integer rowNum=startRow;


        for(Object obj:datas){

            XSSFRow row=null;
            if(ObjectUtils.isEmpty(row=sheet.getRow(rowNum))){
                row=sheet.createRow(rowNum);
            }
            CellRangeAddress region=new CellRangeAddress(rowNum,rowNum+rowHeight,startColumn+1,startColumn+1);
            sheet.addMergedRegion(region);
            rowNum+=rowHeight+1;


            Integer columnNum=startColumn;
            Field[] fields = classa.getDeclaredFields();
            for(Field field:fields){
                field.setAccessible(true);
                XSSFCell cell=null;
                if(ObjectUtils.isEmpty(cell=row.getCell(columnNum))){
                    cell=row.createCell(columnNum);
                }
                try {
                    if(!ObjectUtils.isEmpty(field.get(obj))){
                        cell.setCellValue(field.get(obj).toString());
                    }
                    log.info(field.getName());

                } catch (Exception e) {
                }
                columnNum+=1;
            }

        }
    }
}
