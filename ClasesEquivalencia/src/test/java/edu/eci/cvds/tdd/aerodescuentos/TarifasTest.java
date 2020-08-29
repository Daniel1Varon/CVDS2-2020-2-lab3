package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {
	private CalculadorDescuentos calculador = new CalculadorDescuentos();
	
	@Test
	public void precioNegativo() {
		try {
			double tarifaPrecioNegativo = calculador.calculoTarifa(-10, 12, 9);
		}
		catch(Exception e){}
	}
	
	@Test
	public void diasNegativo() {
		try {
			double tarifaPrecioNegativo = calculador.calculoTarifa(12, -2, 12);
		}
		catch(Exception e){}
	}
	
	@Test
	public void edadInvalidaMaxima() {
		try {
			double tarifaPrecioNegativo = calculador.calculoTarifa(40, 20, 151);
		}
		catch(Exception e){}
	}
	
	@Test
	public void edadInvalidaMinima() {
		try {
			double tarifaPrecioNegativo = calculador.calculoTarifa(40, 20, -1);
		}
		catch(Exception e){}
	}
	
	@Test
	public void tarifaCero() {
		try {
			double tarifaCero = calculador.calculoTarifa(0, 12, 9);
			Assert.assertEquals(tarifaCero, 0,0);
		}
		catch(Exception e){}
	}
	
	@Test
	public void descuentoMenorEdad() {
		try {
			double tarifaMen = calculador.calculoTarifa(10, 0, 12);
			Assert.assertEquals(tarifaMen, 9.5,0);
		}
		catch(Exception e){}
	}
	
	@Test
	public void descuentoDiasMenorEdad() {
		try {
			double tarifaMen = calculador.calculoTarifa(20, 21, 0);
			Assert.assertEquals(tarifaMen, 16,0);
		}
		catch(Exception e){}
	}
	
	@Test
	public void descuentoMayorEdad() {
		try {
			double tarifaMay = calculador.calculoTarifa(8, 12, 66);
			Assert.assertEquals(tarifaMay, 7.36,0);
		}
		catch(Exception e){}
	}
	
}