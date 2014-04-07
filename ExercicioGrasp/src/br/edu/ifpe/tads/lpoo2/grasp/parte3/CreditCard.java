package br.edu.ifpe.tads.lpoo2.grasp.parte3;
class CreditCard extends Payment {

	
	/*
	 * @GRASP: Polimorfismo
	 * 
	 */
	@Override
	double orderPayment(Order order) {
		double total = 0;
		
		for (OrderItem item : order.getItems()) {
			total += item.calculatePriceItem(order.getShipping());		
		}
		 total *= 0.5;
		 return total;
	}


		
}