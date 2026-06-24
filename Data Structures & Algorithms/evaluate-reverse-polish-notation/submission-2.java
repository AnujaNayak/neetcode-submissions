class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < tokens.length; i++)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") ||tokens[i].equals("/"))
            {
                String operator = tokens[i];
                int secondVal = stack.pop();
                int firstVal = stack.pop();
                if(operator.equals("+")){
                    res = firstVal + secondVal;
                }
                else if(operator.equals("-")){
                    res = firstVal - secondVal;
                }
                else if(operator.equals("*")){
                    res = firstVal * secondVal;
                }
                else{
                    res = firstVal / secondVal;
                }
                stack.push(res);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        if(!stack.isEmpty())
        {
            return stack.pop();
        }
        else{
            return res;
        }
    }
}

// ["1","2","+","3","*","4","-"]
//                       ^   ^

// res =   res secondPointer firstPointer
//           9          -      4

