package tpCalculette;

public class DibisionParZeroException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DibisionParZeroException() {
		Panneau.label.setText("ERREUR DE MATHS");
	}

}
