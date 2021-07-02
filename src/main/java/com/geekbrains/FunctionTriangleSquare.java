package com.geekbrains;

public class FunctionTriangleSquare {

    public double squareTriangle(Double a, Double b, Double c) {
        double pp = (a + b + c) / 2.0;
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
    }

 //   public static void main(String[] args) {
 //       Double a = -1.0;
 //       Double b = 5.0;
 //       Double c = 3.0;
 //       System.out.println(squareTriangle(a, b, c));
 //   }
}
