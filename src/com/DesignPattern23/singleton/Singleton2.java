package com.DesignPattern23.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 类似spring里面的方法, 将类名注册,下次从里面直接获取
 */
public class Singleton2 {

    private static Map<String,Singleton2> map = new HashMap<>();
    static {
        Singleton2 single = new Singleton2();
        map.put(single.getClass().getName(),single);
    }

    protected Singleton2(){}

    //静态工厂方法 返回唯一实例
    public static Singleton2 getInstance(String name) {
        if (name == null) {
            name = Singleton2.class.getName();
        }
        if (map.get(name) == null) {
            try {
                map.put(name, (Singleton2)Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }

}
