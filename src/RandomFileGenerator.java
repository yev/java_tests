import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class RandomFileGenerator {
	public static void generate(final int size){
		
		FileWriter writer = null;
		try {
			writer = new FileWriter("/Users/yev/Desktop/random.txt", false);
		
		
		Random r = new Random();
		for (int i = 0; i <= size - 1 ; i++){
			writer.write( String.valueOf (r.nextInt (100000000)) + System.getProperty("line.separator") );
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (writer != null){
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		generate(100000000);
	}
}
