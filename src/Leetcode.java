import java.util.*;
//______________________________________________________________________________________________________________________

public class Leetcode {
    /**
     * takes in a array of integers and finds the two numbers in the array that add up to the target and then
     * returns a pair of indexes to where the two numbers are found.
     * @param nums is a array filled with numbers from the set of all integers
     * @param target is the integers for which two numbers need to be summed to.
     * @return a pair of indexes to where the two numbers can be found.
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    results[0] = nums[i];
                    results[1] = nums[j];
                    for (int result : results) {
                        System.out.println(result + " ");
                    }
                    return results;
                }
            }
        }
        return results;
    } // end method twoSum
    // ______________________________________________________________________________________________________________________
    /**
     * reverses the input of integers. It it is negitive it will maintain the negative at front
     * @param x is a nuber from the set of all integers
     * @return the input integer in reverse
     */
    public static int reverse(int x) {
        boolean negFlag = false;
        String done;
        int results;
        if (x < 0) {
            negFlag = true;
        }
        String toReverse = String.valueOf(x);
        StringBuilder reversed = new StringBuilder(toReverse);
        if (negFlag) {
            reversed.deleteCharAt(0);
        }
        reversed.reverse();
        if (negFlag) {
            done = "-"+ reversed;
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
//______________________________________________________________________________________________________________________
    /**
     * determines if an integers input is a palindrome
     * @param x is a number from the set of integers
     * @return true if the input is a palendrome false if it is not
     */
    public static boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        StringBuilder normal = new StringBuilder(input);
        StringBuilder reversed = new StringBuilder(input);
        reversed.reverse();
        for (int i = 0; i < input.length(); i++) {
            if (normal.charAt(i) != reversed.charAt(i)) {
                return false;
            }
        }
        return true;
    } // end method isPalindrome

    public static int mySqrt(int x) {
        // Base Cases
        if (x == 0 || x == 1)
            return x;
        return 0;
    } // end method mySqrt
//______________________________________________________________________________________________________________________
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;
        int total = 0;
        HashMap<Character, Integer> romanToInt = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        total = romanToInt.get(s.charAt(s.length() - 1));
        for(int i = s.length() - 2; i >= 0; i--) {
            if (romanToInt.get(s.charAt(i)) >= romanToInt.get(s.charAt(i + 1))) {
                total += romanToInt.get(s.charAt(i));
            }
            else {
                total -= romanToInt.get(s.charAt(i));
            }
        }
        return total;
    } // end method romanToInt
//______________________________________________________________________________________________________________________
    /**
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of
     * the integer. The digits are ordered from most significant to least significant in left-to-right order. The large
     * integer does not contain any leading 0's.
     * @param digits is the starting array of digits
     * @return Increments the large integer by one and returns the resulting array of digits.
     */
    public static int[] plusOne(int[] digits) {
        int len = digits.length-1;
        return check(digits, len);

    }
//______________________________________________________________________________________________________________________
    /**
     * helper method for the plusOne method
     * @param arr is the starting array of digits
     * @param index is the index to check
     * @return the new array that is incremented by one.
     */
    private static int[] check(int[] arr, int index) {
        int zeroCount = 0;
        boolean flag = false;

        if (arr.length == 1 && arr[0] < 9) {
            arr[0]++;
            return arr;
        }
        for (int i = index; i >= 0; i--) {
            if (arr[i] == 9) {
                arr[i] = 0;
                zeroCount++;
                continue;
            }
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }

        }
        if (zeroCount == arr.length) {
            int[] results = new int[arr.length+1];
            results[0] = 1;
            flag = true;
            return results;
        }
        return arr;
    }
//______________________________________________________________________________________________________________________

    /**
     * binary search algorithm to find a target in a sorted array and return -1 if the element is not found
     * @param nums is the sorted array
     * @param target is the element to be searched for
     * @return index of the element if it is found or -1 if it is not present
     */
    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo);
            if (target < nums[mid]) {
                hi = mid - 1;
            }
            else if (target > nums[mid]) {
                lo = mid + 1;
            }
            else
                return mid;
        }
        return -1;
    }
