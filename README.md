# Poker-Game

A simple game of 5 Card Poker. This accepts no user input (so far). 

The game randomly assigns 5 cards to the user and 5 to itself, then 
determines a winner based on the best combination of cards. Later versions
may include user input to exchange cards. 

Written entirely in Java 1.8

Included classes:

-->FiveCardPoker<--

      Main class.

      Creates an object of Dealer class. Creates to ArrayList of type Card that will 
      act as the "hands" for both players. 

      The main computation of the game occurs in the final line when "determineWinner()" 
      is called. 

-->Dealer<--

      This class is responsible for dealing cards and consulting the Rulebook class for 
      rules. Dealer determines which player has won the game. 

      Creates an object of the Deck class and Rulebook class. 

-->Deck<--

      Responsible for creating 52 unique cards from a predetermine enumerator set. As well
      as shuffling the deck after creation of cards. 

      The created "deck" is an ArrayList of type Card with a size of 52.

-->Card<--

      Contains information on rank and suit of the Card object. 

-->Rulebook<--

      Responsible for rank and suit priority and determining the hand of a player.
