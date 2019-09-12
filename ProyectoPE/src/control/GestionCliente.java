package control;

import java.util.ArrayList;

import entity.Cliente;
import entity.Reserva;

public class GestionCliente {
	public void insertarCliente() {
		
	}
	
	public void eliminarCliente(long cIdentificacion,ArrayList<Cliente>listaClientes,ArrayList<Reserva>reservas){
		for (Cliente cliente : listaClientes) {
			if (cIdentificacion==cliente.getNumeroIdentificacion()) {
				for (Reserva reserva : reservas ) {
					if(cIdentificacion!=reserva.getCliente().getNumeroIdentificacion()) {
						//listaClientes.remove(index)
						System.out.println("la eliminacion ha sido correcta");
					}
				}
			}
			System.out.println("No existe algun cliente con ese numero de identificacion");
		}
	}
}
