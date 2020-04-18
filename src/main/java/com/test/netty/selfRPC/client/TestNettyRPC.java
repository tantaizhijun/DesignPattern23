package com.test.netty.selfRPC.client;

import com.test.netty.selfRPC.clientStub.NettyRPCProxy;

public class TestNettyRPC {
    public static void main(String[] args) {
        HelloNetty helloNetty = (HelloNetty) NettyRPCProxy.create(HelloNetty.class);
        System.out.println(helloNetty.hello());

        HelloRPC HelloRPC = (HelloRPC) NettyRPCProxy.create(HelloRPC.class);
        System.out.println(HelloRPC.hello("rpc"));

    }
}
