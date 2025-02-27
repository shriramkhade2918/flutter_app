/*Code 2: Row with max 1s
Company: Amazon, Microsoft, Snapdeal
Platform: Leetcode - 2416, GFG
Babbar’s DSA sheet.
Description:
Given a m x n binary matrix mat, find the 0-indexed position of the row that
contains the maximum count of ones, and the number of ones in that row.
In case there are multiple rows that have the maximum count of ones, the
row with the smallest row number should be selected.
Return an array containing the index of the row, and the number of ones in
it.
Example 1:
Input: mat = [[0,1],[1,0]]
Output: [0,1]
Explanation: Both rows have the same number of 1's. So we return the
index of the smaller row, 0, and the maximum count of ones (1). So, the
answer is [0,1].
Example 2:
Input: mat = [[0,0,0],[0,1,1]]
Output: [1,2]
Explanation: The row indexed 1 has the maximum count of ones (2). So
we return its index, 1, and the count. So, the answer is [1,2].
Example 3:

Input: mat = [[0,0],[1,1],[0,0]]
Output: [1,2]
Explanation: The row indexed 1 has the maximum count of ones (2). So
the answer is [1,2].
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1.*/

class rowOfMax1{
    static int[]rowOfMax1return(int arr[][]){
        int count=0;
        int row=-1;
        for(int i=0;i<arr.length;i++){
            int x=0;
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    x++;
                }
            }
            if(count<x){
                count=x;
                row=i;
            }
        }
        return new int[]{row,count};
    }
    public static void main(String[]args){
        int [][]arr=new int[][]{{0,0,0},{0,1,1}};
        int ret[]=rowOfMax1.rowOfMax1return(arr);
        for(int i=0;i<ret.length;i++){
            System.out.print(ret[i]+" ");
        }
    }
}