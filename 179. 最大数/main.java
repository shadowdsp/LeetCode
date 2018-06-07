class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) count++;
            s[i] = String.valueOf(nums[i]);
        }
        if (count <= 0) return "0";
        Arrays.sort(s, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(s[i]);
        }
        return sb.toString();
    }
}