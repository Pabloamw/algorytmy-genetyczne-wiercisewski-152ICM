/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticoperators;
import java.util.ArrayList;
import java.util.Random;

public class GeneticOperators {
    //stworzenie 4 osobników
    public int[] person1=new int[10];
    public int[] person2=new int[10];
    public int[] person3=new int[10];
    public int[] person4=new int[10];
    public ArrayList<int[]> population=new ArrayList<int[]>();

    public GeneticOperators() {
        //dodanie osobników do populacji w konstruktorze
        population.add(create(person1));
        population.add(create(person2));
        population.add(create(person3));
        population.add(create(person4));
    }

    // funkcja mutacji
    public int[] mutation(int[] p1,int howManymMutations){
        Random p=new Random();
        for(int i=0;i<howManymMutations;i++){
            //losuje liczbę indexu z zakresu 10 liczb, losując nową wartość o 1 do 100
            p1[p.nextInt(10)]=p.nextInt(100);
        }
    return p1;
    }

    //metoda crossing powoduje podmiane wartości chromosomu w punkcie podanym jako point
    public ArrayList<int[]> crossing(int[] p1,int[] p2,int point){
       int template= p1[point];
       //wykonanie podmiany przy użyciu zmiennej template
       p1[point]=p2[point];
       p2[point]=template;
       ArrayList<int[]> ret=new ArrayList<>();
       ret.add(p1);
       ret.add(p2);
       //funkcja zwraca tablice dwóch nowych chromosomow stworzonych przez skrzyżowanie
       return ret;
    }
    /*
    * metoda fitness() oblicza wartość funkcji przystosowania,
    *  która równa jest różnicy (suma genów o parzystych indeksach) - (suma genów o nieparzystych indeksach),
    */
    public int fitness(int[] p){
        int even=0;
        int odd=0;
        for(int i=0;i<10;i=i+2){
            odd=odd+p[i];
        }
        for(int i=1;i<10;i=i+2){
            even=even+p[i];
        }
        return even-odd;

    }


    public int[] create(int[] tab){
        Random r = new Random();
        for(int i=0;i<10;i++) {
            tab[i] = r.nextInt(100);
        }
        return tab;
    }
    //funkcja zwraca widok w konsoli chromosomu
    public void showChrom(int[] person){
        System.out.println("NEXT CHRON");
        System.out.println("FITNES = "+fitness(person));
        for(int i=0;i<10;i++) {
            System.out.println(person[i]);
        }
    }
    //funkcja zwracająca nową populację dla wartosci wchodzących 4 chromosomow(osobnikow)
    public ArrayList<int[]> createPopulation(int[] one,int[] two,int[] three,int[] four){
        ArrayList<int[]> pop=new ArrayList<int[]>();
        pop.add(one);
        pop.add(two);
        pop.add(three);
        pop.add(four);
        return pop;
    }

    //wyswietlenie calej populacji
    public void showPopulation(ArrayList<int[]> population){
        System.out.println("===========POPULATION===========\n\n");
        for (int[] i:population) {
            showChrom(i);
        }
    }

    public int[] getPerson1() {
        return person1;
    }

    public void setPerson1(int[] person1) {
        this.person1 = person1;
    }

    public int[] getPerson2() {
        return person2;
    }

    public void setPerson2(int[] person2) {
        this.person2 = person2;
    }

    public int[] getPerson3() {
        return person3;
    }

    public void setPerson3(int[] person3) {
        this.person3 = person3;
    }

    public int[] getPerson4() {
        return person4;
    }

    public void setPerson4(int[] person4) {
        this.person4 = person4;
    }

    public ArrayList<int[]> getPopulation() {
        return population;
    }

    public void setPopulation(ArrayList<int[]> population) {
        this.population = population;
    }



}
