package binary_search;
import java.util.Arrays;
import java.util.Random;
public class binary_search_main {

	public static void main(String[] args) {
		fillArray();
		Arrays.sort(a);
		int number = r.nextInt(a.length);
		counter = 0;
		System.out.println("Binäre Suche iterativ: " + number + " ------------");
		if (binarySearchIter(number)) {
			System.out.println("Der Wert " + number + " ist in diesem Array vorhanden!");
		}
		else {
			System.out.println("Der Wert " + number + " ist nicht in diesem Array vorhanden!");
		}
		System.out.println(counter+" Suchschritte\n");
		counter = 0;
		System.out.println("Binäre Suche rekursiv: " + number + " ------------");
		if (binarySearchRek(number, 0, (a.length - 1))) {
			System.out.println("Der Wert " + number + " ist in diesem Array vorhanden!");
		}
		else {
			System.out.println("Der Wert " + number + " ist nicht in diesem Array vorhanden!");
		}
		System.out.println(counter+" Suchschritte");
	}

	static int[] a = new int[100];
	static Random r = new Random();
	static int counter;
	
	public static void fillArray() {
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(a.length);
		}
	}
	public static boolean binarySearchIter(int number) {
		int begin = 0;
		int end = a.length - 1;
		int half;
		while (begin <= end) {
			half = (int)((begin + end) / 2);
			counter++;
			System.out.println(counter + ". Suchschritt " + a[begin] + " " + a[end] + " " + a[half]);
			if (number == a[half]) {
				return true;
			}
			else if (number < a[half]) {
				end = half - 1;
			}
			else {
				begin = half + 1;
			}
		}
		return false;
	}
	public static boolean binarySearchRek(int number, int begin, int end) {
		if (begin > end) {
			return false;
		}
		int half = (int)((begin + end) / 2);
		counter++;
		System.out.println(counter + ". Suchschritt " + a[begin] + " " + a[end] + " " + a[half]);
		if (number == a[half]) {
			return true;
		}
		else if (number < a[half]){
			return binarySearchRek(number, begin, (half - 1));
		}
		else {
			return binarySearchRek(number, (half + 1), end);
		}
	}
}
