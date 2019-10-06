package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray
 *
 * @author Petr B.
 * @since 05.10.2019, 15:41
 */
public class SimpleArray<T> implements Iterable<T> {
    private T[] data;
    private int position = 0;

    public SimpleArray(int size) {
        this.data = (T[]) new Object[size];
    }

    public void add(T model) {
        if (this.position == this.data.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.position++;
        for (int index = 0; index < this.data.length; index++) {
            if (this.data[index] == null) {
                this.data[index] = model;
                break;
            }
        }
    }

    public void set(int index, T model) {
        if (index < this.data.length) {
            this.data[index] = model;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void remove(int index) {
        if (index < this.data.length) {
            this.data[index] = null;
            for (int i = 0; i < this.data.length; i++) {
                if (this.data[i] == null && (i + 1) < this.data.length) {
                    T el = this.data[this.data.length - 1];
                    this.data[i + 1] = this.data[i];
                    this.data[i] = el;
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        return this.data[index];
    }

    @Override
    public Iterator<T> iterator() {
        T[] elements = this.data;

        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if ((this.index + 1) <= elements.length) {
                    result = true;
                }
                return result;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[this.index++];
            }
        };
    }
}
