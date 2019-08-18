import java.util.StringTokenizer;

public class TryCatch{

	public static void main(String[] args){

/*		try{
			int x=0;
			int y=10;
			int z = y/x;
			System.out.println(z);
		}catch(ArithmeticException e){
			System.out.println("Divided by 0");
			e.printStackTrace();
		}finally{
			System.out.println("Test over");
		}*/

		String test = "Use the force";
		StringTokenizer st = new StringTokenizer(test);

		while (st.hasMoreTokens()){
			String currentWord = st.nextToken();
			System.out.println(currentWord);
		}
		System.out.println();


		StringTokenizer st2 = new StringTokenizer(test,"e",false);
		while (st2.hasMoreTokens()){
			String currentWord = st2.nextToken();
			System.out.println(currentWord);
		}

		System.out.println();

		StringTokenizer st3 = new StringTokenizer(test,"e",true);
		while (st3.hasMoreTokens()){
			String currentWord = st3.nextToken();
			System.out.println(currentWord);
		}

	}
}