/**
 * Example 1:
 [[1,3,1],
 [1,5,1],
 [4,2,1]]
 Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 */
package algorithm.LeetCode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        return dfs(0,0,grid);
    }

    public int dfs(int i, int j, int[][] grid){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }

        if(i<grid.length-1 && j<grid[0].length-1){
            int r1 = grid[i][j] + dfs(i+1, j, grid);
            int r2 = grid[i][j] + dfs(i, j+1, grid);
            return Math.min(r1,r2);
        }

        if(i<grid.length-1){
            return grid[i][j] + dfs(i+1, j, grid);
        }

        if(j<grid[0].length-1){
            return grid[i][j] + dfs(i, j+1, grid);
        }

        return 0;
    }
    public static void main(String[] args){
        MinimumPathSum minimumPathSum=new MinimumPathSum();
        int[][] ints={{1,3,4},{1,2,1},{1,4,1}};
        System.out.print(minimumPathSum.minPathSum(ints));
    }
}
