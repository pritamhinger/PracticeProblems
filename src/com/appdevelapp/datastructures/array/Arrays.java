package com.appdevelapp.datastructures.array;

public class Arrays {
    public static boolean ArrayInitializationExample(){
        try{
            int[] arr1 = new int[5];
            int arr2[] = new int[6];
            int arr3[] =  {1,2,3,4,5};
            int[] arr4 = new int[] {6,7,8,9,10,11};

            System.out.println("Arr1 Size is " + arr1.length);
            System.out.println("Arr2 size is " + arr2.length);
            System.out.println("Arr3 with size : " + arr3.length);
            for (int item: arr3) {
                System.out.println(item);
            }

            System.out.println("Arr4 with size : " + arr4.length);
            for (int item: arr4) {
                System.out.println(item);
            }
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
}
