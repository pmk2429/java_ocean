package graph.api.operations;

/*************************************************************************
 *  Compilation:  javac PathFinder.java
 *  Execution:    java Pathfinder input.txt delimiter source
 *  Dependencies: Queue.java Stack.java Graph.java(Undirected)
 *
 *  Runs breadth first search algorithm from source s on a graph G.
 *  After pre processing the graph, can process shortest path queries
 *  from s to any vertex t.
 *
 *  % java PathFinder routes.txt " " JFK
 *  LAX
 *     JFK
 *     ORD
 *     PHX
 *     LAX
 *  distance 3
 *  MCO
 *     JFK
 *     MCO
 *  distance 1
 *  DFW
 *     JFK
 *     ORD
 *     DFW
 *  distance 2
 *
 *************************************************************************/

import graph.api.undirected.*;
import iomain.io.*;
import iomain.standardio.*;
import queue.Queue;
import stack.MyStack;

public class PathFinder {

  // prev[v] = previous vertex on shortest path from s to v
  // dist[v] = length of shortest path from s to v
  private ST<String, String> prev = new ST<String, String>();
  private ST<String, Integer> dist = new ST<String, Integer>();

  // run BFSAdjacencyList in graph G from given source vertex s
  public PathFinder(Graph g, String s) {

    // put source on the queue
    Queue<String> q = new Queue<String>();
    q.enqueue(s);
    dist.put(s, 0);

    // repeated remove next vertex v from queue and insert
    // all its neighbors, provided they haven't yet been visited
    while (!q.isEmpty()) {
      String v = q.dequeue();
      for (String w : g.adjacentTo(v)) {
        if (!dist.contains(w)) {
          q.enqueue(w);
          dist.put(w, 1 + dist.get(v));
          prev.put(w, v);
        }
      }
    }
  }

  public static void main(String[] args) {
    String filename = args[0];
    String delimiter = args[1];
    In in = new In(filename);
    Graph G = GraphGenerator.read(in, delimiter);
    String s = args[2];
    PathFinder pf = new PathFinder(G, s);
    while (!StdIn.isEmpty()) {
      String t = StdIn.readLine();
      for (String v : pf.pathTo(t)) {
        StdOut.println("   " + v);
      }
      StdOut.println("distance " + pf.distanceTo(t));
    }
  }

  // is v reachable from the source s?
  public boolean hasPathTo(String v) {
    return dist.contains(v);
  }

  // return the length of the shortest path from v to s
  public int distanceTo(String v) {
    if (!hasPathTo(v))
      return Integer.MAX_VALUE;
    return dist.get(v);
  }

  // return the shortest path from v to s as an Iterable
  public Iterable<String> pathTo(String v) {
    MyStack<String> path = new MyStack<String>();
    while (v != null && dist.contains(v)) {
      path.push(v);
      v = prev.get(v);
    }
    return path;
  }
}
