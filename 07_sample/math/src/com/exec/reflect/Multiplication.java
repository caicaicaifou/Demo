package com.exec.reflect;

public class Multiplication implements MathOperation {
    @Override
    public float operate(int a, int b) {
        return a * b;
    }
}
