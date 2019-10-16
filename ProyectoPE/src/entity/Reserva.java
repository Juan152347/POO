package entity;

import java.util.ArrayList;
import java.util.Calendar;


public class Reserva {

	private long numeroReserva;
	private Calendar fecha;
	private boolean pagado;
	private int cantidadPersonas;
	private Cliente cliente;
    private Tour tourReservado;
    private ArrayList<ServicioAdicional> serviciosAdicionales;
    private double precio;
    
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public ArrayList<ServicioAdicional> getServiciosAdicionales() {
		return serviciosAdicionales;
	}

	public void setServiciosAdicionales(ArrayList<ServicioAdicional> serviciosAdicionales) {
		this.serviciosAdicionales = serviciosAdicionales;
	}

	public Tour getTourReservado() {
		return tourReservado;
	}

	public void setTourReservado(Tour tourReservado) {
		this.tourReservado = tourReservado;
	}

	public long getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(long numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

	public Reserva(long numeroReserva, Calendar fecha, boolean pagado, int cantidadPersonas, Cliente cliente,
			Tour tourReservado) {
		this.numeroReserva = numeroReserva;
		this.fecha = fecha;
		this.pagado = pagado;
		this.cantidadPersonas = cantidadPersonas;
		this.cliente = cliente;
		this.tourReservado = tourReservado;
		this.serviciosAdicionales=new ArrayList<>();
	}

	public Reserva() {
		this.serviciosAdicionales= new ArrayList<>();
	}

}
