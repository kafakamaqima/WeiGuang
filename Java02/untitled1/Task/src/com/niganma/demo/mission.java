package com.niganma.demo;

import com.niganma.tool.Print;

public class mission {
    public static void main(String[] args) {
        for (String arg : args) {
            Print.print(arg);
        }

        Test.test();
    }
}

class Test {
    public static void test() {
        Print.print("Hello World");
    }
}