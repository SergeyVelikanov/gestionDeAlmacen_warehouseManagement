/**
 * 
 */
package com;

/**
 * @author Sergey
 * 
 */
public class AlmacenTienda extends AlmacenLocal
{

	public AlmacenTienda(String id,String ciudad,int codPostal,String direccion,long capacidad) throws Exepciones{
		super(id,ciudad,codPostal,direccion,capacidad);
		super.addTienda(this);

	}

	/**
	 * Vender un producto y llamar al almacen local para reponerlo en esta
	 * tienda
	 * 
	 * 
	 * @param prod
	 *            producto que se vende
	 * @param cantidad
	 *            cantidad de producto
	 * @throws Exepciones 
	 */

	public void vender(Producto prod,int cantidad) throws Exepciones{
		Producto pr=this.buscarProd(prod.getId());
		if(pr.getCantidad()>=cantidad){
			pr.setCantidad(pr.getCantidad()-cantidad);
			super.reponerProd(this,prod,cantidad);
		}else
			System.out.println("Cantidad pedida es mayor que el estock del producto");
	}

}
