package ec.edu.modelo.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("seq_empleado"))
	@SequenceGenerator(name = "seq_empleado", sequenceName = "seq_empleado",allocationSize = 1)
	@Column(name = "empl_id")
	private Integer id;

	@Column(name = "empl_iess")
	private String iess;
	@Column(name = "empl_salario")
	private BigDecimal salario;
	
	//Aqui hago una referencia a ciudadano
	//le relaciono con la columna que se relaciona y esta en empleado
	@OneToOne
	@JoinColumn(name = "empl_id_ciudadano")
	private Ciudadano ciudadano;
	
	
	//metodos set y get
	
	
	public Integer getId() {
		return id;
	}
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIess() {
		return iess;
	}
	public void setIess(String iess) {
		this.iess = iess;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", iess=" + iess + ", salario=" + salario + ", ciudadano=" + ciudadano + "]";
	}
	

	
	
	
}
