class Solution {
    public int magicalSum(int m, int k, int[] nums) {
        int MOD = (int) (1e9 + 7);
        int n = nums.length;

        int[][] C = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i-1][j-1] + C[i-1][j]) % MOD;
            }
        }

        int[][] pow = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            pow[i][0] = 1;
            for (int cnt = 1; cnt <= m; cnt++) {
                pow[i][cnt] = (int)((long)pow[i][cnt-1] * nums[i] % MOD);
            }
        }

        int[][][][] dp = new int[n + 1][k + 1][m + 1][m + 1];
        dp[0][0][0][0] = 1;

        for (int pos = 0; pos < n; pos++) {
            for (int bits = 0; bits <= k; bits++) {
                for (int carry = 0; carry <= m; carry++) {
                    for (int chosen = 0; chosen <= m; chosen++) {
                        if (dp[pos][bits][carry][chosen] == 0) continue;
                        
                        int remaining = m - chosen;
                        for (int cnt = 0; cnt <= remaining; cnt++) {
                            int total = carry + cnt;
                            int new_bits = bits + (total & 1);
                            int new_carry = total >> 1;
                            
                            if (new_bits <= k && new_carry <= m) {
                                long add = (long)dp[pos][bits][carry][chosen] 
                                    * C[remaining][cnt] % MOD 
                                    * pow[pos][cnt] % MOD;
                                
                                dp[pos+1][new_bits][new_carry][chosen+cnt] = 
                                    (dp[pos+1][new_bits][new_carry][chosen+cnt] + (int)add) % MOD;
                            }
                        }
                    }
                }
            }
        }


        int res = 0;
        for (int carry = 0; carry <= m; carry++) {
            int final_bits = k;

            int carry_bits = Integer.bitCount(carry);
            if (carry_bits <= k) {
                res = (res + dp[n][k - carry_bits][carry][m]) % MOD;
            }
        }

        return res;
    }
}