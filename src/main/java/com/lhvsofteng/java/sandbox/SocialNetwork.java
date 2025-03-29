package com.lhvsofteng.java.sandbox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class SocialNetwork {

  public static void main(String[] args) {
    Map<String, String[]> graph = new HashMap<>();
    graph.put("-", new String[] {"gessica"});
    graph.put("gessica", new String[] {"rose", "fernanda", "lorena", "jaqueline", "mileni"});
    graph.put("rose", new String[] {"geralda", "tia neuza", "tia bete", "mileni", "gessica"});
    graph.put("fernanda", new String[] {"ota mileni", "jurupinga", "muiezona"});
    graph.put("muiezona", new String[] {"alguem_que_vende_carcola"});
    //    graph.put("me", new String[] {"alice", "bob", "claire"});
    //    graph.put("alice", new String[] {"me", "bob", "john"});
    //    graph.put("bob", new String[] {"alice", "me", "paul"});
    //    graph.put("claire", new String[] {"me", "bruno"});
    //    graph.put("bruno", new String[] {"me", "musk"});

    Scanner scanner = new Scanner(System.in);
    String term = scanner.next();

    while (!term.equals("exit")) {
      Map<String, String> path = search(graph, term);
      System.out.println(
          "term: " + term + "; found: " + (path != null ? getPath(path, term) : "not found"));
      term = scanner.next();
    }
  }

  public static Map<String, String> search(Map<String, String[]> graph, String term) {
    if (graph == null || graph.isEmpty()) {
      return null;
    }

    String[] head = graph.get("-");
    Queue<String> que = new LinkedList<>();
    Map<String, String> path = new HashMap<>();
    Set<String> seen = new HashSet<>();

    que.add(head[0]);
    seen.add(head[0]);

    while (!que.isEmpty()) {
      String currTerm = que.poll();
      if (currTerm.equals(term)) {
        return path;
      }
      if (graph.get(currTerm) != null) {
        for (String s : graph.get(currTerm)) {
          if (seen.contains(s)) {
            continue;
          }
          seen.add(s);
          que.add(s);
          path.put(s, currTerm);
        }
      }
    }

    return null;
  }

  public static String getPath(Map<String, String> path, String term) {
    if (path == null) {
      return "-";
    }
    StringBuilder pathStr = new StringBuilder(term).append(" -> ");
    String p = path.get(term);
    while (p != null) {
      pathStr.append(p);
      p = path.get(p);
      if (p != null) {
        pathStr.append(" -> ");
      }
    }
    return pathStr.toString();
  }
}
