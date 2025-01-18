
// Array, Depth-First Search, Breadth-First Search, Union Find, Matrix

// create a helper dfs function which returns when row or col is out of bounds or not equal to 'O', set board[r][c] = '+' and recursively call it untill it turns all the adjacent 'O' to '+'.
// now in the given 'solve' function, loop through rows and call dfs on every row r and 0th index of col and every row r and (cols - 1)th index. // Left and Right side of matrix
// next do the same but with cols and call dfs on every col c and 0th index of row and every col c and (rows - 1)th index. // Top and Bottom of matrix.
// At last just a loop of loop and check, 
// if(board[r][c] == 'O') board[r][c] = 'X'
// if(board[r][c] == '+') board[r][c] = 'O'

class Solution {
  private int rows;
  private int cols;

  public void solve(char[][] board) {
    rows = board.length;
    cols = board[0].length;

    if (rows == 0)
      return;

    for (int r = 0; r < rows; r++) {
      dfs(board, r, 0);
      dfs(board, r, cols - 1);
    }

    for (int c = 0; c < cols; c++) {
      dfs(board, 0, c);
      dfs(board, rows - 1, c);
    }

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (board[r][c] == 'O') {
          board[r][c] = 'X';
        }
        if (board[r][c] == '+') {
          board[r][c] = 'O';
        }
      }
    }
  }

  private void dfs(char[][] board, int r, int c) {
    if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') {
      return;
    }

    board[r][c] = '+';

    dfs(board, r - 1, c);
    dfs(board, r + 1, c);
    dfs(board, r, c - 1);
    dfs(board, r, c + 1);
  }
}