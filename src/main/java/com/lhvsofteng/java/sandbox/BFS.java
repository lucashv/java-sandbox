package com.lhvsofteng.java.sandbox;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BFS {
  public static void main(String[] args) {
    var joede = new Node("Joede");
    var gui = new Node("Gui");
    var diego = new Node("Diego");
    var andrei = new Node("Andrei");
    var fabricio = new Node("Fabricio");
    var lucas = new Node("Lucas");
    var gildao = new Node("Gildao");
    var alicio = new Node("Alicio");

    lucas.edges = List.of(fabricio, andrei, gui, diego);
    fabricio.edges = List.of(andrei, gui, diego, lucas, gildao);
    andrei.edges = List.of(lucas, fabricio, gui, diego, joede);
    diego.edges = List.of(andrei, gui, fabricio, lucas);
    gui.edges = List.of(andrei, diego, fabricio, lucas);
    joede.edges = List.of(andrei);
    gildao.edges = List.of(alicio);

    Optional.of(search(lucas, "Alicio"))
        .ifPresentOrElse(
            v -> System.out.println("Found = " + v.value().name + ", steps = " + v.level()),
            () -> System.out.println("Not Found!"));
  }

  private static Vertex<Node> search(Node node, String term) {
    if (term == null || term.isEmpty()) {
      return null;
    }

    if (node.name.equals(term)) {
      return new Vertex<>(node, 0);
    }

    var vertex = new Vertex<Node>(node, 0);
    var que = new LinkedList<Vertex<Node>>();
    var seen = new HashSet<String>();

    que.add(vertex);
    seen.add(vertex.value().name);

    var count = 0;
    while (!que.isEmpty()) {
      System.out.printf(
          "%d: que = %s%n",
          count++,
          que.stream().toList().stream()
              .map(v -> v.value().name + ":" + v.level())
              .collect(Collectors.joining(" - ")));
      var currentVertex = que.poll();

      if (currentVertex.value().name.equals(term)) {
        return currentVertex;
      }

      for (var edge : currentVertex.value().edges) {
        if (!seen.contains(edge.name)) {
          que.add(new Vertex<>(edge, currentVertex.level + 1));
          seen.add(edge.name);
        }
      }
    }

    return null;
  }

  private record Vertex<T>(T value, int level) {}

  private static class Node {
    String name;
    List<Node> edges;

    public Node(String name) {
      this.name = name;
      this.edges = null;
    }
  }
}
