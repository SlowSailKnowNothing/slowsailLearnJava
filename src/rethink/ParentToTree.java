package rethink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ParentToTree {
    public static void main(String[] args) {
        List<Integer> parent = Stream.of(-1, 0, 1, 4, 0).collect(toList());
        List<Integer> values = Stream.of(-2,10,10,-3,10).collect(toList());
        TreeNode root=buildTreeNode(parent,values);
        printTree(root);

    }


    public static void printTree(TreeNode root){
        System.out.println(root.val);
        if(!root.children.isEmpty()){
            for(TreeNode child : root.children){
                printTree(child);
            }
        }
    }


    public static TreeNode buildTreeNode(List<Integer> parent, List<Integer> val){
        int len=parent.size();
        Map<Integer,TreeNode> map = new HashMap<Integer,TreeNode>();
        for(int i=0;i<len;i++){
            map.put(i,new TreeNode(val.get(i)));
        }
        int root=0;
        for(int i=0;i<len;i++){
            if(parent.get(i)==-1){
                root=i;
            }else{
                TreeNode node=map.get(i);
                TreeNode parentNode=map.get(parent.get(i));
                parentNode.children.add(node);
            }
        } 
        return map.get(root);
    }

    public static  class TreeNode{
        int val;
        List<TreeNode> children;

        TreeNode(int val){
            this.val=val;
            children=new ArrayList<TreeNode>();
        }
    }
}
