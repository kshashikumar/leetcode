class Solution {

    public void markIsland(char[][] grid, int st, int ed, int marker) {
        if (grid[st][ed] == '0') {
            return;
        } else {
            char ch = (char) marker;
            grid[st][ed] = ch;
            System.out.println("Inner:  st: " + st + " ed: " + ed);
            if (st >= 0 && st < grid.length && ed >= 0 && ed + 1 < grid[0].length && grid[st][ed + 1] == '1') {
                markIsland(grid, st, ed + 1, marker);
            }
            if (st >= 0 && st + 1 < grid.length && ed >= 0 && ed < grid[0].length && grid[st + 1][ed] == '1') {
                markIsland(grid, st + 1, ed, marker);
            }
            if (st >= 0 && st < grid.length && ed - 1 >= 0 && ed < grid[0].length && grid[st][ed - 1] == '1') {
                markIsland(grid, st, ed - 1, marker);
            }
            if ((st - 1) >= 0 && st < grid.length && ed >= 0 && ed < grid[0].length && grid[st - 1][ed] == '1') {
                markIsland(grid, st - 1, ed, marker);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int marker = -1, c = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    System.out.println("i: " + i + " j: " + j);
                    c++;
                    markIsland(grid, i, j, marker);
                    marker--;
                }
            }
        }
        return c;
    }
}