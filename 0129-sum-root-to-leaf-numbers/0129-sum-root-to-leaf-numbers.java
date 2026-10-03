class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode r, int n) {
        if (r == null) return 0;
        n = n * 10 + r.val;
        if (r.left == null && r.right == null) return n;
        return dfs(r.left, n) + dfs(r.right, n);
    }
}