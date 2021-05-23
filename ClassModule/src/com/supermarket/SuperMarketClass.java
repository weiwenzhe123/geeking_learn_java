package com.supermarket;

public class SuperMarketClass {
    private String MarketName; //超市名称
    private String Address;//超市地址
    private Merchandise[] merchandise;//商品数组信息
    private int CarPortNum;//停车场数量

    public int getCarPortNum( ) {
        return CarPortNum;
    }

    public void setCarPortNum(int carPortNum) {
        CarPortNum = carPortNum;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


    public String getMarketName() {
        return MarketName;
    }

    public void setMarketName(String marketName) {
        MarketName = marketName;
    }

    public Merchandise[] getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(Merchandise[] merchandise) {
        this.merchandise = merchandise;
    }
    public Merchandise getMaxPorfitGoods(){
        double totalPorfit=0;
        int maxIndex=0;
        totalPorfit = getMerchandise()[0].getSellPrice() - getMerchandise()[0].getBuyPrice();
        for (int i= 0 ; i < merchandise.length;i++){
            if (totalPorfit  < merchandise[i].getSellPrice()  - merchandise[i].getBuyPrice()){
               totalPorfit = getMerchandise()[i].getSellPrice() - getMerchandise()[i].getBuyPrice();
               maxIndex=i;
            }
        }
        return merchandise[maxIndex];
    }
}
