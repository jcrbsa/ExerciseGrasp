package br.edu.ifpe.tads.lpoo2.grasp.parte2;
class CreditCard extends Payment {

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