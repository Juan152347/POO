package boundary;

import java.util.Calendar;
import java.util.Calendar;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

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

		// para revisar eliminar cliente
		/*
		 * GestionCliente g = new GestionCliente(); ControlAgencia c= new
		 * ControlAgencia(); Cliente cl= new Cliente(); c.setGestionCliente(g); c1=new
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
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("====================================");
			System.out.println("seleccione una opcion");
			System.out.println("1.ver listados de tours disponibles");
			System.out.println("6.Ver lista de clientes");
			System.out.println("7. Insertar cliente ");
			System.out.println("8.eliminar cliente");
			System.out.println("9.reservar tour");
			System.out.println("11. Modificar datos de reserva");
			System.out.println("12. para eliminar reserva");
			System.out.println("13. ver lista de reservas existente");
			

			System.out.println("14.salir");
			System.out.println("====================================");
			op = sc.nextInt();
			switch (op) {
			case 1:
				a.verlistatours();
				
				break;
			case 2:
				break;
			case 6:
				break;
			case 5:

				a.verlistaclientes();
				break;
			case 7 :
				
				long ID;
				String nombre,telefono;
				
				System.out.println("Ingrese un nuevo codigo ");
				ID= sc.nextLong();
				System.out.println("Ingrese nombre ");
				nombre=sc.next();
				System.out.println("Ingrese telefono ");
				telefono=sc.next();
				
				a.getGestionCliente().insertarCliente(ID, nombre, telefono, a.getlClientes());
				
				break;
			
			case 8:
				a.verlistaclientes();
				System.out.println();
				a.getGestionCliente().eliminarCliente(a.getlClientes(), a.getListareservas());
				System.out.println();
				a.verlistaclientes();
				System.out.println();
				break;
			case 9:
				a.reservarTour();
				break;
			case 10:
				System.out.println("digite el codigo de la reserva:");
				long cod=sc.nextLong();
				a.modificarreserva(cod);
				
				break;
			case 11:
				System.out.println("ingrese la reserva que desea modificar");
				a.modificarreserva(sc.nextLong());
				break;
			case 12: 
				System.out.println("ingrese la reserva que desea eliminar: ");	
				a.eliminarReserva(sc.nextLong());
				break;
			case 13: 
				a.verListadoReservas();
				break;

			default:
				break;
			}

		} while (op != 14);

	}
	public static void limpiar() {
		for (int i=0;i<200;i++) {
			System.out.println();
		}
	}
}