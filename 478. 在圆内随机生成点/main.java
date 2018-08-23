class Solution {
    private double radius;
    private double cx;
    private double cy;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.cx = x_center;
        this.cy = y_center;
    }

    public double[] randPoint() {
        double x, y;
        do {
            x = Math.random() * 2 * radius - radius + cx;
            y = Math.random() * 2 * radius - radius + cy;
        } while (radius * radius < (x - cx) * (x - cx) + (y - cy) * (y - cy));
        return new double[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */