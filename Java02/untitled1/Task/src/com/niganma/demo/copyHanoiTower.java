package com.niganma.demo;

import java.util.Scanner;

public class copyHanoiTower {
    public static void main(String[] args) {
        copyHanoiTower hanoiTower = new copyHanoiTower();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int n = sc.nextInt();//键盘录入一个正整数,测试不同数量盘子发生的情况
        // 调用hanoi方法时，需要传递四个参数：盘子的数量和三个柱子的标识符
        hanoiTower.hanoi(n, 'A', 'C', 'B');
    }

    /**
     * 打印汉诺塔的移动过程
     *
     * @param n    盘子的数目
     * @param from 起始柱子
     * @param to   目标柱子
     * @param aux  辅助柱子
     */
    public void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println(from + "->" + to);
            //此为基本情况,有了基本情况,递归就有停止的条件
        } else {
            //1. 将源柱子上的顶部n-1个盘子移动到辅助柱子上
            hanoi(n - 1, from, aux, to);
            //2. 将源柱子上剩下的最大盘子移动到目标柱子上
      /*此过程是参数为n的时候,操作的是最底下的盘子,与调用的hanoi方法里的n-1不同.我们在每次递归调用时将问题规模减小，即从 n 减少到 n-1。这意味着在递归的每一层，我们都在处理更少的盘子。但是，我们并不是在 else 块中忽略最下面的大盘子，而是在每次递归调用中重新定义柱子的角色，以确保大盘子能够被正确地移动。*/
            System.out.println(from + "->" + to);
            //3. 将辅助柱子上的n-1个盘子移动到目标柱子上，覆盖在最大盘子之上
       /*在调用递归方法的过程中,形参'A''C''B'的位置并没有发生变化,而是通过每次递归调用中重新分配 from、to 和 aux 参数的角色，以实现盘子的移动*/
            hanoi(n - 1, aux, to, from);
        }
    }
}
