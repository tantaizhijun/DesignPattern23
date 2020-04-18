package com.test.netty.selfRPC.serverStub;

import java.io.Serializable;

public class ClassInfo  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String className;
    private String methodName;
    private Object[] objects;//参数列表
    private Class<?>[] types;//参数类型

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public Class<?>[] getTypes() {
        return types;
    }

    public void setTypes(Class<?>[] types) {
        this.types = types;
    }
}
