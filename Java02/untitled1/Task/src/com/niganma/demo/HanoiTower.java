package com.niganma.demo;

public class HanoiTower {

    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        int n = 3; // 可以改变这个值来测试不同数量的盘子
        // 调用hanoi方法时，需要传递四个参数：盘子的数量和三个柱子的标识符
        hanoiTower.hanoi(n, 'A', 'C', 'B');
    }

    /**
     * 打印汉诺塔的移动过程
     *
     * @param n    盘子的数量
     * @param from 源柱子
     * @param to   目标柱子
     * @param aux  辅助柱子
     */
    public void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            // 基本情况：如果只有一个盘子，直接移动到目标柱子
            System.out.println(from + "->" + to);
        } else {
            // 1. 将源柱子上的顶部n-1个盘子移动到辅助柱子上
            hanoi(n - 1, from, aux, to);
            // 2. 将源柱子上剩下的最大盘子移动到目标柱子上
            System.out.println(from + "->" + to);
            // 3. 将辅助柱子上的n-1个盘子移动到目标柱子上，覆盖在最大盘子之上
            hanoi(n - 1, aux, to, from);
        }
    }
}
