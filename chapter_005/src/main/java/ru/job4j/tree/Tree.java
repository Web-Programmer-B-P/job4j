package ru.job4j.tree;

import ru.job4j.tree.interfaces.SimpleTree;
import java.util.*;

/**
 * Class Tree
 *
 * @author Petr B.
 * @since 16.10.2019, 16:11
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E>, Iterable<E> {
    private Node<E> root;
    private Queue<Node<E>> data = new LinkedList<>();

    public Tree(E r) {
        root = new Node<>(r);
    }

    @Override
    public Iterator<E> iterator() {
        data.offer(root);
        return new Iterator<E>() {
            private Node<E> prevValue;
            private Node<E> nextValue;
            private int index = -1;

            @Override
            public boolean hasNext() {
                boolean result = index == -1 && root != null || nextValue != null;
                index++;
                return result;
            }

            @Override
            public E next() {
                Node<E> el = data.poll();
                if (prevValue == null && el != null) {
                    prevValue = el;
                } else {
                    prevValue = nextValue;
                    nextValue = el;
                }
                for (Node<E> nextChild : el.leaves()) {
                    data.offer(nextChild);
                }
                if (nextValue == null) {
                    nextValue = data.poll();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return prevValue.getValue();
            }
        };
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(parent).isPresent() && findBy(child).isEmpty()) {
            findBy(parent).get().add(new Node<E>(child));
            result = true;
        }
        if (findBy(parent).isEmpty() && findBy(child).isEmpty()) {
            root.add(new Node<E>(parent));
            findBy(parent).get().add(new Node<E>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }
}
