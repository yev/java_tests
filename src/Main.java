import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;




public class Main {

	private static final int ARRAY_SIZE = 1000000;
	private static final int[] ARRAY = new int[ARRAY_SIZE];
	
	private static void populateArrayFromFile(final String fileName) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(fileName));
		for (int i = 0; i <= ARRAY_SIZE - 1; i++){
			ARRAY[i] = Integer.parseInt(sc.nextLine());
		}
		sc.close();
	}
	
	private static int [] populateSimpleArray(){
		int [] array = new int[]{9, 4, 16, 1, 5, 2};
		return array;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//populateArrayFromFile("/Users/yev/Desktop/random.txt");
		//populateArrayFromFile("/Users/yev/Desktop/new.txt");
		int [] input = populateSimpleArray();
		print(input);
		Date start = new Date();
		System.out.println(start);
		int[] res =  mergeSort(input);
		
		Date end = new Date();
		System.out.println(end);
		System.out.println("Running time = "+ (end.getTime() - start.getTime()));
		print(res);
		
	}
	
	private static void insertionSort(int[] array){
		
		for (int j = 1 ; j < array.length ; j++){
			int key = array[j];
			int i = j-1;
			while ( i >= 0 && array[i] > key){
				array[i+1] = array[i];
				i =  i - 1;
			}
			array[i+1] = key;
		}
		
	}
	
	private static void print(int[] array){
		System.out.print("Array contains the following items : ");
		for (int i=0; i < array.length; i++){
			System.out.print(" "+array[i]+" , ");
		}
		
	}

	/**
	 * Use devide-conqueror algorythm to recursivly devide the array
	 * @param array
	 * @return
	 */
	private static int[] mergeSort(final int[] array){
		if (array.length == 1){
			return array;
		}
		// find the middle index 
		//  make the 2 separate arrays left and right
		
		int middleIndex = array.length / 2; //TODO - for simplicity I'm considering the pair array index 
		
		
		
		int plusOneForOdd = 0;
		if (array.length % 2 == 1){
			plusOneForOdd = 1;
		}
		
		int [] left = new int[middleIndex + plusOneForOdd];
		int [] right = new int[middleIndex];
		
		for (int i = 0; i <= middleIndex -1 + plusOneForOdd; i++){
			left[i] = array[i];
		}
		
		for (int i = 0; i <= middleIndex - 1; i++){
			right[i] = array[middleIndex + i + plusOneForOdd];
		}
		
		left  = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right , middleIndex, plusOneForOdd);
				
	}

	private static int[] merge(int[] left, int[] right, int middle, int oddShift) {
		final int [] result = new int[left.length * 2 - oddShift] ;
		int i =0 ,j = 0, k = 0;
		while ( i < middle || j < middle ) {
			if (i < middle && j < middle){
				if (left[i] < right[j]){
					result[k]=left[i];
					i++;
				}
				else if  (right[j] < left[i]){
					result[k]=right[j];
					j++;
				}
			}
			
			k++;
		}
		
		while (i < left.length){
			result[k] = left[i];
			k++;
			i++;
		}
		while (j < right.length){
			result[k] = right[j];
			k++;
			j++;
		}
		return result;
	}
	
}

