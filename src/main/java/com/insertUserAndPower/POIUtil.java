package com.insertUserAndPower;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excel读写工具类 */
public class POIUtil {

    public static Map<String,List<String>> readExcel(File file) throws Exception {
        Map returnMap = new HashMap();
        List<Map<String,String>> repeatMapList = new ArrayList<>();
        Map<String,String> reduceMap = new HashMap<>();
        InputStream iStream = new FileInputStream(file.getPath());
        XSSFWorkbook workbook = new XSSFWorkbook(iStream);
        for (Sheet xssfSheet : workbook) {
            if (xssfSheet == null || !"工作表4".equals(xssfSheet.getSheetName())) {
                continue;
            }
            Row titleRow = xssfSheet.getRow(0);
            List rowList = new ArrayList();
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                Map infoMap = new HashMap<String,String>();
                Row row = xssfSheet.getRow(rowNum);
                if (reduceMap.get(row.getCell(1).getStringCellValue())!=null){
                    Map map = new HashMap();
                    for (int clo = 0; clo <= row.getLastCellNum(); clo++) {
                        Cell cell2 = row.getCell(clo); // 获取指定列
                        if (cell2==null){
                            continue;
                        }
                        cell2.setCellType(CellType.STRING);
                        String value = cell2.getStringCellValue();
                        if(null == value || "".equals(value)){
                            continue;
                        }
                        map.put(titleRow.getCell(clo).getStringCellValue(),value);
                    }
                    repeatMapList.add(map);
                    continue;
                }
                reduceMap.put(row.getCell(1).getStringCellValue(),"");
                for (int clo = 0; clo <= row.getLastCellNum(); clo++) {
                    Cell cell2 = row.getCell(clo); // 获取指定列
                    if (cell2==null){
                        continue;
                    }
                    cell2.setCellType(CellType.STRING);
                    String value = cell2.getStringCellValue();
                    if(null == value || "".equals(value)){
                       continue;
                    }
                    infoMap.put(titleRow.getCell(clo).getStringCellValue(),value);
                }
                rowList.add(infoMap);
            }
            returnMap.put(xssfSheet.getSheetName(),rowList);
        }
        returnMap.put("repeatMap",repeatMapList);
        return  returnMap;
    }
}