public class Output25 {

    public static void decklastPrint(String[] deck) {// destede en altta açık olun kartları açamaya yarar son kart Joker normal kart gelesiye kadar açar.
        System.out.println("*******************");
        System.out.println("Card on the floor :");
        for (int i = 0; i < 5; i++) {       //destenin el altındaki kagıdı açar ve ekrana basar.
            if (deck[51-i].startsWith("J", deck[51-i].length()-5)) {
                System.out.println(deck[51-i]);
            }
            else{
                System.out.println(deck[51-i]);
                break;
            }
        }
        System.out.println("*******************");
    }
    public static void xPrint(String[] aDeck)
    {int counter =0;
        System.out.println("*******************");
        System.out.println("Card at player :");
        for(String item : aDeck)
        {
            if (item!=null) {
                System.out.println(counter+" "+item);
                counter++;
            }

        }
        System.out.println("*******************");
    }
    public static void deckPrint(String[] deck)
    {
        System.out.println("********************");
        int counter =0;
        for(String item :deck)
        {
            System.out.println(counter+" "+item);
            counter++;
        }
        System.out.println("*******************");
    }
    public static void deckPrint(String[][] deck)
    {
        System.out.println("*******************");
        System.out.println("Card on the floor :");
        int counter =0;
        for (int i = 0; i < deck.length; i++) {
            if (deck[i][0]!=null) {
                if (deck[i][1]=="Açık") {
                    System.out.println(counter+" "+deck[i][0]);
                    counter++;
                }
                else
                {
                    System.out.println(counter+" "+"Kapalı");
                    counter++;
                }

            }
        }

    }

}