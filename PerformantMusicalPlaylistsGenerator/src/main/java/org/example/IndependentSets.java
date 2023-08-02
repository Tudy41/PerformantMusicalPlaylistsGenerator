package org.example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clasa ce permite generarea de multimi stabile maximale pentru un graf dat.
 *
 *
 *
 *
 *
 */

public class IndependentSets {

    Graph graph;
    private static int counter = 0;

    public IndependentSets(Graph graph2) {

        this.graph = graph2;


    }

    public void start() {
        List<Node> nodes = new ArrayList<>(graph.getNodeList());

        Iterator<Node> iter = nodes.iterator();
        List<Node> IS = new ArrayList<>();
        List<List<String>> recordList = new ArrayList<>();
        Node node;
        while (iter.hasNext()) {

            node = iter.next();
            visitNode(node, IS, nodes);


        }


    }

    private void visitNode(Node node, List<Node> previousIS, List<Node> previousCandidates) {


        ArrayList<Node> IS = new ArrayList<>();
        IS.addAll(previousIS);

        ArrayList<Node> candidates = new ArrayList<>(previousCandidates);

        ArrayList<Node> neighbor = (ArrayList<Node>) graph.getNeighborsof(node);
        for (Node n : previousCandidates) {
            if (neighbor.contains(n)) {
                candidates.remove(n);
            }

        }
        IS.add(node);

        candidates.remove(node);


        Iterator<Node> iter = candidates.iterator();
        while (iter.hasNext()) {
            Node nextnode = iter.next();
            if (node.getId() < nextnode.getId())
                visitNode(nextnode, IS, candidates);
        }

        Timestamp timestamp;
        if (candidates.size() == 0) {
            Iterator<Node> iter2 = IS.iterator();
            counter++;

            System.out.println("PlaylistNr" + counter + " {");
            while (iter2.hasNext()) {
                System.out.println(" {" + iter2.next().getContains().getAlbum() + "} ");
            }
            timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(" {" + timestamp + "}");
            System.out.println("}");

        }


    }
}