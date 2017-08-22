import java.util.*;
import java.lang.Math;

public class HoldemGame {

	public static final int MAX_PLAYERS = 10;
	public static final int CARDS = 52;
	private static ArrayList<Card> deck = new ArrayList<Card>();
	
	public static void main(String[] args) {
		// Keyboard for input
		Scanner keyboard = new Scanner(System.in);

		// Gets the number of players from the user
		int players = getPlayers(keyboard);
		System.out.printf("There are %d players.", players);
		
		// Calculates how many cards to deal and how many cards will be left
		int cardsToDeal = MAX_PLAYERS * 2;
		int cardsLeft = CARDS - cardsToDeal;
		
		// Fills the deck ArrayList with Cards
		fill();
		
		// Shuffles the deck using the collections object
		Collections.shuffle(deck);

		// TODO figure out how to deal cards to # of players
		// keep in mind that the cards dealt (each players' hand) needs to be accessible to other methods
		
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
	
	// Fills the deck with cards
	public static void fill() {
		for (Suit s : Suit.values()) {
			for (Value v : Value.values()) {
				deck.add(new Card(v,s));
			}
		}
		/*Test Code
		deck.add(new Card(Value.TWO, Suit.CLUBS));
		deck.add(new Card(Value.TWO, Suit.HEARTS));
		deck.add(new Card(Value.TWO, Suit.DIAMONDS));
		deck.add(new Card(Value.TWO, Suit.SPADES));
		deck.add(new Card(Value.ACE, Suit.CLUBS));
		deck.add(new Card(Value.ACE, Suit.DIAMONDS));
		deck.add(new Card(Value.KING, Suit.DIAMONDS));*/
	}
	
}
