/**
 * 
 */
package com;

/**
 * @author Sergey
 * 
 */
public class Producto
{
	private String id;
	private String nombre;
	private int cantidad;
	/**
	 * @param id
	 * @param nombre
	 * @param cantidad
	 */
	public Producto(String id,String nombre,Integer cantidad) throws Exepciones{
		if(id==null||nombre==null||cantidad==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.id=id;
		this.nombre=nombre;
		this.cantidad=(int)cantidad;
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
	 * @return the cantidad
	 */
	public int getCantidad(){
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(Integer cantidad) throws Exepciones{
		if(cantidad==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.cantidad=(int)cantidad;
	}
}
