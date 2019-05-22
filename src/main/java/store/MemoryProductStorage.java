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
	public void update(String id, Produit p) {
		Produit product = getByID(id);
		int productIndex = productList.indexOf(product);
		p.id = UUID.randomUUID().toString();
		productList.add(productIndex, p);
		productList.remove(product);

	}

	@Override
	public Produit getByID(String id) {
		Produit p =null;

		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).id.equals(id)) {
				p= productList.get(i);
			}
		}
		if(p ==null) {
			try {
				throw new NotExistingProductException("Product not found");
			} catch (NotExistingProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			return p;
		}
		return p;

	}

	@Override
	public void delete(String id) {
		Produit product = getByID(id);
		productList.remove(product);

	}

	@Override
	public List<Produit> all() {

		return productList;
	}

}
