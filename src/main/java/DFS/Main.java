package DFS;

import java.util.ArrayList;
import java.util.List;

class Main {
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] q) {
        List<Integer>[] g = new List[n];
        for(int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] pp : p) {
            g[pp[0]].add(pp[1]);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] qq : q) {
            ans.add(reach(g, qq[0], qq[1], new boolean[n]));
        }
        return ans;
    }

    private boolean reach(List<Integer>[] g, int src, int dst, boolean[] visited) {
        if(src == dst) {
            return true;
        }
        for(int next : g[src]) {
            if(!visited[next] && reach(g, next, dst, visited)) {
                return true;
            }
        }
        visited[src] = true;
        return false;
    }

//    public static void main(String[] args) {
//        int[][] p = {{1,2},{1,0},{2,0}};
//        int[][] q = {{1,0},{1,2}};
//        System.out.println(new Main().checkIfPrerequisite(3, p, q));
//    }
}