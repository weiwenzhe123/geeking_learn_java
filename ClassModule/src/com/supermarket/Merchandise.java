package com.supermarket;/*
    @auth wwz 
    @create 
*/

public class Merchandise {
    private String GoodsName;//商品名称
    private int ID; //商品编号
    private int GoodsNum;//商品数量
    private double SellPrice;//卖出价格
    private double BuyPrice;//买入价格
    private double TodayProfit;//当天利润

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getTodayProfit() {
        return TodayProfit;
    }

    public void setTodayProfit(double todayProfit) {
        TodayProfit = todayProfit;
    }

    public double getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        BuyPrice = buyPrice;
    }

    public double getSellPrice() {
        return SellPrice;
    }

    public void setSellPrice(double sellPrice) {
        SellPrice = sellPrice;
    }

    public int getGoodsNum() {
        return GoodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        GoodsNum = goodsNum;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public double CalcTotalPrice(int numberToBuy , int numberToPrice){
        double totoalprice;
        int FullNumber;
        int HalfNumber;
        HalfNumber = numberToBuy / numberToPrice ;
        FullNumber = numberToBuy - HalfNumber;
        totoalprice = FullNumber * getSellPrice() + (HalfNumber * getSellPrice() /2 );
        return totoalprice;
    }
    //更新利润值
    //利润值 = 售价 - 进价
    public void updateProfit(int numberToBuy, int numberToPrice){
       setTodayProfit(CalcTotalPrice(numberToBuy,numberToPrice) - numberToBuy* getBuyPrice());
    }
    public void updateNumber(int number){
       setGoodsNum( getGoodsNum() - number);
    }
}
