import java.util.Scanner;
import java.lang.Math;

public class HoldemGame {

	public static final int MAX_PLAYERS = 10;
	public static final int CARDS = 52;
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		// TODO get number of players from user
		int players = getPlayers(keyboard);
		System.out.printf("There are %d players.", players);
		
		// TODO calculate number of cards to be dealt
		
		// TODO calculate number of cards left in deck
		
		// TODO consider how game should be played
		
		// TODO figure out card data structure

	}

	public static int getPlayers(Scanner keyboard) {
		int player;
		System.out.println("Please enter the number of players.");
		do {
			System.out.print("Please enter an amount between 1 and 10: ");
			while (!keyboard.hasNextInt()) {
				System.out.print("Please enter an integer: ");
				keyboard.next();
			}
			player = keyboard.nextInt();
		} while (player < 1 || player > 10);
		return player;
	}
	
}
