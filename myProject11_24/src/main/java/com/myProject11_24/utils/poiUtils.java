package com.myProject11_24.utils;

import lombok.Data;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.List;

public class poiUtils {

    @Data
    public class SetDataParam{
        XSSFSheet sheet;
        Integer startRow;
        Integer startColumn;
    }

    public void setData(XSSFSheet sheet, Integer startRow, Integer startColumn, List datas, Class classa){
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
                } catch (Exception e) { }
                columnNum+=1;
            }
        }
    }

    public void setData(SetDataParam param ,List datas, Class classa){
        XSSFSheet sheet=param.getSheet();
        Integer startRow=param.getStartRow();
        Integer startColumn=param.getStartColumn();
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
                } catch (Exception e) { }
                columnNum+=1;
            }
        }
    }
}
