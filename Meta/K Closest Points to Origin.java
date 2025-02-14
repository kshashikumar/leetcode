public class K
Closest Points
to Origin
{
    
    // use the Priority Queue and Double Comparator. Calculate the distance of points to origin directly in comparator and then sort until the size of pq is k. at last pop all from pq and store in int[]

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(
                        Math.sqrt(b[0] * b[0] + b[1] * b[1]),
                        Math.sqrt(a[0] * a[0] + a[1] * a[1])));

        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int t = 0;
        while (!pq.isEmpty()) {
            ans[t++] = pq.poll();
        }

        return ans;

    }
}
