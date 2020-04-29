/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szukanieslowa;

/**
 *
 * @author Pawel
 */
import java.util.Random;

public class TableUtility {
    //losowanie przypadkowego znaku z ciągu
    public char randomCharacter() {
        Random random=new Random();
        String setList = " aąbcćdeęfghijklłmnoópqrsśtuvwxyzźżABCĆDEFGHIJKLMNOÓPQRSŚTUVWXYZŹŻ!.";
        char litera = setList.charAt(random.nextInt(setList.length()));
        return litera;
    }
    //klonowanie tabeli
    public char[] copyTable(char [] toCopy){
        char[] copied=new char[toCopy.length];
        for (int i=0;i<toCopy.length;i++)
            copied[i]=toCopy[i];
        return copied;
    }
    //zamiania string a w tabele charów
    public char[] parseStringToChar(String string){
        char[] ch = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            ch[i] = string.charAt(i);
        }
        return ch;
    }
//zamiana tabeli charów w stringa
    public static String parseCharToString(char[] chars){
        StringBuilder stringBuilder=new StringBuilder();
        for(char i:chars)
        {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}