class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int [m][n];

        for(int i = 0; i < memo.length; i ++)
        {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0,0,m,n);
    }

    public int dfs(int x, int y,int m, int n)
    {   
        if(x < 0 || x >= n || y < 0 || y >= m)
        {
            return 0;
        }

        if(memo[y][x] != -1)
        {
            return memo[y][x];
        }

        if(x == n - 1 && y == m - 1)
        {   
            memo[y][x] = 1;
            return 1;
        }

        int count = 0;

        count += dfs(x + 1,y,m,n);
        count += dfs(x, y + 1,m,n);

        memo[y][x] = count;

        return count;
    }
}
