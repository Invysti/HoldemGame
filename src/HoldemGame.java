import java.util.*;
import java.lang.Math;

public class HoldemGame {

	public static final int MAX_PLAYERS = 10;
	public static final int CARDS = 52;
	private static ArrayList<Card> deck = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();
	private static ArrayList<Card> computerCards = new ArrayList<Card>();
	public static int currentCard = 0;
	public static Vector<Integer> chips = new Vector<Integer>();
	
	public static void main(String[] args) {
		// Keyboard for input
		Scanner keyboard = new Scanner(System.in);

		// Gets the number of players from the user (including the player)
		int players = getPlayers(keyboard);
		System.out.printf("There are %d players.\n", players);
		
		// Calculates how many cards to deal and how many cards will be left
		int cardsToDeal = (players * 2);
		System.out.println("Deal " + cardsToDeal + " cards.");

		// Fills the deck ArrayList with Card objects
		fill();
		
		// Deal cards
		dealCards(cardsToDeal);
		// Testing code to determine if cards have been dealt properly
		System.out.println("Player's Cards: " + playerCards.toString());
		System.out.println("Computer's Cards: " + computerCards.toString());
		
		// TODO each player needs an assigned number of chips
		startingChips(players);
		System.out.println("Chips vector structure: " + chips.toString());
		
		// TODO figure out functionality of the game
			// after dealing cards to player, need to figure out blinds
			// let's assume that we start with the player as the dealer
			// so the player to the left of the dealer starts as small blind
			// player to the left of that person is big blind
			// since we're using an array of size 20 to represent the computers' hands
			// we can start a[0] as the small blind meaning a[2] will be big blind
			// increment the integers by 2 
		
		// TODO after collecting blinds, we will need to figure out each computer's decision
			// TODO this is the difficult part
		
		System.out.println("Please post your blinds.");
		
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
	public static void dealCards(int cardsToDeal) {
		Collections.shuffle(deck);
		System.out.print("The deck is: ");
		System.out.println(deck.toString());
		// double for loop to simulate dealing one card to each player with the player being last, repeats twice
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < (cardsToDeal-2)/2; j++) {
				computerCards.add(deck.get(currentCard));
				currentCard++;
			}
			playerCards.add(deck.get(currentCard));
			currentCard++;
		}
	}
	
	// Gives 1000 initial chips to each player
	public static void startingChips(int players) {
		for (int i = 0; i < players; i++) {
			chips.add(1000);
		}
	}
	
	
	
}
