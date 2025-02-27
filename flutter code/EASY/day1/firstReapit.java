/*Code2: First Repeating Element
Company: Amazon, oracle
Platform: GFG
Striver’s SDE Sheet
Description:
Given an array arr[] of size n, find the first repeating element. The element
should occur more than once and the index of its first occurrence should be the
smallest.
Note:- The position you return should be according to 1-based indexing.
Example 1:
Input:
n = 7
arr[] = {1, 5, 3, 4, 3, 5, 6}
Output: 2
Explanation:
5 is appearing twice and
its first appearance is at index 2
which is less than 3 whose first
occurring index is 3.

Example 2:
Input:
n = 4
arr[] = {1, 2, 3, 4}
Output: -1
Explanation:
All elements appear only once so
the answer is -1.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
Constraints:
1 <= n <= 106
0 <= Ai<= 106 */
import java.util.*;
class firstReapit{
    static int firstReapitNumber(int arr[]){
        Set<Integer> set=new HashSet<>();
        int ind=-1;
        for(int i=arr.length-1;i>=0;i--){
            if(set.contains(arr[i])){
                ind=i+1;

            }else{
                set.add(arr[i]);
            }
        }
        return ind;
    }
    public static void main(String[]s){
        int arr[]=new int[]{1, 5, 3, 4, 3, 5, 6};
        int ret=firstReapit.firstReapitNumber(arr);
        System.out.println(ret);
    }
}