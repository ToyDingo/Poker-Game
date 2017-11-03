/****************************************/
/*Card class only has a rank and a suit.*/
/*It has no other function.             */
/****************************************/
public class Card {
	
	private char rank;
	private char suit;
	private int rankValue;
	private int suitValue;
	
	public Card(String rankSuit){
		
		char[] a = rankSuit.toCharArray();
		
		rank = a[0];
		suit = a[1];
		setRankValue();
		setSuitValue();
	}
	
	public char getRank(){ return rank;}
	
	public char getSuit(){ return suit;}
	
	public int rankValue(){ return rankValue;}
	
	public int suitValue(){ return suitValue;}
	
	private void setRankValue(){
		switch(rank){
			case '2' : rankValue = 0;
			case '3' : rankValue = 1;
			case '4' : rankValue = 2;
			case '5' : rankValue = 3;
			case '6' : rankValue = 4;
			case '7' : rankValue = 5;
			case '8' : rankValue = 6;
			case '9' : rankValue = 7;
			case 'T' : rankValue = 8;
			case 'J' : rankValue = 9;
			case 'Q' : rankValue = 10;
			case 'K' : rankValue = 11;
			case 'A' : rankValue = 12;
		}		
	}
	
	private void setSuitValue(){
		switch(rank){
			case 'c' : suitValue = 0;
			case 'd' : suitValue = 1;
			case 'h' : suitValue = 2;
			case 's' : suitValue = 3;			
		}		
	}
}
