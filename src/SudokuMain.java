
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gishan-mac
 */
public class SudokuMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Random r = new Random();
        int ar[][] = new int[9][9];
        boolean x = true;

        for (int[] ar1 : ar) {
            for (int j = 0; j < ar.length; j++) {
                ar1[j] = r.nextInt(10);
                while (ar1[j] == 0) {
                    ar1[j] = r.nextInt(10);
                }
            }
        }
//        while (x) {
//            x = false;
//            for (int i = 0; i < ar.length; i++) {
//                numcheckha(ar, r, i, x);
//            }
//            for (int i = 0; i < ar.length; i++) {
//                numcheckva(ar, r, i, x);
//            }
//        }

        numcheckbas(ar, r);
        for (int[] ar1 : ar) {
            for (int j = 0; j < ar.length; j++) {
                System.out.print(ar1[j] + " ");
            }
            System.out.println();
        }

    }

    static void numcheckha(int ar2d[][], Random random, int raw, boolean x) {
//        boolean z = true;
//        while (z) {
//            z = false;
        for (int j = 0; j < ar2d.length; j++) {

            f1:
            for (int l = 0; l < j; l++) {
//                    if (l == j) {
//                        break;
//                    }
//                    System.out.println("l = "+l);
                while (ar2d[raw][j] == 0) {
                    ar2d[raw][j] = random.nextInt(10);
                    x = true;
                }
                while (ar2d[raw][l] == ar2d[raw][j]) {
//                        System.out.println("before "+ar2d[raw][j]);
                    ar2d[raw][j] = random.nextInt(10);
//                        System.out.println("after "+ar2d[raw][j]);
                    l = 0;
                    x = true;
                    //  z = true;
                    //  break f1;
                    while (ar2d[raw][j] == 0) {
                        ar2d[raw][j] = random.nextInt(10);
                    }
                }

            }
        }

//        }
    }

    static void numcheckva(int ar2d[][], Random random, int column, boolean x) {
//        boolean z = true;
//        while (z) {
//            z = false;
        for (int j = 0; j < ar2d.length; j++) {

            f1:
            for (int l = 0; l < j; l++) {
//                    if (l == j) {
//                        break;
//                    }
//                    System.out.println("l = "+l);
                while (ar2d[j][column] == 0) {
                    ar2d[j][column] = random.nextInt(10);
                    x = true;
                }
                while (ar2d[l][column] == ar2d[j][column]) {
//                        System.out.println("before "+ar2d[raw][j]);
                    ar2d[j][column] = random.nextInt(10);
//                        System.out.println("after "+ar2d[raw][j]);
                    l = 0;
                    x = true;
                    //  z = true;
                    //  break f1;
                    while (ar2d[j][column] == 0) {
                        ar2d[j][column] = random.nextInt(10);
                    }
                }

            }
        }

//        }
    }

    static void numcheckbas(int ar2d[][], Random random) {
//        boolean z = true;
//        while (z) {
//            z = false;
        for (int i = 0; i < ar2d.length; i++) {
            System.out.println("");
            for (int[] ar1 : ar2d) {
            for (int j = 0; j < ar2d.length; j++) {
                System.out.print(ar1[j] + " ");
            }
            System.out.println();
        }
            System.out.println("");
            System.out.println("i = "+ i);
            for (int j = 0; j < ar2d.length; j++) {
                System.out.println("j = "+j);
//                for (int k = 0; k < ar2d.length; k++) {
//
//                    for (int l = 0; l < ar2d.length; l++) {
//                    if (i==k&&l == j) {
//                        break;
//                    }
////                    System.out.println("l = "+l);
//                        while (ar2d[i][j] == 0) {
//                            ar2d[i][j] = random.nextInt(10);
////                            x = true;
//                        }
//                        while ((ar2d[k][l] == ar2d[i][j]) || (ar2d[l][k] == ar2d[i][j])) {
////                        System.out.println("before "+ar2d[raw][j]);
//                            ar2d[i][j] = random.nextInt(10);
////                        System.out.println("after "+ar2d[raw][j]);
//                            l = 0;
////                            x = true;
//                      //  z = true;
//                            //  break f1;
//                            while (ar2d[i][j] == 0) {
//                                ar2d[i][j] = random.nextInt(10);
//                            }
//                        }
//
//                    }
//                }
                int k = 0, l = 0;
                boolean y;
                while ((k < j) && (l < i)) {
                    y=false;
                    while ((ar2d[i][j] == ar2d[i][k]) || (ar2d[i][j] == ar2d[l][j])||(ar2d[i][j]==0)) {
                    //    System.out.println("before "+ar2d[i][j]);
                        ar2d[i][j] = random.nextInt(10);
                      //  System.out.println("after "+ar2d[i][j]);
                        y=true;
                    }
                    if (k < j) {
                        k++;
                    }
                    if (l < i) {
                        l++;
                    }
                    if(y){
                        k = 0;
                        l = 0;
                    //    System.out.println("run");
                    }
                }

            }

        }
//        }
    }

}
