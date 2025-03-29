package com.lhvsofteng.java.sandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
  private static final int INF = Integer.MAX_VALUE;
  private static final int COSMOPOLIS = 0;
  private static final int PAULINIA = 1;
  private static final int AMERICANA = 2;
  private static final int CAMPINAS = 3;

  public static void main(String[] args) {
    int V = 4;
    List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

    addEdge(adj, COSMOPOLIS, PAULINIA, 15);
    addEdge(adj, COSMOPOLIS, AMERICANA, 30);
    addEdge(adj, PAULINIA, CAMPINAS, 5);
    addEdge(adj, AMERICANA, CAMPINAS, 15);

    shortestPath(adj, V, COSMOPOLIS);
  }

  public static void addEdge(List<List<Pair<Integer, Integer>>> adj, int u, int v, int wt) {
    adj.get(u).add(new Pair<>(v, wt));
    adj.get(v).add(new Pair<>(u, wt));
  }

  public static void shortestPath(List<List<Pair<Integer, Integer>>> adj, int V, int src) {
    Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::first));
    List<Integer> dist = new ArrayList<>(Collections.nCopies(V, INF));

    pq.add(new Pair<>(0, src));
    dist.set(src, 0);

    while (!pq.isEmpty()) {
      int u = pq.peek().second();
      pq.poll();

      for (Pair<Integer, Integer> x : adj.get(u)) {
        int v = x.first();
        int weight = x.second();
        int nWeight = dist.get(u) + weight;
        if (dist.get(v) > nWeight) {
          dist.set(v, nWeight);
          pq.add(new Pair<>(dist.get(v), v));
        }
      }
    }

    System.out.println("Vertex \tDistance from Source");
    for (int i = 0; i < V; i++) {
      System.out.printf("%d \t\t %d\n", i, dist.get(i));
    }
  }

  public record Pair<T, U>(T first, U second) {}
}
