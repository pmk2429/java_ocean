package hard;

import java.util.Stack;

/**
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a
 * Unix-style file system, convert it to the simplified canonical path.
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the
 * directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
 * For this problem, any other format of periods such as '...' are treated as file/directory names.
 * - The canonical path should have the following format:
 * - The path starts with a single slash '/'.
 * - Any two directories are separated by a single slash '/'.
 * - The path does not end with a trailing '/'.
 * - The path only contains the directories on the path from the root directory to the target file or directory (i.e.,
 * no period '.' or double period '..')
 * Return the simplified canonical path.
 * <p>
 * Example 1:
 * ----------
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * <p>
 * Example 2:
 * ----------
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * <p>
 * Example 3:
 * ----------
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * <p>
 * Constraints:
 * ------------
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 */
public class SimplifyPath {

    private static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }

        Stack<String> stack = new Stack<>();
        String[] components = path.trim().split("/");

        // Split the input string on "/" as the delimiter and process each portion one by one
        for (String directory : components) {
            // A no-op for a "." or an empty string
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            }
            else if (directory.equals("..")) {
                // If the current component is a "..", then we pop an entry from the stack if it's non-empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                // Finally, a legitimate directory name, so we add it to our stack
                stack.push(directory);
            }
        }

        // Stitch together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        System.out.println("/home/ ---- " + simplifyPath("/home/"));
        System.out.println("/../ ---- " + simplifyPath("/../"));
        System.out.println("/home//foo/ ---- " + simplifyPath("/home//foo/"));
    }
}
