class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if ((n + m) % 2 == 0) {
            return (findK(nums1, 0, nums2, 0, (n + m) / 2) +
                    findK(nums1, 0, nums2, 0, (n + m) / 2 + 1)) / 2.0;
        } else {
            return findK(nums1, 0, nums2, 0, (n + m) / 2 + 1);
        }
    }

    private double findK(int[] nums1, int ida, int[] nums2, int idb, int k) {
        System.out.println(ida + " - " + idb + " : " + k);
        if (nums1.length <= ida) {
            return nums2[idb+k-1];
        }
        if (nums2.length <= idb) {
            return nums1[ida+k-1];
        }
        if (k == 1) {
            return Math.min(nums1[ida], nums2[idb]);
        }
        int mid = k / 2 - 1;
        int l = ida + mid < nums1.length ? nums1[ida+mid] : Integer.MAX_VALUE;
        int r = idb + mid < nums2.length ? nums2[idb+mid] : Integer.MAX_VALUE;
        int pos = k / 2;
        if (l < r) {
            return findK(nums1, ida + pos, nums2, idb, k - pos);
        } else {
            return findK(nums1, ida, nums2, idb + pos, k - pos);
        }
    }
}