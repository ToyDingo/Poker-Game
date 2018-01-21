import java.util.ArrayList;
import java.util.Scanner;

public class FiveCardPoker {
	
	private static Dealer dealer = new Dealer();
	private static ArrayList<Card> userHand = new ArrayList<Card>();
	private static ArrayList<Card> aiHand = new ArrayList<Card>();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to 5 Card Poker!\n");
		start();
		input.close();
	}
	
	private static void start(){
		userHand.clear();
		aiHand.clear();
		userHand.addAll(dealer.dealCards());
		aiHand.addAll(dealer.dealCards());
		
		System.out.print("You've been dealt these cards:\n");
		for(Card i:userHand){
			System.out.print(i.toString()+" ");
		}
		System.out.println("\n");
		
		System.out.print("How many cards would you like to replace?\n (Type 0, 1, or 2): ");
		int numberToReplace = input.nextInt();
		System.out.println();
		
		if(numberToReplace == 0) results();
		else replace(numberToReplace);		
	}
	
	private static void replace(int n){
		ArrayList<String> replaceThese = new ArrayList<String>();
		String thisCard = new String();
		
		if(n == 1){
			System.out.print("Type the card you'd like to replace.\n (example: sA or c3): ");
			thisCard = input.next();
			replaceThese.add(thisCard);
			System.out.println("\n");
		}
		else{
			for(int i = 1; i <=2; i++){
				if(i == 1) System.out.print("Type the first card you'd like to replace.\n (example: sA or c3): ");
				else System.out.print("Type the second card you'd like to replace.\n (example: sA or c3): ");
				
				thisCard = input.next();
				replaceThese.add(thisCard);
				System.out.println();
			}
		}
		
		dealer.replaceCards(userHand, replaceThese);
		
		System.out.print("This is your new hand:\n");
		for(Card i:userHand){
			System.out.print(i.toString()+" ");
		}
		System.out.println("\n");
		
		results();		
	}
	
	private static void results(){
		System.out.println("Your hand was: ");
		for(Card i:userHand){
			System.out.print(i.toString()+" ");
		}
		System.out.println("\n");
		
		System.out.println("AI hand was: ");
		for(Card i:aiHand){
			System.out.print(i.toString()+" ");
		}
		System.out.println("\n");
		
		System.out.println(dealer.determineWinner(userHand, aiHand)+ "\n");
		
		if(dealer.deckSize() >= 12) restart();
		else System.out.println("There are no longer enough cards in the deck to continue.\n Thanks for playing!");
	}
	
	private static void restart(){
		System.out.println("There are " + dealer.deckSize() + " cards remaining in the deck.");
		System.out.print("Would you like to play another hand?\n (Y or N)");
		String restart = input.next();
		System.out.println();
		
		if(restart.equals("Y") || restart.equals("y")) start();
		else System.out.println("Thanks for playing!\n");
	}
}
