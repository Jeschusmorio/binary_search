package binary_search;
import java.util.Arrays;
import java.util.Random;
public class binary_search_main {

	public static void main(String[] args) {
		Random r = new Random();
		//int laenge = r.nextInt(100)+1;
		int laenge=100;
		int[] a = new int[laenge];
		int zahl = r.nextInt(100);
		//int zahl = 49;
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(100);
			//a[i] = i;
			//System.out.print(a[i]+", ");
		}
		//System.out.println();
		if (sequenzSearch(a, zahl)) {
			System.out.println(zahl+" ist in diesem Array enthalten!");
		}
		else {
			System.out.println(zahl+" ist nicht in diesem Array enthalten!");
		}
		System.out.println();
		if (binarySearch(a, zahl)) {
			System.out.println(zahl+" ist in diesem Array enthalten!");
		}
		else {
			System.out.println(zahl+" ist nicht in diesem Array enthalten!");
		}
	}
	public static boolean sequenzSearch(int[] a, int zahl) {
		System.out.println("Sequenzielle Suche:");
		boolean enthalten = false;
		int zaehler = 0;
		for (int i = 0; i < a.length; i++) {
			zaehler++;
			if (zahl == a[i]) {
				enthalten = true;
				break;
			}
		}
		System.out.println("Suchschritte: "+zaehler);
		return enthalten;
	}
	public static boolean binarySearch(int[] a, int zahl) {
		System.out.println("Binaere Suche:");
		boolean enthalten = false;
		Arrays.sort(a);
		//System.out.println(a.length);
		/*for (int i = 0; i < a.length; i++) { 
			System.out.print(a[i]+", ");
		}
		System.out.println();*/
		int zaehler = 0;
		int max_index = a.length-1;
		int min_index = 0;
		int index;
		while (min_index <= max_index) { //zaehler < Math.log(a.length)
			zaehler++;
			index = (max_index + min_index) / 2;
			//System.out.println(index);
			if (zahl == a[index]) {
				enthalten = true;
				break;
			}
			if (zahl < a[index]) {
				max_index = index-1; //Der Wert ist nicht auf der Stelle "index" somit wird die Suchrange verringert, verhindert ausserdem endlosen Schleifendurchlauf
			}
			if (zahl > a[index]) {
				min_index = index+1;
			}
		}
		System.out.println("Suchschritte: "+zaehler);
		return enthalten;
	}
}
