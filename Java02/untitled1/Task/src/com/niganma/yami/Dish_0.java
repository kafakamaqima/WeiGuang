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