package FloydWarshall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] q) {
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for(int[] pp : p) {
            dp[pp[0]][pp[1]] = true;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dp[i][j]) {
                        continue;
                    }
                    dp[i][j] |= (dp[i][k] && dp[k][j]);
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] qq : q) {
            ans.add(dp[qq[0]][qq[1]]);
        }
        System.out.println(Arrays.deepToString(dp));
        return ans;
    }

//    public static void main(String[] args) {
//        int[][] p = {{1,2},{1,0},{2,0}};
//        int[][] q = {{1,0},{1,2}};
//        System.out.println(new Main().checkIfPrerequisite(3, p, q));
//    }
}