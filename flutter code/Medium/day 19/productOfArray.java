/*Code 1:Product of Array Except Self
Company: Amazon, Facebook, Microsoft, Goldman Sachs,Qualcomm
Platform: leetcode-238
Fraz’s SDE sheet.
Description:
Given an integer array nums, return an array answer such that answer[i] is
equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
integer.
You must write an algorithm that runs in O(n) time and without using the
division operation.
Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.*/
class productOfArray{
    static int[] productOfArrayExceptSelf(int arr[]){

        int multi=1;
        int count=0;
        boolean flag=false;
        int ret[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                multi=multi*arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count++;
               flag= true;
            }
        }
        if(count>1){
            multi=0;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                ret[i]=multi;
            }else if(flag){
                ret[i]=0;

            }else{
                int val=multi/arr[i];
                ret[i]=val;
            }
        }
        return ret;
    }
    public static void main(String[]s){
        int arr[]=new int[]{-1,1,0,0,3};
        int retur[]=productOfArray.productOfArrayExceptSelf(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(retur[i]+" ");
        }
    }
}