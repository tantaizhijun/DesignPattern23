package com.test.netty.selfRPC.server;

public class HelloNettyImpl implements HelloNetty {
    @Override
    public String hello() {
        return "hello";
    }
}
