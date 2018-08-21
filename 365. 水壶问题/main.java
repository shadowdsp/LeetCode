class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || z <= x + y && z % gcd(x, y) == 0) {
            return true;
        }
        return false;
    }

    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}