package entity;

public class Cliente {

	private long numeroIdentificacion;
	private String nombreCompleto;
	private String telefonoContacto;

	public long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public Cliente(long numeroIdentificacion, String nombreCompleto, String telefonoContacto) {
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombreCompleto = nombreCompleto;
		this.telefonoContacto = telefonoContacto;
	}

	public Cliente() {
	}

}
