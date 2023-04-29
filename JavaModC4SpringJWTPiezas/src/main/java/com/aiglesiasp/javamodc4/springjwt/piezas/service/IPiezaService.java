/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.service;

import java.util.List;

import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Pieza;

/**
 * @author aitor
 *
 */
public interface IPiezaService {
	// Metodos del CRUD
	public List<Pieza> listarPieza();

	public Pieza guardarPieza(Pieza pieza);

	public Pieza piezaById(int codigo);

	public Pieza actualizarPieza(Pieza pieza);

	public void eliminarPieza(int codigo);
}
