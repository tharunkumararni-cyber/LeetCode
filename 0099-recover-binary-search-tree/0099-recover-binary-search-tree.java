class Solution {
    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }

        prev = root;
        inorder(root.right);
    }
}