package org.example;

/**
 * Clasa ce reprezinta o muchie dintr-un graf.
 *
 *
 *
 */
public class Edge {

    public Node nod1;
    public Node nod2;

    public Edge(Node n1, Node n2) {

        nod1 = n1;
        nod2 = n2;
    }

    public Node getNod1() {
        return nod1;
    }

    public Node getNod2() {
        return nod2;
    }

    public void setNod1(Node nod1) {
        this.nod1 = nod1;
    }

    public void setNod2(Node nod2) {
        this.nod2 = nod2;
    }

    @Override
    public String toString() {
        System.out.println(nod1);
        System.out.println(nod2);
        return null;
    }


}
