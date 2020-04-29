package geneticoperators;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        GeneticOperators geneticOperators=new GeneticOperators();

        ArrayList<int[]> population=new ArrayList<>();
//iteracja potrójna wykonanego zadania
        for(int i=0;i<3;i++)
       {
           if(i==0)
           {
               System.out.println("FIRST POPULATION");
               //wyswielenie wygenerowanej populacji
               geneticOperators.showPopulation(geneticOperators.population);
           }
           if(i==1){
               System.out.println("POPULATION AFTER MUTATION");
               ArrayList<int[]> p=geneticOperators.population;
               //two mutations
               //stworzenie nowej populacji poprzez mutowanie na chromosomach z poprzedniej populacji
              p.set(0, geneticOperators.mutation(p.get(0),2));
              p.set(0, geneticOperators.mutation(p.get(1),2));
              p.set(0, geneticOperators.mutation(p.get(2),2));
              p.set(0, geneticOperators.mutation(p.get(3),2));
              population=p;
              geneticOperators.showPopulation(p);
           }
           if(i==2){
               System.out.println("POPULATION AFTER MUTATION AND CROSSING");
               //wykonanie krzyzowania i zapisanie jego wynikow do list z
              ArrayList<int[]> z= geneticOperators.crossing(population.get(0),population.get(1),2 );
              //przypisywanie wartości z krzyżowania do tzeciej populacji funkcja set
               population.set(0,z.get(0));
               population.set(1,z.get(1));
               z=geneticOperators.crossing(population.get(2),population.get(3),5 );
               population.set(2,z.get(0));
               population.set(3,z.get(1));
               geneticOperators.showPopulation(population);
           }

       }

    }
}

