package kuaishou;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeTreeTest {
    public static void main(String[] args) {
//        TNode t1=new TNode(1);
//        t1.left=new TNode(7);
//        t1.right=new TNode(2);
//
//        TNode t2=new TNode(2);
//        t2.left=new TNode(1);
//
//        TNode tNode = mergeTree(t1, t2);
//
//        dfs(tNode);

        String t1String="1,2,3,4,NULL,NULL,5,6,NULL,NULL,NULL,NULL,7,NULL,NULL";
        String t2String="1,3,NULL,NULL,10,15,NULL,NULL,16,NULL,NULL";
        TNode tNode1 = buildTree(t1String.split(","));
        TNode tNode2 = buildTree(t2String.split(","));
        dfs(tNode1);
        dfs(tNode2);

        TNode tNode = mergeTree(tNode1, tNode2);
        dfs(tNode);

    }

    public static void dfs(TNode node){
        if(node!=null){
            System.out.println(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static TNode mergeTree(TNode t1,TNode t2) {
        if(t1==null)return t2;
        if(t2==null)return t1;

        t1.val=t1.val+t2.val;
        t1.right=mergeTree(t1.right,t2.right);
        t1.left=mergeTree(t1.left,t2.left);

        return t1;
    }

    public static TNode buildTree(String[] tree){
        LinkedList<String> treeList = new LinkedList<String>();
        for(String str:tree){
            treeList.add(str);
        }
        return buildTree(treeList);
    }

    public static TNode buildTree(LinkedList<String> tree){
        if(tree.isEmpty())return null;
        String str=tree.poll();
        if(str.equals("NULL"))return null;
        int val=Integer.parseInt(str);
        TNode node = new TNode(val);
        node.left=buildTree(tree);
        node.right=buildTree(tree);
        return node;
    }

    public static class TNode{
        TNode left;
        TNode right;
        int val;
        TNode(int val){
            this.val = val;
        }
    }
}
