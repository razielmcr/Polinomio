import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PolinomioTest {
	
	@Test
	public void addTest() {
		Polinomio p = new Polinomio();
		for(int i = 1; i < 12; i++) {
			p.add(i, i + 1);
		}

		ListIterator<Monomio> it = p.polinomio.listIterator();
		
		for(int k = 1; it.hasNext(); k++) {
			assertEquals(k, (int) it.next().getCoeficiente());
		}
	}

	@Test
	public void sumaTest() {
		Polinomio p1 = new Polinomio();
		p1.add(2,0);
		p1.add(6,1);
		p1.add(7,2);
		p1.add(2,3);
		p1.add(2,4);
		p1.add(2,5);

		Polinomio p2 = new Polinomio();
		p2.add(3,0);
		p2.add(3,1);
		p2.add(1,2);
		p2.add(5,3);
		p2.add(0,4);
		p2.add(4,5);

		Polinomio resultado = p1.suma(p2);

		assertEquals(5, (int) resultado.polinomio.get(0).getCoeficiente());
		assertEquals(9, (int) resultado.polinomio.get(1).getCoeficiente());
		assertEquals(8, (int) resultado.polinomio.get(2).getCoeficiente());
		assertEquals(7, (int) resultado.polinomio.get(3).getCoeficiente());
		assertEquals(2, (int) resultado.polinomio.get(4).getCoeficiente());
		assertEquals(6, (int) resultado.polinomio.get(5).getCoeficiente());

	} 

	@Test
	public void toStringTest() {
		Polinomio p1 = new Polinomio();
		p1.add(5,0);
		p1.add(3,1);
		p1.add(7,2);
		p1.add(1,3);
		assertEquals(" 5.0 + 3.0x^1 + 7.0x^2 + 1.0x^3", p1.toString());
	}

}