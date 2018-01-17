/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
package algorithm.LeetCode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

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
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        System.out.println(maximumDepthOfBinaryTree.maxDepth(treeNode10));
    }
}
