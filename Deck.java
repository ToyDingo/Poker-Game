import java.util.ArrayList;
import java.util.Random;

/***************************************************/
/*Deck class is responsible for creating a deck    */
/*of 52 cards. I will also have a shuffle function.*/
/***************************************************/
public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	private enum SuitRanks{
		h2, h3, h4, h5, h6, h7, h8, h9, hT, hJ, hQ, hK, hA, 
		c2, c3, c4, c5, c6, c7, c8, c9, cT, cJ, cQ, cK, cA, 
		d2, d3, d4, d5, d6, d7, d8, d9, dT, dJ, dQ, dK, dA, 
		s2, s3, s4, s5, s6, s7, s8, s9, sT, sJ, sQ, sK, sA
	}

	public Deck(){
		
		for(SuitRanks i:SuitRanks.values()){
			Card card = new Card(i.toString());
			deck.add(card);
		}
		
		shuffle(deck);
	}
	
	private void shuffle(ArrayList<Card> input){
		
		Card temp;
		Random random = new Random();
		int n;
		
		for(int i = 0; i < input.size(); i++){
			n = random.nextInt(52);
			temp = input.get(i);
			input.set(i, input.get(n));
			input.set(n, temp);		
		}	
	}
	
	public Card drawCard(){ return deck.remove(0);}
	
	public int getSize(){ return deck.size();}
	
	public boolean isEmpty(){ return deck.isEmpty();}
}
