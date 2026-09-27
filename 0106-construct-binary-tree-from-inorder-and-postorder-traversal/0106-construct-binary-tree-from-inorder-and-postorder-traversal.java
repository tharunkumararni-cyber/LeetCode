class Solution {
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] in, int[] post, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(post[index--]);

        int i = left;
        while (in[i] != root.val) i++;

        root.right = build(in, post, i + 1, right);
        root.left = build(in, post, left, i - 1);

        return root;
    }
}