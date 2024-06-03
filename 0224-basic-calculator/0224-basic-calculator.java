class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();

        int n = s.length();
        int res = 0 , sign = 1;
        for(int i = 0 ; i < n ; i++){
           
            char c = s.charAt(i);
            
            if(c == '+'){
                sign = 1;
            }else if(c == '-'){
                sign = -1;
            }else if(Character.isDigit(c)){  
                int num = 0;

                for(int j = i ; j < n && Character.isDigit(s.charAt(j)) ; j++){
                    num = (num * 10) + (s.charAt(j) - '0');
                    i = j;
                }

                res += num * sign;
            }else if(c == '('){
                
                stack.push(res);
                stack.push(sign);

                res = 0;
                sign = 1;

            }else if( c == ')'){
                
                res *= stack.pop();
                res += stack.pop();
            }
        }

        return res;
    }
}