class Solution {
    public int evalRPN(String[] tokens) {
        
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n ; i++){
            String s = tokens[i];

            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int n1 = st.pop();
                int n2 = st.pop();

                int ans = 0;
                switch(s){
                    case "+":
                        ans = n1 + n2;
                        break;
                    case "-":
                        ans = n2 - n1;
                        break;
                    case "*":
                        ans = n1 * n2;
                        break;
                    case "/":
                        ans = n2 / n1;
                        break;
                }

                st.push(ans);//ans
            }else{
                int num = Integer.parseInt(s);
                st.push(num);
            }
        }

        return st.pop();
    }
}