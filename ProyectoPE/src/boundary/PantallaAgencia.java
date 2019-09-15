package boundary;

import java.util.Calendar;
import java.util.Calendar;
import java.util.Scanner;
import control.ControlAgencia;
import control.GestionCliente;
import control.GestionTours;
import entity.Cliente;
import entity.Reserva;
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
		Cliente AA= new Cliente();
		Tour A= new Tour();
		Calendar fecha = Calendar.getInstance();
		
		Reserva x = new Reserva(1999, fecha  , false, 15, AA, A);
		a.getListareservas().add(x);
		Tour n = new Tour();
		
		
		a.setGestionCliente(c);
		a.setGestiontours(t);
		int op;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("seleccione una opcion");
			System.out.println("1.ver listados de tours disponibles");
			System.out.println("5.Ver lista de clientes");
			System.out.println("8.eliminar cliente");
			System.out.println("11. para eliminar reserva");
			System.out.println("20. ver lista de reservas");
			
			System.out.println("14.salir");
		    op=sc.nextInt();
			switch (op) {
			case 1:
				a.verlistatours();
				break;
			case 2:
				
			case 5:
				a.verlistaclientes();
				break;
			case 8:
				a.verlistaclientes();
				System.out.println();
				a.getGestionCliente().eliminarCliente(a.getlClientes(), a.getListareservas());
				System.out.println();
				a.verlistaclientes();
				System.out.println();
				break;
			case 11: 
				a.eliminarReserva(1999);
				break;
			case 20: 
				a.verListadoReservas();
				break;
			default:
				break;
			}
			
		}while(op!=14);
		
	}	
}