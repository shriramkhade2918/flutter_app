/*Code 1: Find All Duplicates in an Array
Company: Amazon, Microsoft, OYO Rooms
Platform: Leetcode - 442
Fraz’s DSA sheet.
Description:
Given an integer array nums of length n where all the integers of nums are in the range
[1, n] and each integer appears once or twice, return an array of all the integers that appears
twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:
Input: nums = [1,1,2]
Output: [1]
Example 3:
Input: nums = [1]
Output: []

Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n*/
import java.util.*;
class allDublicateInArray{
    static List<Integer> findAllDublicateInArrayll(int arr[]){
        Set<Integer> set=new HashSet<>();
        List<Integer> al=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                al.add(arr[i]);
            }else{
                set.add(arr[i]);
            }
        }
        return al;
    }
    public static void main(String[]s){
        int arr[]=new int[]{4,3,2,7,8,2,3,1};
        List<Integer> all=allDublicateInArray.findAllDublicateInArrayll(arr);
        int i=0;
        for(int x:all){
            System.out.print(all.get(i++)+ " ");
        }
    }
}