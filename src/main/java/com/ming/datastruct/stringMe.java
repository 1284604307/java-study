package com.ming.datastruct;
// String StringBuffer是Java中的两个主要串类

/**
 * 串有两种存储方式：顺式存储，链式存储
 * String和StringBuffer 都使用的顺势存储
 * Java的String类重载了+,+=,=操作，使其可以进行字符运算[java中没有运算符重载，这是编译中实现的]
 * String的核心结构是常量字符数组，StringBuffer核心是变量字符数组，区别是final修饰
 *
 */
public class stringMe {

    // 串的模式匹配有两种方法，这是第一种BruteForce,第二种是KMP算法

    /**
     * 暴力匹配法，从0开始一次向右匹配，遇到不匹配则目标串回溯，指针+1，直到匹配到或匹配结束
     */
    void Brute_Force(){
        // 略
    }

    /**
     * 暴力匹配虽然简单有效，但是耗时长，没有对上一次匹配的结果进行利用，浪费了很多空间
     *
     */
    void KMP(){

    }
}
