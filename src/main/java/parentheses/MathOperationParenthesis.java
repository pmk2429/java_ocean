package parentheses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * "add(3, 5)" -> 8
 * "sub(8, 3)" -> 5
 * "add(add(3, 5), 7)" -> 15
 * "add(4, sub(12, 2))" -> 14
 */
class MathOperationParenthesis {

    // TODO
    // nested
    // move the "add / sun" to other func

    // "add(add(3, 5), 7)"
    // "(" -- push String (add)
    // "(" -- push String (add)
    // (3, 5) -- push Int (3)
    // (3, 5) -- push Int (5)
    // ")" -- pop "add"
    // ")" -- pop 3, 5
    // perform op 3 + 5
    // push Int (8)
    // 7 -- push Int (7)


    // ")" -- pop "add"
    // ")" -- pop (8, 7)
    // perform op 8 + 7


    private static int calculateNestedOperation(String inputString) {
        Set<String> operations = new HashSet<>();
        int result = -1;
        int startIndex = 0;
        Stack<String> operationStack = new Stack<>();
        Stack<Integer> paramStack = new Stack<>();

        for (int i = 0; i < inputString.length(); i++) {
            char curr = inputString.charAt(i);
            if (curr == '(') {
                String operation = inputString.substring(startIndex, i);
                // if (operations.contains(operation)) {

                // }
                operationStack.push(operation);
            }
            else if (curr == ')') {
                String opToPerform = operationStack.pop();
                if (opToPerform.equals("add")) {
                    result = paramStack.pop() + paramStack.pop();
                    paramStack.push(result);
                }
            }
            else if (Character.isDigit(curr)) { // 3, 5)
                int parenIndex = i;
                while (inputString.charAt(parenIndex) != ')') {
                    parenIndex++;
                }
                String[] inputParams = inputString.substring(i, parenIndex).split(","); // index = 0, 1
                System.out.println(Arrays.toString(inputParams));
                paramStack.push(Integer.parseInt(inputParams[0].trim()));
                paramStack.push(Integer.parseInt(inputParams[1].trim()));
            }
        }

        return result;
    }

    private static int calculateOperation(String inputStr) {
        int startParenthesis = inputStr.indexOf("(");
        int endParenthesis = inputStr.indexOf(")");
        String operation = inputStr.substring(0, startParenthesis);
        String[] inputParams = inputStr.substring(startParenthesis + 1, endParenthesis).split(","); // index = 0, 1
        int result = -1;
        if (operation.equals("add")) {
            result = Integer.parseInt(inputParams[0].trim()) + Integer.parseInt(inputParams[1].trim());
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println("$UBER Interview");
        String input = "add(3, 5)";
        System.out.println(calculateNestedOperation(input));
    }
}