/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.service;

import java.util.List;

import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Proveedor;

/**
 * @author aitor
 *
 */
public interface IProveedorService {
	// Metodos del CRUD
	public List<Proveedor> listarProveedor();

	public Proveedor guardarProveedor(Proveedor proveedor);

	public Proveedor proveedorById(int id);

	public Proveedor actualizarProveedor(Proveedor proveedor);

	public void eliminarProveedor(int id);
}
