import java.util.Arrays;

public class TempCloseToZero {
    private static int closestNumber;

    public static void main(String[] args) {
        int[] ints = { -9, -2, -1, 1, 3, 14, 37, 102 };
        System.out.println("Closest: " + findClosestToZero(ints, 0, ints.length - 1, null));        
    }

    private static int findClosestToZero(int[] ints) {
        Arrays.sort(ints);        
        int closestNumber = ints[0];      
        for (int i = 1; i < ints.length; i++) {
            if (Math.abs(ints[i]) < Math.abs(closestNumber)) {
                closestNumber = ints[i];
                if (i < ints.length - 1 && 
                    Math.abs(closestNumber) == Math.abs(ints[i + 1]) && 
                    closestNumber < 0) {
                    closestNumber *= -1;
                }
            }
        }
        return closestNumber;
    }

    private static int findClosestToZero(int[] ints, int start, int end, Integer closestSoFar) {
        if (end < start) {
            return closestSoFar;
        }

        int mid = (int) Math.floor(((end - start) / 2.0) + start);

        if (ints[mid] == 0) {
            return 0;
        }

        if (start == end) {
            return ints[start];
        }

        if (closestSoFar == null || Math.abs(ints[mid]) < Math.abs(closestSoFar)) {
            closestSoFar = ints[mid];
        }

        if (ints[mid] > 0) {
            return findClosestToZero(ints, 0, mid - 1, closestSoFar);
        } else {
            return findClosestToZero(ints, mid + 1, end, closestSoFar);
        }
    }

}
