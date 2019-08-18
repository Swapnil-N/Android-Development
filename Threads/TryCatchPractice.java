public class TryCatchPractice{

	public static void main(String[] args){

		try{
			int x =0;
			int a = x/x;
			System.out.println(a);
		}catch(ArithmeticException e){
			System.out.println("Divided by 0");
		}

		try{
			int array[] = {1,2,3};
			System.out.println(array[5]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Index out of bounds");
		}





	}

}