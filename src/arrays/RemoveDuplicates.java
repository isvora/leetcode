package arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int l = 1;
        for (int r=1; r<nums.length; r++) {
            if (nums[r] != nums[r-1]) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
