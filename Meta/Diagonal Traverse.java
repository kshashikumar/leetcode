public class Diagonal Traverse
{
    //initially traverse towards up and when the row is out of bound then switvh direction and move down, consider the edge cases where both rw and colum can also go out of bounds
    public int[] findDiagonalOrder(int[][] mat) {
        int r = 0, c = 0, dir = 0, k = 0;

        int rows = mat.length, cols = mat[0].length;

        int[] ans = new int[rows * cols];

        while (k < rows * cols) {

            if (dir == 0) {

                while (r >= 0 && c < cols) {
                    ans[k++] = mat[r][c];
                    r--;
                    c++;
                }

                if (c == cols) {
                    c--;
                    r += 2;
                } else {
                    r++;
                }

                dir = 1;

            } else {

                while (r < rows && c >= 0) {
                    ans[k++] = mat[r][c];
                    r++;
                    c--;
                }

                if (r == rows) {
                    r--;
                    c += 2;
                } else {
                    c++;
                }

                dir = 0;
            }

        }

        return ans;

    }
}
