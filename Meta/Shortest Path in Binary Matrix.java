public class Shortest
Path in
Binary Matrix
{
    
    // In this question, we need to mantain a directions array to move to 8 directions and then use a queue to store (row,col,distance) after you store in queue mark the space as visited, then until the queue is empty poll the queue values and check the 8 directions of each of the polled value from queue, if we find any 0 in those 8 directions then we need to store (newRow,newCol,distance+1) it in queue.if we reach end of matrix return the distance
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, 1 });

        grid[0][0] = 1;

        while (!q.isEmpty()) {

            int[] s = q.poll();

            int r = s[0], c = s[1], d = s[2];

            if (r == n - 1 && c == n - 1)
                return d;

            for (int i = 0; i < directions.length; i++) {
                int newRow = r + directions[i][0];
                int newCol = c + directions[i][1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    q.offer(new int[] { newRow, newCol, d + 1 });
                    grid[newRow][newCol] = 1;
                }
            }

        }

        return -1;
    }
}
