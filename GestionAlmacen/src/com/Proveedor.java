/**
 * 
 */
package com;

import java.util.ArrayList;

/**
 * @author Sergey
 * 
 */
public class Proveedor
{
	private String id;
	private String nombre;
	private String ciudad;
	private int codPostal;
	private String direccion;
	private ArrayList<Producto> prodSuministrados;

	/**
	 * @param id
	 * @param nombre
	 * @param ciudad
	 * @param codPostal
	 * @param direccion
	 */
	public Proveedor(String id,String nombre,String ciudad,Integer codPostal,String direccion) throws Exepciones{
		if(id==null||nombre==null||codPostal==null||direccion==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else{
			this.id=id;
			this.nombre=nombre;
			this.ciudad=ciudad;
			this.codPostal=(int)codPostal;
			this.direccion=direccion;
			prodSuministrados=new ArrayList<Producto>();
			Almacen.listaProveedores.add(this);
		}
	}

	/**
	 * 
	 * @param alm
	 *            almacen donde llevar el producto solicitado
	 * @param prod
	 *            producto a llevar
	 * @param cantidad
	 *            cantidad del producto
	 * @throws Exepciones 
	 */

	public void llevarProd(AlmacenCentral alm,Producto prod,int cantidad) throws Exepciones{
		alm.buscarProd(prod.getId()).setCantidad(cantidad);
	}

	/**
	 * @return the id
	 */
	public String getId(){
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) throws Exepciones{
		if(id==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.id=id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre(){
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) throws Exepciones{
		if(nombre==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.nombre=nombre;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad(){
		return ciudad;
	}

	/**
	 * @param ciudad
	 *            the ciudad to set
	 */
	public void setCiudad(String ciudad) throws Exepciones{
		if(ciudad==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.ciudad=ciudad;
	}

	/**
	 * @return the codPostal
	 */
	public int getCodPostal(){
		return codPostal;
	}

	/**
	 * @param codPostal
	 *            the codPostal to set
	 */
	public void setCodPostal(Integer codPostal) throws Exepciones{
		if(codPostal==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.codPostal=(int)codPostal;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion(){
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) throws Exepciones{
		if(direccion==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.direccion=direccion;
	}

	/**
	 * @return the prodSuministrados
	 */
	public ArrayList<Producto> getProdSuministrados(){
		return prodSuministrados;
	}

	/**
	 * @param prodSuministrados
	 *            the prodSuministrados to set
	 */
	public void setProdSuministrados(ArrayList<Producto> prodSuministrados) throws Exepciones{
		if(prodSuministrados==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.prodSuministrados=prodSuministrados;
	}

}
