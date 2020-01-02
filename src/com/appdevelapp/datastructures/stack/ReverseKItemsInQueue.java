package com.appdevelapp.datastructures.stack;

import com.appdevelapp.datastructures.queue.Queue;

public class ReverseKItemsInQueue {
    public static <V> void reverseK(Queue<V> queue, int k) throws Exception {
        Stack<V> stack = new Stack<>(k);
        int queueSize = queue.getCurrentSize();
        int i = 0;
        while (i < k){
            if(queue.isEmpty()){
                break;
            }
            V element = queue.dequeue();
            stack.push(element);
            i++;
        }

        while (!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        for (int j = 0; j < (queueSize - k); j++) {
            queue.enqueue(queue.dequeue());
        }

//        Queue<V> tempQueue = new Queue<>(queue.getMaxSize() - k);
//        while(!queue.isEmpty()){
//            tempQueue.enqueue(queue.dequeue());
//        }
//
//
//
//        while (!tempQueue.isEmpty()){
//            queue.enqueue(tempQueue.dequeue());
//        }
    }
}
