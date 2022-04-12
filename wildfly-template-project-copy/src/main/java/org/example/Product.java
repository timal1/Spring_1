package org.example;

public class Product {
    private Long id;
    private String title;
    private Long coast;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCoast() {
        return coast;
    }

    public void setCoast(Long coast) {
        this.coast = coast;
    }

    public Product(Long id, String title, Long coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "Товар № " + id + " " + title + " " + coast + " руб.";
    }
}
