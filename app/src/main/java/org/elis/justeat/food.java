package org.elis.justeat;

public class food {
    private String name;
    private String prezzo;
    private String quantità;

    public food( String name, String prezzo, String quantità ){
        this.name = name;
        this.prezzo = prezzo;
        this.quantità = quantità;
    }

    public String getName() {
        return name;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public String getQuantità() {
        return quantità;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public void setQuantità(String quantità) {
        this.quantità = quantità;
    }
}


