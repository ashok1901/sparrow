package com.sparrow.algoSolutions.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FinisCourses {
private boolean canFinishAll(int numCourses, Map<Integer, Set<Integer>> dependencies) {
        
        int[] courses = new int[numCourses];
        for (int i = 0; i<numCourses; i++) {
            if (!dependencies.containsKey(i)) {
                courses[i] = 1;
            }
        }
        
        for (int i = 0; i<numCourses; i++) {
            if (courses[i] == 1) {
                continue;
            }
            
            boolean isDone = false;
            List<Integer> chain = new LinkedList<Integer>();
            chain.add(i);
            int chainIndex = 0;
            Set<Integer> dependencySet = new HashSet<Integer>();
            dependencySet.add(i);
            while(true) {
            	if (chainIndex >= chain.size()) {
            		break;
            	}
            	Integer curCourse = chain.get(chainIndex);
                if (curCourse != null && courses[curCourse] == 0 && dependencies.containsKey(curCourse)) 
                {
                	Set<Integer> dependents = dependencies.get(curCourse);
                    for (int d : dependents) {
                    	if (dependencySet.contains(d)) {
                    		// Cycle
                    		return false;
                    	}
                    	if (!dependencies.containsKey(d)) {
                    	    courses[d] = 1;
                    	} else {
                    	    dependencySet.add(d);
                    	}
                    }
                    chain.addAll(dependents);
                }

                ++chainIndex;
            }
            
            for (int c : dependencySet) {
                courses[c] = 1;
            }
        }
        
        for (int i = 0; i<numCourses; i++) {
            if (courses[i] == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> dep = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
        	int child = prerequisites[i][0];
        	int father = prerequisites[i][1];
        	if (!dep.containsKey(child)) {
        		dep.put(child, new HashSet<Integer>());
        	}
        	
            dep.get(child).add(father);
        }
        
        return canFinishAll(numCourses, dep);
    }
    
    public static void main(String[] args) {
    	//4, [[0,1],[3,1],[1,3],[3,2]]
    	// 3, [[0,1],[0,2],[1,2]]
    	//8, [[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]
    	int courses = 8;
		int[][] dep = new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
		System.out.println(new FinisCourses().canFinish(courses, dep));
	}
}
