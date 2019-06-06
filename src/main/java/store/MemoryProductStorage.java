package store;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryProductStorage implements ProductStorage {

	List<Produit> productList = new ArrayList<>();

	@Override
	public String save(Produit p) {
		p.id = UUID.randomUUID().toString();
		productList.add(p);
		return p.id;
	}

	@Override
	public void update(String id, Produit p) throws NotExistingProductException {
		Produit product = getByID(id);
		int productIndex = productList.indexOf(product);
		p.id = product.getId();
		productList.set(productIndex, p);;

	}

	@Override
	public Produit getByID(String id) throws NotExistingProductException {
		Produit p =null;

		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).id.equals(id)) {
				p= productList.get(i);
				break;
			}
		}
		if(p ==null) {
			
				throw new NotExistingProductException("Product not found");
			
		}else {
			return p;
		}

	}

	@Override
	public void delete(String id) throws NotExistingProductException {
		Produit product = getByID(id);
		productList.remove(product);

	}

	@Override
	public List<Produit> all() {

		return productList;
	}

}
