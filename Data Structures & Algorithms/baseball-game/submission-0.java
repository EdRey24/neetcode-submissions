class Solution {
    public int calPoints(String[] operations) {
        int result = 0;
        Stack<Integer> score = new Stack<>();
        for(String op : operations){
            if(op.equals("+")){
                int top = score.pop();
                int sum = top + score.peek();
                score.push(top);
                score.push(sum);
                result += sum;
            }else if(op.equals("D")){
                int num = 2 * score.peek();
                score.push(num);
                result += num;
            }else if(op.equals("C")){
                result -= score.pop();
            }else{
                score.push(Integer.parseInt(op));
                result += Integer.parseInt(op);
            }
        }
        return result;
    }
}