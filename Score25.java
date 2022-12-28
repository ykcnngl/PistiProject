public class Score25 {
    public static void pointCalculate(String[] playerTaken, int[] playerPisti, String[] computerTaken, int[] computerPisti)
    {
        int computerPoint=0;
        int playerPoint=0;
        int computerTakenIndex =0;
        for (int i = 0; i < computerTaken.length; i++) {
            if (computerTaken[i]!=null) {
                if (computerTaken[i].substring(computerTaken[i].length()-2,computerTaken[i].length()).equals("er")) {
                    computerPoint++;//jokerleri sayar puan ekler
                }
                if (computerTaken[i].substring(computerTaken[i].length()-2,computerTaken[i].length()).equals("A")) {
                    computerPoint++;//as ları sayar puan ekler.
                }
                if (computerTaken[i].equals("Clubs2")) {
                    computerPoint=computerPoint+2;
                }
                if (computerTaken[i].equals("Diamonds10")) {
                    computerPoint=computerPoint+3;
                }//Bu iki kartın puan durumu oyuna göre 2 ve 3 olduğundan değerlerini değiştirdiğim kısım
                computerTakenIndex++;
            }
            else break;
        }
        int playerTakenIndex =0;
        for (int i = 0; i < playerTaken.length; i++) {
            if (playerTaken[i]!=null) {
                if (playerTaken[i].substring(playerTaken[i].length()-2,playerTaken[i].length()).equals("er")) {
                    playerPoint++;//jokerleri sayar puan ekler
                }
                if (playerTaken[i].substring(playerTaken[i].length()-2,playerTaken[i].length()).equals("A")) {
                    playerPoint++;//as'ları sayar puan ekler.
                }
                if (playerTaken[i].equals("Clubs2")) {
                    playerPoint=computerPoint+2;
                }
                if (playerTaken[i].equals("Diamonds10")) {
                    playerPoint=computerPoint+3;
                }//Diğer oyuncu için de aynı hesaplar
                playerTakenIndex++;
            }
            else break;
        }
        //kağıt çoğunluğuna göre +3 puan verilmeli.
        if (playerTakenIndex>computerTakenIndex) {
            playerPoint=playerPoint+3;
        }
        if (playerTakenIndex<computerTakenIndex) {
            computerPoint=computerPoint+3;
        }
        computerPoint=computerPoint+computerPisti[0]*10;
        playerPoint=playerPoint+playerPisti[0]*10;
        System.out.println("Bilgisayar Puanı :"+computerPoint);
        System.out.println("Kullanıcı Puanı :"+playerPoint);


    }
}
