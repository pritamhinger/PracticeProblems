package com.appdevelapp.datastructures.heap;

public class Heap {
    public static void buildMaxHeap(int[] heapArray, int heapSize)
    {
        // swap largest child to parent node
        for (int i = (heapSize - 1) / 2; i >= 0; i--){
            maxHeapify(heapArray, i, heapSize);
        }
    }

    private static void maxHeapify(int[] heapArray, int index, int heapSize){
        int largest = index;
        while (largest < heapSize / 2){      // check parent nodes only
            int left = (2 * index) + 1;       //left child
            int right = (2 * index) + 2;      //right child

            if (left < heapSize && heapArray[left] > heapArray[index]){
                largest = left;
            }
            if (right < heapSize && heapArray[right] > heapArray[largest]){
                largest = right;
            }
            if (largest != index){ // swap parent with largest child
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;
            }
            else
                break; // if heap property is satisfied
        } //end of while
    }

    public static void buildMinHeap(int[] heapArray, int heapSize) {
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            minHeapify(heapArray, i, heapSize);
        }
    }

    private static void minHeapify(int[] heapArray, int index, int heapSize) {
        int largest = index;

        while (index < heapSize / 2) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < heapSize && heapArray[left] < heapArray[index]) {
                largest = left;
            }

            if (right < heapSize && heapArray[right] < heapArray[largest]) {
                largest = right;
            }

            if (largest != index) {
                System.out.println("Swapping " + heapArray[index] + " with " + heapArray[largest]);
                int temp = heapArray[largest];
                heapArray[largest] = heapArray[index];
                heapArray[index] = temp;
                index = largest;
            } else {
                break;
            }
        }
    }

    public static int[] findKSmallest(int[] arr,int k) {

        int[] result = new int[k];
        int heapSize = arr.length;
        for (int i = 0; i < k; i++) {
            result[i] = removeMin(arr, heapSize);
            heapSize--;
        }

        return result;
    }

    private static int removeMin(int[] arr, int heapSize){
        buildMinHeap(arr, heapSize);
        int min = arr[0];
        arr[0] = arr[heapSize-1];
        return min;
    }

    public static int[] findKLargest(int[] arr,int k)
    {
        int[] result = new int[k];
        int heapSize = arr.length;
        for (int i = 0; i < k; i++) {
            result[i] = removeMax(arr, heapSize);
            heapSize--;
        }
        return result;
    }

    private static int removeMax(int[] arr, int heapSize){
        buildMaxHeap(arr, heapSize);
        int max = arr[0];
        arr[0] = arr[heapSize-1];
        return max;
    }
}
