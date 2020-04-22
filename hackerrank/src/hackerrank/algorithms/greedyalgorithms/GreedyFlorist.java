// https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
package hackerrank.algorithms.greedyalgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;


public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static void getMinimumCost1(int k, int[] c) {
    	// an array of int
    	int[] intarr = new int[c.length];
    	int total=0,rounds=1;
    	
    	// an array of reverse sorted ints
    	intarr = Arrays.stream(c).boxed()
    	    .sorted(Collections.reverseOrder())
    	    .mapToInt(Integer::intValue)
    	    .toArray();
    	
    	Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
    	Dictionary dictionary = new Hashtable();
    	
    	for (int i = 0; i < intarr.length; i++) {
			//dict.put(i, intarr[i]);
    		dict.put(intarr[i], c[i]);
		}
    	
    	 // Printing all words stored in the map.
        for(Integer key: dict.keySet())
            System.out.println(key + ": " + dict.get(key));	
               
    }
    
    static int getMinimumCost2(int k, int[] c) {
        Arrays.sort(c);
        int sum=0;
        int div=k;
        for(int i=c.length-1,count=0;i>=0;i--,k--)
        {
            if(k>0)
            {
                sum+=c[i];
                count++;
            }
            else
            {
                sum+=((count/div)+1)*c[i];
                count++;
            }
        }
        return sum;

    }
    
    static int getMinimumCost3(int k, int[] c) {
        Arrays.sort(c);
        int sum=0;
        int div=k;
        int count=0;
        int i=c.length-1;
        
        while (i>=0) {
            if(k>0)
            {
                sum+=c[i];
                count++;
            }
            else
            {
                sum+=((count/div)+1)*c[i];
                count++;
            }
			i--;
			k--;
		}
        return sum;

    }
    
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int sum = 0; 
        for(int x=c.length-1; x>=0;x--) sum+=(((c.length-1 - x)/k) + 1) * c[x];
        return sum;      

    }
    
    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] c = new int[n];
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);
        System.out.println(minimumCost);
//          getMinimumCost1(k,c);
        
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//        bufferedWriter.close();

        scanner.close();

	}


}
