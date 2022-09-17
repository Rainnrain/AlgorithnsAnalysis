public class ExprBalanceCheck {
    public static void main(String[] args) {

    }
        public static boolean balanceCheck (String expr){

            //Create stack
            MyStack<Character> myStack= new MyStack<>();
            //Iterate over expr
            for (int i = 0; i < expr.length(); i++) {
                Character ch= expr.charAt(i);
                //Filter non player chars
                if (ch!='('&&ch!='{'&&ch!='['&&ch!=')'&&ch!='}'&&ch!=']') continue;
                //if it is a symbol tobe processed
                if(ch=='('||ch=='{'||ch=='['){
                    myStack.push(ch);
                    continue;
                }
                if(myStack.isEmpty()) return false;
                switch(ch){
                    case ')':
                        if(myStack.pop()!='(') return false;
                        break;
                    case']':
                        if(myStack.pop()!='[') return false;
                        break;
                    case'}':
                        if(myStack.pop()!='{') return false;
                        break;
                }
            }//end of for
            //Return if stack is empty

             return myStack.isEmpty();
    }
}
