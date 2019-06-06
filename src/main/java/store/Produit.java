package store;

public class Produit {

	private String id;
	private String name;
	private String description;
	private double price;
	private double idealTemperature;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
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

}
