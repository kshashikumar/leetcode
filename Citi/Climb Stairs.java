public class Climb Stairs
{

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        if (mp.containsKey(n)) {
            return mp.get(n);
        }
        int t = climbStairs(n - 1) + climbStairs(n - 2);
        mp.put(n, t);
        return mp.get(n);
    }
}
