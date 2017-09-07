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
		
		// Each player begins the game with 1000 chips
		startingChips(players);
		System.out.println("Chips vector structure: " + chips.toString());
		
		
		// Currently only collects blinds for first round assuming dealer is the player
		System.out.println("Please post your blinds.");
		collectBlind(0);
		System.out.println("New Chips vector structure: " + chips.toString());
		
		// Let's begin by assuming that everyone calls
			// This needs to start at bigBlind + 1 who has the first choice
			// Call or no call?
		
		// TODO after collecting blinds, we will need to figure out each computer's decision
			// TODO this is the difficult part
		
		
		
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
	
	// Collect blinds from players
	// TODO deal with redundancy
	public static void collectBlind(int dealer) {
		int smallBlind = dealer + 1;
		int bigBlind = dealer + 2;
		if (smallBlind > 9) {
			smallBlind = 0;
			bigBlind = 1;

		} else if (bigBlind > 9) {
				smallBlind = 9;
				bigBlind = 0;
		}
		chips.set(smallBlind, chips.get(smallBlind) - 10);
		chips.set(bigBlind, chips.get(bigBlind) - 20);
		
	}
}
