/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Usuario;

/**
 * @author aitor
 *
 */
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	Usuario findByUsername(String username);
}
