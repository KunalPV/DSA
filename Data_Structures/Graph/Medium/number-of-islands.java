
// Graph, Array, Depth-First Search, Breadth-First Search, Union Find, Matrix

class Solution {

  // private int rows;
  // private int cols;

  public int numIslands(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (rows == 0)
      return 0;

    int islands = 0;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1') {
          dfs(grid, r, c);
          islands++;
        }
      }
    }

    return islands;
  }

  private void dfs(char[][] grid, int r, int c) {
    int rows = grid.length;
    int cols = grid[0].length;
    if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1') {
      return;
    }

    grid[r][c] = '0';

    dfs(grid, r + 1, c);
    dfs(grid, r - 1, c);
    dfs(grid, r, c + 1);
    dfs(grid, r, c - 1);
  }
}