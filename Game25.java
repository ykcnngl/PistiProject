import java.util.Random;
import java.util.Scanner;

public class Game25 {
    public static void DealCard(String[] deck, String[] playerDeck, String[] computerDeck, String[][] floorDeck){                          //çift boyutlu dizi oluşturdum yer için çok tercih edilmiyomuş hata alabilirim
        int index=0;
        for (int i = 0; i < deck.length; i++) {
            if (deck[i].equals("")) {
                index=i;
            }                                                                         // destenin bitip bitmediğini kontrol ediyo
        }
        index++;
        

        
        playerDeck[0]=deck[index];
        playerDeck[1]=deck[index+1];
        playerDeck[2]=deck[index+2];                                                //oyuncu destesi dağıtıldı
        playerDeck[3]=deck[index+3];

        
        computerDeck[0]=deck[index+4];
        computerDeck[1]=deck[index+5];                                              //bilgisayarın destesi ilk dağıtım
        computerDeck[2]=deck[index+6];
        computerDeck[3]=deck[index+7];                                             

        
        floorDeck[0][0]=deck[index+8];           
        floorDeck[0][1]="Kapalı";
        floorDeck[1][0]=deck[index+9];
        floorDeck[1][1]="Kapalı";
        floorDeck[2][0]=deck[index+10];
        floorDeck[2][1]="Kapalı";
        floorDeck[3][0]=deck[index+11];
        floorDeck[3][1]="Açık";

        for (int i = 0; i < 12; i++) {                                             //dağıtılan kartları attık
            deck[i]="";
        }
	}
    
	public static void Cut(String[] deck, String[] playerDeck, String[] computerDeck, String[][] floorDeck) {


        Deck25.Deckshuffle(deck);                                                  
        
		Random rnd = new Random();                                   //desteden rastgele kesilecek
        int cut = 16+rnd.nextInt(18);
        String[] deste1 = new String[52];
        String[] deste2 = new String[52];
        int d2counter=0;
        for (int i = 0; i < deck.length; i++) {
            if (i<cut) {
                deste1[i]=deck[i];
            }
            else{
                deste2[d2counter]=deck[i];
                d2counter++;
            }
        }
        int counter =0;
        for(String item :deste2)
        {
            if (item==null) {
                break;}

            deck[counter]=item;
            counter++;
        }
        for(String item :deste1) {
            if (item==null) {
                break;}

            deck[counter]=item;
            counter++;
        }
        // kartlar kesildi dağıtmayı bul

        

        DealCard (deck, playerDeck, computerDeck, floorDeck);
	}

    public static void atlatici(String[] deck)                                                 
    {
        for (int i = 0; i < deck.length-1; i++) {
            if (deck[i]==null) {
                deck[i]=deck[i+1];
                deck[i+1]=null;
            }
        }
    }
    public static void throwCard(String[][]floorDeck,String[] playerDeck,int index)
    {   int lastIndex=0;
        if (floorDeck[0][0]!=null) {
            for (int i = 0; i < floorDeck.length; i++) {                           //Yerdeki boş alanın indexini buluyoruz.
                if(floorDeck[i][0]==null)
                {
                    lastIndex=i;
                    break;
                }
            }}
        floorDeck[lastIndex][0]=playerDeck[index];
        floorDeck[lastIndex][1]="Açık";
        playerDeck[index]=null;
        atlatici(playerDeck);
    }
    public static void computerThrowCard(String[][]floorDeck,String[] computerDeck,String[] computerTaken,int[] computerPisti)
    {
        int random=0;
        Random rnd = new Random();

        do {
            random = rnd.nextInt(4);
            if (computerDeck[0]==null&&computerDeck[1]==null&&computerDeck[2]==null&&computerDeck[3]==null) {
                break;
            }
        } while (computerDeck[random]==null);
        throwCard(floorDeck, computerDeck, random);
        control(floorDeck, computerTaken, computerPisti);
    }
    public static void playerThrowCard(String[][]floorDeck, String[] playerDeck, int index, String[] playerTaken, int[] playerPisti)
    {
        throwCard(floorDeck, playerDeck, index);
        control(floorDeck, playerTaken, playerPisti);

    }
    public static void cardonfloor(String[][] floorDeck, String[] cardatfloor)
    {
        int cardatfloorIndex =0;
        for (int i = 0; i < cardatfloor.length; i++) {
            if (cardatfloor[i]!=null) {
                cardatfloorIndex++;
            }
            else break;
        }
        for (int i = 0; i < floorDeck.length; i++) {
            if (floorDeck[i][0]!=null) {
                cardatfloor[cardatfloorIndex+i]=floorDeck[i][0];
            }

        }
        for (int i = 0; i < floorDeck.length; i++) {
            floorDeck[i][0]=null;
            floorDeck[i][1]="Açık";

        }
    }
    public static void control(String[][]floorDeck, String[] cardatfloor, int[] pisti)
    {
        int index=51;

        for (int i = 51; i >= 0; i--) {
            if (floorDeck[i][0]==null) {
                index =i;
            }
            else break;
        }                                                                                                                //yerdeki elemanların sonunu aldım.
        index--;
        if(floorDeck[index][0]!=null)
        {
            if (index==0) {                                                                                              //yer boş
            }
            else{
                if (floorDeck[index][0].startsWith("J", floorDeck[index][0].length()-5))
                {
                    cardonfloor(floorDeck, cardatfloor);                                                                          // joker


                }
                else if (index==1&&floorDeck[index][0].substring(floorDeck[index][0].length()-2).equals(floorDeck[index-1][0].substring(floorDeck[index-1][0].length()-2))) {
                    //pişti
                    pisti[0]++;
                    cardonfloor(floorDeck, cardatfloor);

                }
                else if (floorDeck[index][0].substring(floorDeck[index][0].length()-2).equals(floorDeck[index-1][0].substring(floorDeck[index-1][0].length()-2))) {
                    cardonfloor(floorDeck, cardatfloor);
                }

            }

        }}
    public static void 	dealCard2(String[] deck,String[] computerDeck,String[] playerDeck)
    {int index =0;
        while(deck[index].equals(""))
            index++;


        playerDeck[0]=deck[index];
        playerDeck[1]=deck[index+1];
        playerDeck[2]=deck[index+2];
        playerDeck[3]=deck[index+3];                            //oynadığımız desteyi ilk dağıtma kısmı


        computerDeck[0]=deck[index+4];
        computerDeck[1]=deck[index+5];
        computerDeck[2]=deck[index+6];
        computerDeck[3]=deck[index+7];                           //bilgisayarın destesini ilk dağıtma kısmı

        for (int i = 0; i < 8; i++) {
            deck[index+i]="";
        }
    }
    public static void play(String[] deck,String[][] floorDeck,String[] playerDeck,String[] computerDeck,boolean a,String[] playerTaken,int[] playerPisti,String[] computerTaken,int[] computerPisti)
    {
        Scanner scn=new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            if(!a)
                output.decklastPrint(deck);                     //Burada da yazdırma var işte output koyarak farklı classlardan birleştiriyoruz zaten.

            output.deckPrint(floorDeck);                          //yerdeki desteleri yazıyoruz.
            output.xPrint(playerDeck);
            System.out.print("Choose one card to throw:");
            playerThrowCard(floorDeck, playerDeck, scn.nextInt(),playerTaken,playerPisti);
            computerThrowCard(floorDeck, computerDeck,computerTaken,computerPisti);
            //Kullanıcının output'a sayı girmesini sağladığım kısım.
        }
        if(!a)
            dealCard2(deck, computerDeck, playerDeck);

    }
}
