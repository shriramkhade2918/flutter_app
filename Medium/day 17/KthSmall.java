/*Code 2: Kth smallest element
Company: VMWare, Accolite, Amazon, Microsoft, Snapdeal, Hike, Adobe,
Google, ABCO, Cisco
Platform: GFG
Bubbar’s DSA sheet.
Description:
Given an array arr[] and an integer K where K is smaller than size of array,
the task is to find the Kth smallest element in the given array. It is given
that all array elements are distinct.
*Note :- l and r denotes the starting and ending index of the array.
Example 1:
Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
L=0 R=5
Output : 7
Explanation :
3rd smallest element in the given
array is 7.

Example 2:
Input:
N = 5
arr[] = 7 10 4 20 15
K = 4 L=0 R=4
Output : 15
Explanation :
4th smallest element in the given
array is 15.*/

import java.util.*;
class KthSmall {
    static int kthSmallElement(int arr[],int k){
        Arrays.sort(arr);
        int n=arr.length;
        return arr[n-1];
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
        System.out.println("Enter the position of Smallest element:");
        int k=sc.nextInt();
        int ret=KthSmall.kthSmallElement(arr,k);
        System.out.println(ret);

    }
     

}