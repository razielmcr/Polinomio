import estructuras.lineales.*;

public class Polinomio {

	public ListaDoblementeLigada<Monomio> polinomio;

	public Polinomio() {
		polinomio = new ListaDoblementeLigada<>();
	}

	public static void main(String[] args) {
		Polinomio p1 = new Polinomio();
		p1.add(5,0);
		p1.add(3,1);
		p1.add(7,2);
		p1.add(1,3);
		System.out.println(p1.toString());

		Polinomio p2 = new Polinomio();
		p2.add(3,0);
		p2.add(3,1);
		p2.add(7,2);
		p2.add(1,3);
		System.out.println(p2.toString());

		Polinomio resultado = new Polinomio();

		int i = 0;
		while(i < p1.polinomio.size()) {
			resultado.add(p1.polinomio.get(i).suma(p2.polinomio.get(i)));
			i++;
		}

		System.out.println(resultado.toString());

	}

	public boolean add(double coeficiente, int grado) {
		if(grado < 0) throw new IllegalStateException();
		polinomio.add(new Monomio(coeficiente, grado));
		return true;
	}

	public void add(Monomio m) {
		polinomio.add(m);
	}

	public String toString() {
		return polinomio.toString();
	}

}