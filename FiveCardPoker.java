import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FiveCardPoker {

	public static void main(String[] args) {
		
		Dealer dealer = new Dealer();
		ArrayList<Card> userHand = new ArrayList<Card>(dealer.dealCards());
		ArrayList<Card> aiHand = new ArrayList<Card>(dealer.dealCards());
		
		//Scanner userInput = new Scanner(System.in);
		
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
		
		System.out.println(dealer.determineWinner(userHand, aiHand));
	}
}
