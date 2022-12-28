import java.util.Random;

public class Deck25{
	public static void CreateCards(String[] Cards) {
		
		Cards[0]= "Diamonds A";
		Cards[1]= "Diamonds 2";
		Cards[2]= "Diamonds 3";
		Cards[3]= "Diamonds 4";
		Cards[4]= "Diamonds 5";
		Cards[5]= "Diamonds 6";
		Cards[6]= "Diamonds 7";
		Cards[7]= "Diamonds 8";
		Cards[8]= "Diamonds 9";
		Cards[9]="Diamonds 10";
		Cards[10]="Diamonds Q";
		Cards[11]="Diamonds K";
		Cards[12]="Diamonds J";
		
		Cards[13]= "Spades A";
		Cards[14]= "Spades 2";
		Cards[15]= "Spades 3";
		Cards[16]= "Spades 4";
		Cards[17]= "Spades 5";
		Cards[18]= "Spades 6";
		Cards[19]= "Spades 7";
		Cards[20]= "Spades 8";
		Cards[21]= "Spades 9";
		Cards[22]="Spades 10";
		Cards[23]= "Spades Q";
		Cards[24]= "Spades K";
		Cards[25]= "Spades J";
		
		Cards[26]= "Hearts A";
		Cards[27]= "Hearts 2";
		Cards[28]= "Hearts 3";
		Cards[29]= "Hearts 4";
		Cards[30]= "Hearts 5";
		Cards[31]= "Hearts 6";
		Cards[32]= "Hearts 7";
		Cards[33]= "Hearts 8";
		Cards[34]= "Hearts 9";
		Cards[35]="Hearts 10";
		Cards[36]= "Hearts Q";
		Cards[37]= "Hearts K";
		Cards[38]= "Hearts J";
		
		Cards[39]= "Clubs A";
		Cards[40]= "Clubs 2";
		Cards[41]= "Clubs 3";
		Cards[42]= "Clubs 4";
		Cards[43]= "Clubs 5";
		Cards[44]= "Clubs 6";
		Cards[45]= "Clubs 7";
		Cards[46]= "Clubs 8";
		Cards[47]= "Clubs 9";
		Cards[48]="Clubs 10";
		Cards[49]= "Clubs Q";
		Cards[50]= "Clubs K";
		Cards[51]= "Clubs J";                                                     // Kartları String arrayde oluşturdum.
		
	}
	
	public static void Deckshuffle(String[] deck) {
        CreateCards(deck);
        Random rnd = new Random();
        for (int k = 0; k < deck.length; k++) {
			int Shuffle = rnd.nextInt(52);
			String temporary = deck[k];
			deck[k]=deck[Shuffle];
			deck[Shuffle]=temporary;                                         //Karılma işlemi 
		}
	}
}
	
	
	