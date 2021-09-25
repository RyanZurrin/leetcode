public class TwoSums {
    static int[] values;

    public static int[] twoSum(int[] nums, int target) {

        int[] results = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    results[0] = nums[i];
                    results[1] = nums[j];
                    for (int k = 0; k < results.length; k++){
                        System.out.println(results[k] + " ");
                    }
                    return results;
                }
            }
        }
        return results;
    } // end method twoSum

    public static int reverse(int x) {
        boolean negFlag = false;
        String done;
        int results;
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            negFlag = true;
        }
        String toReverse = String.valueOf(x);
        StringBuffer reversed = new StringBuffer(toReverse);
        if (negFlag) {
            reversed.deleteCharAt(0);
        }
        reversed.reverse();
        if (negFlag) {
            done = "-"+ reversed.toString();
        } else {
            done = reversed.toString();
        }
        try {
            results = Integer.parseInt(done);
        }
        catch(NumberFormatException e) {
            return 0;
        }
        if (results > Integer.MAX_VALUE || results < Integer.MIN_VALUE) {
            return 0;
        }
        return results;
    }

    public static boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        StringBuffer normal = new StringBuffer(input);
        StringBuffer reversed = new StringBuffer(input);
        reversed.reverse();
        for (int i = 0; i < input.length(); i++) {
            if (normal.charAt(i) != reversed.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int results;
        int i = results = 1;
        for (; results <= x; i++) {
            results = i * i;
        }
        return i - 1;
    }


    public static void main(String[] args) {
        int val = 1534236469;
        System.out.println(mySqrt(4));
        System.out.println(isPalindrome(8));
        System.out.println(isPalindrome(16));

        reverse(val);
    }
}
