/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szukanieslowa;


import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Main {
private static Instant time;
    public static void main(String[] args) {
	SecretWord secretWord=new SecretWord("Witaj świecie!");
        time=Instant.now();
        char[] parent=secretWord.generateParent();
        int bestFitnes=secretWord.fitnes(parent);
        int currentFitnes=0;
        //wykonywanie mutacji dopóki nie zgadza sie tyle liter ile jest w tablicy
        while(currentFitnes<secretWord.getWordLength()){
            char [] child=secretWord.mutation(parent);
            //sprawdzenie czy fitnes dziecka jest większy niż rodzica
            currentFitnes= secretWord.fitnes(child);
            if (bestFitnes>=currentFitnes)
            {}
            else{
                //wyswietlenie dziecka jezeli ma wiekszy fitnes niz rodzic
                System.out.println(TableUtility.parseCharToString(child)
                        +"  "
                        +currentFitnes
                        +"  "
                        + ChronoUnit.MILLIS.between(time,Instant.now())
                        +"ms");
                if (currentFitnes>=parent.length)
                    break;
                //przypisanie dziecka jako rodzica
                bestFitnes=currentFitnes;
                parent=child;
            }
        }
    }
}
