package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AnuncioBeanTest {

	ProdutoBean Prod_Test = new ProdutoBean("ID001",
			"Produto001",
			"Caracteristicas001",
			100.00,
			"Conservado");
	ArrayList<URL> Images_Test = new ArrayList<URL>();
	Double Desconto_Test = 0.8;
	AnuncioBean Anuncio_Test = new AnuncioBean(Prod_Test,
											   Images_Test,
											   Desconto_Test);

	@Test
	void Teste_Desconto_Negativo() {
		Anuncio_Test.setDesconto(-0.5);
		assertThrows(IllegalArgumentException.class,
				()->Anuncio_Test.getValor());
	}
	
	@Test
	void Teste_Desconto_Maior_Que_Um() {
		Anuncio_Test.setDesconto(1.1);
		assertThrows(IllegalArgumentException.class,
				()->Anuncio_Test.getValor());
	}
	
	@Test
	void Teste_Desconto_Zero() {
		Anuncio_Test.setDesconto(0.0);
		Double Expected_Value = 100.00;
		Double Output = Anuncio_Test.getValor();
		assertEquals(Expected_Value, Output);
	}
	
	@Test
	void Teste_Desconto_Total() {
		Anuncio_Test.setDesconto(1.0);
		Double Expected_Value = 0.00;
		Double Output = Anuncio_Test.getValor();
		assertEquals(Expected_Value, Output);
	}
	
	@Test
	void Teste_Desconto_Padrao() {
		//Desconto de 80% de R$100.00
		Double Expected_Value = 20.00;
		Double Output = Anuncio_Test.getValor();
		assertEquals(Expected_Value, Output);
	}

}
