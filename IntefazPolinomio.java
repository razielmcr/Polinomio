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
				System.out.println("Opcion 2");
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