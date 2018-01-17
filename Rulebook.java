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
	private boolean isStraight;
	private HashMap<Character, Integer> rankHm = new HashMap<Character, Integer>();
	private HashMap<Character, Integer> suitHm = new HashMap<Character, Integer>();
	
	public Rulebook(){}
	
	public int[] determineHand(ArrayList<Card> hand){
		
		int[] result = new int[2];
		highestRank = 0;
		isStraight = true;
		rankHm.clear();
		suitHm.clear();
		
		sortHand(hand);
		
		result[1] = highestRank;
		
		if(rankHm.size() == 2){
			if(rankHm.containsValue(4)) result[0] = 8; //4 of a Kind
			else if(rankHm.containsValue(3)) result[0] = 7; //Full House
		}
		
		else if(rankHm.size() == 3){
			if(rankHm.containsValue(3)) result[0] = 4; //3 of a Kind
			else if(rankHm.containsValue(2)) result[0] = 3; //2 Pair
		}
		
		else if(rankHm.size() == 4) result[0] = 2; //Pair
		
		else if(rankHm.size() == 5){
			if(isStraight){
				if(suitHm.size() == 1) result[0] = 9; //Straight Flush
				else if(suitHm.size() == 1 && highestRank == 12) result[0] = 10; //Royal Flush
				else if(suitHm.size() > 1) result[0] = 5; //Straight
			}
			else if(!isStraight){
				if(suitHm.size() == 1) result[0] = 6; //Flush
				else if(suitHm.size() > 1) result[0] = 1; //High Card
			}
		}
		
		return result;
	}
	
	private void sortHand(ArrayList<Card> hand){
		for(int i = 0; i < hand.size(); i++){
			if(rankHm.containsKey(hand.get(i).getRank())){
				rankHm.put(hand.get(i).getRank(), rankHm.get(hand.get(i).getRank())+1);
			}
			else{
				rankHm.put(hand.get(i).getRank(), 1);
			}
			
			if(suitHm.containsKey(hand.get(i).getSuit())){
				suitHm.put(hand.get(i).getSuit(), suitHm.get(hand.get(i).getSuit())+1);
			}
			else{
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
				case '2' : handValues[i] = 0; break;
				case '3' : handValues[i] = 1; break;
				case '4' : handValues[i] = 2; break;
				case '5' : handValues[i] = 3; break;
				case '6' : handValues[i] = 4; break;
				case '7' : handValues[i] = 5; break;
				case '8' : handValues[i] = 6; break;
				case '9' : handValues[i] = 7; break;
				case 'T' : handValues[i] = 8; break;
				case 'J' : handValues[i] = 9; break;
				case 'Q' : handValues[i] = 10; break;
				case 'K' : handValues[i] = 11; break;
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
	
	public String whatHandIsThis(int input){
		switch(input){
			case 1 : return "High Card!";
			case 2 : return "Pair!";
			case 3 : return "2 Pair!";
			case 4 : return "3 of a Kind!";
			case 5 : return "Straight!";
			case 6 : return "Flush!";
			case 7 : return "Full House!";
			case 8 : return "4 of a Kind!";
			case 9 : return "Straight Flush!";
			case 10 : return "Royal Flush!";
		}
		
		return null;
	}
}
