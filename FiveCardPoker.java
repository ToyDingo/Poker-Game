import java.util.HashMap;
import java.util.Scanner;

public class FiveCardPoker {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Your best hand is " + DetermineHand(userInput));
	}
	
	private static String DetermineHand(Scanner userInput){
		
		//Creates an array of Strings from user input
		String[] input = userInput.nextLine().split(",");
		
		//Setting up HashMap of all the ranks
		HashMap<Character, Integer> ranks = new HashMap<Character, Integer>();
		
		//Setting up HashMap of all the suits
		HashMap<Character, Integer> suits = new HashMap<Character, Integer>();
		
		//Fill in the HashMaps with the input ranks and suits.
		//Converting each element in input[] to char[].
		for(int i = 0; i < input.length; i++){
			char[] a = input[i].toCharArray();
			
			if(!ranks.containsKey(a[0])) ranks.put(a[0], 1);
			if(ranks.containsKey(a[0])) ranks.put(a[0], ranks.get(a[0]) + 1);
			if(!suits.containsKey(a[1])) suits.put(a[1], 1);
			if(suits.containsKey(a[1])) suits.put(a[1], suits.get(a[1]) + 1);	
		}
		
		StringBuilder result = new StringBuilder("");
		Object[] b = ranks.keySet().toArray();
		
		//Flush
		if(suits.size() == 1) return "Flush!";
		
		//Full House
		if(ranks.containsValue(2) && ranks.containsValue(3)){
			if(ranks.get(b[0]) > ranks.get(b[1]))
				return "Full House, " + b[0] + "'s over " + b[1] + "'s.";
			if(ranks.get(b[1]) > ranks.get(b[0]))
				return "Full House, " + b[1] + "'s over " + b[0] + "'s.";
		}
		
		//Four of a Kind
		if(ranks.containsValue(3) && ranks.containsValue(1)){
			for(int i = 0; i < b.length; i++){
				if(ranks.get(b[i]) == 4) return "Four of a kind, " + b[i] + "'s.";
			}
		}
		
		//Three of a kind
		if(ranks.containsValue(3) && ranks.containsValue(1)){
			for(int i = 0; i < b.length; i++){
				if(ranks.get(b[i]) == 3) return "Three of a kind, " + b[i] + "'s.";
			}
		}
		
		//One Pair
		if(ranks.containsValue(2) && ranks.size() == 4){
			for(int i = 0; i < b.length; i++){
				if(ranks.get(b[i]) == 2) return "Pair of " + b[i] + "'s.";
			}
		}
		
		//Two Pair
		if(ranks.containsValue(2) && ranks.size() == 3){
			result.append("Two pair, ");
			for(int i = 0; i < b.length; i++){
				if(ranks.get(b[i]) == 2) return b[i] +"'s ";
			}
		}
		
		//High Card
		if(ranks.size() == 5 && suits.size() != 5) return "high card of ";
		
		return result.toString();
	}

}
