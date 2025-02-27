/*Code 2: Find the Duplicate Number
Company: Amazon, Microsoft
Platform: Leetcode - 287
Fraz’s and Love Bubbar’s DSA sheet.
Description:
Given an array of integers nums containing n + 1 integers where each integer is in the
range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant
extra space.
Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears
two or more times.*/
import java.util.*;
class findDoublicateNumber{
    static int findDoublicateNumberInArray(int arr[]){
        Set<Integer> set=new HashSet<>();
        int val=0;
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                val=arr[i];
            }else{
                set.add(arr[i]);
            }

        }
        return val;
    }
    public static void main(String[]s){
        int arr[]=new int[]{3,1,3,4,2};
        int ret=findDoublicateNumber.findDoublicateNumberInArray(arr);
        System.out.println(ret);
    }
}