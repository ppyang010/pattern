package com.caicy.pattern.proxy;

/**
 * 拥有出租房子这个接口的叫做房东
 * Created by Administrator on 2018/3/18.
 */
public class HouseOwnerA implements HouseRent,HouseClean{


    /**
     * 出租
     *
     * @param who
     */
    @Override
    public void rentOut(String who) {
        System.out.printf("我出租一套三室一厅的房子给%s \n",who);
        System.out.printf("我和%s签订合同\n",who);
    }


    @Override
    public void cleanHouse(String s) {
        System.out.println("清理房间");
    }
}
