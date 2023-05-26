package spring.mvc.session10.entity;

public class Product {
	private String name;
	private Integer quantity;
	private Double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
