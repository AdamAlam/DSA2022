public class ContainerWithMostWater {

    // https://leetcode.com/problems/container-with-most-water/

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }


    public static int maxAreaBrute(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                int curArea = h * w;
                area = (curArea > area) ? curArea : area;
            }
        }


        return area;
    }

    public static int maxArea(int[] height) {
        int max_area = 0;

        int i = 0;
        int j = height.length - 1;

        while (i != j) {
            int curArea = Math.min(height[i], height[j]) * (j - i);
            max_area = Math.max(max_area, curArea);
            if (height[i] < height[j]){
                i++;
            } else {
                j--;
            }

        }
        return max_area;
    }


}
