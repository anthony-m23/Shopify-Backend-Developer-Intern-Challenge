package com.CompanyInventory;

public class InventoryItem {
    private String cost;
    private String name;
    private String SKU;
    private String type;
    private String address;

    public InventoryItem(String name, String address, String SKU, String cost, String type) {
        this.cost = cost;
        this.name = name;
        this.SKU = SKU;
        this.type = type;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
