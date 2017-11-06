import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/***********************************************************/
/*Rulebook will make the calculations as to what the value */
/* of each hand is. It will return that value to the Dealer*/
/* who will compare that value to other hands to determine */
/* a winner.                                               */
/***********************************************************/
public class Rulebook {
	
	private int highestRank;
	private boolean isStraight = true;
	private HashMap<Character, Integer> rankHm = new HashMap<Character, Integer>();
	private HashMap<Character, Integer> suitHm = new HashMap<Character, Integer>();
	
	public int determineHand(ArrayList<Card> hand){
		
		sortHand(hand);
		
		if(rankHm.size() == 2){
			if(rankHm.containsValue(4)) return 8; //4 of a Kind
			if(rankHm.containsValue(3)) return 7; //Full House
		}
		
		if(rankHm.size() == 3){
			if(rankHm.containsValue(3)) return 4; //3 of a Kind
			if(rankHm.containsValue(2)) return 3; //2 Pair
		}
		
		if(rankHm.size() == 4) return 2; //Pair
		
		if(rankHm.size() == 5){
			if(isStraight){
				if(suitHm.size() == 1) return 9; //Straight Flush
				if(suitHm.size() == 1 && highestRank == 12) return 10; //Royal Flush
				if(suitHm.size() > 1) return 5; //Straight
			}
			if(!isStraight){
				if(suitHm.size() == 1) return 6; //Flush
				if(suitHm.size() > 1) return 1; //High Card
			}
		}
		
		return 0; //Error
	}
	
	private void sortHand(ArrayList<Card> hand){
		for(int i = 0; i < hand.size(); i++){
			if(rankHm.containsKey(hand.get(i).getRank())){
				rankHm.put(hand.get(i).getRank(), rankHm.get(hand.get(i).getRank())+1);
			}
			else if(!rankHm.containsKey(hand.get(i).getRank())){
				rankHm.put(hand.get(i).getRank(), 1);
			}
			
			if(suitHm.containsKey(hand.get(i).getSuit())){
				suitHm.put(hand.get(i).getSuit(), suitHm.get(hand.get(i).getSuit())+1);
			}
			else if(!suitHm.containsKey(hand.get(i).getSuit())){
				suitHm.put(hand.get(i).getSuit(), 1);
			}
		}
		
		isStraight(hand);
	}
	
	//Determines if the hand is a straight and what the highest card is
	private void isStraight(ArrayList<Card> hand){
		
		int[] handValues = new int[5];
		
		for(int i = 0; i < 5 ; i++){
			
			switch(hand.get(i).getRank()){
				case '2' : handValues[i] = 0;
				case '3' : handValues[i] = 1;
				case '4' : handValues[i] = 2;
				case '5' : handValues[i] = 3;
				case '6' : handValues[i] = 4;
				case '7' : handValues[i] = 5;
				case '8' : handValues[i] = 6;
				case '9' : handValues[i] = 7;
				case 'T' : handValues[i] = 8;
				case 'J' : handValues[i] = 9;
				case 'Q' : handValues[i] = 10;
				case 'K' : handValues[i] = 11;
				case 'A' : handValues[i] = 12;
			}
		}
		
		Arrays.sort(handValues);
		highestRank = handValues[4];
		
		for(int i = 0; i < 5; i++){
			if((handValues[i] + 1) != handValues[i+1]){
				isStraight = false;
				i = 5;
			}
		}
	}
}
