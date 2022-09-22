package model;

public class ProductOrders {
	private int orderId;
	private int productId;
	private int amountProduct;
	private float price;

	public ProductOrders(int orderId, int productId, int amountProduct, float price) {
		this.orderId = orderId;
		this.productId = productId;
		this.amountProduct = amountProduct;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmountProduct() {
		return amountProduct;
	}

	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductOrders [orderId=" + orderId + ", productId=" + productId + ", amountProduct=" + amountProduct
				+ ", price=" + price + "]";
	}
	
	

}
