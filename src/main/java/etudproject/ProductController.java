package etudproject;

import java.util.List;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.Post;
import store.MemoryProductStorage;
import store.NotExistingProductException;
import store.Produit;

@Controller("/product")
public class ProductController {

	MemoryProductStorage storage = new MemoryProductStorage();

	@Get("/")
	List<Produit> index() {
		return storage.all();
	}



	@Get("/{id}")
	Produit get(String id) {

		return storage.getByID(id)	;

	}

	@Post("/")
	String create(@Body Produit p) {
		return storage.save(p);
	}

	@Patch("/{id}")
	HttpStatus update(String id, @Body Produit p) throws NotExistingProductException {
		storage.update(id, p);
		return HttpStatus.OK;
	}

	@Delete("/{id}")
	HttpStatus delete(String id) throws NotExistingProductException {
		storage.delete(id);
		return HttpStatus.OK;
	}
}