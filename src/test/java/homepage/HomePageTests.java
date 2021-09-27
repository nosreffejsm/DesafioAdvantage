package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import base.BaseTests;

public class HomePageTests extends BaseTests {
	
	@Test
	public void testContarCategorias_cincoCategoriasDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarProdutos(), is(5));
	}
	
	@Test
	public void testValidarCarrinhoZerado_ZeroItensNoCarrinho() {
		int produtosNoCarrinho = homePage.obterQuantidadeProdutosNoCarrinho();
		assertThat(produtosNoCarrinho, is(0));
	}

}

