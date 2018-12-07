package com.stage;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张扬
 * @Date: 2018/9/28 11:15
 * @Description:
 */
public class ChargeFactory {

    private static final String SCANNERPACKAGE = "com.stage";

    private ClassLoader classLoader = this.getClass().getClassLoader();

    private List<Class<? extends ChargeInterface>> chargeList;

    public ChargeInterface createChargeStage(ChargeEuem chargeEuem){
        for (Class<? extends ChargeInterface> clazz:chargeList) {
            AmountInterface amountInterface= handleAnnotation(clazz);
            if (chargeEuem.getValue().equals(amountInterface.chargeType())){
                try {
                    return clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }
    public static ChargeFactory getInstance() {
        return ChargeFactoryInstance.instance;
    }

    private static class ChargeFactoryInstance {
        private static ChargeFactory instance = new ChargeFactory();
    }

    private ChargeFactory() {
        init();
    }


    private AmountInterface handleAnnotation(Class<? extends ChargeInterface> clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        if (null == annotations || annotations.length == 0) {
            return null;
        }
        for (Annotation annotation : annotations) {
            if (annotation instanceof AmountInterface) {
                return (AmountInterface) annotation;
            }
        }
        return null;
    }

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

    private void init() {
        chargeList = new ArrayList<Class<? extends ChargeInterface>>();
        File[] resources = getResources();
        Class<ChargeInterface> chargeClass = null;
        try {
            chargeClass = (Class<ChargeInterface>) classLoader.loadClass(ChargeInterface.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (File file : resources) {
            try {
                Class<?> clazz = classLoader.loadClass(SCANNERPACKAGE + "." + file.getName().substring(0,file.getName
                        ().lastIndexOf('.')));
                if (ChargeInterface.class.isAssignableFrom(clazz) && clazz != chargeClass) {
                    chargeList.add((Class<? extends ChargeInterface>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
