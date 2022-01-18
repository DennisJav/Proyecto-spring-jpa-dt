package ec.edu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ec.edu.modelo.Paciente;

@Repository
public class PacienteRepoImpl implements IPacienteRepo {

	// Aqui se conecta con la base de datos en el segundo jdbctemplate es cualquier
	// nombre
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertarPaciente(Paciente paciente) {

//		insert into paciente(id , nombre, apellido, edad) values (1,'denis','tapia',25)

//		datos a insertar
		Object[] datosAInsertar = new Object[] { paciente.getId(), paciente.getNombre(), paciente.getApellido(),
				paciente.getEdad() };

		this.jdbcTemplate.update("	insert into paciente(id , nombre, apellido, edad) values (?,?,?,?)",
				datosAInsertar);

	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		// select * from paciente where id =1
		Object[] datoABuscar = new Object[] { id };
		return this.jdbcTemplate.queryForObject("select * from paciente where id =?", datoABuscar,
				new BeanPropertyRowMapper<Paciente>(Paciente.class));
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {

		Object[] datosAActualizar = new Object[] { paciente.getId(), paciente.getNombre(), paciente.getApellido(),
				paciente.getEdad(), paciente.getId() };
		this.jdbcTemplate.update("update paciente set id=?,nombre= ?, apellido=?, edad=?  where id=?",
				datosAActualizar);

	}

	@Override
	public void borrarPaciente(Integer id) {
		// delete from paciente where id =1
		Object[] datoABorrar = new Object[] { id };

		this.jdbcTemplate.update("delete from paciente where id =?", datoABorrar);

	}

}
