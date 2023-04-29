/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Suministra;
import com.aiglesiasp.javamodc4.springjwt.piezas.service.SuministraServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;;

	@GetMapping("/suministra")
	public List<Suministra> listarSuministra() {
		return suministraServiceImpl.listarSuministra();
	}

	@PostMapping("/suministra")
	public Suministra guardarSuministra(@RequestBody Suministra suministra) {
		return suministraServiceImpl.guardarSuministra(suministra);
	}

	@GetMapping("/suministra/{id}")
	public Suministra empleadoById(@PathVariable(name = "id") int id) {
		Suministra suministra = new Suministra();
		suministra = suministraServiceImpl.suministraById(id);
		return suministra;
	}

	@PutMapping("/suministra/{id}")
	public Suministra actualizarEmpleado(@PathVariable(name = "id") int id, @RequestBody Suministra suministra) {

		Suministra suministra_seleccionado = new Suministra();
		Suministra suministra_actualizado = new Suministra();
		suministra_seleccionado = suministraServiceImpl.suministraById(id);
		suministra_seleccionado.setPrecio(suministra.getPrecio());
		suministra_seleccionado.setPieza(suministra.getPieza());
		suministra_seleccionado.setProveedor(suministra.getProveedor());

		suministra_actualizado = suministraServiceImpl.actualizarSuministra(suministra_seleccionado);
		return suministra_actualizado;
	}

	@DeleteMapping("/suministra/{id}")
	public void eliminarEmpleado(@PathVariable(name = "id") int id) {
		suministraServiceImpl.eliminarSuministra(id);
	}

}
