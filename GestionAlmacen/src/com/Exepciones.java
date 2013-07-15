/**
 * 
 */
package com;

/**
 * @author Sergey
 *
 */
@SuppressWarnings("serial")
public class Exepciones extends Exception
{
	public static final String NULL_ARGUMENT_EXEPTION="ARGUMENTO NULO NO ESTA PERMITIDO";
	public static final String PRODUCTO_NO_ENCONTRADO="PRODUCTO NO EXISTE";
	public Exepciones(String mensaje) {
		super(mensaje);
	}

}
