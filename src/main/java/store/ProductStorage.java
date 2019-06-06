package store;

import java.util.List;

interface ProductStorage {

	/**
	 * creates an new product in the store
	 * 
	 * @param p the product to store
	 * @return the ID of the created object
	 */
	String save(Produit p);

	/**
	 * updates an existing product in the store Beware the product id must be filled
	 * in
	 * 
	 * @param p the product to update
	 */
	void update(String id, Produit p) throws NotExistingProductException;

	/**
	 * get a product by its id
	 * 
	 * @param id
	 * @return a product
	 */
	Produit getByID(String id) throws NotExistingProductException;

	/**
	 * deletes a product by its id
	 * 
	 * @param id
	 */
	void delete(String id) throws NotExistingProductException;

	/**
	 * list all products
	 * 
	 * @return a list of products
	 */
	List<Produit> all();
}
