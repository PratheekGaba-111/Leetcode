class Solution {
    public boolean isValid(String s) {
        // so we are given 3 types of brackets -> () {} []

        // what we have to do is to verify that, there is a proper closing for each open bracket
        // we need a stack and an hashmap with 3 brackets
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            //lets say we compare with top first and we do pop or push
            if(c == '(' || c == '{' || c == '[') stk.push(c);

            else{
                    if(stk.isEmpty()) return false;
                    Character top = (stk.isEmpty())? '$' : stk.peek();
                    if(top == '(' && ')' == c){
                        stk.pop();
                    }
                    else if(top == '{' && '}' == c){
                        stk.pop();
                    }
                    else if(top == '[' && ']' == c){
                        stk.pop();
                    }
                    else{
                        return false;
                    }
            }
        }
        
        return stk.isEmpty();
    }
}