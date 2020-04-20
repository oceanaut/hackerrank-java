package hackerrank.algorithms.greedyalgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LuckBalance {
	
    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
    	int unimportant_sum=0,ktemp=0;
    	ArrayList<Integer> l_important= new ArrayList<Integer>();
    	
    	for (int[] i : contests) {
			if ( i[1] == 0 ) {
				unimportant_sum += i[0];
			}else if ( i[1] == 1 ) {
				l_important.add(i[0]);
			}
		}
    	
    	Collections.sort(l_important, Collections.reverseOrder());
    	
    	for (Integer i : l_important) {
			if (ktemp < k ) {
				unimportant_sum += i;
				ktemp += 1;				
			}else {
				unimportant_sum -= i;
			}
		}
    	
    	return unimportant_sum;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//        bufferedWriter.close();

        scanner.close();

	}

}
