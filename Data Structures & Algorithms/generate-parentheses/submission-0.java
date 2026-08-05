class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0,0,n, result, stack);
        return result;
    }

    private void backtrack(int openP, int closedP, int n, List<String> result, StringBuilder stack){
        if(openP == closedP && openP == n){
            result.add(stack.toString());
            return;
        }

        if(openP < n){
            stack.append('(');
            backtrack(openP + 1, closedP, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if(closedP < openP){
            stack.append(')');
            backtrack(openP, closedP + 1, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}