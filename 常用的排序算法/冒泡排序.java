/*
冒泡排序就是把小的元素往前调或者把大的元素往后调。
比较是相邻的两个元素比较，交换也发生在这两个元素之间。
所以，如果两个元素相等，我想你是不会再无聊地把他们俩交换一下的；
如果两个相等的元素没有相邻，那么即使通过前面的两两交换把两个相邻起来，这时候也不会交换，
所以相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法。 
*/

class Solution {
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    nums[j] ^= nums[j+1];
                    nums[j+1] ^= nums[j];
                    nums[j] ^= nums[j+1];
                }
            }
        }
    }
}