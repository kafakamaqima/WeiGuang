##### 类和对象是Java中最基本的两个概念，先来看一个简单的Person类
```
public class Person {
    private String name;
    private int age;
    private int sex;

    private void eat() {
    	System.out.println(name+"正在吃东西");
    }

    private void sleep() {
    
    }

    private void dadoudou() {
    	
    }
}
```
#### 为了完成下面的要求,请你先创建一个java项目,该项目有一个主类(名字任意,里面有一个main函数作为程序入口),一个Person类,Person类的内容在上面已经给出。
#### 1. 请你为这个Person类添加构造方法实现复制对象,并在题解附上你的Person类代码。你的构造方法用到this关键字了吗?请说说它的作用。
-   代码如下:
```
package com.niganma.job;

public class Person {
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
    }

    // 复制构造方法，用于创建一个已有对象的副本
    public Person(Person another) {
        this.name = another.name;// 将another对象的name属性值复制给新对象
        this.age = another.age;// 将another对象的age属性值复制给新对象
        this.sex = another.sex;// 将another对象的sex属性值复制给新对象
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
```
-   *this*关键字的作用:区分局部变量和成员变量,其本质就是代表了<u>**方法调用者的地址值**</u>,因此,是谁调用了这个方法,那么就会被附上相应的值
#### 2. 在主类的main方法中创建Person类的一个对象,并给它的字段赋值（可以用构造函数，也可以用引用变量）。说说对象和类的关系。
-   ***代码如下***:
```
package com.niganma.job;

public class PersonTest {

    public static void main(String[] args) {
        // 使用带参数的构造方法创建Person对象并初始化属性
        Person original = new Person("张三", 30, 1);

        //顺便把复制构造也敲一下

        /*使用带参数的构造方法创建Person对象并初始化属性,
        () 里面是传递了一个 Person 类的对象 original,
        复制构造方法会使用这个对象的状态来初始化新对象。
         就相当于在外层的Person里又调用了括号里面的Person
         从而实现复制构造*/
        Person copy = new Person(original);

        // 使用setter方法修改原始对象的属性
        original.setAge(100);

        original.eat();
        original.sleep();
        original.dadoudou();

        // 再顺便验证一下复制是否成功(此时原始对象的age属性已被修改,如果复制成功,则打印出来的数值会不同)
        System.out.println("原始对象: " + original.getName() + ", 年龄: " + original.getAge() + ", 性别: " + original.getSex());
        System.out.println("复制对象: " + copy.getName() + ", 年龄: " + copy.getAge() + ", 性别: " + copy.getSex());
    }

}
```
- ***对象和类的关系***:
  - 类是一个蓝图或模板，它定义了一类对象的属性（成员变量）和行为（方法）。类描述了如何创建对象，以及这些对象将具有哪些数据和函数。
  - 对象是根据类创建的实例，它是类的具体化。
  每个对象都拥有类中定义的属性和方法，但它们都有不同的数据
  ***打个比方***
  - 类就像一个模具或蓝图，它规定了要创建的对象的形状和结构。
  - 对象就是使用这个模具或蓝图制造出来的具体物品。
  - 如果类是一辆车的设计图纸，那么对象就是根据这张图纸制造出来的具体车辆。所有的车辆都遵循同样的设计（类），但每辆车可能有不同的颜色、型号（对象的属性值不同）
#### 3. 学习访问修饰符,为你的Person类的字段和方法添加你认为合适的访问修饰符。尝试在不同的位置(当前类,相同包的其它类，包的外部等)访问这些字段和方法，并总结出各种访问修饰符的限制范围。
***各种访问修饰符的限制范围:***
-   public:没有任何限制，可以在任何地方访问。
-   private:只能在声明它的类内部访问。(在子类中,不能直接访问private修饰的字段和方法,而是要通过getter/setter方法)
-   default(没有修饰符,一个变量如果什么都不打的话,系统就默认帮你设置)：在同一个包内可以访问，在包外不可以访问。
-   protected:在同一个包内可以访问，在包外也可以访问，但只能访问该类的子类。

---
---
##### 请了解静态变量和静态方法并完成以下任务：
#### 4. 为你的Person类创建一个静态方法命名为count,该方法返回Person类存在多少个对象。注意,count方法不应该统计到已经被销毁的Person对象。
>-   有个问题诶,(⊙_⊙)?查了下资料,好像不能实现"count方法不应该统计到已经被销毁的Person对象"这一目的,因为Java有垃圾回收机制,对象被销毁的时间是由垃圾回收器决定的,而不是由程序直接控制的,我们只能统计创建的对象数量，而不能准确统计“存在”的对象数量，因为对象可能已经被垃圾回收器回收，但我们的计数器并不知道这一点.
>-   这个count方法只会返回已创建的Person对象的数量,而不会考虑这些对象是否仍然存在于内存中。也就是说,即使某些对象已经被垃圾回收,personCount的值仍然会保持不变,因为它只在对象创建时增加,而不会在对象销毁时减少.
>-   这个是内存原理的东西吧应该,对象在不被使用的时候,引用的地址值就会被丢进垃圾回收器里(当程序创建对象时,它会在堆内存中分配空间。每个对象都有一个引用,指向堆内存中的这个空间。当对象不再被任何引用指向时，它就变得“不可访问”了，这意味着程序没有办法再访问或使用这个对象)
```
package com.niganma.job;

public class Person {
    public static int personCount = 0;//定义一个计数器,初始化一下数值
    private String name;
    private int age;
    private int sex; // 假设1代表男性,0代表女性

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
```
补充了三个部分:
-   public static int personCount = 0;//定义一个计数器,初始化一下数值
-    personCount++;//每次创建一个Person就自增一次
-    public static int count() {
       return personCount;//在 PersonTest 里面调用 Person.count() 这个方法时就会返回计数完毕的 personCount 的值
    }
 