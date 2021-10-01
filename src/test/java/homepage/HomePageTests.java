package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.CategoryPage;

public class HomePageTests extends BaseTests {
	
	@Test
	public void testContarCategorias_cincoCategoriasDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarCategorias(), is(5));
	}
	
	@Test
	public void testValidarCarrinhoZerado_ZeroItensNoCarrinho() {
		int produtosNoCarrinho = homePage.obterQuantidadeProdutosNoCarrinho();
		assertThat(produtosNoCarrinho, is(0));
	}
	
	@Test
	public void testValidarRedirecionamentoCategoria_RedirecionamentoOK() {
		int indice = 0;
		
		String nomeCategoria_HomePage = homePage.obterNomeCategoria(indice);
		
		CategoryPage categoryPage = homePage.clicarCategoria(indice);
		
		String nomeCategoria_CategoryPage = categoryPage.obterNomeCategoria();
		
		assertThat(nomeCategoria_HomePage.toUpperCase(), is (nomeCategoria_CategoryPage.toUpperCase()));
	}
	
	//@Test
	

}

