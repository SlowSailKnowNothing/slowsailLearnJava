package leetcodeTreeTest;


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public  class leetcodeDFSTarget {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;

        dfs(root,target,res,new ArrayList<>());
        return res;
    }

    public  static void  dfs(TreeNode root,int target,List<List<Integer>> res,List<Integer> list){
        if(root==null)return;
        if(root!=null&&root.left==null&&root.left==null){
            if(target-root.val==0){
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }else return;
        }

        list.add(root.val);
        dfs(root.left,target-root.val,res,list);
        dfs(root.right,target-root.val,res,list);
        list.remove(list.size()-1);


    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.left=null;
        root.right=new TreeNode(3,null,null);

        System.out.println(pathSum(root,-2));
    }
}
