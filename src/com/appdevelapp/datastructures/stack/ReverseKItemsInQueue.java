package com.appdevelapp.datastructures.stack;

import com.appdevelapp.datastructures.queue.Queue;
import com.apple.laf.AquaEditorPaneUI;

public class ReverseKItemsInQueue {
    public static <V> void reverseK(Queue<V> queue, int k) throws Exception {
        Stack<V> stack = new Stack<>(k);
        int i = 0;
        while (i < k){
            if(queue.isEmpty()){
                break;
            }
            V element = queue.dequeue();
            stack.push(element);
            i++;
        }

        Queue<V> tempQueue = new Queue<>(queue.getMaxSize() - k);
        while(!queue.isEmpty()){
            tempQueue.enqueue(queue.dequeue());
        }

        while (!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        while (!tempQueue.isEmpty()){
            queue.enqueue(tempQueue.dequeue());
        }
    }
}
