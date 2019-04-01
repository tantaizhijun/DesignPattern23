package com.DesignPattern23.Observer.demo1;

public class HanFeiZi implements IHanFeiZi{

    /**
     * 增加两个状态，方便监控
     */
    private boolean isHaveFun = false;
    private boolean isEat = false;


    /**
     * 李斯 监听
     *
     *  持有监听者的引用，如果监听者过多，代码量就臃肿，频繁修改，不好
     */
    private ILiSi liSi = new LiSi();


    @Override
    public void haveFun() {
        System.out.println("韩非子: 玩去了");
        this.liSi.update("李斯看到韩非子在玩耍");
//        this.isHaveFun = true;
    }

    @Override
    public void eat() {
        System.out.println("韩非子: 吃饭呢！");
        this.liSi.update("李斯看到韩非子在吃饭");
//        this.isEat = true;
    }

    public boolean isHaveFun() {
        return isHaveFun;
    }

    public void setHaveFun(boolean haveFun) {
        isHaveFun = haveFun;
    }

    public boolean isEat() {
        return isEat;
    }

    public void setEat(boolean eat) {
        isEat = eat;
    }
}
