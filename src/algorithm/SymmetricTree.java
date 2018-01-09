package algorithm;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return ST(root.left, root.right);

    }

    private boolean ST(TreeNode left, TreeNode right) {
        TreeNode l = left;
        TreeNode r = right;
        if (l == null && r == null)
            return true;
        else if (l != null && r != null) {
            return l.val == r.val && ST(l.left, r.right) && ST(l.right, r.left);
        } else return false;

    }

    public void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        if (root.right != null) {
            printTree(root.right);
//            System.out.println(root.right.val);
        }
        if (root.left != null) {
            printTree(root.left);
//            System.out.println(root.left.val);
        }

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
        SymmetricTree symmetricTree = new SymmetricTree();
        symmetricTree.printTree(treeNode10);
        System.out.println(symmetricTree.isSymmetric(treeNode10));
    }
}
