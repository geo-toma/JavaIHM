package lesThreads;

public class CompteEnBanque {
	
	private int solde = 100;

	public int getSolde() {
		if(solde < 0)
			System.out.println("vous etes a decouvert");
		return solde;
	}
	
	public synchronized void retrait(int retrait) {
		solde -= retrait;
		System.out.println("solde = "+solde);
	}
}
