package stackBlackoutMath;

import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;

public class BlackOutMath{

    private static final String OPERATORS = "-+*/^";
    private static final String OPEN      = "([{";
    private static final String CLOSE     = ")]}";

    
    //Time complexity O(n), n is the length of infix, Space Complexity O(2n) ~O(n) for stacks
    public Integer evaluate(String infix) {
    	 if (infix == null || infix.length() == 0 || !validParentheses(infix))  		
             return null;	 
    	 boolean round =false;
    	 if (!infix.contains("^")) round =true;
         char sign = '+';
         Stack<Long> stack1 = new Stack<>(); // store operands
         Stack<Character> stack2 = new Stack<>(); // store operators
         for (int i = 0; i < infix.length(); i++) {
             char ch = infix.charAt(i);
             if (Character.isDigit(ch)) {
                 long num = 0;
                 while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                     num = num * 10 + infix.charAt(i++) - '0';
                 }
                 i--;
                 stack1.push(eval(sign, stack1, num, round));
             } else if (ch == ' ') {
                 continue;
             } else if (OPEN.indexOf(ch)>=0) {
                 stack1.push(Long.MAX_VALUE);
                 stack2.push(sign);
                 sign = '+';
             } else if (CLOSE.indexOf(ch)>=0) {
                 long num = 0;
                 while (stack1.peek() != Long.MAX_VALUE) {
                     num += stack1.pop();
                 }
                 stack1.pop(); 
                 char operator = stack2.pop();
                 stack1.push(eval(operator, stack1, num, round));
             } else {
                 sign = ch;
             }
         }
         int result = 0;
         while (!stack1.isEmpty()) {
             result += stack1.pop();
         }
        if (result !=0)
        	 return (Integer) result;
        return null;
    }
    
    //Time complexity O(1), Space Complexity O(1)
    private long eval(char sign, Stack<Long> stack1, long num, boolean round) {
        if (sign == '+') {
            return num;
        } else if (sign == '-') {
            return -num;
        } else if (sign == '*') {       	
            return stack1.pop() * num;
        } else if (sign =='/') {
        	long first = stack1.pop();
        	if(first%num == 0 || !round)
        		return first / num;
        	else
        		return Math.round(first / (double)num);        	
        } else if (sign =='^')
        	return (long) Math.pow(stack1.pop(),num);
        else {
        	System.out.println("invalid:"+sign);
        	return -1;
        }
    }
    
    //Time Complexity O(n) n is length of string, Space Complexity O(n)
	private boolean validParentheses(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');	 
		Stack<Character> stack = new Stack<Character>();	 
		for (char c:s.toCharArray()) {	 
			if (map.keySet().contains(c)) {
				stack.push(c);
			} else if (map.values().contains(c)) {
				if (!stack.empty() && map.get(stack.peek()) == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}	 
		return stack.empty();
	}
	
	 //Time complexity O(n), n is length of string, Space Complexity O(1)
    private boolean validExpression(String expression) {
        if (isAnOperator(expression.charAt(0)) || isAnOperator(expression.charAt(expression.length()-1))) {
            return false;
        }
        int openParenthCount = 0;
        boolean lastWasOp = false;
        boolean lastWasOpen = false;
        for (char c : expression.toCharArray()) {
            if(c == ' ') continue;
            if (OPEN.indexOf(c)>=0) {
                openParenthCount++;
                lastWasOpen = true;
                continue;
            } else if (CLOSE.indexOf(c)>=0) {
                if (openParenthCount <= 0 || lastWasOp) {
                    return false;
                }
                openParenthCount--;
            }else if (isAnOperator(c)){
                if (lastWasOp || lastWasOpen) return false;
                lastWasOp = true;
                continue;
            }else if(!Character.isDigit(c)){
                return false;
            }
            lastWasOp = false;
            lastWasOpen = false;
        }
        if(openParenthCount != 0) return false;
        if(lastWasOp || lastWasOpen) return false;
        return true;
    }
    
    //Time complexity O(1), Space Complexity O(1)
    private boolean isAnOperator(char c) {
    	return OPERATORS.indexOf(c)>=0?true:false;   		
    }

    
	//Time complexity O(2m+2n+2mxn) ~ O(mn), m is left length, n is right length
    //Space Complexity O(n+m) to store results
    public String solve(String infix) {
        //YOUR CODE HERE
    	String[] strs=infix.split("=");
    	String left = strs[0];
    	String right = strs[1];	
    	int lLen = left.length();
    	int rLen = right.length();
    	
    	//remove 1 at each side, and compare all combinations
    	//Time complexity O(mn), Space Complexity O(n+m) 
    	Integer[] res1=blackoutOneUtil(left); 
    	Integer[] res2=blackoutOneUtil(right);
    	StringBuilder sb=new StringBuilder();
    	for (int i=0;i<lLen;i++) {
    		for(int j=0;j<rLen;j++) {
    			if(res1[i]!=null && res2[j] !=null && (int)res1[i]==(int)res2[j]) {
    				sb.append(left.substring(0,i)+left.substring(i+1));
    				sb.append("=");
    				sb.append(right.substring(0,j)+right.substring(j+1));
    				return sb.toString();
    			}
    		}
    	}
    	
    	//remove two at left side and compare with right value
    	//Time compliexity O(n), n is length of right ,Space Complexity O(1)
    	Integer rValue = evaluate(right) ;    	
    	String res = blackoutTwoUtil(left, rValue);
    	if(res!=null) {
    		sb=new StringBuilder();
    		sb.append(res);
    		sb.append("=");
    		sb.append(right);
    		return sb.toString();
    	} 
    	
    	//remove two at right side and compare with left value
    	///Time complexity O(n),  n is length of left, Space Complexity O(1)
    	Integer lValue = evaluate(left);
    	res = blackoutTwoUtil(right, lValue);
    	if(res!=null) {
    		sb=new StringBuilder();
    		sb.append(left);
    		sb.append("=");
    		sb.append(res);
    		return sb.toString();
    	} 
    	
    	return null; 
    }
    
    //utility method to remove 1 char and save to an array
    //Time complexity O(n), n is the length of input string, Space Complexity O(n)
    private Integer[] blackoutOneUtil(String s){
    	Integer[] res = new Integer[s.length()];
    	for (int i=0;i<s.length();i++) {
    		String s1 = s.substring(0,i)+s.substring(i+1);
    		if(  validExpression(s1)) 
    			res[i]=evaluate(s1);
    		else
    			res[i]=null;
    	}    	  
    	return res;
    }
    
    //utility method to remove 2 char and compare with input value
    //Time complexity O(n), n is the length of input string, Space Complexity O(1)
    private String blackoutTwoUtil (String s, Integer value) {
    	int n=s.length();
    	for (int i=0;i<n-1;i++) {
    		for (int j=i+1;j<n;j++){
    			String s1= s.substring(0,i)+s.substring(i+1,j)+s.substring(j+1);	
        		if(  validExpression(s1)) {        			
        			Integer val = evaluate(s1);
        			if(val!=null && val==(int)value) {       			
        				return s1;
        			}
        		}
    		}
    	}
    	return null;
    }
}
