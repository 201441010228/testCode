package com.insertUserAndPower;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Auther: 张扬
 * @Date: 2018/11/13 15:25
 * @Description:
 */
public class ReRecoder {


    public static  void  main(String args[]) throws Exception {

        File file = new File("E:\\aaa.xlsx");
        boolean flag = false;
        InputStream iStream = new FileInputStream(file.getPath());
        XSSFWorkbook workbook = new XSSFWorkbook(iStream);
        Map map = POIUtil.readExcel(file);
//        List<Map<String,String>> repeatMap = map.
        List<Map<String,String>> sourceData = (List<Map<String, String>>) map.get("repeatMap");
        StringBuilder stringBuilder1 = new StringBuilder();
        for (Map<String,String> map1:sourceData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into bdp_user_dept_rel(user_id,dept_id,type)");
            stringBuilder.append("select u.id,d.id,1 from bdp_user u,bdp_department d where u.account = "
                                         + "'"+map1.get("账号")+"'and d.driver_team_id= "+map1.get("车队id")+";");
//            stringBuilder.append("("+"(select id from bdp_user where account = '"+map1.get("账号")+"'),"
//           +"(select id from bdp_department where driver_team_id = "+map1.get("车队id")+")"+",1);");

            stringBuilder1.append("'"+map1.get("账号")+"',");
        }
        System.out.println(stringBuilder1.toString());

    }


}
