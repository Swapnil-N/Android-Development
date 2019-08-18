import java.util.concurrent.atomic.AtomicInteger;
public class ThreadSafe {

	static int i = 0;
	static AtomicInteger ai;
	static int si = 0;

	public static synchronized void add(int j){
		si+=1;
	}


	public static void main (String[] args) {

		ai = new AtomicInteger(0);

		for (int i = 0; i < 200; i++) {
			new myThread().start();
		}

		try {
			Thread.sleep(3000);
		} catch (Exception e) {}

		System.out.println("Here is no normal regular i: " + i);
		System.out.println("Here is atomic ai: " + ai);
		System.out.println("Here is Si" + si);
	}

	public static class myThread extends Thread {

		public void run () {

			try {
				Thread.sleep(2);
			} catch (Exception e) {}
			i++;
			ai.getAndAdd(1);
			add(1);
		}
	}

}