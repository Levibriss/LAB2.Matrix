package com.company;

public class Main {

    public static void main(String[] args) {
	Matrix a = new Matrix(2);
    a.SetElement(0, 1, 1);
    a.SetElement(1, 0, 1);
    a.SetElement(1, 1, 0);
        System.out.println(a);
        Matrix b = a;
    for (int i = 0; i < 9; i ++){
        b = b.product(a);
        System.out.println(b);
    }

    Matrix dop = new Matrix(3);
        for (int i = 0, n = 0; i < 3; i ++){
            for (int j = 0; j < 3; j++, n++) {
                dop.SetElement(i, j, n);
            }
        }
        System.out.println(dop);

        System.out.println(dop.doMirrorDig(0));
        System.out.println(dop.doMirrorDig(1));
    }
}
