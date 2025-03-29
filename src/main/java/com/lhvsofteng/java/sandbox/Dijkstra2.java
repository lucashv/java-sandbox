package com.lhvsofteng.java.sandbox;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra2 {

  public static void main(String[] args) {
    var graph =
        Map.of(
            "Cosmopolis",
            Map.of(
                "Paulinia", 15,
                "Americana", 30),
            "Paulinia",
            Map.of(
                "Cosmopolis", 15,
                "Americana", 10,
                "Campinas", 5),
            "Americana",
            Map.of(
                "Paulinia", 12,
                "Campinas", 20,
                "Limeira", 15),
            "Campinas",
            Map.of(
                "Paulinia", 5,
                "Americana", 20));

    var from = "Cosmopolis";
    var to = "Campinas";
    var shortestPath = findShortestPath(graph, from, to);
    var stack = new Stack<String>();
    var step = to;
    while (step != null) {
      stack.add(step);
      step = shortestPath.get(step);
    }
    while (!stack.isEmpty()) {
      var city = stack.pop();
      System.out.printf("%s -> ", city);
    }
    //    Scanner scanner = new Scanner(System.in);
    //    String from = scanner.next();
    //    String to = scanner.next();
    //
    //    while (!from.equals("exit")) {
    //      Map<String, String> shortestPath = findShortestPath(graph, from, to);
    //
    //      from = scanner.next();
    //      to = scanner.next();
    //    }
  }

  public static Map<String, String> findShortestPath(
      Map<String, Map<String, Integer>> graph, String from, String to) {
    var path = new HashMap<String, String>();
    var costs = getCosts(from, graph);
    var que = new PriorityQueue<>(Comparator.comparingInt(CityDistance::distance));
    var processed = new HashSet<String>();

    costs.forEach((k, v) -> que.add(new CityDistance(k, v)));

    while (!que.isEmpty()) {
      var cityDistance = que.poll();
      var distance = cityDistance.distance();
      var neighborCities = graph.get(cityDistance.city());

      if (neighborCities == null) {
        continue;
      }

      if (processed.contains(cityDistance.city())) {
        continue;
      }

      for (String city : neighborCities.keySet()) {
        var newCost = distance + neighborCities.get(city);
        if (costs.get(city) >= newCost) {
          costs.put(city, newCost);
          path.put(city, cityDistance.city());
        }
      }
      processed.add(cityDistance.city());
    }

    return path;
  }

  private static Map<String, Integer> getCosts(
      String from, Map<String, Map<String, Integer>> graph) {
    var result = new HashMap<>(graph.get(from));
    var que = new LinkedList<String>();
    var seen = new HashSet<String>();

    result.put(from, 0);
    que.add(from);

    while (!que.isEmpty()) {
      var city = que.poll();
      if (!result.containsKey(city)) {
        result.put(city, 0x3f3f3f3f);
      }
      if (!seen.contains(city)) {
        seen.add(city);
        Optional.ofNullable(graph.get(city)).stream()
            .map(Map::keySet)
            .flatMap(Collection::stream)
            .forEach(que::add);
      }
    }

    return result;
  }

  public record CityDistance(String city, Integer distance) {}
}
