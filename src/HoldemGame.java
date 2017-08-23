import java.util.*;
import java.lang.Math;

public class HoldemGame {

	public static final int MAX_PLAYERS = 10;
	public static final int CARDS = 52;
	private static ArrayList<Card> deck = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();
	private static ArrayList<Card> computerCards = new ArrayList<Card>();
	public static int currentCard = 0;
	
	public static void main(String[] args) {
		// Keyboard for input
		Scanner keyboard = new Scanner(System.in);

		// Gets the number of players from the user
		int players = getPlayers(keyboard);
		System.out.printf("There are %d players.\n", players);
		
		// Calculates how many cards to deal and how many cards will be left
		int cardsToDeal = (players * 2);
		System.out.println("Deal " + cardsToDeal + " cards.");

		// Fills the deck ArrayList with Cards
		fill();
		
		// Deal cards
		dealCards(players);
		
		// Testing the player and computer's hand
		System.out.println("Player's Cards: " + playerCards.toString());
		System.out.println("Computer's Cards: " + computerCards.toString());
		
		// TODO deal cards to players
		// TODO figure out functionality of the game
		// TODO win condition???
		
		
	}
	
	// Gets the number of players from the user, must be between 2 and 10 players
	public static int getPlayers(Scanner keyboard) {
		int player;
		System.out.println("Please enter the number of players.");
		do {
			System.out.print("Please enter an amount between 2 and 10: ");
			while (!keyboard.hasNextInt()) {
				System.out.print("Please enter an integer: ");
				keyboard.next();
			}
			player = keyboard.nextInt();
		} while (player < 2 || player > 10);
		return player;
	}
	
	// Fills the deck with cards
	public static void fill() {
		for (Suit s : Suit.values()) {
			for (Value v : Value.values()) {
				deck.add(new Card(v,s));
			}
		}
	}
	
	// Shuffles and deals the cards to the players
	// TODO inaccurate number of cards are currently being dealt to the players
	public static void dealCards(int cardsToDeal) {
		Collections.shuffle(deck);
		System.out.print("The deck is: ");
		System.out.println(deck.toString());
		// double for loop to simulate dealing one card to each player with the player being last, repeats twice
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < cardsToDeal; j++) {
				computerCards.add(deck.get(currentCard));
				currentCard++;
			}
			playerCards.add(deck.get(currentCard));
			currentCard++;
		}
	}
	
}
