package control;

import java.util.ArrayList;

import entity.Tour;
import entity.Reserva;
import entity.Cliente;

public class ControlAgencia {

	private GestionTours gestiontours;

	private ControlAgencia gestionCliente;

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

	public ControlAgencia getGestionCliente() {
		return gestionCliente;
	}

	public void setGestionCliente(ControlAgencia gestionCliente) {
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
	public void verlistaclientes() {
		for (Reserva reserva : this.reservas) {
			System.out.println(reserva.getCliente().getNumeroIdentificacion()+" "+reserva.getCliente().getNombreCompleto()+" "+reserva.getCantidadPersonas()+" "+reserva.getCliente().getTelefonoContacto());
		}
	}
	

}
