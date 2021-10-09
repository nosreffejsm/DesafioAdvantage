package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginModalPage;
import pages.ProductPage;
import pages.RegisterPage;

public class HomePageTests extends BaseTests {
	
	String usuarioLogin = "Jefferson";
	String senhaLogin = "Jeff123";
	
	@Test
	public void testContarCategorias_CincoCategoriasDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarCategorias(), is(5));
	}

	@Test
	public void testValidarCarrinhoZerado_ZeroItensNoCarrinho() {
		int produtosNoCarrinho = homePage.obterQuantidadeProdutosNoCarrinho();
		assertThat(produtosNoCarrinho, is(0));
	}

	@Test
	public void testValidarAcessoCincoCategorias_CincoCategoriasAcessoOk() {

		int quantidadeCategoria = homePage.contarCategorias();
		for (int i = 0; i < quantidadeCategoria; i++) {

			String nomeCategoria_HomePage = homePage.obterNomeCategoria(i);

			CategoryPage categoryPage = homePage.clicarCategoria(i);

			String nomeCategoria_CategoryPage = categoryPage.obterNomeCategoria();

			assertThat(nomeCategoria_HomePage.toUpperCase(), is(nomeCategoria_CategoryPage.toUpperCase()));

			voltarPaginaAnterior();
		}
	}

	@Test
	public void testValidarDetalhePrimeiroProdutoPorCategoria_DetalhePrimeiroProdutoOK() {

		int quantidadeCategoria = homePage.contarCategorias();
		for (int i = 0; i < quantidadeCategoria; i++) {

			CategoryPage categoryPage = homePage.clicarCategoria(i);

			String nomeProduto_CategoryPage = categoryPage.obterNomeProduto(1);
			String precoProduto_CategoryPage = categoryPage.obterPrecoProduto(1);

			ProductPage productPage = categoryPage.clicarProduto(1);

			String nomeProduto_ProductPage = productPage.obterNomeProduto();
			String precoProduto_ProductPage = productPage.obterPrecoProduto().replace(" SOLD OUT", "");

			assertThat(nomeProduto_CategoryPage.toUpperCase(), is(nomeProduto_ProductPage.toUpperCase()));
			assertThat(precoProduto_CategoryPage, is(precoProduto_ProductPage));

			voltarPaginaAnterior();
			voltarPaginaAnterior();
		}
	}
	
	@Test
	public void testCadastroComSucesso_UsuarioCadastrado() {	
		
		LoginModalPage loginModalPage = homePage.clicarLoginUser();
		
		loginModalPage.checarUsuariioExiste_DeletarUsuario(usuarioLogin, senhaLogin);
		
		homePage.clicarLoginUser();
		
		RegisterPage registerPage = loginModalPage.clicarCreateNewAccount();

		registerPage.preencherFormularioCadastro(usuarioLogin, senhaLogin);

		homePage = registerPage.clicarRegister();
		
		String usuarioLogado = HomePage.obterUsuarioLogado();
		
		assertThat(usuarioLogin, is (usuarioLogado));

	}

}
