public class ThreadPractice{

	public static void main(String[]args){
		Thread t1 = new Thread("Thread 1"){

			public void run(){
				for (int i=1;i<=10;i++)
					System.out.println(getName() + " " + i);
			}//run
		};//Thread 1
	}
}