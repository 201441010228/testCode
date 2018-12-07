package com.com.lastWork;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyzePostDataUtil {


    //原加密字符串组成格式：人员编号+系统标识+时间戳 如：zs|erp|1521448142833
    public final static String EMP_NAME = "empName";
    public final static String SYSID = "sysId";
    public final static String LOGINTIME = "loginTime";

    /**
     * 返回map格式的解析后的数据
     * 若传入参数有问题返回值为空
     * @param encrypt
     * @param key
     * @return
     */
    public static Map<String, String> analyzeDataMap(String encrypt, String key) {
        String[] postData = getEncryptStringArray(encrypt,key);
        if (null == postData){
            return null;
        }
        Map<String, String> encryptMap = new ConcurrentHashMap<String,String>();
        encryptMap.put(EMP_NAME, postData[0]);
        encryptMap.put(SYSID, postData[1]);
        encryptMap.put(LOGINTIME, postData[2]);
        return encryptMap;
    }

    /**
     * 返回解析后的String [] 类型数据
     * 若 缺少传参返回null
     * @param encrypt
     * @param key
     * @return
     */
    private static String[] getEncryptStringArray(String encrypt, String key) {
        if (encrypt == null || key == null) {
            return null;
        }
        return EncryUtil.encrypt(encrypt, key).split("\\|");
    }
}
