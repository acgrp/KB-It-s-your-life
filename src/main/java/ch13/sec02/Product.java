package main.java.ch13.sec02;

public class Product<K, M> {
    public K kind;
    public M model;

    public Product() {
    }

    public Product(K kind, M model) {
        this.kind = kind;
        this.model = model;
    }

    public K getKind() {
        return kind;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }
}
