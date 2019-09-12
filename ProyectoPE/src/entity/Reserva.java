package entity;

import java.util.Calendar;
import java.util.Date;

public class Reserva {

	private long numeroReserva;
	private Calendar fecha;
	private boolean pagado;
	private int cantidadPersonas;
	private Cliente cliente;

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

	public Reserva(long numeroReserva, Calendar fecha, boolean pagado, int cantidadPersonas, Cliente cliente) {
		this.numeroReserva = numeroReserva;
		this.fecha = fecha;
		this.pagado = pagado;
		this.cantidadPersonas = cantidadPersonas;
		this.cliente = cliente;
	}

	public Reserva() {
	}

}
