package patternObserver;

import java.util.ArrayList;
import java.util.Calendar;

public class Horloge implements Observable {

	private Calendar cal;
	private String hour = "";
	private ArrayList<Observateur> list = new ArrayList<>();

	public void run() {
		while (true) {
			cal = Calendar.getInstance();

			hour = cal.get(Calendar.HOUR_OF_DAY) + " : "
					+ (cal.get(Calendar.MINUTE) < 10 ? "0" + cal.get(Calendar.MINUTE) : cal.get(Calendar.MINUTE)) + " : "
					+ (cal.get(Calendar.SECOND) < 10 ? "0" + cal.get(Calendar.SECOND) : cal.get(Calendar.SECOND));
			updateObservateurs();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addObservateur(Observateur obs) {
		list.add(obs);
	}

	@Override
	public void delObservateurs() {
		list = new ArrayList<>();
	}

	@Override
	public void updateObservateurs() {
		for (Observateur obs : list)
			obs.update(hour);
	}

}
