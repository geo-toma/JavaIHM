package patternObserver;

public interface Observable {
	
	public void addObservateur(Observateur obs);
	public void delObservateurs();
	public void updateObservateurs();

}
