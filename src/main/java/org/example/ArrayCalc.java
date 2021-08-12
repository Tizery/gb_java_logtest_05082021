package org.example;

public class ArrayCalc implements Arrayable{

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            sum += arr[i];
        }
        return sum;
    }

    @Override
    public int[] convertInNewArr(int[] arr) {
        int x = 0;
        int [] result = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                x = arr[i];
                result = new int[arr.length - i - 1];
                for (int j = i + 1, k = 0; j < arr.length; j++, k++) {
                    if (arr[j] == 4) continue;
                    result[k] = arr[j];
                }
            }
        }
        try{
            x = 1 / x;
        } catch(ArithmeticException e){
            throw new RuntimeException();
        }
        return result;
    }

    public boolean checkArr (int[] arr) {
        boolean one = false;
        boolean four = false;
        for (int a : arr) {
            if (a != 1 && a !=4)
                return false;
            if (a == 1)
                one = true;
            if (a == 4)
                four = true;
        }
        return (one && four);
    }

}
