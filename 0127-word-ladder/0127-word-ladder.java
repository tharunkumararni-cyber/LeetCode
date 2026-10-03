class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                String s = q.poll();
                char[] a = s.toCharArray();

                for (int i = 0; i < a.length; i++) {
                    char old = a[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        a[i] = c;
                        String t = new String(a);
                        if (t.equals(endWord)) return level + 1;
                        if (set.remove(t)) q.add(t);
                    }
                    a[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}