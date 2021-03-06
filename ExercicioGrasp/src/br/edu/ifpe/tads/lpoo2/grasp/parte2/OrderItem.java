package br.edu.ifpe.tads.lpoo2.grasp.parte2;

class OrderItem{
	private Product product;
	private int quantity;
	
	public OrderItem(Product product1, int i) {	
		
		this.product = product1;
		this.quantity = i;
	}	
	
	public double calculatePriceItem(Shipping shipping) {		
		return product.calculatePrice(this.quantity) + product.calculateWeight(this.quantity) * shipping.getPricePerKg();
	}

	public Product getProduct() {
		return this.product;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
}