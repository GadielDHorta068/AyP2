/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package datastructures;

import java.util.Iterator;
import java.util.Stack;

/**
 * An abstract base class providing some functionality of the BinaryTree interface.
 * <p>
 * The following five methods remain abstract, and must be implemented
 * by a concrete subclass: size, root, parent, left, right.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
        implements BinaryTree<E> {

    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the sibling (or null if no sibling exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) return null;                  // p must be the root
        if (p == left(parent))                            // p is a left child
            return right(parent);                           // (right child might be null)
        else                                              // p is a right child
            return left(parent);                            // (left child might be null)
    }

    /**
     * Returns the number of children of Position p.
     *
     * @param p A valid Position within the tree
     * @return number of children of Position p
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    /**
     * Returns an iterable collection of the Positions representing p's children.
     *
     * @param p A valid Position within the tree
     * @return iterable collection of the Positions of p's children
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);    // max capacity of 2
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given
     * snapshot using an inorder traversal
     *
     * @param p        Position serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if (right(p) != null)
            inorderSubtree(right(p), snapshot);
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in inorder.
     *
     * @return iterable collection of the tree's positions reported in inorder
     */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            inorderSubtree(root(), snapshot);   // fill the snapshot recursively
        return snapshot;
    }

    /**
     * Returns an iterable collection of the positions of the tree using inorder traversal
     *
     * @return iterable collection of the tree's positions using inorder traversal
     */
    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }

    /**
     * Retorna true si el nodo start está a la izquierda del nodo end. Si el nodo no
     * está a la izquierda o son nodos nulos o es el mismo nodo retorna false
     */
    @Override
    public boolean isLeft(Position<E> start, Position<E> end) {
        if ((start == null) || (end == null) || (end == start)) {
            return false;
        }

        //Si start esta antes que end.....
        Iterable<Position<E>> orden = this.positions();
        Iterator<Position<E>> iterador1 = orden.iterator();
        int startPos = 0;
        while (iterador1.hasNext()) {
            Position<E> current = iterador1.next();
            if (current.equals(start)) {
                break;
            }
            startPos++;
        }

        Iterator<Position<E>> iterador2 = orden.iterator();
        int endPos = 0;
        while (iterador2.hasNext()) {
            Position<E> current = iterador2.next();
            if (current.equals(end)) {
                break;
            }
            endPos++;
        }
        return startPos < endPos;
    }

    /**
     * Retorna una colección iterable de posiciones de un árbol con un recorrido
     * inorder. Utiliza un algoritmo no recursivo
     */
    public Iterable<Position<E>> inorderNR() {
        List<Position<E>> inorderNR = new ArrayList<>();
        if (isEmpty()) {
            return inorderNR;
        }

        /** Paso a) Inicializar una pila vacía. **/
        Stack<Position<E>> stack = new Stack<>();
        Position<E> current = root();

        while (!stack.isEmpty() || current != null) {
            /** Paso b) Apilar el nodo actual (comenzando desde el nodo raíz) a la pila.
             *  Continuar apilando los nodos a la izquierda del nodo actual hasta alcanzar un valor NULL. **/
            while (current != null) {
                stack.push(current);
                current = left(current);
            }

            /** Paso c) Si el nodo actual es NULL y la pila no está vacía:
             * Desapilar el último elemento de la pila e insertarlo en una lista
             * donde va a ir quedando el resultado del recorrido **/
            current = stack.pop();
            inorderNR.add(0, current);
            /** Configurar el nodo actual para que sea el nodo a la derecha del nodo desapilado **/
            current = right(current);
            
        }
        /**Paso d) ( WHILE) Si el nodo actual es NULL y la pila está vacía, entonces el algoritmo ha finalizado.
         *  Retornar la lista donde queda el resultado de todo el recorrido **/
        return inorderNR;
    }

}
