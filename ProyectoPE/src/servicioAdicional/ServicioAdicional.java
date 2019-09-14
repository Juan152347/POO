package servicioAdicional;

public class ServicioAdicional {

	private long Servicio;
	private String nombreServicio;
	private double precio;
	public long getServicio() {
		return Servicio;
	}
	public void setServicio(long servicio) {
		Servicio = servicio;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public ServicioAdicional(long servicio, String nombreServicio, double precio) {
		Servicio = servicio;
		this.nombreServicio = nombreServicio;
		this.precio = precio;
	}
	public ServicioAdicional() {
	}
	
}
