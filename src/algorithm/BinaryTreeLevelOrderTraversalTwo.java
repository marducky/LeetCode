package algorithm;


import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversalTwo {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curLevCnt = 1;
        int nextLevCnt = 0;
        ArrayList<Integer> levelres = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevCnt--;
            levelres.add(cur.val);

            if (cur.left != null) {
                queue.add(cur.left);
                nextLevCnt++;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevCnt++;
            }

            if (curLevCnt == 0) {
                curLevCnt = nextLevCnt;
                nextLevCnt = 0;
                res.add(levelres);
                levelres = new ArrayList<Integer>();
            }
        }
        return res;
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
        BinaryTreeLevelOrderTraversalTwo binaryTreeLevelOrderTraversalTwo = new BinaryTreeLevelOrderTraversalTwo();
        System.out.println(binaryTreeLevelOrderTraversalTwo.levelOrder(treeNode10));
//        SymmetricTree symmetricTree = new SymmetricTree();
//        symmetricTree.printTree(treeNode10);
//        System.out.println(symmetricTree.isSymmetric(treeNode10));
    }
}
