class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int[] a, int target, int start,
                   List<Integer> temp, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < a.length; i++) {
            if (i > start && a[i] == a[i - 1])
                continue;

            if (a[i] > target)
                break;

            temp.add(a[i]);
            backtrack(a, target - a[i], i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}