/****************************************/
/*Card class only has a rank and a suit.*/
/*It has no other function.             */
/****************************************/
public class Card {
	
	private char rank, suit;
	private String suitRank;
	
	public Card(String suitRank){
		
		this.suitRank = suitRank;
		char[] a = suitRank.toCharArray();
		
		rank = a[1];
		suit = a[0];
	}
	
	public char getRank(){ return rank;}
	
	public char getSuit(){ return suit;}
	
	public String toString(){ return suitRank;}
}
