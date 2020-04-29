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

public class GeneticAlgorithm implements GeneticUtility{
//algortym fitness zlicza ilosc pasujacych liter w tablicy między szukanym a poszkującym slowem
    public int fitnes(char[] fitnessWord,char[] target){
        int counter=0;
        for(int i=0;i<fitnessWord.length;i++)
        {
            if (fitnessWord[i]==target[i])
                counter++;
        }
        return counter;
    }

    @Override
    public int fitnes(char[] fitnessWord) {
        return 0;
    }
    //Mutuje randomowo wybiera wartosc ablicy o okreslonym indexie
    @Override
    public char[] mutation(char[] chromosom1) {
        Random p=new Random();
        int index=p.nextInt(chromosom1.length);
        chromosom1[index] =randomCharacter();
        return chromosom1;
    }
//wybiera randomową wartość znaku z listy znaków
    public char randomCharacter(){
        Random random=new Random();
        String setList = " aąbcćdeęfghijklłmnoópqrsśtuvwxyzźżABCĆDEFGHIJKLMNOÓPQRSŚTUVWXYZŹŻ!.";
        char litera = setList.charAt(random.nextInt(setList.length()));
        return litera;
    }
    }

