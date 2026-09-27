class Solution {
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] pre, int[] in, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(pre[index++]);

        int i = left;
        while (in[i] != root.val) i++;

        root.left = build(pre, in, left, i - 1);
        root.right = build(pre, in, i + 1, right);

        return root;
    }
}