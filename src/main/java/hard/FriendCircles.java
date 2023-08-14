package hard;

/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in
 * nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
 * then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total
 * number of friend circles among all the students.
 * <p>
 * Example 1:
 * ----------
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * <p>
 * Example 2:
 * ----------
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * <p>
 * Note:
 * -----
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCircles {

    private static int M;
    private static int N;

    public void dfs(int[][] maze, int[] visited, int i) {
        for (int j = 0; j < M; j++) {
            if (maze[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(maze, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] maze) {
        M = maze.length;
        N = maze[0].length;
        int[] visited = new int[M];
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (visited[i] == 0) {
                dfs(maze, visited, i);
                count++;
            }
        }
        return count;
    }
}
