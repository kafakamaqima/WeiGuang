## Task1.继承
### 首先我们为每个菜品写一个类，比如：
```
public class Dish-0 {
    private String name;//菜品名称
    private double price;//菜品价格

    public void profile(){
        System.out.println("番茄炒蛋是普通的大众菜肴，烹调方法比较简单，而且营养搭配合理。色泽鲜艳，口味宜人，深受大众喜爱。其营养价值丰富，具有营养素互补的特点以及健美抗衰老的作用。番茄含有丰富的胡萝卜素、维生素C和B族维生素，番茄红素具有独特的抗氧化能力。鸡蛋含有大量的维生素和矿物质及有高生物价的蛋白质。蛋黄中含有丰富的卵磷脂、固醇类等，对神经系统和身体发育有非常好的作用，深受人们的喜爱。");
    }

    public Dish-0(String name,double price){
        this.name = "番茄炒蛋";
        this.price = 10;
    }
}
```
#### 1. 请你了解Java的继承机制，编写Dish作为基类，包含上面类的属性和方法，然后编写两个类Dish_1和Dish_2继承这个基类，并在菜品类的构造方法里把菜品名字和价格写好（菜品名字和价格自行决定）。
#### 2. 显然不同的菜品介绍是不一样的，也就是说调用该菜品类的profile方法时，应该输出符合的介绍，请做到这一点。
-   ***1,2两题解法在一起了***
    -   代码如下(代码路径:WeiGuang\Java02\untitled1\Task\src\com\niganma\yami\Dish.java):
