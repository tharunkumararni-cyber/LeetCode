class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(String s, int start, List<String> cur, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPal(s, start, i)) {
                cur.add(s.substring(start, i + 1));
                backtrack(s, i + 1, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isPal(String s, int l, int r) {
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}