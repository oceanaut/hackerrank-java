// https://www.hackerrank.com/challenges/candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
package hackerrank.algorithms.dynamicprogramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Candies {

	static long candies1(int n, int[] arr) { //testcase 11,12 fails
		int[] candies= new int[n];
		Arrays.fill(candies,1) ; //Alice wants to give at least 1 candy to each child.
	    for(int i=1;i<n;i++){
	        if (arr[i]>arr[i-1]) {
	        	candies[i]=candies[i-1]+1;
			}
	    }
	    
	    for(int i=n-2;i>=0;i--){
	        if (arr[i]>arr[i+1]) {
	        	candies[i]=Math.max(candies[i],candies[i+1]+1);
			}
	    	
	    }
	    
		return Arrays.stream(candies).sum();
	}
    // Complete the candies function below.
    static long candies(int n, int[] arr) {
    int[] candies= new int[n];
    Arrays.fill(candies,1) ; //Alice wants to give at least 1 candy to each child.
    for(int i=1;i<n;i++){
        candies[i]=(arr[i]>arr[i-1]?candies[i-1]+1:1); //If two children sit next to each other, then the one with the higher rating must get more candies.
    }
    long count=0 ;
    for(int i=n-2;i>=0;i--){
    	if(arr[i]>arr[i+1] && candies[i+1] >= candies[i]){
            candies[i]= candies[i+1]+1 ;
        }
        count+=candies[i] ;
    }
    count+=candies[n-1] ;
    return count ;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWri ter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//        bufferedWriter.close();

        scanner.close();
    }
}