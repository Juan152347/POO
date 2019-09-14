package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import entity.Tour;
import entity.Reserva;
import entity.Cliente;

public class ControlAgencia {

	private GestionTours gestiontours;

	private GestionCliente gestionCliente;

	private ArrayList<Tour> listaTours;
	private ArrayList<Reserva> reservas;
	private ArrayList<Cliente> listaClientes;

	public ControlAgencia() {
		this.listaTours = new ArrayList<>();
		this.reservas = new ArrayList<>();
		this.listaClientes = new ArrayList<>();
	}

	public GestionTours getGestiontours() {
		return gestiontours;
	}

	public void setGestiontours(GestionTours gestiontours) {
		this.gestiontours = gestiontours;
	}

	public GestionCliente getGestionCliente() {
		return gestionCliente;
	}

	public void setGestionCliente(GestionCliente gestionCliente) {
		this.gestionCliente = gestionCliente;
	}

	public ArrayList<Tour> getListaTours() {
		return listaTours;
	}

	public void setListatoures(ArrayList<Tour> listatoures) {
		this.listaTours = listatoures;
	}

	public ArrayList<Reserva> getListareservas() {
		return reservas;
	}

	public void setListareservas(ArrayList<Reserva> listareservas) {
		this.reservas = listareservas;
	}

	public ArrayList<Cliente> getlClientes() {
		return listaClientes;
	}

	public void setlClientes(ArrayList<Cliente> lClientes) {
		this.listaClientes = lClientes;
	}
////////////////////////////// VER LISTA DE TOURS ////////////////////////////////////////////////
	public void verlistatours() {
		for (Tour tour : this.listaTours) {
			System.out.println(tour.getCodigoIdentidad() + " " + tour.getNombreComercial() + " " + tour.getPrecio());
		}
	}

	public boolean validarTour(long codigo) {
		if (codigo > 1000000 && codigo < 10000000) {
			for (Tour tour : this.listaTours) {
				if (codigo == tour.getCodigoIdentidad()) {
					return false;
				}

			}
			return true;
		} else {
			return false;
		}

	}
/////////////////////// VER LISTA CLIENTES REGISTRADOS ////////////////////////////////////////////
	
	public void verlistaclientes() {
		for (Reserva reserva : this.reservas) {
			System.out.println(
					reserva.getCliente().getNumeroIdentificacion() + " " + reserva.getCliente().getNombreCompleto()
							+ " " + reserva.getCantidadPersonas() + " " + reserva.getCliente().getTelefonoContacto());
		}
	}

	
	public void reservarTour() {
		Scanner sc = new Scanner(System.in);
		boolean estat = false, estac = false;
		Tour auxt = new Tour();
		Cliente auxc = new Cliente();
		System.out.println("digite codigo de identificacion del tour");
		long codt = sc.nextLong();
		for (Tour tour : listaTours) {
			if (tour.getCodigoIdentidad() == codt) {
				estat = true;
				auxt = tour;
			}
		}
		System.out.println("digite el numero de identificacion del cliente");
		long codc = sc.nextLong();
		for (Cliente cliente : listaClientes) {
			if (cliente.getNumeroIdentificacion() == codc) {
				estac = true;
				auxc = cliente;
			}
		}
		if (estat && estac) {
			boolean fval = false;
			Reserva auxr = new Reserva();
			auxr.setNumeroReserva(numerodereserva());
			Calendar cal = Calendar.getInstance();
			while (!fval) {
				System.out.println("digite la fecha de la reserva");
				System.out.println("año:");
				int año = sc.nextInt();
				System.out.println("mes:");
				int mes = sc.nextInt();
				System.out.println("dia:");
				int dia = sc.nextInt();
				cal.set(año, mes, dia);
				fval = validarFecha(cal, auxc, auxt);
				fval = validarFecha(cal);
				if (!fval) {
					System.out.println("no se puede hacer la reserva intente de nuevo");
				}

			}
			auxr.setFecha(cal);
			auxr.setTourReservado(auxt);
			auxr.setCliente(auxc);
		}

	}

	public long numerodereserva() {
		long i = Math.round((Math.random() * (9999 - 1000 + 1) + 1000));
		for (Reserva Reserva : reservas) {
			if (i == Reserva.getNumeroReserva()) {
				return numerodereserva();
			}
		}
		return i;
	}

	public boolean validarFecha(Calendar fecha, Cliente cli, Tour tou) {
		for (Reserva reserva : reservas) {
			if (cli == reserva.getCliente() && fecha.compareTo(reserva.getFecha()) == 0
					&& tou == reserva.getTourReservado()) {
				return false;
			}
		}
		return true;
	}

	public boolean validarFecha(Calendar fecha) {
		Calendar fechaA = Calendar.getInstance();
		long mils = fechaA.getTimeInMillis() - fecha.getTimeInMillis();
		long dias = mils / 1000 / 60 / 60 / 24;
		if (dias > 2) {
			return true;
		} else {
			return false;
		}
	}
///////////////////////////////eliminar reserva (pediente a revision)//////////////////////////////////////////////////
	public void eliminarReserva (long creserva) {
		char confirmacion ;
		boolean existe= false;
		Scanner esc= new Scanner(System.in);
		for (Reserva reserva : reservas) {
			if( creserva==reserva.getNumeroReserva()) {
				System.out.println("Desea eliminar esta reserva?");
				confirmacion= esc.next().charAt(0);
				if (confirmacion=='s') {
					reservas.remove(reservas.indexOf(reserva));
					existe= true;
					System.out.println("La eliminacion de la reserva ha sido correcta");
				}
				
			} 
		}
		if (existe == false) {
			System.out.println("No existe ese numero de reserva");
		}
	}

}
