/*Code 1: Kth Largest Element in an Array
Company: Amazon, Microsoft, Walmart, Adobe
Platform: Leetcode - 215
Striver’s and love Bubbar’s DSA sheet.
Description:
Given an integer array nums and an integer k, return the kth largest
element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct
element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104*/
import java.util.*;
class KthLarge {
    static int kthLargElement(int arr[],int k){
        Arrays.sort(arr);
        int n=arr.length;
        return arr[n-k];
    }
    public static void main(String []s){
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the Array Size:");
        int x=sc.nextInt();
        int arr[]=new int[x];
        System.out.println("Enter Array Element:");
        for(int i=0;i<x;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the position of largest element:");
        int k=sc.nextInt();
        int ret=KthLarge.kthLargElement(arr,k);
        System.out.println(ret);

    }
     

}