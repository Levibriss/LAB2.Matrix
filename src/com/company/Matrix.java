package com.company;

public class Matrix {
    private int[][] Matrix; //Двумерный массив для храния матрицы
    int size;               //размер матрицы

    Matrix (int a){
        size = a;
        Matrix = new int[a][a];
        for(int i = 0; i < a; i++){
            Matrix[i][i] = 1;
        }
    }

    public Matrix sum(Matrix b){                            //сложение матриц
        Matrix tmp = new Matrix(size);
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                tmp.SetElement(i, j, Matrix[i][j] + b.Matrix[i][j]);
            }
        }
       return tmp;
    }

    public Matrix product(Matrix b){                  // умножение матриц
        Matrix tmpMatrix = new Matrix(size);
        for(int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                int tmp = 0;
                for (int n = 0; n < size; n++) {
                    tmp += Matrix[row][n] * b.Matrix[n][column];
                }
                tmpMatrix.SetElement(row, column, tmp);
            }
        }
        return tmpMatrix;
    }

    public void SetElement(int row, int column, int value){   //встаить элемент в матрицу
        Matrix[row][column] = value;
    }

    public int GetElement(int row, int column){
        return Matrix[row][column];
    } //

    public String toString(){                       //вывод матрицы в консоль
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < size; i++) {
            tmp.append("[");
            for (int j = 0; j < size; j++) {
                tmp.append(Matrix[i][j]).append(" ");
            }
            tmp.append("]\n");
        }
        return tmp.toString();
    }

    public Matrix doMirrorDig (int type){         //отражение по диагонали
        Matrix mir = new Matrix(size);
        if(type != 0 & type !=1) {
            System.out.println("Sorry. Wrong type.");
            mir.Matrix = Matrix;
            return mir;
        }
        if (type == 0)                          //отражение по главной диагонали
            for (int i = 0; i<size; i++){
                for(int j = 0; j<size; j++){
                    mir.SetElement(j, i, GetElement(i,j));
                }
            }
        if(type == 1){                          //отражение по побочной диагонали
            for (int i = 0, l = size -1  ; i<size | l >0; i++, l--){
                for (int j = 0, n = size - 1 ; j <size| n >0; j++, n--) {
                    mir.SetElement(n, l, GetElement(i,j));
                }
            }
        }
        return mir;
    }
    public int getSize(){
        return size;
    }
}
