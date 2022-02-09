package ec.edu.modelo.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("seq_cliente"))
	@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)

	@Column(name = "cli_id")
	private Integer id;
	@Column(name = "cli_nombre")
	private String nombre;

	// metodos set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	//RELACION LIJERA
	//Lista de telefonos y el telefono puede ser tipo string
	//no requiere una tabla porque es una coleccion
	@ElementCollection
	private List<String> telefonos;
	//crea una coleccion asociada al cliente con un unico dato
	//debe anotarse la anotacion element colecction
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", telefonos=" + telefonos + "]";
	}



}
