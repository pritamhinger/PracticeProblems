package com.appdevelapp.datastructures.stack;

public class FindCelebChallenge {
    public static int findCelebrity(int[][] party, int numPeople) throws Exception {
        int celebrity = -1;
        Stack<Integer> stack = new Stack<>(numPeople);
        for (int i = 0; i < numPeople; i++) {
            stack.push(numPeople - i - 1);
        }

        int firstNumber = -1;
        int secondNumber = -1;

        while (!stack.isEmpty()){
            firstNumber = stack.pop();
            if(stack.isEmpty()){
                break;
            }

            secondNumber = stack.pop();
            if(party[firstNumber][secondNumber] == 1){
                stack.push(secondNumber);
            }
            else {
                stack.push(firstNumber);
            }
        }

        int candidate = firstNumber;
        if(candidate == -1){
            return candidate;
        }

        for (int i = 0; i < numPeople; i++) {
            if(i != candidate && party[candidate][i] != 0){
                return  -1;
            }
        }

        for (int i = 0; i < numPeople; i++) {
            if(i != candidate && party[i][candidate] != 1){
                return -1;
            }
        }

        return candidate;
    }
}
