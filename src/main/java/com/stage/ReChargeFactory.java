package com.stage;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张扬
 * @Date: 2018/9/29 14:33
 * @Description:
 */
public class ReChargeFactory {

    private static final String SCANNERPACKAGE = "com.stage";

    private ClassLoader classLoader = getClass().getClassLoader();

    private List<Class<? extends ChargeInterface>> chargeInterfaces = null;


    /**
     * 获取文件
     */
    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(SCANNERPACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 加载策略类
     */
    private void loadStageClass() {
        chargeInterfaces = new ArrayList<Class<? extends ChargeInterface>>();
        File[] files = getResources();
        Class<ChargeInterface> chargeInterface = null;
        try {
            chargeInterface = (Class<ChargeInterface>) classLoader.loadClass(ChargeInterface.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (File file : files) {
            try {
                Class<?> clazz = classLoader.loadClass(SCANNERPACKAGE + "." + file.getName().substring(0, file.getName()
                        .lastIndexOf(",")));
                if (ChargeInterface.class.isAssignableFrom(clazz) && clazz != chargeInterface) {
                    chargeInterfaces.add((Class<? extends ChargeInterface>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 返回类上的注解数据
     */
    private AmountInterface handlerAnnouncation(Class clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (Annotation a : annotations) {
            if (a instanceof AmountInterface) {
                return (AmountInterface) a;
            }
        }
        return null;
    }


}
