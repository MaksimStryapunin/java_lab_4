package ru.stryapunin;

public class Comparable <String> {
    private String data;

    public Comparable(String data) {
        this.data = data;
    }

    @Override
    public int compare(String obj) {
        return this.data.compareTo(obj);
    }

}
