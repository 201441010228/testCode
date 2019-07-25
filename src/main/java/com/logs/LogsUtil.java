package com.logs;

import com.utils.WriterExcelFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 张扬
 * @Date: 2018/12/17 14:41
 * @Description:
 */
public class LogsUtil {

    public static Long count = 1L;
    public static List<Map<String, Object>> values = new ArrayList<>();
    public static String date = "20181225";

    private static void getLog() throws IOException {
        File readFile = new File("D:\\log\\lbs-base-api-" + date + ".log\\lbs-base-api-" + date + ".log");
        String createAt = "2018-12-25";
        InputStream is = new FileInputStream(readFile);
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str1 = null;
        while ((str1 = bufferedReader.readLine()) != null) {
            if (!(str1.contains("search=") || str1.contains("outsideSearch="))) {
                continue;
            }
            if (str1.contains("resultCount:")){
                str1 = str1.replace("resultCount:","resultCount=");
            }
            Map<String, Object> value = new LinkedHashMap<>();
            String cityId = getValue(str1, "cityId");
            if (cityId == null || "null".equals(cityId)) {
                continue;
            }
            String soType =  getValue(str1, "soType");
            if (!("1".equals(soType) ||  "2".equals(soType))) {
                continue;
            }
            count++;
            String cityName = getValue(str1, "cityName");
            String serviceType = getValue(str1,"serviceType");
            String lang = getValue(str1, "lang");
            String resultCount = getValue(str1, "resultCount");
            value.put("cityId", cityId);
            value.put("cityName", cityName);
            value.put("soType", soType);
            value.put("serviceType", serviceType);
            value.put("lang", lang);
            value.put("resultCount", resultCount);
            value.put("createAt", createAt);
            values.add(value);
        }
        bufferedReader.close();
        inputStreamReader.close();
        is.close();
        List<String> titles = new ArrayList<String>();
        titles.add("cityId");
        titles.add("cityName");
        titles.add("soType");
        titles.add("serviceType");
        titles.add("lang");
        titles.add("resultCount");
        titles.add("createAt");
    boolean flag = WriterExcelFile.generateWorkbook("D:\\log\\lbs-base-api-" + date + ".log\\" + date + ".xlsx", "result", "xlsx", titles, values);
        if (flag) {
            System.out.println("success");
        }

}

    private static String getValue(String message, String findFile) {
        String searchString = findFile + "=";
        int startOffset = searchString.length();
        return message.substring(message.indexOf(searchString) + startOffset,
                                 message.indexOf(",", message.indexOf(searchString)));
    }

    public static void main(String[] args) {
        try {
            getLog();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
