//https://leetcode.com/problems/trapping-rain-water/
import java.util.Arrays;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] testArr = {5, 0, 3, 0, 0, 0, 2, 3, 4, 2, 1};
        System.out.println(attempt2(testArr));
    }


//    This algorithm works by filling in water horizontally
//    It starts at level 0 and fills in any gaps by finding borders
//    It then moves up a level and fills in any gaps in that level
//    O(m*n) where m is the max height in the array and n is the length of the array
    public static int attempt1(int[] height) {
        int area = 0;
        int maxHeight = Arrays.stream(height).max().getAsInt();

        for (int level = 0; level < maxHeight; level++) {
            boolean start = false;
            int startIndex = 0;
            for (int i = 0; i < height.length; i++) {
                int curHeight = height[i];
                if (curHeight > level) {
                    if (!start) {
                        start = true;
                    } else {
                        area += (i - startIndex - 1);

                    }
                    startIndex = i;
                }
            }
            if (!start) {
                return area;
            }

        }


        return area;
    }

//    This algorithm works by finding the amount of water above any given point
//    in the array and adding it to the area
//    O(n) where n in the length of the array
    public static int attempt2(int[] height) {
        int area = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int curHeight = height[i];
//            gets max height to the left and right of the curHeight
            int maxL = Arrays.stream(Arrays.copyOfRange(height, 0, i)).max().getAsInt();
            int maxR = Arrays.stream(Arrays.copyOfRange(height, i + 1, height.length)).max().getAsInt();
//            Finds the smaller of the two peaks
            int minOfTwo = Math.min(maxL, maxR);
            int diff = minOfTwo - curHeight;
//            Adds difference between curHeight and minOfTwo to area if diff is positive
            area += Math.max(diff, 0);

        }
        return area;
    }
}
