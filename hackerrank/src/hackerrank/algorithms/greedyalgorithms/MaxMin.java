// https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms

package hackerrank.algorithms.greedyalgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxMin {
	
    // Complete the maxMin function below.
    static int maxMin1(int k, int[] arr) {
        Arrays.sort(arr);
        int a =0;
        int min=Integer.MAX_VALUE ;
        int diff = 0;
    
        while(a<arr.length-k+1)
        {
            diff = arr[a+k-1] - arr[a];
            if(diff<min)
                min = diff;

            a++;        
        }

       return min;

    }
    
    static int maxMin2(int k, int[] arr) {
    	int unfair=Integer.MAX_VALUE ;
    	Arrays.sort(arr);
    	int i=0;
        while(i <arr.length-k+1)
        {
        	unfair = Math.min(unfair, (arr[i+k-1]-arr[i]) );
            i++;
        }
    	return unfair;
    }
    static int maxMin(int k, int[] arr) {
    	int unfair=Integer.MAX_VALUE ;
    	Arrays.sort(arr);
    	for (int j = 0; j < (arr.length-k+1); j++) {
        	unfair = Math.min(unfair, (arr[j+k-1]-arr[j]) );
		}
    	return unfair;
    }
    
    
    private static final Scanner scanner = new Scanner(System.in);    

	public static void main(String[] args) {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//        bufferedWriter.close();

        scanner.close();
	}

}
