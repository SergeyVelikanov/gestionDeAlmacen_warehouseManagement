/**
 * 
 */
package com;

import java.util.ArrayList;

/**
 * @author Sergey
 * 
 */
public class Almacen
{
	private String id;
	private String ciudad;
	private int codPostal;
	private String direccion;
	private long capacidad;
	private ArrayList<String[]> listaProdPermitidos;
	private ArrayList<Producto> listaActualProductos;
	protected static ArrayList<Proveedor> listaProveedores;

	/**
	 * @param id
	 * @param ciudad
	 * @param codPostal
	 * @param direccion
	 * @param capacidad
	 */
	public Almacen(String id,String ciudad,Integer codPostal,String direccion,Long capacidad) throws Exepciones{
		if(id==null||ciudad.isEmpty()||codPostal==null||direccion==null||capacidad==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else{
			this.id=id;
			this.ciudad=ciudad;
			this.codPostal=(int)codPostal;
			this.direccion=direccion;
			this.capacidad=(long)capacidad;
			listaProdPermitidos=new ArrayList<String[]>();
			listaActualProductos=new ArrayList<Producto>();
			listaProveedores=new ArrayList<Proveedor>();
		}
	}

	/**
	 * @param prod
	 *            - String[] donde prod[0] nombre de producto permitido prod[1]-
	 *            cantidad minima prod[2]- cantidad maxima
	 */
	public void aniadirProdPerm(String[] prod) throws Exepciones{
		if(prod==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else{
			if(this.listaProdPermitidos.isEmpty()||buscarProdPerm(prod[0])==null){
				String[] prodPermitido=new String[3];
				prodPermitido[0]=prod[0];
				prodPermitido[1]=prod[1];
				prodPermitido[2]=prod[2];
				listaProdPermitidos.add(prodPermitido);
			}
		}
	}

	/**
	 * 
	 * @param prod
	 *            producto a añadir
	 */

	public void aniadirProd(Producto prod) throws Exepciones{
		if(prod==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else{
			if(permitirAniadido(prod))
				this.listaActualProductos.add(prod);
		}
	}

	/**
	 * *
	 * 
	 * @param prov
	 *            proveedor a añadir
	 */

	public void aniadirProv(Proveedor prov) throws Exepciones{
		if(prov==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			listaProveedores.add(prov);
	}

	/**
	 * @return the listaProdPermitidos
	 */
	public ArrayList<String[]> getListaProdPermitidos(){
		return listaProdPermitidos;
	}

	/**
	 * @param listaProdPermitidos
	 *            the listaProdPermitidos to set
	 */
	public void setListaProdPermitidos(ArrayList<String[]> listaProdPermitidos) throws Exepciones{
		if(listaProdPermitidos==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.listaProdPermitidos=listaProdPermitidos;
	}

	/**
	 * @return the listaActualProductos
	 */
	public ArrayList<Producto> getListaActualProductos(){
		return listaActualProductos;
	}

	/**
	 * @param listaActualProductos
	 *            the listaActualProductos to set
	 */
	public void setListaActualProductos(ArrayList<Producto> listaActualProductos) throws Exepciones{
		if(listaActualProductos==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.listaActualProductos=listaActualProductos;
	}

	/**
	 * @return the listaProveedores
	 */
	public ArrayList<Proveedor> getListaProveedores(){
		return listaProveedores;
	}

	/**
	 * @param listaProveedores
	 *            the listaProveedores to set
	 */
	public void setListaProveedores(ArrayList<Proveedor> listaProveedores) throws Exepciones{
		if(listaProveedores==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			Almacen.listaProveedores=listaProveedores;
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
	 * @return the capacidad
	 */
	public long getCapacidad(){
		return capacidad;
	}

	/**
	 * @param capacidad
	 *            the capacidad to set
	 */
	public void setCapacidad(Long capacidad) throws Exepciones{
		if(capacidad==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.capacidad=(long)capacidad;
	}

	// UTILIDADES

	/**
	 * Busca a un producto por su id
	 * 
	 * @param idProd
	 *            -id del producto a buscar
	 * 
	 * @return Producto si producto con este id existe en almacen o null si no
	 *         existe o lista productos vacia
	 */

	public Producto buscarProd(String idProd){
		Producto pr=null;
		if(!this.listaActualProductos.isEmpty()){
			for(Producto itr:this.listaActualProductos){
				if(itr.getId().equalsIgnoreCase(idProd)){
					pr=itr;
					break;
				}
			}
		}
		return pr;
	}

	/**
	 * Busca a un producto permitido para este almacen por su id
	 * 
	 * @param nom
	 *            -nombre del producto a buscar
	 * 
	 * @return String[] si producto con este id existe en almacen o null si no
	 *         existe o lista productos vacia
	 */
	public String[] buscarProdPerm(String nom){
		String[] prod=null;
		if(!this.listaProdPermitidos.isEmpty()){
			for(String[] itr:this.listaProdPermitidos){
				if(itr[0].equals(nom))
					prod=itr;
			}
		}
		return prod;
	}

	/**
	 * Busca a un proveedor por su id
	 * 
	 * @param id
	 *            - id de proveedor a buscar
	 * 
	 * @return Proveedor si existe en la lista o null si no existe o lista vacia
	 */

	public Proveedor buscarProv(String id){
		Proveedor prov=null;
		if(!Almacen.listaProveedores.isEmpty()){
			for(Proveedor itr:Almacen.listaProveedores){
				if(itr.getId().equals(id))
					prov=itr;
			}
		}
		return prov;
	}

	/**
	 * Permite o prohibe añadir un profucto
	 * 
	 * @param prod
	 *            - producto para añadir
	 * 
	 * @return true si la lista de productos permitidos para este almacen no
	 *         esta vacia y el producto para añadir esta entre los productos
	 *         permitidos y cantidad del producto a añadir no supera max
	 *         permitido para este producto en el almacen false en el caso
	 *         contrario
	 */

	public boolean permitirAniadido(Producto prod){
		boolean perm=false;
		if(!this.listaProdPermitidos.isEmpty()){
			for(String[] itr:this.listaProdPermitidos)
				if(itr[0].equals(prod.getNombre())){
					if(this.listaActualProductos.isEmpty()&&prod.getCantidad()<=Integer.valueOf(itr[2]))
						perm=true;
					if(!this.listaActualProductos.isEmpty()
							&&buscarProd(prod.getId()).getCantidad()+prod.getCantidad()<=Integer.valueOf(itr[2]))
						perm=true;
				}
		}
		return perm;
	}

}
