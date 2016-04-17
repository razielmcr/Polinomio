import java.util.Scanner;

public class IntefazPolinomio {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		int option, salir = 1;

		System.out.println("---------------------------------------------------------------");
		System.out.println("-----------------------   POLINOMIOS   ------------------------");
		System.out.println("---------------------------------------------------------------");

	    while(salir == 1) {

			//Menu
		    System.out.println("\n\tSeleccione una opción.\n");
			System.out.println(" 1.-Crear Polinomio.\n 2.-Sumar Polinomios.\n 3.-Multiplicar Polinomios.\n 4.-Mostrar Polinomios.\n 5.-Salir.\n");
			option = s.nextInt();

		  	//Llenar Polinomios
			if(option == 1){
				System.out.println("Opcion 1");
			}
				
			else if (option == 2) {
				System.out.println("Opcion 2: Suma. \t Ingrese el numero de terminos de su primer polinomio.");
				int cantidad = s.nextInt();
				for (int i = 1; i <= cantidad; i++) {
					System.out.print("Termino: "+i+"\n");
					System.out.print("Ingrese coeficiente: ");
					int coef = s.nextInt();
					System.out.print("Ingrese exponente: ");
					int expon = s.nextInt();
					Monomio p1 = new Monomio(coef, expon);
					}	
				System.out.println("Ingrese el numero de terminos de su segundo polinomio.");
				int cantidad = s.nextInt();
				for (int i = 1; i <= cantidad; i++) {
					System.out.print("Termino: "+i+"\n");
					System.out.print("Ingrese coeficiente: ");
					int coef2 = s.nextInt();
					System.out.print("Ingrese exponente: ");
					int expon2 = s.nextInt();
					Monomio p2 = new Monomio(coef2, expon2);
					}	
				
				System.out.println("La suma de los polinomios es:");
				
				p1.suma(p2);
				//imprimir la suma de los dos, (toString de otro polinomio p3?)

			}
				
			else if (option == 3) {
				System.out.println("Opcion 3");
			}
				
			else if (option == 4) {
				System.out.println("Opcion 4");
			}

			else { break; }

	    	System.out.println("\nDesea hacer otro calculo?\n 1.-Si\n 2.-No\n");
	    	salir = s.nextInt();
	    }

	}
}
