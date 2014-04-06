package br.edu.ifpe.tads.lpoo2.grasp.parte3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Receipt {

	Product product;
	Order order;

	
	
	public Receipt(Product product, Order order) {
		super();
		this.product = product;
		this.order = order;
	}
	

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(" --------------- Pedido item --------- ");
		buffer.append("\n");
		buffer.append(" --------------- Info Produto --------- ");
		buffer.append("\n");
		buffer.append(" Nome da Produto : ");
		buffer.append(this.product.name);
		buffer.append(" \n ");
		buffer.append("Price: ");
		buffer.append(this.product.price);
		buffer.append(" \n ");
		buffer.append("Peso: ");
		buffer.append(this.product.weight);
		buffer.append(" \n ");
		buffer.append("Perecivel: ");
		buffer.append(this.product.perecivel);
		buffer.append("\n");
			double total =0;
		for (OrderItem item : this.order.getItems()) {
			total = total + item.calculatePriceItem(this.order.getShipping());
		}
		buffer.append("Preço por Peso Entrega:");
		buffer.append(this.order.getShipping().pricePerWeight);
		buffer.append("Total de todos Items do Pedido:"); 
		buffer.append(total);
		buffer.append(" --------------- Info Cliente --------- ");
		buffer.append("\n");
		buffer.append(this.order.getCustomer().getName());
		buffer.append("\n");
		buffer.append(" --------------- Info Entrega --------- ");
		buffer.append("\n");
		Calendar test = Calendar.getInstance();
		test.add(Calendar.DAY_OF_WEEK, this.order.getShipping().deliveryTime );
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String format = simpleDateFormat.format(new Date(test.getTimeInMillis()));
		buffer.append("Previsão de Entrega:");
		buffer.append(format);
		buffer.append(" \n ");

		return buffer.toString();
	}


}
