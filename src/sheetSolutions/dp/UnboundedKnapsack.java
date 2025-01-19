
/*
Given a set of items, each with a weight and a value, represented by the array wt and val respectively. Also, a knapsack with a weight limit capacity.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.

Examples:

Input: val = [1, 1], wt = [2, 1], capacity = 3
Output: 3
Explanation: The optimal choice is to pick the 2nd element 3 times. */
public class UnboundedKnapsack {
    static int knapSack(int[] val, int[] wt, int capacity) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n+1][capacity+1];

        for(int i =0;i<=n;i++){
            for(int j =0;j<=capacity;j++){

                if(i==0|| j==0){
                    dp[i][j]=0;
                }

                else if(wt[i-1]<=j){
                    // The only change in normal knapsack and this one is that when an item is
                    // already included we can re include it or exclude it to check if profit will be
                    // max or not thus dp[i-1][j-wt[i-1]] in norma knapsack changes to
                    // dp[i][j-wt[i-1]]
                    dp[i][j] = Math.max(val[i-1] +dp[i][j-wt[i-1]] ,dp[i-1][j]);
                }

                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}


