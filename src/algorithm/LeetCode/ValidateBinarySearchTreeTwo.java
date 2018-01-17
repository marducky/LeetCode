/**
 *
 * 这题实际上简化了难度，因为一般的二叉搜索树是左<=根<右，而这道题设定为左<根<右，那么就可以用中序遍历来做。因为如果不去掉左=根这个条件的话，那么下边两个数用中序遍历无法区分：

20       20
/           \
20           20

它们的中序遍历结果都一样，但是左边的是BST，右边的不是BST。去掉等号的条件则相当于去掉了这种限制条件。下面我们来看使用中序遍历来做，这种方法思路很直接，通过中序遍历将所有的节点值存到一个数组里，然后再来判断这个数组是不是有序的，代码如下：
 */

package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTreeTwo {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }
    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

}
