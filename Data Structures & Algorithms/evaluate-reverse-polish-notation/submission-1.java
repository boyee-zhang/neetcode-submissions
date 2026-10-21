class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        //Stack<Character> op = new Stack<>();
        
        for(String token : tokens)
        {
            if(token.equals("+"))
            {
                int second = nums.pop();
                int first = nums.pop();
              
                nums.push(first + second);
            }
            else if(token.equals("-"))
            {
                int second = nums.pop();
                int first = nums.pop();
         
                nums.push(first - second);
            }
            else if(token.equals("*"))
            {
                int second = nums.pop();
                int first = nums.pop();

                nums.push(first * second);
            }
            else if(token.equals("/"))
            {
                int second = nums.pop();
                int first = nums.pop();
                nums.push(first / second);
            }
            else
            {   
                int num = 0;
                boolean negative = false;
                for(char c : token.toCharArray())
                {   
                    if(c == '-')
                    {
                        negative = true;
                        continue;
                    }
                    num = num * 10 + (c - '0');
                }
                // System.out.println("num " + num);
                if(negative) num = -num;
                nums.push(num);
            }
        }

        return nums.pop();

    }
}
