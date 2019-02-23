package lesThreads;

public class RunImpl implements Runnable {
	
	private CompteEnBanque cb;
	private String name;
	
	public RunImpl(CompteEnBanque cb, String name) {
		this.cb = cb;
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			if (cb.getSolde() > 0) {
				System.out.println("retrait effectue par "+name);
				cb.retrait(2);
			}
		}
	}

}
