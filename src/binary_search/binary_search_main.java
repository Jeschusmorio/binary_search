package binary_search;
import java.util.Arrays;
import java.util.Random;
public class binary_search_main {

	public static void main(String[] args) {
		fillArray();
		Arrays.sort(a);
		int number = r.nextInt(a.length);
		counter = 0;
		System.out.println("Suche: " + number + " ------------");
		if (search(number, 0, (a.length - 1))) {
			System.out.println("Der Wert " + number + " ist in diesem Array vorhanden!");
		}
		else {
			System.out.println("Der Wert " + number + " ist nicht in diesem Array vorhanden!");
		}
		System.out.println(counter+" Suchschritte");
	}

	static final int LENGTH = 100;
	static int[] a = new int[LENGTH];
	static Random r = new Random();
	static int counter;
	
	public static void fillArray() {
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(a.length);
		}
	}
	public static boolean search(int number, int begin, int end) {
		if (begin > end) {
			return false;
		}
		counter++;
		int half = (int)((begin + end) / 2);
		System.out.println(counter + ". Suchschritt " + a[begin] + " " + a[end] + " " + a[half]);
		if (number == a[half]) {
			return true;
		}
		else if (number < a[half]){
			return search(number, begin, (half - 1));
		}
		else {
			return search(number, (half + 1), end);
		}
	}
}
