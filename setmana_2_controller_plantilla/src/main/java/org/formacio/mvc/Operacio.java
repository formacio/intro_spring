package org.formacio.mvc;

public class Operacio {

	private final int op1;
	private final int op2;
	private final int resultado;
	
	public Operacio(int op1, int op2, int resultado) {
		this.op1 = op1;
		this.op2 = op2;
		this.resultado = resultado;
	}

	public int getOp1() {
		return op1;
	}
	
	public int getOp2() {
		return op2;
	}
	
	public int getResultado() {
		return resultado;
	}
	
	
}
