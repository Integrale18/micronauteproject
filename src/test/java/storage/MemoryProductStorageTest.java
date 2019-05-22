package storage;

import java.util.UUID;

import store.MemoryProductStorage;
import store.NotExistingProductException;
import store.Produit;
import spock.lang.*;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.context.ApplicationContext;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import spock.lang.AutoCleanup;
import spock.lang.Shared;
import spock.lang.Specification;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import javax.inject.Inject;

public class MemoryProductStorageTest extends Specification{

	//@Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer);
	
	//@Shared @AutoCleanup RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL());
	MemoryProductStorage store = new MemoryProductStorage();
	
	// empty storage returns empty list
	
	public boolean emptyList() {
		
		return store.all().isEmpty();
	}
	
	// adding a product returns the product in the list
	
     public Produit addProduitAndReturnPrduitInTheList() {
    	 
    	String id =null;
    	 Produit produit = new Produit();
    	 produit.setDescription("Yaourt");
    	 id = store.save(produit);
		return store.getByID(id);
	}
	// adding a product will generate a new id
     
     public String addProduitGenerateNewId() {
    	 
    	 Produit produit = new Produit();
    	 produit.setDescription("Cafe");
    	 return store.save(produit);
     }
     
     // deleting a product will remove it from the list
     
     public void deleteAProductAndRemoveItFromList() {
    	 
    	 Produit produit = new Produit();
    	 produit.setDescription("Cafe");
    	 String id = store.save(produit);
    	 int newlistSize = store.all().size();
    	 store.delete(id);
    	 int finalListSize = newlistSize-1;
     }
     
     // modifying a product will change it in the list
     
     public Produit updateProductAndUpdateInTheList() {
    	 
    	 Produit produit = new Produit();
    	 produit.setDescription("Victago");
    	 String id = store.save(produit);
    	 Produit updateProduit = new Produit();
    	 updateProduit.setDescription("Vitago");
    	 store.update(id, updateProduit);
    	 Produit intheList = store.getByID(id);
    	 return intheList;
    	 
     }
     
     // getting a product by its id will throw a NotExistingProductException if it does not exits
     // getting a product by its id will return it if it does exist
     
     public void getProductOrThrowExceptionIfNot() {
    	 
    	 String idProduit = UUID.randomUUID().toString();
    	 
    	 store.getByID(idProduit);
    	 
     }
}
