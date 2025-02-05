public class Interval
List Intersections
{
    
    // In this compare the values of the 0 positions of both the arraylists and then keep the max and do same min for 1 positions of array lists then if the st is less than ed then we have a intersection store it and move the pointer of array having less 1 position value
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> li = new ArrayList<>();

        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int st = Math.max(firstList[i][0], secondList[j][0]);
            int ed = Math.min(firstList[i][1], secondList[j][1]);
            System.out.println(st + "  " + ed);

            if (st <= ed) {
                li.add(new int[] { st, ed });
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        for (int t = 0; t < li.size(); t++) {
            System.out.println(li.get(t));
        }
        return li.toArray(new int[li.size()][]);
    }
}
