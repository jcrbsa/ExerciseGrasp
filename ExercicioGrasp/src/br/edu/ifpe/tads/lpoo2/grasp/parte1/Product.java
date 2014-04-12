package br.edu.ifpe.tads.lpoo2.grasp.parte1;

class Product {	
	String name;
	double price;
	double weight;
	/*
	 * Adiciona produto perec�vel
	 */
	boolean perecivel;
	
	public Product(String name, double price, double weight) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		
	}
	
	
	public Product(String name, double price, double weight, boolean perecivel) {
		super();
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.perecivel = perecivel;
	}


	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public double calculatePrice(int quantity) {
		return this.price * quantity;
	}
	
	public double getWeight() {
		return this.weight;
	}
		
	public double calculateWeight(int quantity) {
		return this.weight * quantity;
	}

	
}