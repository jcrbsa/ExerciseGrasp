package br.edu.ifpe.tads.lpoo2.grasp.parte3;

class Product {	
	String name;
	double price;
	double weight;
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

	public void printerProduct(){
		String str = "Name#: " + this.name + "\n";
		
		str += "Price: " + this.price + "\n";
		str += "Weight: " + this.weight + "\n";
		str += "Perecivel: " + this.weight + "\n";
		//str += "Calculate Price: " + this.calculatePrice(this.) + "\n";
		//str += "Calculate Weight: " + this.calculateWeight(quantity) + "\n";

		System.out.println(str);
		
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