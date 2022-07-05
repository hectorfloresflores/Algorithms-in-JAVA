package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    boolean[] cycle = new boolean[1];
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
        return !cycle[0];
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
        cache[row] = true;
        visited[row] = false;
    }

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        System.out.println(c.canFinish(2, new int[][]{{1,0},{0,1}}
           ));
    }
}
