// https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=sorting

package practice.interviewpreparationkit.sorting;

import java.util.Scanner;

public class BubbleSort {
	
     static void countSwaps(int[] a) {
    	int count = 0;
    	for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1 ; j++) {
				if ( a[j] > a[j+1] ) {
					int temp=a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					count++;		
				}
			}
		}
    	
    	
        System.out.println(String.format(
                "Array is sorted in %d swaps.%n" +
                        "First Element: %d%n" +
                        "Last Element: %d%n",
                count,
                a[0],
                a[a.length - 1]));
    		
    			
    }

    private static final Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();

	}

}
