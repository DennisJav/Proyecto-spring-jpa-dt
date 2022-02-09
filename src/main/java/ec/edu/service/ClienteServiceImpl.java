package ec.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.modelo.jpa.Cliente;
import ec.edu.repository.jpa.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo clienteRepo;
	
	@Override
	public void guardarCliente(Cliente cliente) {
		this.clienteRepo.insertarCliente(cliente);
	}

}
