class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0;
        
        for (int i = 0; i < n; ++i) 
            for (int j = i + 1; j < n; ++j)
                for (int k = j + 1; k < n; ++k) {
                    double area = area(points, i, j, k);
                    if (area > max) {
                        max = area;
                    }
                }
        
        
        return max;
    }

    double area(int[][] points, int i, int j, int k) {
        int[] p1 = points[i];
        int[] p2 = points[j];
        int[] p3 = points[k];
        
        double area = 0;
        area += area(p1, p2);
        area += area(p2, p3);
        area += area(p3, p1);
        
        return Math.abs(area);
    }
    
    double area(int[] p1, int[] p2) {
        int w = p2[0] - p1[0];
        double h = (p1[1] + p2[1] + 200) / 2.0;
        return w * h;
    }
}