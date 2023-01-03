package uk.co.argon.common.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
//import java.util.Queue;
import java.util.Set;

import uk.co.argon.common.datastructures.queue.FifoQueue;
import uk.co.argon.common.datastructures.queue.Queue;

public class Graph2 {
	public static void main(String...args) {
		//componentCount();
		shortestPath();
	}
	
	private static void componentCount() {
		Map<Integer, List<Integer>> graph = getGraphPath();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count=0;
		int cc = 0;
		int l = 0;
		for(Integer i: graph.keySet()) {
			if(!map.containsKey(i)) {
				count++;
				cc=0;
				cc = dfsCompCnt(graph, map, i, cc);
				l = (cc>l)?cc:l;
			}
		}
		
		/*List<Integer> l = map.values().stream().distinct().collect(Collectors.toList());
		for(Integer i: l)
			cc = (Collections.frequency(map.values(), i)>cc)?Collections.frequency(map.values(), i):cc;*/
		
		System.out.println("Distinct: "  );
		System.out.println("Count: " + count);
		System.out.println("Largest Comp: " + l);
		System.out.println(map);
	}
	
	private static int dfsCompCnt(Map<Integer, List<Integer>> graph, Map<Integer, Integer> map, Integer node, int cc) {
		if(!map.containsKey(node)) {
			map.put(node, ++cc);
			for(Integer j: graph.get(node))
				cc = dfsCompCnt(graph, map, j, cc);
		}
		return cc;
	}
	
	private static void shortestPath() {
		Map<Character, List<Character>> graph = createGraph();
		//Queue<Entry<Character, Integer>> queue = new LinkedList<Entry<Character, Integer>>();
		Queue<Entry<Character, Integer>> q = new FifoQueue<>(Map.entry('w', 0));
		System.out.println(shortestPath(graph, q, new HashSet<>(), 'z'));
	}
	
	private static int shortestPath(Map<Character, List<Character>> graph, Queue<Entry<Character, Integer>> queue, Set<Character> set, Character end) {
		if(queue.isEmpty())
			return -1;
		
		if(!set.contains(queue.peek().getKey())) {
			Entry<Character, Integer> e = queue.poll();
			set.add(e.getKey());
			for(Character c: graph.get(e.getKey())) {
				if(c==end)
					return e.getValue()+1;
				queue.queue(Map.entry(c, e.getValue()+1));
			}
		}
		
		return shortestPath(graph, queue, set, end);
	}
	
	private static Map<Character, List<Character>> createGraph() {
		List<List<Character>> edges = new ArrayList<>();
		edges.add(Arrays.asList('w','x'));
		edges.add(Arrays.asList('x','y'));
		edges.add(Arrays.asList('z','y'));
		edges.add(Arrays.asList('z','v'));
		edges.add(Arrays.asList('w','v'));
		//System.out.println(edges);
		return getGraphPath(edges);
	}
	
	private static Map<Integer, List<Integer>> getGraphPath() {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		graph.put(1, Arrays.asList(2));
		graph.put(2, Arrays.asList(1));
		graph.put(3, Arrays.asList());
		graph.put(4, Arrays.asList(6));
		graph.put(5, Arrays.asList(6));
		graph.put(6, Arrays.asList(4,5,7,8));
		graph.put(7, Arrays.asList(6));
		graph.put(8, Arrays.asList(6));
		graph.put(9, Arrays.asList());
		
		return graph;
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
