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

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     *
     * @param price
     */
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