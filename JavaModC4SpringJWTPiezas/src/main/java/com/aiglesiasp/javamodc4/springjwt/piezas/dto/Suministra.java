/**
 * 
 */
package com.aiglesiasp.javamodc4.springjwt.piezas.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author aitor
 *
 */
@Entity
@Table(name = "suministra")
public class Suministra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "precio")
	private int precio;

	@ManyToOne
	@JoinColumn(name = "codigopieza")
	private Pieza pieza;

	@ManyToOne
	@JoinColumn(name = "idproveedor")
	private Proveedor proveedor;

	// CONTRUCTORES
	public Suministra() {

	}

	public Suministra(int precio, Pieza pieza, Proveedor proveedor) {
		this.precio = precio;
		this.pieza = pieza;
		this.proveedor = proveedor;
	}

	// GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Suministra [id=" + id + ", precio=" + precio + ", pieza=" + pieza + ", proveedor=" + proveedor + "]";
	}

}
