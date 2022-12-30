package AdjacencyMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] q) {
        boolean[][] grid = new boolean[n][n];
        List<Integer>[] g = new List[n];

        for(int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] pp : p) {
            g[pp[0]].add(pp[1]);
        }
        for(int i = 0; i < n; i++) {
            bfs(g, grid, i);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] qq : q) {
            ans.add(grid[qq[0]][qq[1]]);
        }
        return ans;
    }
    private void bfs(List<Integer>[] g, boolean[][] grid, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(q.size() > 0) {
            int curr = q.poll();
            if(!grid[start][curr]) {
                grid[start][curr] = true;
                for(int next : g[curr]) {
                    q.add(next);
                }
            }
        }
    }

//    public static void main(String[] args) {
//        int[][] p = {{1,2},{1,0},{2,0}};
//        int[][] q = {{1,0},{1,2}};
//        System.out.println(new Main().checkIfPrerequisite(3, p, q));
//    }
}