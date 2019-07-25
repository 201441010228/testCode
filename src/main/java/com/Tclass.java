package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;

/**
 * @Auther: 张扬
 * @Date: 2018/10/17 18:31
 * @Description:
 */
public class Tclass {

    private static <T> void listAddAllAvoidNPE(List<T> dest, List<T> source) {
        if (source == null) {
            return;
        }
        dest.addAll(source);
    }

    private static <T> void listAddAvoidNull(List<T> dest, T source) {
        if (source == null) {
            return;
        }
        dest.add(source);
    }

    public static void main(String args[]) throws JSONException, IOException {
        String str = "["
                + "{"
                + "\"serial_number\":\"1\","
                + "\"flight_date\":\"2017-02-06\","
                + "\"flight_no\":\"SC8756\","
                + "\"departure_airport\":\"FOC\","
                + "\"arrival_airport\":\"TNA\","
                + "\"std\":\"2017-02-06 15:30:00\","
                + "\"atd\":\"2017-02-06 17:12:00\","
                + "\"sta\":\"2017-02-06 17:45:00\","
                + "\"ata\":\"2017-02-06 19:12:00\","
                + "\"abnormal_status\":\"延误\","
                + "\"abnormal_reason\":\"其他空域用户占用空域\","
                + "\"cld_time\":\"2017-02-15 10:10:00\","
                + "\"sub_flights\":["
                + "]"
                + "},"
                + "{"
                + "\"serial_number\":\"2\","
                + "\"flight_date\":\"2017-02-06\","
                + "\"flight_no\":\"SC8756\","
                + "\"departure_airport\":\"TNA\","
                + "\"arrival_airport\":\"URC\","
                + "\"std\":\"2017-02-06 18:35:00\","
                + "\"atd\":\"2017-02-06 20:12:00\","
                + "\"sta\":\"2017-02-06 23:20:00\","
                + "\"ata\":\"\","
                + "\"abnormal_status\":\"备降\","
                + "\"abnormal_reason\":\"\","
                + "\"cld_time\":\"2017-02-15 10:10:00\","
                + "\"sub_flights\":["
                + "{"
                + "\"serial_number\":\"1\","
                + "\"flight_date\":\"2017-02-06\","
                + "\"flight_no\":\"SC8756\","
                + "\"departure_airport\":\"TNA\","
                + "\"arrival_airport\":\"TLQ\","
                + "\"std\":\"2017-02-06 18:45:00\","
                + "\"atd\":\"2017-02-06 20:12:00\","
                + "\"sta\":\"2017-02-06 23:30:00\","
                + "\"ata\":\"2017-02-07 00:47:00\","
                + "\"abnormal_status\":\"正常\","
                + "\"abnormal_reason\":\"\","
                + "\"cld_time\":\"2017-02-15 10:10:00\","
                + "\"sub_flights\":["
                + "]"
                + "},"
                + "{"
                + "\"serial_number\":\"2\","
                + "\"flight_date\":\"2017-02-06\","
                + "\"flight_no\":\"SC8756\","
                + "\"departure_airport\":\"TLQ\","
                + "\"arrival_airport\":\"URC\","
                + "\"std\":\"2017-02-07 00:00:00\","
                + "\"atd\":\"2017-02-07 02:18:00\","
                + "\"sta\":\"2017-02-07 01:00:00\","
                + "\"ata\":\"\","
                + "\"abnormal_status\":\"备降\","
                + "\"abnormal_reason\":\"\","
                + "\"cld_time\":\"2017-02-15 10:10:00\","
                + "\"sub_flights\":["
                + "]"
                + "}"
                + "]"
                + "}"
                + "]";
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList arrayList = objectMapper.readValue(str, ArrayList.class);
         getValue(arrayList);
    }

    public static String getValue(List<Map<String,Object>> array){
        if (array.size() == 0) {
            return null;
        }
        for (int i = 0; i < array.size(); i++) {
            Map<String, Object> map = array.get(i);
            System.out.println(map.get("abnormal_status"));
            if (map.get("sub_flights") != null){
                getValue((List<Map<String, Object>>) map.get("sub_flights"));
            }
        }
        return null;
    }

}
