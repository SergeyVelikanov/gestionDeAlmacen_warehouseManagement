/**
 * 
 */
package com;

import java.util.ArrayList;

/**
 * @author Sergey
 * 
 */
public class AlmacenLocal extends AlmacenCentral
{
	private ArrayList<AlmacenTienda> listaTiendas;

	public AlmacenLocal(String id,String ciudad,int codPostal,String direccion,long capacidad) throws Exepciones{
		super(id,ciudad,codPostal,direccion,capacidad);
		listaTiendas=new ArrayList<AlmacenTienda>();
		super.getListaAlmacenes().add(this);
	}

	/**
	 * Reponer al almacen tienda un producto que esta por debajo del limite a
	 * peticion de la tienda luego se llama al almacen central para reponer el
	 * mismo producto si esta por debajo del umbral a este almacen local
	 * 
	 * @param alm
	 *            almacen de tienda donde se repone el producto
	 * @param prod
	 *            producto areponer
	 * @param cantidad
	 *            cantidad del producto a reponer
	 * @throws Exepciones 
	 */
	public void reponerProd(AlmacenTienda alm,Producto prod,int cantidad) throws Exepciones{
		Producto pr=this.buscarProd(prod.getId());
		String[] prodPerm=this.buscarProdPerm(prod.getNombre());
		if(pr.getCantidad()>=cantidad){
			alm.buscarProd(prod.getId()).setCantidad(cantidad);
			pr.setCantidad(pr.getCantidad()-cantidad);
			if(pr.getCantidad()<=Integer.valueOf(prodPerm[1])){
				super.reponerProd(this,prod,cantidad);
			}
		}else{
			alm.buscarProd(prod.getId()).setCantidad(pr.getCantidad());
			super.reponerProd(this,prod,(Integer.valueOf(prodPerm[2])+(cantidad-alm.buscarProd(prod.getId())
					.getCantidad())));
			alm.buscarProd(prod.getId()).setCantidad(cantidad-alm.buscarProd(prod.getId()).getCantidad());
		}
	}

	/**
	 * @return the listaTiendas
	 */
	public ArrayList<AlmacenTienda> getListaTiendas(){
		return listaTiendas;
	}

	/**
	 * @param listaTiendas
	 *            the listaTiendas to set
	 */
	public void setListaTiendas(ArrayList<AlmacenTienda> listaTiendas) throws Exepciones{
		if(listaTiendas==null)
			throw new Exepciones(Exepciones.NULL_ARGUMENT_EXEPTION);
		else
			this.listaTiendas=listaTiendas;
	}
	
	public void addTienda(AlmacenTienda alm) {
		this.listaTiendas.add(alm);
	}
}
