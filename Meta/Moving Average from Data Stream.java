public class Moving
Average from
Data Stream
{
    // follow the object orented principles, take a variable and assign maxwindowsize and add sum then return average based on size of array
    private List<Integer> ans = new ArrayList<>();
    private int maxWindowSize = 0;
    private int windowSize = 0;

    public MovingAverage(int size) {
        this.maxWindowSize = size;
    }

    public double next(int val) {

        ans.add(val);
        int t = maxWindowSize, i = ans.size() - 1;
        double sum = 0;
        while (t > 0 && i >= 0) {
            sum += ans.get(i);
            t--;
            i--;
        }

        return ans.size() > maxWindowSize ? sum / maxWindowSize : sum / ans.size();

    }
}
