package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Clasa ce permite gestionarea si crearea unei structuri de tip Graf.
 *
 *
 *
 */
public class Graph {

    List<Node> nodeList;
    List<Edge> edgeList;

    public Graph(Graph g) {
        nodeList = new ArrayList<>();
        edgeList = new ArrayList<>();
        this.nodeList = g.getNodeList();
        this.edgeList = g.getEdgeList();

    }

    public Graph(List<Node> nodeList, List<Edge> edgeList) {
        this.nodeList = new ArrayList<>();
        this.edgeList = new ArrayList<>();
        this.nodeList = nodeList;
        this.edgeList = edgeList;


    }

    public Graph() {
        nodeList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public void addNode(Node n) {

        nodeList.add(n);
    }

    List<Node> getNeighborsof(Node n) {
        List<Node> list = new ArrayList<>();
        for (Edge e : this.getEdgeList()) {
            if (e.getNod1().equals(n)) {
                list.add(e.getNod2());

            }
            if (e.getNod2().equals(n)) {
                list.add(e.getNod1());

            }
        }
        Set<Node> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;

    }

    public void addEdge(Edge e) {

        edgeList.add(e);
    }

    public void refreshNodes() {

        List<Node> listWithoutDuplicates = nodeList.stream().distinct().collect(Collectors.toList());
        nodeList = listWithoutDuplicates;
    }

    public void refreshEdges() {

        Set<Edge> set = new HashSet<>(edgeList);
        edgeList.clear();
        edgeList.addAll(set);
    }

    public boolean containsNode(Node n2) {

        for (Node n : nodeList) {
            if (n.equals(n2)) {
                return true;
            }

        }
        return false;
    }

    public boolean containsEdge(Edge e2) {
        for (Edge e : edgeList) {

            if ((e.getNod1().equals(e2.getNod1())) && (e.getNod2().equals(e2.getNod2())) || ((e.getNod1().equals(e2.getNod2())) && (e.getNod2().equals(e2.getNod1()))) || ((e.getNod2().equals(e2.getNod1())) && (e.getNod1().equals(e2.getNod2())))) {
                return true;
            }

        }
        return false;
    }


    public String toString() {
        for (Node s : nodeList) {
            System.out.println(s);
        }
        System.out.println("*****************************************");
        for (Edge s : edgeList) {
            System.out.println(s);
        }
        return null;
    }
}
