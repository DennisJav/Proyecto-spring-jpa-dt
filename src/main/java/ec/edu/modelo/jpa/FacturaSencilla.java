package ec.edu.modelo.jpa;

public class FacturaSencilla {
	
	private String numero;
	private String cedula;
	
	//Crear el constructor por defecto
		public FacturaSencilla() {
		
		}
	
	//Obligatorio crear el constructor con los atributos
	public FacturaSencilla(String numero, String cedula) {
		super();
		this.numero = numero;
		this.cedula = cedula;
	}
	
	



	//Metodos set y get
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "FacturaSencilla [numero=" + numero + ", cedula=" + cedula + "]";
	}
	
	
}
