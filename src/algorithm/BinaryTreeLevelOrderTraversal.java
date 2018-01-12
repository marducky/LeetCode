package algorithm;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> resListList = new ArrayList<>();

        return resListList;

    }

    public ArrayList<TreeNode> getPerLevelTreeNode(TreeNode root) {
        if (root == null)
            return null;
        ArrayList<TreeNode> resTreeNode = new ArrayList<TreeNode>();
        resTreeNode.add(root.left);
        resTreeNode.add(root.right);
        return resTreeNode;

    }

    public static void main(String[] args) {
        TreeNode treeNode10 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode31 = new TreeNode(3);
        TreeNode treeNode32 = new TreeNode(4);
        TreeNode treeNode33 = new TreeNode(4);
        TreeNode treeNode34 = new TreeNode(4);
        treeNode10.left = treeNode21;
        treeNode10.right = treeNode22;
        treeNode21.left = treeNode31;
        treeNode21.right = treeNode32;
        treeNode22.left = treeNode33;
        treeNode22.right = treeNode34;
//        SymmetricTree symmetricTree = new SymmetricTree();
//        symmetricTree.printTree(treeNode10);
//        System.out.println(symmetricTree.isSymmetric(treeNode10));
    }
}
