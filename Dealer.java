import java.util.ArrayList;

/***********************************************************/
/* Dealer simply deals cards and determines a winner.      */
/***********************************************************/
public class Dealer {

	Deck deck = new Deck();
	Rulebook rulebook = new Rulebook();
	
	public Dealer(){}
	
	public ArrayList<Card> dealCards(){
		
		ArrayList<Card> hand = new ArrayList<Card>();
		
		for(int i = 0; i < 5; i++){
			hand.add(deck.drawCard());
		}
		
		return hand;
	}
	
	public ArrayList<Card> replaceCards(ArrayList<Card> hand, ArrayList<String> replace){
		
		for(String i : replace){
			for(Card j : hand){
				if(j.toString().equals(i)){
					hand.remove(j);
					break;
				}
			}
		}
		
		for(int i = 0; i < replace.size(); i++){
			hand.add(deck.drawCard());
		}
		
		return hand;
	}
	
	public String determineWinner(ArrayList<Card> userHand, ArrayList<Card> aiHand){
		
		StringBuilder result = new StringBuilder("");
		int[] user = rulebook.determineHand(userHand);
		int[] ai = rulebook.determineHand(aiHand);
		
		if(user[0] > ai[0])
			result.append("You win with " + rulebook.whatHandIsThis(user[0]));
		else if(user[0] < ai[0])
			result.append("Your opponent wins with " + rulebook.whatHandIsThis(ai[0]));
		else if(user[0] == ai[0]){
			if(user[1] > ai[1])
				result.append("You win with high card!");
			else if(user[1] < ai[1])
				result.append("Your opponent wins with high card!");
			else if(user[1] == ai[1])
				result.append("It's a tie!");
		}		
		
		return result.toString();
	}
}
