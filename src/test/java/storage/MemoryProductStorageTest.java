package storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;

import io.micronaut.context.ApplicationContext;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import store.MemoryProductStorage;
import store.Produit;

public class MemoryProductStorageTest {
	EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);
	RxHttpClient client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL());
	MemoryProductStorage store = new MemoryProductStorage();
	// empty storage returns empty list
	@Test
	public void testIndex() {
		List<Produit> produits = client.toBlocking().retrieve(HttpRequest.GET("/product"),
				Argument.listOf(Produit.class));
		assertEquals(0, produits.size());
	}

	@Test
	public void testAddProduitAndReturnPrduitInTheList() {
		Produit produit = new Produit();
		produit.setDescription("Yaourt");
		String idp = client.toBlocking().retrieve(HttpRequest.POST("/product", produit));
		Produit myproduit = client.toBlocking().retrieve(HttpRequest.GET("/product/" + idp),
				Argument.of(Produit.class));
		assertEquals(produit.getDescription(), myproduit.getDescription());
	}

	@Test
	public void testaddProduitGenerateNewId() {
		Produit produit = new Produit();
		produit.setDescription("Cafe");
		String id = client.toBlocking().retrieve(HttpRequest.POST("/product/", produit));
		assertNotEquals("", id);
	}

	@Test
	public void testdeleteAProductAndRemoveItFromList() {

		List<Produit> produits = client.toBlocking().retrieve(HttpRequest.GET("/product/"),
				Argument.listOf(Produit.class));
		Produit produit = new Produit();
		produit.setDescription("Cafe");
		String id = client.toBlocking().retrieve(HttpRequest.POST("/product/", produit));
		client.toBlocking().retrieve(HttpRequest.DELETE("/product/" + id), Argument.of(HttpStatus.class));
		List<Produit> newproduits = client.toBlocking().retrieve(HttpRequest.GET("/product/"),
				Argument.listOf(Produit.class));
		assertEquals(newproduits.size(), produits.size());
	}
/*
	@Test
	public void testupdateProductAndUpdateInTheList() {

		Produit produit = new Produit();
		produit.setDescription("Victago");
		String id = client.toBlocking().retrieve(HttpRequest.POST("/product/", produit));

		Produit myproduit = client.toBlocking().retrieve(HttpRequest.GET("/product/" + id), Argument.of(Produit.class)); 
		
	
		myproduit.setDescription("jus");

		client.toBlocking().retrieve(HttpRequest.PATCH("/product/" + id, myproduit), Argument.of(HttpStatus.class));

		Produit newp = client.toBlocking().retrieve(HttpRequest.GET("/product/" + id), Argument.of(Produit.class));

		assertEquals("jus", newp.getDescription());
	}
*/
	@Test
	public void testGetById() {
		Produit produit = new Produit();
		produit.setDescription("LOHO");
		String id = client.toBlocking().retrieve(HttpRequest.POST("/product/", produit));
		Produit myproduit = client.toBlocking().retrieve(HttpRequest.GET("/product/" + id), Argument.of(Produit.class));
		assertEquals(produit.getDescription(), myproduit.getDescription());
	}
}
