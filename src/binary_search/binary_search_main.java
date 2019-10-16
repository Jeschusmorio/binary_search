package binary_search;
import java.util.Arrays;
import java.util.Random;
public class binary_search_main {

	public static void main(String[] args) {
		for (int i = 0; i < menge.length; i++) {
			menge[i] = i;
		}
		for (int i = 0; i < menge.length; i++) {
			suche(i);
		}
	}
	
	static int[] menge = new int[100];
	
	public static void suche (int suchzahl) {
		System.out.println("suche "+suchzahl+" ---------------");
		int anfang = 0;
		int ende = menge.length - 1;
		int zaehler = 0;
		
		while (anfang <= ende) {
			zaehler++;
			int halbe = anfang + (int)((ende - anfang) / 2);
			System.out.println("suchschritt "+anfang+" "+ende+" "+halbe);
			if (menge[halbe] == suchzahl) {
				System.out.println("found");
				break;
			}
			else if (suchzahl < menge[halbe]) {
				ende = halbe - 1;
			}
			else {
				anfang = halbe + 1;
			}
		}
		System.out.println(zaehler);
	}
}
