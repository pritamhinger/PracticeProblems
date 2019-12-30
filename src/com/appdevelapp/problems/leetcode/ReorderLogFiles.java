package com.appdevelapp.problems.leetcode;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        BTree letterTree = new BTree();
        BTree digitTree = new BTree();
        for (String log:logs) {
            int type = getLogType(log);
            switch (type){
                case 1:
                    LogPart logPart = ParseLog(log);
                    break;
                case 2:
                    System.out.println("Digit Type");
                    break;
                default:
                    continue;
            }
        }
        return logs;
    }

    private int getLogType(String log) {
        int index = log.indexOf(" ");
        char ch = log.charAt(index+1);
        if(ch >= 'a' && ch <= 'z'){
            return 1;
        }
        else if(ch >= '0' && ch <= '9'){
            return 2;
        }
        return 0;
    }

    private LogPart ParseLog(String log){
        int index = log.indexOf(" ");
        String identifier = log.substring(0, index);
        LogPart logPart = new LogPart();
        logPart.identifier = identifier;
        logPart.log = log;
        return  logPart;
    }
}


class BTreeNode{
    int index;
    BTreeNode left;
    BTreeNode right;

    BTreeNode(int index){
        this.index = index;
        this.left = null;
        this.right = null;
    }
}

class BTree{
    private BTreeNode root;
    BTree(){
        this.root = null;
    }

    public BTreeNode getRoot(){
        return this.root;
    }

    public void setRoot(BTreeNode node){
        this.root = node;
    }
}

class LogPart{
    String identifier;
    String log;
    int index;
}