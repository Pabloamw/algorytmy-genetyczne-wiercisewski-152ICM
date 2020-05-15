/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem8hetmanow;

/**
 *
 * @author Paweł
 */
public class Problem8Hetmanow {

private static boolean dia_r[] = new boolean[256];
private static boolean dia_l[] = new boolean[256];
private static boolean kolumna[] = new boolean[8];       // tablica kolumn
private static boolean chart[][] = new boolean[8][8];// tablica pozycji hetmnanow
private static byte found = 0;                       // licznik znalezionych pozycji
 
@SuppressWarnings("unchecked")
private static void add_hetman(int row) {
for (int i=0; i<8; i++) {
if (!((kolumna[i]) || (dia_r[i-row+128]) || (dia_l[row+i+128]))) {
dia_r[i-row+128] = true;     //wprowadzanie przekątnych
dia_l[row+i+128] = true;
kolumna[i] = true;               //wprowadzenie kolumny
chart[i][row] = true;        //ustawienie hetmana na pozycji w tablicy
if (row<7) {
add_hetman(row+1);       // analiza nastepnego wiersza
}
else {                       // zapisanie wyniku
found++;
printCombination();
}
//usuwanie hetmana oraz poszukiwania nowego miejsca do ustawienia hetmana
dia_r[i-row+128] = false;
dia_l[row+i+128] = false;
kolumna[i] = false;
chart[i][row] = false;
}      
}
}
 
public static void printCombination() {
System.out.println("kombinacja: " + found);
System.out.println("  ABCDEFGH");
System.out.println("");
for (int y=7; y>=0; y--) {
System.out.print(y+1 + " ");
for (int x=0; x<8; x++) {
if (chart[x][y]) {
System.out.print("H");
}
else {
System.out.print(" ");
}
}
System.out.println();
}
System.out.println("");
System.out.println("");
}
 
/**
* 
*/
public static void main(String[] args) {
add_hetman(0);             // ustawienie pierwszego hetmana
}
 
}


