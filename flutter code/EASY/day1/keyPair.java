/*Code3: Key Pair
Company: Zoho, Flipkart, Morgan Stanley, Accolite, Amazon, Microsoft,
FactSet, Hike, Adobe, Google, Wipro, SAP Labs, CarWale
Platform: GFG
Description:
Given an array Arr of N positive integers and another number X. Determine
whether or not there exist two elements in Arr whose sum is exactly X.
Example 1:
Input:
N = 6, X = 16
Arr[] = {1, 4, 45, 6, 10, 8}
Output: Yes
Explanation: Arr[3] + Arr[4] = 6 + 10 = 16
Example 2:
Input:
N = 5, X = 10
Arr[] = {1, 2, 4, 3, 6}
Output: Yes
Explanation: Arr[2] + Arr[4] = 4 + 6 = 10

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 105 */
import java.util.*;
class keyPair{
    static boolean keyPairRet(int arr[],int x){

        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int temp=x-arr[i];
            if(set.contains(temp)){
                return true;

            }else{
                set.add(arr[i]);
            }
        }

        return false;
    }
    public static void main(String[]s){
        int arr[]=new int[]{1, 4, 45, 6, 10, 8};
        int x=16;
        boolean ret=keyPair.keyPairRet(arr,x);
        System.out.println(ret);
    }

}