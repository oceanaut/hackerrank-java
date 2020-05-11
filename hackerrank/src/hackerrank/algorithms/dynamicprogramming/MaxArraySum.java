// https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
package hackerrank.algorithms.dynamicprogramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum1(int[] arr) {
    	int incl = 0, excl = 0, new_excl=0;
    	
    	for (int a : arr) {
    		new_excl = Math.max(incl, excl);        
    		incl = excl + a;
    		excl = new_excl;
		}
    	
    	return Math.max(incl, excl);
    }
    
	 static int maxSubsetSum2(int arr[]) {
		 ArrayList<Integer> dp = new ArrayList<Integer>();
	        dp.add(arr[0]);
	        dp.add(Math.max(arr[1],arr[0]));
	        for(int i=2;i<arr.length;i++)
	            dp.add(Math.max(arr[i],Math.max(arr[i]+dp.get(i-2),dp.get(i-1))));
	        return dp.get(arr.length-1);
	 }
	 
	 static int maxSubsetSum(int arr[]) {
		    int n = arr.length ;
		    
		    int inclusive = arr[0] , exclusive = 0, ex ;
		    
		    for(int i=1; i<n; i++)
		    {
		        ex = Math.max(inclusive, exclusive) ;

		        inclusive = arr[i]+exclusive ;

		        exclusive = ex ;
		    }

		 return Math.max(inclusive, exclusive) ;
	 }
	 
    private static final Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);
        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//        bufferedWriter.close();

        scanner.close();

	}

}
