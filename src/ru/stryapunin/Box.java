package ru.stryapunin;

public class Box<T> {
    private T item;

    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("No empty");
        }
        this.item = item;
    }

    public T get() {
        T value = this.item;
        this.item = null; // Важно: обнуляем ссылку
        return value;
    }

    public boolean isFull() {
        return this.item != null;
    }

    @Override
    public String toString() {
        return "Box {" + item + '}';
    }
}
