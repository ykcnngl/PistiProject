public class PistiProject {
    public static void main(String[] args) {

        String[] deck=new String[52];//destemizdeki kartlar
        String[] playerDeck=new String[4];//oyuncumuzun elindeki deste
        String[] playerTaken=new String[52];//oyuncumuzun aldıkları
        int[] playerPisti=new int[1];//oyuncumuzun pişti sayılarını tutar.
        String[] computerDeck=new String[4];//bilgisayarın elindeki deste
        String[] computerTaken=new String[52];//bilgisayarın aldıkları
        int[] computerPisti=new int[1];//bilgisayarın pişti sayılarını tutar.
        String[][] floorDeck=new String[52][2];//yerdeki destemiz

        Game25.Cut(deck,playerDeck,computerDeck,floorDeck);


        while (!deck[51].equals("")) 
		Game25.play(deck,floorDeck,playerDeck,computerDeck,false, playerTaken,playerPisti, computerTaken,computerPisti);
  
        Game25.play(deck,floorDeck,playerDeck,computerDeck,true, playerTaken,playerPisti, computerTaken,computerPisti);

        Output25.deckPrint(floorDeck);
        System.out.println("computerPisti"+computerPisti[0]+"  playerPisti :"+playerPisti[0]);
	Score25.pointCalculate(playerTaken, playerPisti, computerTaken, computerPisti);
	}
}
