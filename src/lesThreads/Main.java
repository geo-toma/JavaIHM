package lesThreads;

public class Main {

	public static void main(String[] args) {
		
//		TestThread t = new TestThread("A");
//		TestThread t1 = new TestThread(" B", t);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("status du thread "+t.getName()+" = "+t.getState());
//		System.out.println("status du thread "+t1.getName()+" = "+t1.getState());
		
		CompteEnBanque cb = new CompteEnBanque();
//		CompteEnBanque cb1 = new CompteEnBanque();
		
		Thread thread = new Thread(new RunImpl(cb, "geo"));
		Thread thread2 = new Thread(new RunImpl(cb, "serge"));
		
		thread.start();
		thread2.start();
		
	}

}
