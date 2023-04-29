/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiglesiasp.javamodc4.springjwt.piezas.dao.IProveedorDAO;
import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Proveedor;

/**
 * @author aitor
 *
 */
@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	IProveedorDAO iProveedorDAO;

	@Override
	public List<Proveedor> listarProveedor() {
		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public Proveedor proveedorById(int id) {
		return iProveedorDAO.findById(id).get();
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public void eliminarProveedor(int id) {
		iProveedorDAO.deleteById(id);

	}

}
