/**
 * For example,
 Given board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class WordSearchTwo {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int rowindex, int colindex, boolean[][] visited) {
        if (index == word.length())
            return true;
        if (rowindex < 0 || colindex < 0 || rowindex >=board.length || colindex >= board[0].length)
            return false;
        if (visited[rowindex][colindex])
            return false;
        if (board[rowindex][colindex] != word.charAt(index))
            return false;
        visited[rowindex][colindex] = true;
        boolean res = dfs(board, word, index + 1, rowindex - 1, colindex,
                visited)
                || dfs(board, word, index + 1, rowindex + 1, colindex, visited)
                || dfs(board, word, index + 1, rowindex, colindex + 1, visited)
                || dfs(board, word, index + 1, rowindex, colindex - 1, visited);
        visited[rowindex][colindex] = false;
        return res;
    }
    public static void main(String[] args){
        char[][] chars={{'A','B','C','D'},{'S','F','C','S'},{'V','F','B','G'},{'H','N','C','K'},{'L','E','R','S'}};
        for (char[] tempChar:chars){
        System.out.println(Arrays.toString(tempChar));}
        String string="ACFFERSGBFVS";
        WordSearchTwo wordSearchTwo=new WordSearchTwo();
        System.out.println(wordSearchTwo.exist(chars,string));
    }
}
