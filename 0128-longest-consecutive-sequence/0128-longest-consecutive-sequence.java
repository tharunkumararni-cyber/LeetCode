class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) s.add(n);

        int ans = 0;
        for (int n : s) {
            if (!s.contains(n - 1)) {
                int x = n;
                while (s.contains(x)) x++;
                ans = Math.max(ans, x - n);
            }
        }
        return ans;
    }
}