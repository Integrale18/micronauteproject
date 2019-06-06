package store;

public class Produit {

	String id;
	String name;
	String description;
	double price;
	double idealTemperature;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getIdealTemperature() {
		return idealTemperature;
	}

	public void setIdealTemperature(double idealTemperature) {
		this.idealTemperature = idealTemperature;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

}
