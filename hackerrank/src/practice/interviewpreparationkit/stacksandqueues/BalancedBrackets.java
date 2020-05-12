package practice.interviewpreparationkit.stacksandqueues;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    static char rev(char semiBracket) {      
	        if ( semiBracket == ')' ) {
	        	return '(';
			}else if ( semiBracket == '}' ) {
				return '{';
			}else {
				return '[';
			}       
    }
    
    static String isBalanced(String s) {
		    	//  char is one of the primitive datatypes in Java, which cannot be used in generics. 
		    	//  the wrapper java.lang.Character
		    	Stack<Character> stack1 = new Stack<Character>(); 
		    	char[] chars=s.toCharArray();	
		    	for (char  c : chars) {
		    		if(c == '[' || c == '{' || c == '(') {
		    			stack1.push(c);
		    		}else if (stack1.size() == 0) {
		    			return "NO";
					}else if (stack1.pop() == rev(c)) {
		    			continue;
					}
		    		else {
		    			return "NO";
					}	
		    		
		    	}		    	
		    return stack1.size() == 0 ? "YES" : "NO";

    }
    
    
    
    // Complete the isBalanced function below.
    static String isBalanced11(String s) {
        char c [] = new char[s.length()];
        int top = -1;
        boolean x,y,z;
        c[++top] = s.charAt(0);
        for(int i=1;i<s.length();i++){
            char next = s.charAt(i);
            // System.out.println(next);
            x = (top!=-1) && (c[top] == '(') && (next == ')');
            y = (top!=-1) &&(c[top] == '{') && (next == '}');
            z = (top!=-1) && (c[top] == '[') && (next == ']');
            if(x || y || z)
                top--;
            else if((next=='(') || (next=='{') ||(next=='['))
                c[++top] = s.charAt(i);
            else
                return "NO";
        }
        if(top==-1)
            return "YES";
        else
            return "NO";


    }

    
    private static final Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
//		 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            String s = scanner.nextLine();

	            String result = isBalanced(s);
	            System.out.println(result);
//	            bufferedWriter.write(result);
//	            bufferedWriter.newLine();
	        }

//	        bufferedWriter.close();

	        scanner.close();

	}

}
