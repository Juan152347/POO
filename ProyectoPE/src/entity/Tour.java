package entity;

public class Tour {

	private long codigoIdentidad;
	private String nombreComercial;
	private String lugarPartida;
	private String horaPartida;
	private double precio;

	public long getCodigoIdentidad() {
		return codigoIdentidad;
	}

	public void setCodigoIdentidad(long codigoIdentidad) {
		this.codigoIdentidad = codigoIdentidad;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getLugarPartida() {
		return lugarPartida;
	}

	public void setLugarPartida(String lugarPartida) {
		this.lugarPartida = lugarPartida;
	}

	public String getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Tour(long codigoIdentidad, String nombreComercial, String lugarPartida, String horaPartida, double precio) {
		this.codigoIdentidad = codigoIdentidad;
		this.nombreComercial = nombreComercial;
		this.lugarPartida = lugarPartida;
		this.horaPartida = horaPartida;
		this.precio = precio;
	}

	public Tour() {
	}

}
