package com.adrian.ejemplofactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    private List<Item> items;

    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" pepe"));
        System.out.println(client.getName());
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLastname());
    }

    public Invoice(){
        System.out.println("Creando el componente de la factura");
        System.out.println(client);
    

    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal(){
        int total = items.stream().mapToInt(Item::getImporte).sum();
        return total;
    }

    

}
