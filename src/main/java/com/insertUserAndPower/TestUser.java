package com.insertUserAndPower;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Auther: 张扬
 * @Date: 2018/9/4 10:41
 * @Description:
 */
public class TestUser {

    private static int initPeopleId = 1133;
    private static int initPeopleId_ref = 1133;

    public static void main(String args[]) throws Exception {
        File file = new File("E:\\aaa.xlsx");
        boolean flag = false;
        InputStream iStream = new FileInputStream(file.getPath());
        XSSFWorkbook workbook = new XSSFWorkbook(iStream);
        Map map = POIUtil.readExcel(file);
        for (Sheet xssfSheet : workbook) {
            if (xssfSheet == null) {
                continue;
            }
            if (flag) {
                continue;
            }
            flag = true;
            List<Map<String, String>> list = (List<Map<String, String>>) map.get("车队长权限");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("INSERT INTO `bdp_user_112` (`id`,`account`,`password`,`name`,`mobile`,"
                                        + "`address`,`mail`,`type`,`state`,`insert_time`) VALUES ");
            for (Map<String, String> m : list) {
                if (m.get("邮箱").indexOf("@") == -1) {
                    continue;
                }
                stringBuffer.append("('" + initPeopleId + "',");
                stringBuffer.append("'" + m.get("邮箱").substring(0, m.get("邮箱").indexOf("@")) + "',");
                stringBuffer.append("'',");
                stringBuffer.append("'" + m.get("名字") + "',");
                stringBuffer.append("'" + m.get("电话") + "',");
                stringBuffer.append("'',");
                stringBuffer.append("'" + m.get("邮箱") + "',");
                stringBuffer.append("'" + 1 + "',");
                stringBuffer.append("'" + 1 + "',");
                stringBuffer.append("now()),");
                initPeopleId++;
            }
            StringBuffer stringBufferRef = new StringBuffer();
            stringBufferRef.append("INSERT INTO `bdp_user_role_rel` (`user_id`,`role_id`) VALUES ");
            for (Map<String, String> m : list) {
                if (m.get("邮箱").indexOf("@") == -1) {
                    continue;
                }
                stringBufferRef.append("('" + initPeopleId_ref + "',");
                stringBufferRef.append("'" + 64 + "'),");
                initPeopleId_ref++;
            }
        }
    }

}
