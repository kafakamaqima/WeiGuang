package com.niganma.job;

public class PersonTest {

    public static void main(String[] args) {
        /*使用带参数的构造方法创建Person对象并初始化属性,
        () 里面是传递了一个 Person 类的对象 original，
        复制构造方法会使用这个对象的状态来初始化新对象。
         就相当于在外层的Person里又调用了括号里面的Person
         从而实现复制构造*/
        Person original = new Person("张三", 30, 1);

        // 使用复制构造方法创建一个副本
        Person copy = new Person(original);

        // 使用setter方法修改原始对象的属性
        original.setAge(100);

        original.eat();
        original.sleep();
        original.dadoudou();

        // 验证复制是否成功(此时原始对象的age属性已被修改,如果复制成功,则打印出来的数值会不同)
        System.out.println("原始对象: " + original.getName() + ", 年龄: " + original.getAge() + ", 性别: " + original.getSex());
        System.out.println("复制对象: " + copy.getName() + ", 年龄: " + copy.getAge() + ", 性别: " + copy.getSex());
        System.out.println("已创建的Person对象数量为: " + Person.count());
    }

}
