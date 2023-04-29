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

import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Proveedor;
import com.aiglesiasp.javamodc4.springjwt.piezas.service.ProveedorServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;

	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedor() {
		return proveedorServiceImpl.listarProveedor();
	}

	@PostMapping("/proveedores")
	public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}

	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorById(@PathVariable(name = "id") int id) {
		Proveedor proveedor = new Proveedor();
		proveedor = proveedorServiceImpl.proveedorById(id);
		return proveedor;
	}

	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name = "id") int id, @RequestBody Proveedor proveedor) {

		Proveedor proveedor_seleccionado = new Proveedor();
		Proveedor proveedor_actualizado = new Proveedor();
		proveedor_seleccionado = proveedorServiceImpl.proveedorById(id);

		proveedor_seleccionado.setNombre(proveedor.getNombre());
		proveedor_seleccionado.setSuministra(proveedor.getSuministra());

		proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(proveedor_seleccionado);
		return proveedor_actualizado;
	}

	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name = "id") int id) {
		proveedorServiceImpl.eliminarProveedor(id);
	}

}
