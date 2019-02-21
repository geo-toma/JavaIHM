package tpCalculette;

public enum Operateur {
	ADDITION('+'),
	SOUSTRATION('-'),
	MULTIPLICATION('x'),
	DIVISION('/');
	
	private char name;
	
	private Operateur(char name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ""+name;
	}

	public char getName() {
		return name;
	}
	
}
