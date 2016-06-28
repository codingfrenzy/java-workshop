import java.util.*;

/**
 * Created by prasanthnair on 6/27/15.
 */
public class Solution {

    public static int numIslands(char[][] grid) {
        class Coordinates {
            public int x;
            public int y;

            public Coordinates(int i, int j) {
                x = i;
                y = j;
            }

            public String toString() {
                return x + " " + y;
            }
        }

        if (grid.length <= 0 || grid == null)
            return 0;

        int count = 0;
        LinkedList<Coordinates> q = new LinkedList<Coordinates>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    q.addFirst(new Coordinates(i, j));
                    grid[i][j] = '2';
                    count++;

                    while (q.size() > 0) {
                        Coordinates current = q.poll();
                        int ii = current.x;
                        int jj = current.y;

                        if (ii - 1 >= 0 && grid[ii - 1][jj] == '1') {
                            q.addFirst(new Coordinates(ii - 1, jj));
                            grid[ii - 1][jj] = '2';
                        }
                        if (jj - 1 >= 0 && grid[ii][jj - 1] == '1') {
                            q.addFirst(new Coordinates(ii, jj - 1));
                            grid[ii][jj - 1] = '2';
                        }
                        if (jj + 1 < grid[ii].length && grid[ii][jj + 1] == '1') {
                            q.addFirst(new Coordinates(ii, jj + 1));
                            grid[ii][jj + 1] = '2';
                        }
                        if (ii + 1 < grid.length && grid[ii + 1][jj] == '1') {
                            q.addFirst(new Coordinates(ii + 1, jj));
                            grid[ii + 1][jj] = '2';
                        }
//                        System.out.println(ii + " " + jj);
//                        for(Object obj : q) {
//                            System.out.println(obj);
//                        }
//                        System.out.println(Arrays.toString(grid[ii]));
                    }
                }
            }
        }

        return count;
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        /*
        Use BFS

        get all words from the set (by iterating through the set)
        from that get only words that differ by 1
        use queue for keeping track of visited words
        use stack per item of Q to remember the path (so its a queue of stacks)

        */

        if (beginWord == null || endWord == null || wordList == null || beginWord.isEmpty() || endWord.isEmpty()) {
            return 0;
        }

        int returnCount = 0;//, processCount=0, addCount=0;
        LinkedList<String> q = new LinkedList<String>();

        q.addLast(beginWord);
        String currentWord;

        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }

        while ((currentWord = q.peekFirst()) != null) {
            returnCount++;
            int size = q.size();
//            System.out.println(size);
//            System.out.println(wordList.toString());
            if (q.contains(endWord)) {
                return returnCount;
            }

            for (int i = 0; i < size; i++) {
//                System.out.println(q.toString());
                currentWord = q.pollFirst();

                char[] cWordArray = currentWord.toCharArray();
                for (int j = 0; j < beginWord.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char temp = cWordArray[j];
                        cWordArray[j] = c;
                        String test = String.valueOf(cWordArray);
                        cWordArray[j] = temp;
                        if (wordList.contains(test)) {
                            wordList.remove(test);
                            q.addLast(test);
                        }
                    }
                }
            }
        }

        return 0;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null && wordDict == null)
            return true;
        if (s == null || wordDict == null)
            return false;
        //dp[i] represents if s.substring(0, i+1) is wordbreakable.
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            System.out.println(dp[i]);
            for (int j = 0; j < i; j++) {
                System.out.println(dp[j] + " " + s.substring(j, i));
                if (dp[j] && wordDict.contains(s.substring(j, i)))
                    dp[i] = true;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] st = {"school","less"};
        Set<String> h = new HashSet<String>(Arrays.asList(st));
        System.out.println(s.wordBreak("schoolless", h));
    }
}