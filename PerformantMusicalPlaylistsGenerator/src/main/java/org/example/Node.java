package org.example;

import java.util.Objects;

/**
 * Clasa ce reprezinta un nod dintr-un graf.
 *
 *
 *
 */
public class Node implements Comparable<Node> {
    RecordsFromCSV contains;
    public static int universalId = 0;
    public int id;

    public Node(RecordsFromCSV r) {
        universalId++;
        id = universalId;
        contains = r;
    }

    public void setContains(RecordsFromCSV contains) {
        this.contains = contains;
    }

    public RecordsFromCSV getContains() {
        return contains;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.contains.getAlbum();
    }

    @Override
    public int compareTo(Node o) {

        if (this.contains.getNumber().equals(o.getContains().getNumber())) {

            return 0;
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        Node n = (Node) obj;
        if (Objects.equals(this.getContains().getNumber(), n.getContains().getNumber())) {
            return true;

        }
        return false;
    }
}
