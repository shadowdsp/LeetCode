import jdk.internal.jshell.tool.resources.l10n;

/*
选择排序是给每个位置选择当前元素最小的，
比如给第一个位置选择最小的，在剩余元素里面给第二个元素选择第二小的，依次类推，
直到第n-1个元素，第n个元素不用选择了，因为只剩下它一个最大的元素了。
那么，在一趟选择，如果当前元素比一个元素小，而该小的元素又出现在一个和当前元素相等的元素后面，那么交换后稳定性就被破坏了。
比较拗口，举个例子，序列5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，
那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法。 
*/

class Solution {
    public void selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int id = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[id] > nums[j]) {
                    id = j;
                }
            }
            if (id != i) {
                nums[i] ^= nums[id];
                nums[id] ^= nums[i];
                nums[i] ^= nums[id];
            }
        }
    }
}