package lesson9.labs.prob8;

import java.util.Optional;

public class OrderItem {
	private Product product;
	private int quantityRequested;
	private double totalPrice;
	//package level constructor
	OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantityRequested = quantity;
		totalPrice = product.getUnitPrice().orElse(1.0) * quantity;
	}
	@Override
	public String toString() {
		return "   " + product.getProductId() + ": " + quantityRequested + ", " + product.getUnitPrice();
	}
	public Optional<Product> getProduct() {
		return Optional.of(product);
	}
	public Optional<Integer> getQuantityRequeste2d() {
		return Optional.of(quantityRequested);
	}
	public Optional<Double> getTotalPrice() {
		return Optional.of(totalPrice);
	}
	
}
