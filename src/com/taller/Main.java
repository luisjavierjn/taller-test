package com.taller;

import java.util.*;

public class Main {

    public static class Par {
        int primero;
        int segundo;

        public Par(int primero, int segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }
    }

    public static boolean compareArrays(Integer[] arr1, Integer[] arr2) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(arr2));
        return set1.equals(set2);
    }

    public static void myPrint(List<Integer[]> myArrays) {
        if(myArrays.size() == 0) {
            System.out.println("[]");
        }

        myArrays.forEach(x -> {
            int l = x.length;
            for(int i=0; i<l; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
        });
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();
        testCase7();
        testCase8();
    }

    public static List<Integer[]> MyFunction(int[] numbers, int targetSum) {
        int n = numbers.length;
        int total = 0;
        List<Integer[]> retval = new ArrayList<>();

        HashMap<Integer, Par> comb = new HashMap<>();

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                Par par = new Par(i,j);
                int key = numbers[i] + numbers[j];
                comb.put(key,par);
            }
        }

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int suma = numbers[i] + numbers[j];

                if(comb.containsKey(targetSum - suma)) {

                    Par p = comb.get(targetSum - suma);

                    if(p.primero != i && p.segundo != i && p.primero != j && p.segundo != j) {
                        Integer[] cuadruplas = {numbers[i], numbers[j], numbers[p.primero], numbers[p.segundo]};
                        total = numbers[i] + numbers[j] + numbers[p.primero] + numbers[p.segundo];

                        boolean encontrado = false;
                        for(int k=0; k< retval.size(); k++) {
                            if(compareArrays(retval.get(k),cuadruplas))
                                encontrado = true;
                        }

                        if(!encontrado) retval.add(cuadruplas);
                    }
                }
            }
        }

        return retval;
    }

    public static void testCase1() {
        System.out.println();
        int[] numbers = {7 , 6,  4, -1, 1 ,2};
        int targetSum = 16;

        System.out.println("Test Case1");
        myPrint(MyFunction(numbers,targetSum));
    }

    public static void testCase2() {
        System.out.println();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int targetSum = 10;

        System.out.println("Test Case2");
        myPrint(MyFunction(numbers,targetSum));
    }

    public static void testCase3() {
        System.out.println();
        int[] numbers = {5, -5, -2, 2, 3, -3};
        int targetSum = 0;

        System.out.println("Test Case3");
        myPrint(MyFunction(numbers,targetSum));
    }

    public static void testCase4() {
        System.out.println();
        int[] numbers = {-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int targetSum = 4;

        System.out.println("Test Case4");
        myPrint(MyFunction(numbers,targetSum));
    }

    public static void testCase5() {
        System.out.println();
        int[] numbers = {-1, 22, 18, 4, 7, 11, 2, -5, -3};
        int targetSum = 30;

        System.out.println("Test Case5");
        myPrint(MyFunction(numbers,targetSum));
    }

    public static void testCase6() {
        System.out.println();
        int[] numbers = {-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5};
        int targetSum = 20;

        System.out.println("Test Case6");
        myPrint(MyFunction(numbers,targetSum));
    }

    public static void testCase7() {
        System.out.println();
        int[] numbers = {1, 2, 3, 4, 5};
        int targetSum = 100;

        System.out.println("Test Case7");
        myPrint(MyFunction(numbers,targetSum));
    }

    public static void testCase8() {
        System.out.println();
        int[] numbers = {1, 2, 3, 4, 5, -5, 6, -6};
        int targetSum = 5;

        System.out.println("Test Case8");
        myPrint(MyFunction(numbers,targetSum));
    }
}
