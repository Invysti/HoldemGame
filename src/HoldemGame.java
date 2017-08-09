import java.util.*;
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
		int cardsToDeal = MAX_PLAYERS * 2;
		
		// TODO calculate number of cards left in deck
		int cardsLeft = CARDS - cardsToDeal;
		
		// TODO implement card data structure linked list?
		LinkedList deck = new LinkedList();
		
		// TODO shuffle cards

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
