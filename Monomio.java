public class Monomio<T> implements Comparable<T> {

	private int exponente;

	private double coeficiente;

	public Monomio() {}

	public Monomio(double coeficiente, int exponente) {
		this.coeficiente = coeficiente;
		this.exponente = exponente;
	}

	public int getExponente() { return exponente; }

	public double getCoeficiente() { return coeficiente; }

	public void setCoeficiente(double coeficiente) { this.coeficiente = coeficiente; }

	public void setexponente(int exponente) { this.exponente = exponente; }

	public Monomio suma(Monomio m) {
		if(exponente != m.getExponente()) throw new IllegalArgumentException();
		return new Monomio(coeficiente + m.getCoeficiente(), exponente);
	}

	public Monomio multiplica(Monomio m) {
		return new Monomio(coeficiente * m.getCoeficiente(), exponente * m.getExponente());
	}

	public String toString() {
		String coef = new String();
		coef = (coeficiente < 0) ? "- " + coeficiente : "+ " + coeficiente;
		if(exponente == 0) return "" + coeficiente;
		return coef + "x^" + exponente;
	}

	public int compareTo(T o) {
		if(o == null) throw new NullPointerException();
		if(o.getClass() != this.getClass()) throw new ClassCastException();
		Monomio m = (Monomio) o;
		if(m.exponente < this.exponente) return -1;
		if(m.exponente == this.exponente) return 0;
		return 1;
	}

}
