package LapTrinhHuongDoiTuong.week2;

import java.io.*;
import java.util.Scanner;

public class baitaptuan2 {
  static int fibonacci(int n){
    if(n<0 || n > 100){
      System.out.println("Gia tri nhap vao < 0 hoac > 100 khong ho[ le");
      return -1;
    }
    else if( n == 0 || n == 1) return n;
    else return fibonacci(n-1) + fibonacci(n-2);
  }

  static void Display(int matrix[][], int m, int n){
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
          System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  static void tinhTong(int matrix1[][], int matrix2[][],int m,int n){
    int maxtrixNew[][] = new int[m][n];
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        maxtrixNew[i][j] = matrix1[i][j] + matrix2[i][j];
      }
    }
    Display(maxtrixNew, m, n);
  }

  static void tinhTich(int matrix1[][], int matrix2[][],int m, int n){
    int matrixNew[][] = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            matrixNew[i][j] = 0;
            for (int k = 0; k < n; k++) {
                matrixNew[i][j] = matrixNew[i][j] + matrix1[i][k] * matrix1[k][j];
            }
        }
    }
    Display(matrixNew, m, n);
  }

  public static void main(String [] args) throws IOException{
    int input;
    System.out.println("Nhap so n: ");
    Scanner scanner= new Scanner(System.in);
    input = scanner.nextInt();
    scanner.close();
    System.out.println("Tong so fibonnaci " + input + " la: " + fibonacci(input));
    int m=0,n =0;
    int matrix1[][] = new int[0][];
    int matrix2[][] = new int[0][];
    try{
      Scanner file = new Scanner(new File("/home/vuthoai/CodeJava/LTHDT/week2/matran.txt"));
      m = file.nextInt();
      n = file.nextInt();
      matrix1 = new int[m][n];
      matrix2 = new int[m][n];
      for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
          matrix1[i][j] = file.nextInt();
        }
      }
      for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
          matrix2[i][j] = file.nextInt();
        }
      }
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }
    System.out.println("Ma tran A: ");
    Display(matrix1,m,n);
    System.out.println("Ma tran B: ");
    Display(matrix2,m,n);
    System.out.println("Tong hai ma tran: ");
    tinhTong(matrix1,matrix2,m,n);
    System.out.println("Tich hai ma tran: ");
    tinhTich(matrix1,matrix2,m,n);
  }
}
