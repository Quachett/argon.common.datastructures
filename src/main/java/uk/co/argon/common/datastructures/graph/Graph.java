package uk.co.argon.common.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uk.co.argon.common.datastructures.queue.FifoQueue;
import uk.co.argon.common.datastructures.queue.Queue;
import uk.co.argon.common.datastructures.stack.Stack;

public class Graph {

	public static void main(String...strings) {
		//dfs();
		//bfs();
		hasPath();
		
		//createGraph();
	}
	
	private static void dfs() {
		Map<Character, List<Character>> graph = getGraph();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		stack.push(graph.entrySet().iterator().next().getKey());
		System.out.println("DFS Nodes: " + dfs(graph, stack, sb));
		sb = new StringBuilder();
		System.out.println("DFS Nodes: " + dfs(graph, graph.entrySet().iterator().next().getKey(), sb));
	}
	
	private static String dfs(Map<Character, List<Character>> graph, Stack<Character> stack, StringBuilder sb) {
		if(stack.isEmpty())
			return sb.toString();
		
		Character node = stack.pop();
		sb.append(node).append(", ");
		for(Character str: graph.get(node))
			stack.push(str);
		return dfs(graph, stack, sb);
	}
	
	private static String dfs(Map<Character, List<Character>> graph, Character node, StringBuilder sb) {
		sb.append(node).append(", ");
		for(Character str: graph.get(node))
			dfs(graph, str, sb);
		return sb.toString();
	}
	
	private static void bfs() {
		Map<Character, List<Character>> graph = getGraph();
		Queue<Character> queue = new FifoQueue<>();
		StringBuilder sb = new StringBuilder();
		queue.queue(graph.entrySet().iterator().next().getKey());
		System.out.println("BFS Nodes: " + bfs(graph, queue, sb));
	}
	
	private static String bfs(Map<Character, List<Character>> graph, Queue<Character> queue, StringBuilder sb) {
		if(queue.isEmpty())
			return sb.toString();
		Character node = queue.poll();
		sb.append(node).append(", ");
		if(!graph.get(node).isEmpty())
			for(Character str: graph.get(node))
				queue.queue(str);
		
		return bfs(graph, queue, sb);
	}
	
	private static Map<Character, List<Character>> getGraph() {
		Map<Character, List<Character>> graph = new HashMap<>();

		graph.put('a', Arrays.asList('c','b'));
		graph.put('b', Arrays.asList('d'));
		graph.put('c', Arrays.asList('e'));
		graph.put('d', Arrays.asList('f'));
		graph.put('e', Arrays.asList());
		graph.put('f', Arrays.asList());
		
		return graph;
	}
	
	private static void hasPath() {
		Map<Character, List<Character>> graph = getGraphPath();

		System.out.println("\nDFS Has Path: " + hasPath(graph, 'j', 'f', false));
		System.out.println("\nDFS Cyclic Has Path: " + hasPath(createGraph(), new HashSet<Character>(), 'j', 'm', false));
		System.out.println("\nBFS Has Path: " + hasPath(graph, new FifoQueue<Character>('j'), 'f', false));
		System.out.println("\nBFS Cyclic Has Path: " + hasPath(createGraph(), new FifoQueue<Character>('i'), new HashSet<Character>(), 'm', false));
	}
	
	private static boolean hasPath(Map<Character, List<Character>> graph, Character start, Character end, boolean hasPath) {
		if(!hasPath) {
			System.out.print(start + ' ');
			for(Character str: graph.get(start)) {
				if(str==end)
					return true;
				
				hasPath = hasPath(graph, str, end, hasPath);
			}
		}
		return hasPath;
	}
	
	private static boolean hasPath(Map<Character, List<Character>> graph, Set<Character> set, Character start, Character end, boolean hasPath) {
		if(!hasPath) {
			if(!set.contains(start)) {
				System.out.print(start + " ");
				set.add(start);
				for(Character str: graph.get(start)) {
					if(str==end)
						return true;
					
					hasPath = hasPath(graph, set, str, end, hasPath);
				}
			}
		}
		return hasPath;
	}
	
	private static boolean hasPath(Map<Character, List<Character>> graph, Queue<Character> queue, Character end, boolean hasPath) {
		if(queue.isEmpty())
			return hasPath;

		Character start = queue.peek();
		System.out.print(start + " ");
		for(Character str: graph.get(queue.poll())) {
			if(str==end)
				return true;
			queue.queue(str);
		}
		hasPath = hasPath(graph, queue, end, hasPath);
		
		
		return hasPath;
	}
	
	private static boolean hasPath(Map<Character, List<Character>> graph, Queue<Character> queue, Set<Character> set, Character end, boolean hasPath) {
		if(queue.isEmpty())
			return hasPath;

		if(!set.contains(queue.peek())) {
			System.out.print(queue.peek() + " ");
			set.add(queue.peek());
			for(Character str: graph.get(queue.poll())) {
				if(str==end)
					return true;
				queue.queue(str);
			}
			hasPath = hasPath(graph, queue, set, end, hasPath);
		}
		
		return hasPath;
	}
	
	private static Map<Character, List<Character>> getGraphPath() {
		Map<Character, List<Character>> graph = new HashMap<>();

		graph.put('f', Arrays.asList('g','i'));
		graph.put('g', Arrays.asList('h'));
		graph.put('h', Arrays.asList());
		graph.put('i', Arrays.asList('g', 'k'));
		graph.put('j', Arrays.asList('i'));
		graph.put('k', Arrays.asList());
		
		return graph;
	}
	
	private static Map<Character, List<Character>> createGraph() {
		List<List<Character>> edges = new ArrayList<>();
		edges.add(Arrays.asList('i','j'));
		edges.add(Arrays.asList('k','i'));
		edges.add(Arrays.asList('m','k'));
		edges.add(Arrays.asList('k','l'));
		edges.add(Arrays.asList('o','n'));
		//System.out.println(edges);
		return getGraphPath(edges);
	}
	
	private static Map<Character, List<Character>> getGraphPath(List<List<Character>> edges) {
		Map<Character, List<Character>> graph = new HashMap<>();
		
		for(List<Character> list: edges) {
			if(graph.containsKey(list.get(0)))
				graph.get(list.get(0)).add(list.get(1));
			else
				graph.put(list.get(0), new ArrayList<Character>(Arrays.asList(list.get(1))));
			if(graph.containsKey(list.get(1)))
				graph.get(list.get(1)).add(list.get(0));
			else
				graph.put(list.get(1), new ArrayList<Character>(Arrays.asList(list.get(0))));
		}
		
		for(Map.Entry<Character, List<Character>> e: graph.entrySet())
			System.out.println(e.getKey() + ": " + e.getValue());

		
		return graph;
	}

}
