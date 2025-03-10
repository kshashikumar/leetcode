public class Closest
Binary Search
Tree Value
{
      // traverse the tree to left if target is ledd than root and to right if greater than root. at each stage find difference between root.val to target and closest to target and update closest accordingly also if closest value is greater than the root value when the difference is same take the small value
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)
                    || (Math.abs(root.val - target) == Math.abs(closest - target) && root.val < closest)) {
                closest = root.val;
            }

            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }
}
