package com.timlad.springweb.data;


public class Product {
    private Long id;
    private String title;
    private Double coast;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCoast() {
        return coast;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoast(Double coast) {
        this.coast = coast;
    }

    public Product(Long id, String title, Double coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }
}
