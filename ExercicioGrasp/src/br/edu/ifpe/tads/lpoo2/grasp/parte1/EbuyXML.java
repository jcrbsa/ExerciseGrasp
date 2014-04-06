/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.tads.lpoo2.grasp.parte1;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author bruno.andrade
 */
public class EbuyXML {

    public void createXML(List<Order> listasOrder) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            for (Order order : listasOrder) {

                Element customer = doc.createElement("customer");
                rootElement.appendChild(customer);

//                Attr attr = doc.createAttribute("name");
//                attr.setValue(order.getCustomer().getName());
//                customer.setAttributeNode(attr);
                Element Order = doc.createElement("order");

                customer.appendChild(Order);
                Attr attr2 = doc.createAttribute("id");
                attr2.setValue(Integer.toString(order.getNumber()));
                Order.setAttributeNode(attr2);

                for (OrderItem item : order.getItems()) {

                    Element OrderItem = doc.createElement("item");

                    Order.appendChild(OrderItem);

                    Element Product = doc.createElement("product");
                    OrderItem.appendChild(Product);

                    Element name = doc.createElement("name");
                    name.appendChild(doc.createTextNode(item.getProduct().name));
                    Product.appendChild(name);

                    Element Price = doc.createElement("price");
                    Price.appendChild(doc.createTextNode(Double.toString(item.getProduct().price)));
                    Product.appendChild(Price);

                    Element Weight = doc.createElement("weight");
                    Weight.appendChild(doc.createTextNode(Double.toString(item.getProduct().weight)));
                    Product.appendChild(Weight);

                    Element Perecivel = doc.createElement("perecivel");
                    Perecivel.appendChild(doc.createTextNode(item.getProduct().perecivel == true ? "Perecivel" : "Nao Perecivel"));
                    Product.appendChild(Perecivel);

                }

                Element Shipping = doc.createElement("shipping");
                Order.appendChild(Shipping);

                Element DeliveryTime = doc.createElement("deliveryTime");
                DeliveryTime.appendChild(doc.createTextNode(Integer.toString(order.getShipping().deliveryTime)));
                Shipping.appendChild(DeliveryTime);
                Element PricePerWeight = doc.createElement("pricePerWeight");
                Shipping.appendChild(doc.createTextNode(Double.toString(order.getShipping().getPricePerKg())));
                Shipping.appendChild(PricePerWeight);

            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("E:\\Drobpox\\Dropbox\\ANALise. & DESEN. SISTEMAS\\Disciplinas\\Padrões de Objetos\\Exercicio\\exercicio-grasp\\ExerciseGRASP\\ExercicioGrasp\\resources\\grasp.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
