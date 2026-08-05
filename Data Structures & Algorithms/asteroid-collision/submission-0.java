class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int num : asteroids){
            while(!stack.isEmpty() && willCollide(stack.peek(), num)){
                int top = stack.pop();
                num = collision(top, num);
            }
            if(num != 0){
                stack.push(num);
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean willCollide(int top, int num){
        return top > 0 && num < 0;
    }

    private int collision(int top, int num){
        if(Math.abs(top) == Math.abs(num)){
            return 0;
        }
        int bigger = Math.max(Math.abs(top),Math.abs(num));
        if(bigger != top && bigger != num){
            return -1 * bigger;
        }else{
            return bigger;
        }
    }
}