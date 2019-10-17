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
    private int numberOfElements = 1;

    public Tree(E r) {
        root = new Node<>(r);
    }

    @Override
    public Iterator<E> iterator() {
        List<E> elementsOfTree = new ArrayList<>();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (!(elementsOfTree.contains(el.getValue()))) {
                elementsOfTree.add(el.getValue());
            }
            for (Node<E> nextChild : el.leaves()) {
                data.offer(nextChild);
            }
        }
        return new Iterator<E>() {
            private int index;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (index < numberOfElements) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elementsOfTree.get(index++);
            }
        };
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(parent)) {
                el.add(new Node<>(child));
                numberOfElements++;
                result = true;
                break;
            }
            for (Node<E> nextChild : el.leaves()) {
                data.offer(nextChild);
            }
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
