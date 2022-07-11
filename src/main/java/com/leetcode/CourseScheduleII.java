package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] cycle = new boolean[1];
    public int[] canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new LinkedList<>());
        }
        //1 will be fill the grpah connections and 2 will be visited
        //Fill the visited matrix with the graph connections
        for (int[] course : prerequisites) {
            graph.get(course[0]).add(course[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] hasCycle = new boolean[numCourses];
        for (int row = 0; row < graph.size(); row++) {
            if (!cycle[0]) {
                //boolean[] visited = new boolean[numCourses];
                dfs(graph, row, visited, hasCycle);
                continue;
            }
            break;
        }
        //If there it is a cycle return false because it can not be possible
        return cycle[0] ? new int[0] : queue.stream().mapToInt(Integer::intValue).toArray();
    }

    void dfs(List<List<Integer>> graph, int row, boolean[] visited, boolean[] cache) {
        if (cycle[0] || visited[row]){
            cycle[0] = true;
            return;

        }
        if (cache[row]) {
            return;
        }

        visited[row] = true;
        for (Integer depend : graph.get(row)) {
            // visited[row] = true;
            System.out.println("row " + row + "col " + depend);
            //visited[row] = false;
            dfs(graph, depend, visited, cache);
        }
        queue.add(row);
        cache[row] = true;
        visited[row] = false;
    }


    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
        System.out.println(c.canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}
        ));
    }
}
