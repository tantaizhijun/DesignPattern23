package com.test.netty.selfRPC.serverStub;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.reflections.Reflections;


import java.lang.reflect.Method;
import java.util.Set;

//服务端业务处理类
public class InvokeHandler extends ChannelInboundHandlerAdapter {

    //根据接口找实现类
    private String getImplClassName(ClassInfo classInfo) throws Exception {
        //服务提供方的包路径
        String interfacePath = "com.test.netty.selfRPC.server";
        int lastIndexOf = classInfo.getClassName().lastIndexOf(".");
        String interfaceName = classInfo.getClassName().substring(lastIndexOf);
        Class superClass = Class.forName(interfacePath + interfaceName);
        //查找子类
        Reflections reflection = new Reflections(interfacePath);
        Set<Class<?>> implClass = reflection.getSubTypesOf(superClass);
        if(implClass.size()==0) {
            System.out.println("没找到实现类");
            return null;
        } else if(implClass.size() > 1) {
            System.out.println("找到多个子类,不明确");
            return null;
        } else {
            Class[] classes = implClass.toArray(new Class[0]);
            return classes[0].getName();//实现类的名字
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ClassInfo classInfo = (ClassInfo) msg;
        System.out.println("收到请求"+classInfo);
        Object clazz = Class.forName(getImplClassName(classInfo)).newInstance();
        //反射执行方法,获取返回值,并返回
        Method method = clazz.getClass().getMethod(classInfo.getMethodName(), classInfo.getTypes());
        Object result = method.invoke(clazz, classInfo.getObjects());
        ctx.writeAndFlush(result);
    }
}
