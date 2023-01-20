package webpro;

public class item {
	private int id;
	private String name;
	private String category;
	private double price;
	private String img;
	public  int getId() {
		return id;
	}
	public item(int id, String name, String category, double price, String img) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.img = img;
	}
	public item() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
		
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", image="
				+ img + "]";
	}
	
	
}
