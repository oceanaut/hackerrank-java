//https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem?h_l=interview&playlist_slugs[]=interview-preparation-kit&playlist_slugs[]=stacks-queues
package practice.interviewpreparationkit.stacksandqueues;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class ATaleofTwoStacks {

	public static void main(String[] args) {
	    try (final Scanner in = new Scanner(System.in)) {
	    	
	        final LinkedList<Integer> list = new LinkedList<>();
	        
	        for (int q = in.nextInt(); q > 0; q--) {
		          switch (in.nextInt()) {
		          case 1: //Enqueue element into the end of the queue.
		            list.add(in.nextInt());
		            continue;
		          case 2: //Dequeue the element at the front of the queue.
		            list.removeFirst();
		            continue;
		          case 3: //Print the element at the front of the queue
		            System.out.println(list.getFirst());
		          }
	        }
	      
	    }

	}

}
