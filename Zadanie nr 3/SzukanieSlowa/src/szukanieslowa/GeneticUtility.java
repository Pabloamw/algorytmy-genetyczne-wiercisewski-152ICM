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
public interface GeneticUtility {
    public int fitnes(char[] fitnessWord);
    public char[] mutation(char[] chromosom1);
}
