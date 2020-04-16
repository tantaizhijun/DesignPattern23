package com.test.DesignPattern23.Observer.demo1;

public class Spy extends Thread{

    private HanFeiZi hanFeiZi;

    private LiSi liSi;

    private String type;

    public Spy(HanFeiZi hanFeiZi,LiSi liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }


    @Override
    public void run() {
        while (true){
            //监控是否在吃饭
            if (this.type.equals("eat")) {
                if (this.hanFeiZi.isEat()) {
                    this.liSi.update("韩非子在吃饭");
                    this.hanFeiZi.setEat(false);
                }
            } else {   //监控是否在娱乐
                if (this.hanFeiZi.isHaveFun()) {
                    this.liSi.update("韩非子在娱乐");
                    this.hanFeiZi.setHaveFun(false);
                }
            }

        }
    }
}
