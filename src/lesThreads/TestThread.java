package lesThreads;

public class TestThread extends Thread {
	
	Thread t;
	
	public TestThread(String name) {
		super(name);
		System.out.println("status du thread "+this.getName()+" = "+this.getState());
		this.start();
		System.out.println("status du thread "+this.getName()+" = "+this.getState());
	}
	
	public TestThread(String name, Thread t) {
		super(name);
		this.t = t;
		System.out.println("status du thread "+this.getName()+" = "+this.getState());
		this.start();
		System.out.println("status du thread "+this.getName()+" = "+this.getState());
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("status "+this.getName()+" = "+this.getState());
			if(t != null)
				System.out.println("status de "+t.getName()+" pendant le thread "+this.getName()+" = "+t.getState());
		}
	}

	public void setT(Thread t) {
		this.t = t;
	}

}
