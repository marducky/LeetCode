package algorithm.LeetCode;

public class ConstructBinaryTreeFromPreorderAndInorderTravers {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        return buildTree(preorder, 0, preLength - 1, inorder, 0, inLength - 1);
    }

    public TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preEnd)
            return null;

        int rootVal = pre[preStart];
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, preStart + 1, preStart + len, in, inStart, rootIndex - 1);
        root.right = buildTree(pre, preStart + len + 1, preEnd, in, rootIndex + 1, inEnd);

        return root;
    }
}
