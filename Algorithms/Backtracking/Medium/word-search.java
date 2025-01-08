
// Array, String, Backtracking, Depth-First Search, Matrix

// initialize rows and cols in global scope.
// loop through the matrix/array of arrays with r, c, check if dfs(board, word, r, c, 0), if yes return true. Else return false at the end.
// in dfs(char[][] board, String word, int r, int c, int index), check if index == word length, if yes the we have traversed till end and found all word, return true.
// check if 0 <= r < rows, or 0 <= c < cols, or if board[r][c] equals word.charAt(index), that means r and c are within bound (board) and word matches. If not then return false.
// board[r][c] = '*', // change the character of word to '*', so that we dont go through it again.
// now create variable 'result' and assign it to dfs(board, word, r - 1, c, index + 1) or dfs(board, word, r + 1, c, index + 1) or dfs(board, word, r, c - 1, index + 1) or dfs(board, word, r, c + 1, index + 1)
// board[r][c] = word.charAt(index), // backtracking, change the '*' back to its original word, and finally return result;

package Algorithms.Backtracking.Medium;

class Solution {
  private int rows;
  private int cols;

  public boolean exist(char[][] board, String word) {
    rows = board.length;
    cols = board[0].length;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (dfs(board, word, r, c, 0)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean dfs(char[][] board, String word, int r, int c, int index) {
    if (index == word.length()) {
      return true;
    }

    if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word.charAt(index)) {
      return false;
    }

    board[r][c] = '*';

    boolean result = dfs(board, word, r - 1, c, index + 1) || dfs(board, word, r + 1, c, index + 1)
        || dfs(board, word, r, c - 1, index + 1) || dfs(board, word, r, c + 1, index + 1);

    board[r][c] = word.charAt(index);

    return result;
  }
}
