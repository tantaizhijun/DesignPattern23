package com.test.netty.selfRPC.clientStub;

import com.test.netty.selfRPC.serverStub.ClassInfo;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 客户端代理类
 */
public class NettyRPCProxy {

    //创建代理对象
    public static Object create(Class target) {
        return Proxy.newProxyInstance(target.getClassLoader(),
                new Class[]{target},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //封装参数
                        ClassInfo classInfo = new ClassInfo();
                        classInfo.setClassName(target.getName());
                        classInfo.setMethodName(method.getName());
                        classInfo.setObjects(args);
                        classInfo.setTypes(method.getParameterTypes());
                        //开始用netty发送
                        NioEventLoopGroup group = new NioEventLoopGroup();
                        ResultHandler resultHandler = new ResultHandler();
                        try {
                            Bootstrap b = new Bootstrap();
                            b.group(group)
                                    .channel(NioSocketChannel.class)
                                    .handler(new ChannelInitializer<SocketChannel>() {
                                        @Override
                                        protected void initChannel(SocketChannel ch) throws Exception {
                                            ChannelPipeline pipeline = ch.pipeline();
                                            pipeline.addLast("encoder",new ObjectEncoder());
                                            pipeline.addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE,
                                                    ClassResolvers.cacheDisabled(null)));
                                            //客户端业务处理类
                                            pipeline.addLast("handler",resultHandler);
                                        }
                                    });
                            ChannelFuture future = b.connect("127.0.0.1", 9998).sync();
                            future.channel().writeAndFlush(classInfo).sync();
                            future.channel().closeFuture().sync();
                        }catch (Exception e){

                        }finally {
                            group.shutdownGracefully();
                        }

                        return resultHandler.getResponse();
                    }
                });
    }
}