//______________________________________________________________________________________________________________________

    /**
     * uses a implementation of a binary search to find the first bad version of a program in a repository which
     * utilizes the isBadVersion method that has an api in the leetcode library. It is just included here to remove
     * errors.
     * @param n is the version started at but not the first
     * @return the index of the fisrt bad version
     */
    public int firstBadVersion(int n) {
        int lo = 0;
        int hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (isBadVersion(mid)){
                hi = mid - 1;
            }
            else if (!isBadVersion(mid)) {
                lo = mid + 1;
            }
            else
                return mid;
        }
        return -1;

    }

    /**
     * non working implementation
     * @param n n/a
     * @return true
     */
    public boolean isBadVersion(int n) { // this is part of the leetcode implementation
        return true;
    }
//______________________________________________________________________________________________________________________

    /**
     * searches an array for a target and if found returns the index. If not found it returns the index where it should
     * be in the array if it was to be inserted
     * @param nums array of elements
     * @param target target to find or to be added
     * @return index of where element was found or where it should be inserted
     */
    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
            if(index == nums.length - 1 && nums[nums.length-1] > index) {
                index = i;
            }
            index++;
        }
        return index;
    }

    /**
     * like the above but using a binary search algorithm instead making it a O(log n) runtime. Where the one above is
     * a O(n) so this one is faster.
     * @param nums array of elements
     * @param target target to find or to be added
     * @return index of where element was found or where it should be inserted
     */
    public static int searchInsertTwo(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        if (nums[nums.length-1] < target) {
            return nums.length;
        }
        if (nums[0] > target) {
            return 0;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (target < nums[mid]) {
                hi = mid - 1;
            }
            else if (target > nums[mid]) {
                lo = mid + 1;
            }
            else
                return mid;
        }
        return hi + 1;
    }
//______________________________________________________________________________________________________________________

    /**
     * takes an unsorted array and finds all the squares of the elements and then sorts it and returns it.
     * @param nums the array of elements
     * @return a new sorted array of the elements all squared.
     */
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
//______________________________________________________________________________________________________________________

    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     * @param nums the array of elements
     * @param k the total shift
     */
    public static void rotate(int[] nums, int k) {
        int[] shifted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            shifted[(k + i) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = shifted[i];
        }
    }

//______________________________________________________________________________________________________________________

    /**
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

//______________________________________________________________________________________________________________________

    /**
     *  Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers
     *  such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
     *  where 1 <= first < second <= numbers.length.
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSumTwo(int[] numbers, int target) {
        int[] results = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    results[0] = i+1;
                    results[1] = j+1;
                    return results;
                }
            }
        }
        return results;
    }
//______________________________________________________________________________________________________________________
    public static String convertToBinary(int N) {
        if (N == 1) {
            return "1";
        }
        return convertToBinary(N/2) + (N%2);
    } // end method convertToBinary
//______________________________________________________________________________________________________________________
    public int bisect_right(int[] arr, int target) {
        return bisect_right(arr, target);
    }

   public static int bisect_right(int[] arr, int target, int i, int j) {
        if (i==j) return i;
        int mid = (i+j) /2;
        if (arr[mid] <= target) i = mid + 1;
        else
            j = mid;
        return bisect_right(arr, target, i, j);
   }

   public static void testingLibraries(){
        LinkedList<String> n = new LinkedList<>();

   }
//______________________________________________________________________________________________________________________

    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     * @param s
     */
    public static void reverseString(char[] s) {
        StringBuffer rev = new StringBuffer(String.valueOf(s));
        rev.reverse();
        for (int i = 0; i < s.length; i++) {
            s[i] = rev.charAt(i);
        }
    }

//______________________________________________________________________________________________________________________

    public static String reverseWords(String s) {
        String[] splitWords = s.split(" ");
        s = "";
        for (int i  = 0; i < splitWords.length; i++) {
            StringBuilder sb = new StringBuilder(splitWords[i]);
            sb.reverse();
            if (i == 0) {
                s += sb;
            } else
                s += " " + sb;
        }
        System.out.println(s);
        return s;
    }
//______________________________________________________________________________________________________________________

//______________________________________________________________________________________________________________________
//______________________________________________________________________________________________________________________
//______________________________________________________________________________________________________________________

//**********************************************************************************************************************
//======================================================================================================================

    public static void main(String[] args) {
        /*
        int[] test = {2, 7, 11, 15};
        moveZeroes(test);
        for (int i = 0; i < test.length; i ++) {
            System.out.print(test[i] + " ");
        }
         */
        String str = "Lets's go to the Park";
        reverseWords(str);
        System.out.println(str);



        /*
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(64));
        System.out.println(mySqrt(2147395600));

         */
    }
}
