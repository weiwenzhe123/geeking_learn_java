import com.supermarket.Customer;
import com.supermarket.Merchandise;
import com.supermarket.SuperMarketClass;

import java.util.Scanner;

public class TestBuyGoods {
    public static void main(String[] args) {
        //定义变量
        String GoodsName;
        int number;
        int Id;
        double SellPrice;
        double BuyPrince;
        //定义超市信息
        SuperMarketClass SuperMarket = new SuperMarketClass();
        SuperMarket.setAddress("中州大道航海路666号");
        SuperMarket.setCarPortNum(300);
        SuperMarket.setMarketName("爱便利超市");
        //定义商品信息
        Merchandise[] all = new Merchandise[200];
        SuperMarket.setMerchandise(all);
        for (int i = 0; i < all.length; i++) {
            Merchandise merchandise = new Merchandise();
            GoodsName = "商品名称为" + i;
            Id = i;
            number = (int) (1 + Math.random()) * 200;
            SellPrice = (1 + Math.random()) * 100;
            BuyPrince = (2 + Math.random()) * 100;
            all[i] = merchandise;
            all[i].setBuyPrice(BuyPrince);
            all[i].setSellPrice(SellPrice);
            all[i].setID(Id);
            all[i].setGoodsName(GoodsName);
            all[i].setGoodsNum(number);
            all[i].setTodayProfit(0);
        }
        boolean IsOpen = true;
        Scanner scanner = new Scanner(System.in);
        boolean IsTakeCar;
        while (IsOpen) {

            //开始营业了
            System.out.println("超市开门了");
            System.out.println("当前超市名称为:" + SuperMarket.getMarketName());
            System.out.println("当前超市地址为:" + SuperMarket.getAddress());
            System.out.println("当前拥有商品:" + SuperMarket.getMerchandise().length + "种");
            //进来客户了
            Customer customer = new Customer();
            GoodsName = "顾客编号1";
            SellPrice = (Math.random() + 3) * 2000;
            IsTakeCar = Math.random() > 0.5;
            customer.setDriveCar(IsTakeCar);
            customer.setMoney(SellPrice);
            customer.setName(GoodsName);
            if (IsTakeCar) {
                //开车了
                if (SuperMarket.getCarPortNum() <= 0) {
                    System.out.println("对不起，停车位不够，请下次再来");
                } else {
                    System.out.println("停车位充足，欢迎光临");
                    System.out.println("停车位编号为：" + SuperMarket.getCarPortNum());
                    SuperMarket.setCarPortNum(SuperMarket.getCarPortNum() - 1);

                }
            } else {
                System.out.println("穷逼，没开车，来吧");
            }
            Id = 1;
            double TotalPrice = 0;
            while (Id > 0) {
                System.out.println("请输入要买的商品ID(输入为-1 表示退出)");
                Id = scanner.nextInt();
                if (Id >= SuperMarket.getMerchandise().length) {
                    System.out.println("您输入的商品编号有问题，请重新输入,最大值为:" + SuperMarket.getMerchandise().length);
                    continue;
                }
                if ( Id < 0 )
                {
                    //退出
                    break;
                }
                System.out.println("您选的商品为：" + SuperMarket.getMerchandise()[Id].getGoodsName() + "商品单价为："
                        + SuperMarket.getMerchandise()[Id].getSellPrice());

                System.out.println("请输入您要购买几个：");
                number = scanner.nextInt();
                if (number > SuperMarket.getMerchandise()[Id].getGoodsNum() || number <= 0) {
                    System.out.println("您输入有误，请重新输入");
                    continue;
                }
                if (TotalPrice + number * SuperMarket.getMerchandise()[Id].getSellPrice() > customer.getMoney()) {
                    System.out.println("对不起，您买的东西超过您所带的金额，请重新选购");
                    continue;
                }
                //计算总的买的金额
                TotalPrice = TotalPrice + number * SuperMarket.getMerchandise()[Id].getSellPrice();
                SuperMarket.getMerchandise()[Id].setTodayProfit((SuperMarket.getMerchandise()[Id].getBuyPrice()
                        - SuperMarket.getMerchandise()[Id].getSellPrice()) * number);
                SuperMarket.getMerchandise()[Id].setGoodsNum(SuperMarket.getMerchandise()[Id].getGoodsNum() - number);

            }
            //购买完毕
            System.out.println("您本次总共购买了：" + TotalPrice + "元");
            if (customer.isDriveCar()) {
                SuperMarket.setCarPortNum(SuperMarket.getCarPortNum() + 1);
            }
            System.out.println("请输入是否还要营业");
            IsOpen = scanner.nextBoolean();
        }
        //已关门
        System.out.println("超市关门了");
        for (int i = 0; i < SuperMarket.getMerchandise().length; i++) {
            if (SuperMarket.getMerchandise()[i].getGoodsNum() != 200){
                //有卖出商品
                System.out.println("卖出的商品名称为："+ SuperMarket.getMerchandise()[i].getGoodsName());
                System.out.println("卖出的数量为："+ (200-SuperMarket.getMerchandise()[i].getGoodsNum()));
                System.out.println("卖出的商品利润为："+ SuperMarket.getMerchandise()[i].getTodayProfit());
            }
        }
    }
}
