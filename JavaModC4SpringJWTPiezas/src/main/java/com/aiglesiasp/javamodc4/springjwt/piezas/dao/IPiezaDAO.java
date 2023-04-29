/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiglesiasp.javamodc4.springjwt.piezas.dto.Pieza;

/**
 * @author aitor
 *
 */
public interface IPiezaDAO extends JpaRepository<Pieza, Integer> {

}
