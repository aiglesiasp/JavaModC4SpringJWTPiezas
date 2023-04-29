/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Usuario;
import com.aiglesiasp.javamodc4.springjwt.piezas.service.UsuarioServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class UsuarioController {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	

	@GetMapping("/usuarios")
	public List<Usuario> listarUsuario() {
		return usuarioServiceImpl.listarUsuario();
	}

	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		return usuarioServiceImpl.guardarUsuario(usuario);
	}

	@GetMapping("/usuarios/{id}")
	public Usuario usuarioById(@PathVariable(name = "id") int id) {
		Usuario usuario = new Usuario();
		usuario = usuarioServiceImpl.usuarioById(id);
		return usuario;
	}
	
	@GetMapping("/usuarios/{username}")
	public Usuario usuarioById(@PathVariable(name = "username") String username) {
		Usuario usuario = new Usuario();
		usuario = usuarioServiceImpl.usuarioByUsername(username);
		return usuario;
	}

	@PutMapping("/usuarios/{id}")
	public Usuario actualizarUsuario(@PathVariable(name = "id") int id, @RequestBody Usuario usuario) {

		Usuario usuario_seleccionado = new Usuario();
		Usuario usuario_actualizado = new Usuario();
		usuario_seleccionado = usuarioServiceImpl.usuarioById(id);
		usuario_seleccionado.setId(id);
		usuario_seleccionado.setPassword(usuario.getPassword());
		usuario_seleccionado.setRole(usuario.getRole());
		usuario_seleccionado.setUsername(usuario.getUsername());

		usuario_actualizado = usuarioServiceImpl.actualizarUsuario(usuario_seleccionado);

		return usuario_actualizado;
	}

	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable(name = "id") int id) {
		usuarioServiceImpl.eliminarUsuario(id);
	}

}
