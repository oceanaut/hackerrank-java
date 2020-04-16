// https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
package practice.interviewpreparationkit.sorting;

import java.util.*;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker1 implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
        int nameCompare = a.name.compareTo(b.name);
        int scoreCompare = b.score-a.score;
        if(scoreCompare == 0){
            return nameCompare;
        }
        return scoreCompare;
    }
}

class Checker implements Comparator<Player> {
  	// complete this method
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            return (a.score > b.score ? -1 : 1);
        }
        else {
            return (a.name).compareTo(b.name);
        }
    }
}

public class SortingComparator {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
