/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiglesiasp.javamodc4.springjwt.piezas.dao.IPiezaDAO;
import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Pieza;

/**
 * @author aitor
 *
 */
@Service
public class PiezaServiceImpl implements IPiezaService {

	@Autowired
	IPiezaDAO iPiezaDAO;

	@Override
	public List<Pieza> listarPieza() {
		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza guardarPieza(Pieza pieza) {
		return iPiezaDAO.save(pieza);
	}

	@Override
	public Pieza piezaById(int codigo) {
		return iPiezaDAO.findById(codigo).get();
	}

	@Override
	public Pieza actualizarPieza(Pieza pieza) {
		return iPiezaDAO.save(pieza);
	}

	@Override
	public void eliminarPieza(int codigo) {
		iPiezaDAO.deleteById(codigo);

	}

}
