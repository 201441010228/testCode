package com.insertUserAndPower;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Auther: 张扬
 * @Date: 2018/11/13 10:35
 * @Description:
 */
public class InsertDept {

    private static int initPeopleId = 1190;
    private static int initPeopleId_ref = 1190;

    public static void main(String args[]) throws Exception {

        File file = new File("E:\\aaa.xlsx");
        boolean flag = false;
        InputStream iStream = new FileInputStream(file.getPath());
        XSSFWorkbook workbook = new XSSFWorkbook(iStream);
        Map map = POIUtil.readExcel(file);
        List<Map<String,String>>  sourceData = (List<Map<String, String>>) map.get("工作表4");
        //遍历数据
        for (Map<String,String> mapIterator:sourceData) {

            if (mapIterator.get("邮箱").indexOf("@") == -1) {
                continue;
            }
            //(`id`,`account`,`password`,`name`,`mobile`,`address`,"
            //                                         + "`mail`,`type`,`state`,`insert_time`)
            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("insert into  `bdp_user_1113`("+"id,account,name,mobile,mail,type,state,insert_time)"
//                                         + "VALUES");
//            stringBuilder.append("(" + initPeopleId + ",");
//            stringBuilder.append("'" + mapIterator.get("账号") + "',");
//            stringBuilder.append("'" + mapIterator.get("姓名") + "',");
//            stringBuilder.append("'" + mapIterator.get("电话") + "',");
//            stringBuilder.append("'" + mapIterator.get("邮箱") + "',");
//            stringBuilder.append(2 + ",");
//            stringBuilder.append(1 + ",");
//            stringBuilder.append("now());");
//            stringBuilder.append("update bdp_user_dept_rel set dept_id = ");
//            stringBuilder.append("(" + initPeopleId + ",");
//            stringBuilder.append("(select id from bdp_department where driver_team_id = "+mapIterator.get("车队id")+") "
//                                         + "where user_id  = "+initPeopleId+";");
//            stringBuilder.append("1);");
//            stringBuilder.append("update into  `bdp_user_role_rel_1113`(user_id,role_id) VALUES");
//            stringBuilder.append("(" + initPeopleId + ",");
//            stringBuilder.append(64+");");
//            stringBuilder.append("insert into  `bdp_user_module_rel`(user_id,module_id) VALUES");
//            stringBuilder.append("(" + initPeopleId + ",");
//            stringBuilder.append(3+");");
            initPeopleId++;
            System.out.println(stringBuilder.toString());
        }

        Thread.sleep(2000);

    }

}
