import java.util.*;
class HospitalScheduler {
    static void scheduleSurgeries(int[] start, int[] end) {
        int n = start.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> end[a] - end[b]);
        System.out.println("Scheduled Surgeries:");
        int count = 1, lastEnd = end[idx[0]];
        System.out.println("Surgery " + (idx[0]+1) + ": " + start[idx[0]] + "-" + end[idx[0]]);
        for (int i = 1; i < n; i++) {
            if (start[idx[i]] >= lastEnd) {
                System.out.println("Surgery " + (idx[i]+1) + ": " + start[idx[i]] + "-" + end[idx[i]]);
                lastEnd = end[idx[i]]; count++;
            }
        }
        System.out.println("Total scheduled: " + count);
    }
    static int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = (s1.charAt(i-1)==s2.charAt(j-1)) ? dp[i-1][j-1]+1
                           : Math.max(dp[i-1][j], dp[i][j-1]);
        return dp[m][n];
    }
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,12};
        int[] end   = {4,5,6,7,11,14};
        scheduleSurgeries(start, end);
        System.out.println("LCS of AGGTAB and GXTXAYB: " + lcs("AGGTAB","GXTXAYB"));
    }
}