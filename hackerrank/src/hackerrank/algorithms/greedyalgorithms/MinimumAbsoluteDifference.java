// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=greedy-algorithms
package hackerrank.algorithms.greedyalgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumAbsoluteDifference {
	
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference1(int[] arr) {
        int min=999999999;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++)
        {
            if(Math.abs(arr[i]-arr[i+1])<min)
            min=Math.abs(arr[i]-arr[i+1]);
        }
        return min;

    }
    
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min=Math.abs(arr[0]-arr[1]);
        
        for(int i=1;i<arr.length-1;i++)
        {
            min = (Math.abs(arr[i]-arr[i+1])<min) ? Math.abs(arr[i]-arr[i+1]) : min;
        }
        return min;

    }
    

    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//	       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] arr = new int[n];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        int result = minimumAbsoluteDifference(arr);
	        System.out.println(result);
//	        bufferedWriter.write(String.valueOf(result));
//	        bufferedWriter.newLine();
//
//	        bufferedWriter.close();

	        scanner.close();
	    }


}
