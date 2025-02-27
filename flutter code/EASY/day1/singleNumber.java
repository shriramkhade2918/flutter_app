/*Code 1:Single Number
Company : Amazon, wipro, Capgemini, DXC technology, Schlumberger,
Avizva, epam, cadence, paytm, atlassian,cultfit+7
Platform: LeetCode - 136
Striver’s SDE Sheet
Description:
Given a non-empty array of integers nums, every element appears
twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use
only constant extra space.
Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1
Constraints:
1 <= nums.length <= 3 * 10^4
-3 * 104 <= nums[i] <= 3 * 10^4
Each element in the array appears twice except for one element
which appears only once. */

import java.util.*;
class singleNumber{
    static int singlenumberRet(int arr[]){
        int n=arr.length;
        Arrays.sort(arr);
        int val=0;
        for(int i=1;i<n;i=i+2){
            if(arr[i-1]!=arr[i]){
                val= arr[i-1];
                break;
            }
        }

        return val;

    } 
    public static void main(String[]s){
        int arr[]=new int[]{2,2,1};
        int ret =signleNumber.singlenumberRet(arr);
        System.out.println(ret);
    }
}