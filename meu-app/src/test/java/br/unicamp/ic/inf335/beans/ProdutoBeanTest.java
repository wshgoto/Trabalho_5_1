package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProdutoBeanTest {

	String Codigo_Test = "ID001";
	String Nome_Test = "Produto001";
	String Descricao_Test = "Caracteristicas001";
	Double Valor_Test = 100.00;
	String Estado_Test = "Conservado";
	
	ProdutoBean Prod_Test = new ProdutoBean(Codigo_Test,
											Nome_Test,
											Descricao_Test,
											Valor_Test,
											Estado_Test);
	ProdutoBean Prod_Test2 = new ProdutoBean("ID002",
											"Produto002",
											"Caracteristicas002",
											99.99,
											"Conservado");
	
	@Test
	void Get_Codigo_Test() { 
		String Output = Prod_Test.getCodigo();
		String Expected_Value = Codigo_Test;
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Set_Codigo_Test() {
		String Expected_Value = "ID002";
		Prod_Test.setCodigo(Expected_Value);
		String Output = Prod_Test.getCodigo();
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Get_Nome_Test() { 
		String Output = Prod_Test.getNome();
		String Expected_Value = Nome_Test;
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Set_Nome_Test() {
		String Expected_Value = "Produto002";
		Prod_Test.setNome(Expected_Value);
		String Output = Prod_Test.getNome();
		assertEquals(Output, Expected_Value);
	}

	@Test
	void Get_Descricao_Test() { 
		String Output = Prod_Test.getDescricao();
		String Expected_Value = Descricao_Test;
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Set_Descricao_Test() {
		String Expected_Value = "Descricao002";
		Prod_Test.setDescricao(Expected_Value);
		String Output = Prod_Test.getDescricao();
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Get_Valor_Test() { 
		Double Output = Prod_Test.getValor();
		Double Expected_Value = Valor_Test;
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Set_Valor_Test() {
		Double Expected_Value = 666.66;
		Prod_Test.setValor(Expected_Value);
		Double Output = Prod_Test.getValor();
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Get_Estado_Test() { 
		String Output = Prod_Test.getEstado();
		String Expected_Value = Estado_Test;
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Set_Estado_Test() {
		String Expected_Value = "Deteriorado";
		Prod_Test.setEstado(Expected_Value);
		String Output = Prod_Test.getEstado();
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Compare_Test_With_Higher_Value() {
		//Prod_Test.valor > Prod_Test2.valor
		int Output = Prod_Test.compareTo(Prod_Test2);
		int Expected_Value = 1;
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Compare_Test_With_Lower_Value() {
		Prod_Test2.setValor(100.01);
		//Prod_Test.valor < Prod_Test2.valor
		int Output = Prod_Test.compareTo(Prod_Test2);
		int Expected_Value = -1;
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Compare_Test_With_Equal_Value() {
		Prod_Test2.setValor(100.00);
		//Prod_Test.valor = Prod_Test2.valor
		int Output = Prod_Test.compareTo(Prod_Test2);
		int Expected_Value = 0;
		assertEquals(Output, Expected_Value);
	}

}
