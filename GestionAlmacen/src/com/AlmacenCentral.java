/**
 * 
 */
package com;

import java.util.ArrayList;

/**
 * @author Sergey
 * 
 */
public class AlmacenCentral extends Almacen
{
	private static ArrayList<Almacen> listaAlmacenes;

	/**
	 * @param id
	 * @param ciudad
	 * @param codPostal
	 * @param direccion
	 * @param capacidad
	 * @throws Exepciones
	 */
	public AlmacenCentral(String id,String ciudad,int codPostal,String direccion,long capacidad) throws Exepciones{
		super(id,ciudad,codPostal,direccion,capacidad);
		listaAlmacenes=new ArrayList<Almacen>();
	}

	/**
	 * Reponer al almacen local un producto que esta por debajo del limite a
	 * peticion de almacen local luego se llama al proveedor para reponer el
	 * mismo producto si esta por debajo del umbral a este almacen central
	 * 
	 * @param alm
	 *            almacen local donde se repone el producto
	 * @param prod
	 *            producto areponer
	 * @param cantidad
	 *            cantidad del producto a reponer
	 * @throws Exepciones 
	 * @throws NumberFormatException 
	 */
	public void reponerProd(AlmacenLocal alm,Producto prod,int cantidad) throws NumberFormatException, Exepciones{
		Producto pr=this.buscarProd(prod.getId());
		String[] prodPerm=this.buscarProdPerm(prod.getNombre());
		if(pr.getCantidad()>=cantidad){
			alm.buscarProd(prod.getId()).setCantidad(cantidad);
			pr.setCantidad(pr.getCantidad()-cantidad);
			if(pr.getCantidad()<=Integer.valueOf(prodPerm[1])){
				for(Proveedor prov:this.getListaProveedores()){
					if(prov.getProdSuministrados().contains(pr)){
						prov.llevarProd(this,pr,Integer.valueOf(prodPerm[2])-pr.getCantidad());
						break;
					}
				}
			}
		}else{
			alm.buscarProd(prod.getId()).setCantidad(pr.getCantidad());
			for(Proveedor prov:this.getListaProveedores()){
				if(prov.getProdSuministrados().contains(pr)){
					prov.llevarProd(this,pr,Integer.valueOf(prodPerm[2])
							+(cantidad-alm.buscarProd(prod.getId()).getCantidad()));
					alm.buscarProd(prod.getId()).setCantidad((cantidad-alm.buscarProd(prod.getId()).getCantidad()));
					break;
				}
			}
		}
	}

	/**
	 * @return the listaAlmacenes
	 */
	public static ArrayList<Almacen> getListaAlmacenes(){
		return listaAlmacenes;
	}

	/**
	 * @param listaAlmacenes
	 *            the listaAlmacenes to set
	 */
	public static void setListaAlmacenes(ArrayList<Almacen> listaAlmacenes)throws Exepciones{
		if(listaAlmacenes==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
		AlmacenCentral.listaAlmacenes=listaAlmacenes;
	}
}