```
package com.niganma.yami;

public class Dish {
    private String name;
    private double price;

    //默认构造函数
    public Dish() {
    }

    //重载构造函数,使用传入的参数
    public Dish(String name, double price) {
        this.name = "番茄炒蛋";
        this.price = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void profile() {
        System.out.println(
                "番茄炒蛋是普通的大众菜肴，烹调方法比较简单，而且营养搭配合理。色泽鲜艳，口味宜人，深受大众喜爱。其营养价值丰富，具有营养素互补的特点以及健美抗衰老的作用。番茄含有丰富的胡萝卜素、维生素C和B族维生素，番茄红素具有独特的抗氧化能力。鸡蛋含有大量的维生素和矿物质及有高生物价的蛋白质。蛋黄中含有丰富的卵磷脂、固醇类等，对神经系统和身体发育有非常好的作用，深受人们的喜爱。");
    }

    public class Dish_1 extends Dish {
        public Dish_1() {
            super("阿帕茶", 40721);

        }

        public void profile() {
            System.out.println(
                    "阿帕茶是特殊的特供菜肴，烹调方法十分简单，并且营养搭配合理。色泽明亮，口味宜人，深受大众喜爱。其营养价值丰富，具有营养素互补的特点以及提神醒脑的作用。茶含有丰富的尿素、无机盐和鸭梨黄色素,鸭梨黄素具有独特的抗还原能力。阿帕茶具有激发人类觉醒替身的能力,深受乔鲁诺的喜爱。");
        }

    }

    public class Dish_2 extends Dish {
        public Dish_2() {
            super("典明粥", 114514);
        }

        public void profile() {
            System.out.println(
                    "典明粥是普通的大众菜肴，烹调方法比较简单，而且营养搭配合理。色泽鲜艳，口味宜人，深受大众喜爱。其营养价值丰富，具有营养素互补的特点以及健美抗衰老的作用。由著名美食家花京院_典明发明,深受人们的喜爱。");
        }
    }

}
```
## Task2.接口和多态
#### 3. 请你了解接口相关的知识，创建一个名为Order的接口，里面有cook和check两个方法，cook输出该菜品的烹饪方法，check随机返回true（表示原料足够可以烹饪该菜品）或者false（表示不能烹饪该菜品），模拟实际情况中可能某些菜品原料不够的情况。让你的菜品类继承这个接口，并完成厨师类System的manageOrder函数。
#### 4. 我们都知道面向对象的三大特性：封装继承多态，其实接口就是多态的一种实现机制，厨师调用的明明是Order类的方法，实际执行的却是Dish_1或者Dish_2的方法
```
package com.niganma.yami;

import java.util.List;
import java.util.Random;

// 定义Order接口
interface Order {
    void cook(); // 输出烹饪方法
    boolean check(); // 检查原料是否足够
}

// 实现Order接口的Dish_0类
public class Dish_0 implements Order {
    private static Random random = new Random();
    private String name;
    private double price;

    public Dish_0() {
    }

    public Dish_0(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void cook() {
        System.out.println(name + " 的烹饪方法是：" + "烹饪细节");
    }

    @Override
    public boolean check() {
        return random.nextBoolean();
    }

    public void profile() {
        System.out.println("番茄炒蛋是普通的大众菜肴，烹调方法比较简单，而且营养搭配合理。色泽鲜艳，口味宜人，深受大众喜爱。其营养价值丰富，具有营养素互补的特点以及健美抗衰老的作用。番茄含有丰富的胡萝卜素、维生素C和B族维生素，番茄红素具有独特的抗氧化能力。鸡蛋含有大量的维生素和矿物质及有高生物价的蛋白质。蛋黄中含有丰富的卵磷脂、固醇类等，对神经系统和身体发育有非常好的作用，深受人们的喜爱。");
    }

    public static class Dish_1 extends Dish_0 {
        public Dish_1() {
            super("阿帕茶", 40721);
        }

        @Override
        public void cook() {
            System.out.println("阿帕茶的烹饪方法是：" + "金色圣水承装在高档茶具中");
        }

        @Override
        public void profile() {
            System.out.println("阿帕茶是特殊的特供菜肴，烹调方法十分简单，并且营养搭配合理。色泽明亮，口味宜人，深受大众喜爱。其营养价值丰富，具有营养素互补的特点以及提神醒脑的作用。茶含有丰富的尿素、无机盐和鸭梨黄色素,鸭梨黄素具有独特的抗还原能力。阿帕茶具有激发人类觉醒替身的能力,深受乔鲁诺的喜爱。");
        }
    }

    public static class Dish_2 extends Dish_0 {
        public Dish_2() {
            super("典明粥", 114514);
        }

        @Override
        public void cook() {
            System.out.println("典明粥的烹饪方法是：" + "金色传说和美味咸粥混合,慢火熬制");
        }

        @Override
        public void profile() {
            System.out.println("典明粥是普通的大众菜肴，烹调方法比较简单，而且营养搭配合理。色泽鲜艳，口味宜人，深受大众喜爱。其营养价值丰富，具有营养素互补的特点以及健美抗衰老的作用。由著名美食家花京院_典明发明,深受人们的喜爱。");
        }
    }
}
// 订单处理系统类
class OrderSystem {
    private static int orderNumber = 1; // 订单编号从1开始递增

    public void manageOrder(List<Order> dishes) {
        boolean canCook = true;
        for (Order dish : dishes) {
            if (!dish.check()) { // 检查原料是否足够
                canCook = false;
                break; // 一旦有一个菜品原料不足，就终止循环
            }
        }

        if (!canCook) {
            System.out.println("取消订单");
        } else {
            for (Order dish : dishes) {
                dish.cook(); // 输出菜品的烹饪方法
            }
            System.out.println("订单编号：" + orderNumber++);
        }
    }

    public static void main(String[] args) {
        OrderSystem orderSystem = new OrderSystem();
        List<Order> dishes = List.of(
                new Dish_0("番茄炒蛋", 10.0),
                new Dish_0.Dish_1(),
                new Dish_0.Dish_2()
        );
        orderSystem.manageOrder(dishes);
    }
}
```
## Task3.泛型
#### 5. 了解泛型相关的知识，按照要求进一步完善manageOrder函数。
#### 菜品和厨师都准备好了，顾客可以来点单了！所以我们要对刚才写好的manageOrder函数进一步完善，传入的参数除了订单，还有顾客。顾客点单可能是从餐桌上的二维码扫码进入，也可能直接从微信的小程序进入，我们用TableCustomer和WechatCustomer表示这两种类型的顾客，对于Wechat类型的顾客，如果是堂食，则不需要额外做什么，如果是外卖，则需要送到顾客的地址。而对于Table类型的顾客，我们要把餐送到对应的餐桌上，当然这些只需要用文字输出来表示即可。
***以下是TableCustomer和WechatCustomer类:***
```
public class TableCustomer {
    public int tableId;//餐桌编号
}
```
```
public class WechatCustomer {
    public String address;//顾客地址
    public boolean takeout;//true代表该顾客是外卖，false代表该顾客是堂食
}
```

