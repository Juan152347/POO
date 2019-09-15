package boundary;

import java.util.Calendar;
import java.util.Scanner;

import control.ControlAgencia;
import control.GestionCliente;
import control.GestionTours;
import entity.Cliente;
import entity.Tour;


public class PantallaAgencia {

	private ControlAgencia agencia;

	public PantallaAgencia() {
		this.agencia = new ControlAgencia();
	}
	
	public static void main(String[] args) {
		
		//para revisar eliminar cliente
		/*GestionCliente g = new GestionCliente();
		ControlAgencia c= new ControlAgencia();
		Cliente cl= new Cliente();
		c.setGestionCliente(g);
		c1=new
		*/
		GestionTours t = new GestionTours();
		GestionCliente c = new GestionCliente();
		ControlAgencia a= new ControlAgencia();
		
		
		a.setGestionCliente(c);
		a.setGestiontours(t);
		int op;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("seleccione una opcion");
			System.out.println("1.ver listados de tours disponibles");
			System.out.println("5.Ver lista de clientes");
			System.out.println("8.eliminar cliente");
			System.out.println("14.salir");
		    op=sc.nextInt();
			switch (op) {
			case 1:
				a.verlistatours();
				break;
			case 5:
				a.verlistaclientes();
				break;
			case 8:
				a.verlistaclientes();
				System.out.println();
				a.getGestionCliente().eliminarCliente(a.getlClientes(), a.getListareservas());
				System.out.println();
				a.verlistaclientes();
				break;

			default:
				break;
			}
			
		}while(op!=14);
		
	}	
}