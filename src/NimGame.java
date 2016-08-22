import java.util.Stack;

/**
 * Created by prasanthnair on 8/17/16.
 */
/*
https://leetcode.com/problems/nim-game/

292. Nim Game  QuestionEditorial Solution  My Submissions
Total Accepted: 90402
Total Submissions: 167491
Difficulty: Easy
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 */

public class NimGame extends ASolution {
    @Override
    void runSolution() {
        println("Win? " + (canWinNim(8) ? "yes" : "no"));
    }

    int[] choices = {1, 2, 3};
    Stack<Game> st = new Stack<>();

    class Game {
        int n;
        int turn;

        Game(int n, int turn) {
            this.n = n;
            this.turn = turn;
        }
    }

    private boolean canWinNim(int n) {
        return n%4>0;
    }
    private boolean canWinNim1(int n) {

        if (n <= 3)
            return true;

        boolean canHeWin = false;
        boolean canIWin = false;
        st.push(new Game(n, 1));
        while (!st.empty()) {
            Game g = st.pop();
//            if ((g.n == 4 && g.turn % 2 == 0) || (g.n <= 3 && g.turn % 2 == 1)) {
//                canIWin = true;
//            }
            if((g.n == 4 && g.turn % 2 == 1) || (g.n <= 3 && g.turn % 2 == 0)){
                return false;
            }
            for (int ch : choices) {
                if (g.n - ch > 3) {
                    st.push(new Game(g.n - ch, g.turn + 1));
                }
            }
        }
        return true;
    }

}
