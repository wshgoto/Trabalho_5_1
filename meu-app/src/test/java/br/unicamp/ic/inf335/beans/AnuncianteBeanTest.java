package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AnuncianteBeanTest {
	
	ProdutoBean Prod_Test1 = new ProdutoBean("ID001",
			"Produto001",
			"Caracteristicas001",
			100.00,
			"Conservado");
	ArrayList<URL> Images_Test1 = new ArrayList<URL>();
	Double Desconto_Test1 = 0.8;
	AnuncioBean Anuncio_Test1 = new AnuncioBean(Prod_Test1,
											   Images_Test1,
											   Desconto_Test1);

	ProdutoBean Prod_Test2 = new ProdutoBean("ID002",
			"Produto002",
			"Caracteristicas002",
			200.00,
			"Conservado");
	ArrayList<URL> Images_Test2 = new ArrayList<URL>();
	Double Desconto_Test2 = 0.4;
	AnuncioBean Anuncio_Test2 = new AnuncioBean(Prod_Test2,
											   Images_Test2,
											   Desconto_Test2);

	ProdutoBean Prod_Test3 = new ProdutoBean("ID003",
			"Produto003",
			"Caracteristicas003",
			300.00,
			"Conservado");
	ArrayList<URL> Images_Test3 = new ArrayList<URL>();
	Double Desconto_Test3 = 0.5;
	AnuncioBean Anuncio_Test3 = new AnuncioBean(Prod_Test3,
											   Images_Test3,
											   Desconto_Test3);

	ArrayList<AnuncioBean> Lista_de_Anuncio = 
			new ArrayList<AnuncioBean>();
	ArrayList<AnuncioBean> Anuncios_Test = 
			new ArrayList<AnuncioBean>();
	AnuncianteBean Anunciante_Test = new AnuncianteBean("José",
														"123",
														Anuncios_Test);
	
	
	@Test
	void Teste_Remover_Mais_Anuncios_Do_Que_Existentes() {
		//Considerando que inicialmente
		//o Anunciante_Test não tem nenhum anúncio
		//portanto remover anúncios não deveria ser possível.
		assertThrows(IllegalArgumentException.class,
				()->Anunciante_Test.removeAnuncio(1));
		//assertEquals(Lista_de_Anuncio.size(),0);
	}
	
	@Test
	void Teste_Dois_Anuncios_Remove_Um() {
		Lista_de_Anuncio.add(Anuncio_Test1);
		Lista_de_Anuncio.add(Anuncio_Test2);
		Anunciante_Test.setAnuncios(Lista_de_Anuncio);
		Anunciante_Test.removeAnuncio(1);
		ArrayList<AnuncioBean> Output = 
				new ArrayList<AnuncioBean>();
		Output = Anunciante_Test.getAnuncios();
		int Output_Size = Output.size();
		assertEquals(Output_Size,1);
	}
	
	@Test
	void Teste_2_Anuncios_Adiciona_Um() {
		Lista_de_Anuncio.add(Anuncio_Test1);
		Lista_de_Anuncio.add(Anuncio_Test2);
		Anunciante_Test.setAnuncios(Lista_de_Anuncio);
		Anunciante_Test.addAnuncio(Anuncio_Test3);
		ArrayList<AnuncioBean> Output = 
				new ArrayList<AnuncioBean>();
		Output = Anunciante_Test.getAnuncios();
		Lista_de_Anuncio.add(Anuncio_Test3);
		assertEquals(Output, Lista_de_Anuncio);
	}
	
	@Test
	void Teste_Media_3_Anuncios() {
		Lista_de_Anuncio.add(Anuncio_Test1);
		Lista_de_Anuncio.add(Anuncio_Test2);
		Lista_de_Anuncio.add(Anuncio_Test3);
		Anunciante_Test.setAnuncios(Lista_de_Anuncio);
		Double Output = Anunciante_Test.valorMedioAnuncios();
		Double Expected_Value = 290.00/3;
		assertEquals(Output, Expected_Value);
	}
	
	@Test
	void Teste_Media_0_Anuncios() {
		assertThrows(IllegalArgumentException.class,
				()->Anunciante_Test.valorMedioAnuncios());

	}

}
