import java.util.ArrayList;

/***********************************************************/
/* Dealer simply deals cards and determines a winner.      */
/***********************************************************/
public class Dealer {

	Deck deck = new Deck();
	Rulebook rulebook = new Rulebook();
	
	public ArrayList<Card> dealCards(){
		
		ArrayList<Card> hand = new ArrayList<Card>();
		
		for(int i = 0; i < 5; i++){
			hand.add(deck.drawCard());
		}
		
		return hand;
	}
	
	public ArrayList<Card> replaceCards(ArrayList<Card> hand, ArrayList<Card> replace){
		
		for(Card i : replace){
			hand.remove(i);
		}
		
		for(int i = 0; i < replace.size(); i++){
			hand.add(deck.drawCard());
		}
		
		return hand;
	}
	
	public String determineWinner(ArrayList<Card> userHand, ArrayList<Card> aiHand){
		
		StringBuilder result = new StringBuilder("");
		
		if(rulebook.determineHand(userHand)[0] > rulebook.determineHand(aiHand)[0])
			result.append("You win with " + rulebook.whatHandIsThis(rulebook.determineHand(userHand)[0]));
		if(rulebook.determineHand(userHand)[0] < rulebook.determineHand(aiHand)[0])
			result.append("Your opponent wins with " + rulebook.whatHandIsThis(rulebook.determineHand(aiHand)[0]));
		if(rulebook.determineHand(userHand)[0] == rulebook.determineHand(aiHand)[0]){
			if(rulebook.determineHand(userHand)[1] > rulebook.determineHand(aiHand)[1])
				result.append("You win with high card!");
			if(rulebook.determineHand(userHand)[1] < rulebook.determineHand(aiHand)[1])
				result.append("Your opponent wins with high card!");
			if(rulebook.determineHand(userHand)[1] == rulebook.determineHand(aiHand)[1])
				result.append("It's a tie!");
		}		
		
		return result.toString();
	}
}
