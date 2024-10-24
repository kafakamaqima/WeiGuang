package com.niganma.job;

public class Person {
    public static int personCount = 0;//定义一个计数器,初始化一下数值
    private String name;
    private int age;
    private int sex; // 假设1代表男性，0代表女性

    // 默认构造方法
    public Person() {
    }

    // 构造方法，用于创建新对象时初始化属性
    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        personCount++;//每次创建一个Person就自增一次
    }

    // 复制构造方法，用于创建一个已有对象的副本
    public Person(Person another) {
        this.name = another.name;
        this.age = another.age;
        this.sex = another.sex;
        personCount++;//同理,每次创建一个Person就自增一次
    }

    public static int count() {
        return personCount;
        //在PersonTest里面调用Person.count()这个方法时就会返回计数完毕的personCount的值
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void eat() {
        System.out.println(name + "正在吃东西");
    }

    public void sleep() {
        System.out.println(name + "正在睡觉");
    }

    public void dadoudou() {
        System.out.println(name + "正在打豆豆");
    }

}