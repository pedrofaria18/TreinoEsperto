package Arvore;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import Dados.Series;

public class Heap<T> {
    public ArrayList<T> itens;

    public Heap() {
        itens = new ArrayList<T>();

    }

    public void siftUp() {
        int k = itens.size() - 1;

        while (k > 0) {
            int p = (k - 1) / 2;
            T item = itens.get(k);
            T pai = itens.get(p);

            if (((Series) item).compareTo((String) pai) > 0) {

                itens.set(k, pai);
                itens.set(p, item);
                k = p;
            } else {
                break;
            }
        }
    }

    public void insert(T item) {
        itens.add(item);
        siftUp();
    }

    public static void inserirHeap(T item) {
        insert(item);
    }

    public void siftDown() {
        int k = 0;
        int l = 2 * k + 1;

        while (l < itens.size()) {
            int max = l, r = l + 1;

            if (r < itens.size()) {
                if (((Series) itens.get(r)).compareTo((String) itens.get(l)) > 0) {

                    T temp = itens.get(k);
                    itens.set(k, itens.get(max));
                    itens.set(max, temp);
                    k = max;
                    l = 2 * k + 1;
                } else {
                    break;
                }
            }
        }
    }

    public T delete() throws NoSuchElementException {
        if (itens.size() == 0) {
            throw new NoSuchElementException();
        }
        if (itens.size() == 1) {
            return itens.remove(0);
        }

        T hold = itens.get(0);
        itens.set(0, itens.remove(itens.size() - 1));
        siftDown();
        return hold;
    }

    public int size() {
        return itens.size();
    }

    public boolean isEmpty() {
        return itens.isEmpty();
    }

    public String toString() {
        return itens.toString();
    }
}
