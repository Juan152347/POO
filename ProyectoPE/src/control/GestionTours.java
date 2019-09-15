package control;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Cliente;
import entity.Reserva;
import entity.Tour;
import entity.Tour;

public class GestionTours {

	public GestionTours() {
	}

	public void llenarlista(ArrayList<Tour> listaTours) {
		Tour aux = new Tour(5698423, "bahamas", "bogota", "2:30pm", 500000);
		listaTours.add(aux);
		aux.setCodigoIdentidad(6975321);
		aux.setNombreComercial("Roma");
		aux.setLugarPartida("bogota");
		aux.setHoraPartida("10:00am");
		aux.setPrecio(1200000);
		listaTours.add(aux);
		aux.setCodigoIdentidad(9856417);
		aux.setNombreComercial("Ejipto");
		aux.setLugarPartida("medellin");
		aux.setHoraPartida("8:00pm");
		aux.setPrecio(1200000);
		listaTours.add(aux);
	}
//////////////////////////////////////// INSERTAR TOUR //////////////////////////////////////////////////

	public void insertarTour(long codigo, String nombre, String lugarp, String hora, double precio,
			ArrayList<Tour> ListaTours) {
		ControlAgencia ca = new ControlAgencia();
		Tour ntour = new Tour(codigo, nombre, lugarp, hora, precio);
		if (ca.validarTour(codigo)) {
			ListaTours.add(ntour);
		}
	}

////////////////////////////////////////// ELIMINAR TOUR ////////////////////////////////////////////////////////

	public void EliminarTour(long codigo, ArrayList<Tour> listaTours, ArrayList<Reserva> listaReserva) {
		boolean eliminable = true;
		for (Reserva reserva : listaReserva) {
			if (codigo == reserva.getTourReservado().getCodigoIdentidad()) {
				eliminable = false;
			}
		}
		if (eliminable) {
			for (Tour tour : listaTours) {
				if (codigo == tour.getCodigoIdentidad()) {
					listaTours.remove(listaTours.indexOf(tour));
					System.out.println("tour eliminado con exito");
				}
			}
		} else {
			System.out.println("no se puede eliminar el tour");
		}
	}

//////////////////////////////////////// MODIFICAR TOUR //////////////////////////////////////////////////////////

	public void ModificarTour(long codigo, ArrayList<Tour> listaTours) {

		Scanner x = new Scanner(System.in);
		int p = 0;

		do {

			if (VerificarExistencia(codigo, listaTours)) {

				System.out.println("Marque el numero de la opcion que desea modificar:");
				System.out.println("1.Codigo");
				System.out.println("2.Nombre Comercial");
				System.out.println("3.Lugar de Partida");
				System.out.println("4.Hora de Partida");
				System.out.println("5.Precio");
				System.out.println("6.Salir");

				System.out.println("Ingrese que opcion desa modificar: ");
				p = x.nextInt();
				switch (p) {

				case 1:

					System.out.println("Ingrese su nuevo codigo de identificación: ");
					mod(codigo, listaTours, x.nextLong());
					break;

				case 2:
					System.out.println("Ingrese su nuevo nombre comercial: ");
					mod(codigo, x.next(), listaTours);
					break;

				case 3:
					System.out.println("ingrese su nuevo lugar de partida: ");
					mod(x.next(), codigo, listaTours);

				case 4:
					System.out.println("Ingrese nu nueva hora de partida:");
					mod(listaTours, x.next(), codigo);
					break;

				case 5:
					System.out.println("Ingrese su nuevo precio: ");
					mod(listaTours, x.nextDouble(), codigo);
					break;

				}

			}

			else {
				System.out.println("El Tour solicitado no existe");
			}
		} while (p != 6);
	}

////////////////////////////////////  VERIFICAR EXISTENCIA /////////////////////////////////////////	
	public boolean VerificarExistencia(long codigo, ArrayList<Tour> listaTours) {
		for (Tour tour : listaTours) {
			if (codigo == tour.getCodigoIdentidad()) {
				return true;
			}

		}
		return false;
	}
///////////////////////////////////// MOD CODIGO  TOUR /////////////////////////////////////////////////////	

	public void mod(long cod, ArrayList<Tour> listaTours, long codn) {
		boolean codesta = false;
		for (Tour tour : listaTours) {
			if (codn == tour.getCodigoIdentidad()) {
				codesta = true;
			}
		}
		for (Tour tour : listaTours) {
			if (tour.getCodigoIdentidad() == cod && codesta == false) {
				tour.setCodigoIdentidad(codn);

			}
		}
	}

///////////////////////////////////// MOD NOMBRE TOUR //////////////////////////////////////////////////////////	
	public void mod(long cod, String nombre, ArrayList<Tour> listaTours) {
		for (Tour tour : listaTours) {
			if (tour.getCodigoIdentidad() == cod) {
				tour.setNombreComercial(nombre);
			}
		}
	}

///////////////////////////////////// MOD LUGAR TOUR ////////////////////////////////////////////////////////////	  
	public void mod(String lugar, long cod, ArrayList<Tour> listaTours) {
		for (Tour tour : listaTours) {
			if (tour.getCodigoIdentidad() == cod) {
				tour.setLugarPartida(lugar);
			}
		}
	}

///////////////////////////////////// MOD HORA TOUR //////////////////////////////////////////////////////////7
	public void mod(ArrayList<Tour> listaTours, String hora, long cod) {
		for (Tour tour : listaTours) {
			if (tour.getCodigoIdentidad() == cod) {
				tour.setHoraPartida(hora);

			}
		}
	}

//////////////////////////////////// MOD PRECIO TOUR/////////////////////////////////////////////////////////
	public void mod(ArrayList<Tour> listaTours, double precio, long cod) {
		for (Tour tour : listaTours) {
			if (tour.getCodigoIdentidad() == cod) {
				tour.setPrecio(precio);
			}
		}
	}

}
