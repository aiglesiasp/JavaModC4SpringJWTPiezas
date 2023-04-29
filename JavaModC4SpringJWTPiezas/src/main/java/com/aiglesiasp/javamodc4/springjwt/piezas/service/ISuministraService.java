/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.service;

import java.util.List;

import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Suministra;

/**
 * @author aitor
 *
 */
public interface ISuministraService {
	// Metodos del CRUD
	public List<Suministra> listarSuministra();

	public Suministra guardarSuministra(Suministra suministra);

	public Suministra suministraById(int id);

	public Suministra actualizarSuministra(Suministra suministra);

	public void eliminarSuministra(int id);

}
