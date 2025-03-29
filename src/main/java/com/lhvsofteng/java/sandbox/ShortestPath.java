package com.lhvsofteng.java.sandbox;

import java.util.*;

public class ShortestPath {
  public static void main(String[] args) {
    // int[][] input = new int[][] {{9, 4, 9, 9}, {6, 7, 6, 4}, {8, 3, 3, 7}, {7, 4, 9, 10}};
    int[][] input =
        new int[][] {
          {4, 4},
          {3, 7}
        };
    Solution s = new Solution();
    System.out.println(" -> " + s.minimumCostPath(input));
  }

  private static class Solution {

    // Function to return the minimum cost to react at bottom
    // distance cell from top city cell.
    public int minimumCostPath(int[][] grid) {
      int numVertex = grid.length;
      int[][] dist = new int[numVertex][numVertex];
      boolean[][] seen = new boolean[numVertex][numVertex];

      // Code here
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid.length; j++) {
          dist[i][j] = 0x3f3f3f3f;
        }
      }

      dist[0][0] = grid[0][0];
      Edge currEdge = new Edge(0, 0);

      while (currEdge != null) {
        int currDist = dist[currEdge.x][currEdge.y];
        for (Edge e : getEdges(currEdge, numVertex)) {
          if (!seen[e.x][e.y]) {
            if (dist[e.x][e.y] > grid[e.x][e.y] + currDist) {
              dist[e.x][e.y] = grid[e.x][e.y] + currDist;
            }
          }
        }
        seen[currEdge.x][currEdge.y] = true;
        currEdge = getLowerCostEdge(dist, seen, numVertex);
      }

      return dist[numVertex - 1][numVertex - 1];
    }

    private Edge getLowerCostEdge(int[][] dist, boolean[][] seen, int numVertex) {
      int cost = Integer.MAX_VALUE;
      Edge edge = null;

      for (int x = 0; x < numVertex; x++) {
        for (int y = 0; y < numVertex; y++) {
          if (!seen[x][y]) {
            if (cost > dist[x][y]) {
              cost = dist[x][y];
              edge = new Edge(x, y);
            }
          }
        }
      }

      return edge;
    }

    private List<Edge> getEdges(Edge currentEdge, int numVertex) {
      int x = currentEdge.x;
      int y = currentEdge.y;
      List<Edge> edges = new ArrayList<>();

      if (y < numVertex - 1) {
        edges.add(new Edge(x, y + 1));
      }
      if (y > 0) {
        edges.add(new Edge(x, y - 1));
      }

      if (x < numVertex - 1) {
        edges.add(new Edge(x + 1, y));
      }
      if (x > 0) {
        edges.add(new Edge(x - 1, y));
      }

      return edges;
    }

    private static class Edge {
      int x;
      int y;

      public Edge(int x, int y) {
        this.x = x;
        this.y = y;
      }

      @Override
      public String toString() {
        return "Edge(" + x + ":" + y + ")";
      }

      @Override
      public boolean equals(Object e) {
        if (!(e instanceof Edge)) return false;
        Edge otherEdge = (Edge) e;
        return this.x == otherEdge.x && this.y == otherEdge.y;
      }

      @Override
      public int hashCode() {
        return this.x * 12312 + this.y * 14343234;
      }
    }
  }
}
