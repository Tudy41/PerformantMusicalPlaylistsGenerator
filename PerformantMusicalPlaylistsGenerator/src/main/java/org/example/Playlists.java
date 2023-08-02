package org.example;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * Clasa ce detine o lista de inregistrari dintr-un set de date si o poate prelucra.
 *
 *
 *
 *
 *
 *
 */
public class Playlists {


    private List<Set<RecordsFromCSV>> listOfPlaylists;


    private IndependentSets unrelatedPlaylists;



    public void generateUnrelatedPlaylists() {
        Graph g = this.createPlaylistsGraph();
        g.refreshNodes();
        g.refreshEdges();

        unrelatedPlaylists = new IndependentSets(g);

        unrelatedPlaylists.start();


    }



    public List<Set<RecordsFromCSV>> getListOfPlaylists() {
        return listOfPlaylists;
    }





    public void setListOfPlaylists(List<Set<RecordsFromCSV>> listOfPlaylists) {
        this.listOfPlaylists = listOfPlaylists;
    }



    public Graph createPlaylistsGraph() {

        Graph g = new Graph();

        List<RecordsFromCSV> listOfRecords = ImportTool.getListOfRecords();
        Node prim, second;
        Edge e;
        for (RecordsFromCSV recordPrim : listOfRecords) {
            prim = new Node(recordPrim);
            for (RecordsFromCSV recordSecond : listOfRecords) {

                second = new Node(recordSecond);
                if (prim.getContains().getArtist().equals(second.getContains().getArtist())) {
                    e = new Edge(prim, second);
                    if (g.containsNode(prim) && g.containsNode(second)) {
                        if (!g.containsEdge(e)) {
                            g.addEdge(e);
                        }

                    }
                    if (!g.containsNode(prim)) {

                        g.addNode(prim);
                        if (!g.containsEdge(e)) {
                            g.addEdge(e);
                        }
                    }
                    if (!g.containsNode(second)) {

                        g.addNode(second);
                        if (!g.containsEdge(e)) {
                            g.addEdge(e);
                        }
                    }

                }
                if (prim.getContains().getGenre().equals(second.getContains().getGenre())) {
                    e = new Edge(prim, second);
                    if (g.containsNode(prim) && g.containsNode(second)) {
                        if (!g.containsEdge(e)) {
                            g.addEdge(e);
                        }

                    }
                    if (!g.containsNode(prim)) {

                        g.addNode(prim);
                        if (!g.containsEdge(e)) {
                            g.addEdge(e);
                        }
                    }
                    if (!g.containsNode(second)) {

                        g.addNode(second);
                        if (!g.containsEdge(e)) {
                            g.addEdge(e);
                        }
                    }
                }
                if (prim.getContains().getYear().equals(second.getContains().getYear())) {
                    e = new Edge(prim, second);
                    if (g.containsNode(prim) && g.containsNode(second)) {
                        if (!g.containsEdge(e)) {
                            g.addEdge(e);
                        }

                    }

                    if (!g.containsNode(prim)) {

                        g.addNode(prim);
                        if (!g.containsEdge(e)) {
                            g.addEdge(e);
                        }
                    }
                    if (!g.containsNode(second)) {

                        g.addNode(second);
                        if (!g.containsEdge(e)) {
                            g.addEdge(e);
                        }
                    }
                }


            }
        }


        return g;
    }
}
