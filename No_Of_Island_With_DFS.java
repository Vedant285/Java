import java.util.*;

public class No_Of_Island_With_DFS {
    static void dfs(int arr[][], int i, int j, int vis[][], int n, int m) {
        vis[i][j] = 1;
        int dc[] = { -1, 0, 1, 0 };
        int dr[] = { 0, -1, 0, 1 };
        for (int l = 0; l < 4; l++) {
            int nr = dc[l] + i;
            int nc = dr[l] + j;
            if (nr >= 0 && nc >= 0 && nr < n && nc < m && vis[nr][nc] == 0 && arr[nr][nc] == 1) {
                dfs(arr, nr, nc, vis, n, m);
            }
        }
    }

    static void Search(int arr[][], int n, int m) {
        int k = 0;
        int vis[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && arr[i][j] == 1) {
                    k++;
                    dfs(arr, i, j, vis, n, m);
                }
            }
        }
        System.out.println("Total Island's Are: "+k);

    }

    public static void main(String[] args) {
        int n;
        int m;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column of Ocean");
        n = sc.nextInt();
        m = sc.nextInt();
        int arr[][] = new int[n][m];
        System.out.println("Enter water and island ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Search(arr, n, m);
    }

}
