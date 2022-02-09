package ec.edu.modelo.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	
	
	
	
	@Id
	@Column(name = "fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("seq_fatura"))
	@SequenceGenerator(name = "seq_fatura", sequenceName = "seq_fatura",allocationSize = 1)
	private Integer id;
	
	@Column(name = "fact_cedula")
	private String cedula;
	
	@Column(name = "fact_numero")
	private String numero;
	
	@Column(name = "fact_fecha")
	private LocalDateTime fecha;

//	@UnoaMuchos()
	@OneToMany(mappedBy = "factura",cascade=CascadeType.ALL) //FECTH CARGA A LOS HIJOS LOS PRECARGA
	private List<DetalleFactura> detalles;
////	
//	@OneToMany(mappedBy = "factura",cascade=CascadeType.ALL) //FECTH CARGA A LOS HIJOS LOS PRECARGA
//	private List<DetalleFactura> detalles;
	
	
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", cedula=" + cedula + ", numero=" + numero + ", fecha=" + fecha + ", detalles="
				+ detalles + "]";
		//Aniadir el fecth
	}

//	@Override
//	public String toString() {
//		return "Factura [id=" + id + ", cedula=" + cedula + ", numero=" + numero + ", fecha=" + fecha + ", ]";
//		//EL DETALLE o EL HIJO NO VIEN CARGADO 
//	}

	

	
	
	
}
