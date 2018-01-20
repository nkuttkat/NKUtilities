/* 
 * Copyright (C) 2018 Nils Kuttkat<nkuttkat@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nkutilities.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The Class AbstractGraph maintains Node states during pathfinding operations.
 * The algorithm used for pathfinding must be implemented by subclasses by
 * overriding the {@code findPath} method.
 *
 * @author Nils Kuttkat
 */
public abstract class AbstractPathfinder {

    /**
     * The Class NodeState is an internal class that stores a node's state
     * during pathfinding operations.
     *
     * @author Nils Kuttkat
     */
    private class NodeState implements Comparable<NodeState> {

        /**
         * The current distance to the start node.
         */
        private double distance;

        /**
         * The current predecessor.
         */
        private GraphNode predecessor;

        /**
         * Denotes if the node was already visited.
         */
        private boolean visited;

        /**
         * Instantiates a new node state.
         */
        private NodeState() {
            this.visited = false;
            this.distance = Double.POSITIVE_INFINITY;
        }

        /*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(NodeState state) {
            int returnValue = 0;

            if (this.getDistance() < state.getDistance()) {
                returnValue = -1;
            } else if (this.getDistance() > state.getDistance()) {
                returnValue = 1;
            }

            return returnValue;
        }

        /**
         * Gets the current distance.
         *
         * @return the distance
         */
        public double getDistance() {
            return distance;
        }

        /**
         * Gets the current predecessor.
         *
         * @return the predecessor
         */
        public GraphNode getPredecessor() {
            return predecessor;
        }

        /**
         * Checks if the associated node is visited.
         *
         * @return true, if is visited
         */
        public boolean isVisited() {
            return visited;
        }

        /**
         * Sets the distance.
         *
         * @param distance the new distance
         */
        public void setDistance(double distance) {
            this.distance = distance;
        }

        /**
         * Sets the predecessor.
         *
         * @param predecessor the new predecessor
         */
        public void setPredecessor(GraphNode predecessor) {
            this.predecessor = predecessor;
        }

        /**
         * Sets the associated node visited.
         *
         * @param visited the new visited
         */
        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    /**
     * The state map associates nodes to node states.
     */
    private HashMap<GraphNode, NodeState> stateMap;

    /**
     * Instantiates a new graph.
     */
    public AbstractPathfinder() {
        this.stateMap = new HashMap<GraphNode, NodeState>();
    }

    /**
     * Clear all node states.
     */
    public void clearState() {
        this.stateMap.clear();
    }

    /**
     * Find path.
     *
     * @param object The object whose edges will be considered
     * @param startNode the start node
     * @param targetNode the target node
     * @return the calculated path
     */
    public abstract ArrayList<GraphNode> findPath(Object object,
            GraphNode startNode, GraphNode targetNode);

    /**
     * Find path.
     *
     * @param object the object
     * @param startNode the start node
     * @param targetNode the target node
     * @param maxDistance the max distance
     * @return the array list
     */
    public ArrayList<GraphNode> findPath(Object object,
            GraphNode startNode,
            GraphNode targetNode,
            double maxDistance) {
        ArrayList<GraphNode> path, newPath = new ArrayList<GraphNode>();
        path = this.findPath(object, startNode, targetNode);

        for (GraphNode node : path) {
            if (this.getDistanceForNode(node) <= maxDistance) {
                newPath.add(node);
            } else {
                break;
            }
        }

        return newPath;
    }

    /**
     * Gets the distance for node.
     *
     * @param node the node
     * @return The distance to the start node
     */
    public double getDistanceForNode(GraphNode node) {
        double distance = Double.POSITIVE_INFINITY;

        if (this.stateMap.containsKey(node)) {
            distance = this.stateMap.get(node).getDistance();
        }

        return distance;
    }

    /**
     * Gets the distance map.
     *
     * @return the distance map
     */
    public HashMap<GraphNode, NodeState> getDistanceMap() {
        return stateMap;
    }

    /**
     * Gets the last reachable node.
     *
     * @param path the path
     * @param maxDistance the max distance
     * @return the last reachable node
     */
    public GraphNode getLastReachableNode(ArrayList<GraphNode> path, double maxDistance) {
        GraphNode node = null;

        return node;
    }

    /**
     * Gets the predecessor for node.
     *
     * @param node the node
     * @return the predecessor for node
     */
    public GraphNode getPredecessorForNode(GraphNode node) {
        GraphNode predecessor = null;

        if (this.stateMap.containsKey(node)) {
            predecessor = this.stateMap.get(node).getPredecessor();
        }

        return predecessor;
    }

    /**
     * Gets the reachable nodes.
     *
     * @param distance the distance
     * @return the reachable nodes
     */
    public HashSet<GraphNode> getReachableNodes(double distance) {
        HashSet<GraphNode> reachableNodes = new HashSet<GraphNode>();

        for (GraphNode node : this.stateMap.keySet()) {
            if (this.getDistanceForNode(node) < distance) {
                reachableNodes.add(node);
            }
        }

        return reachableNodes;
    }

    /**
     * Gets the state map.
     *
     * @return the state map
     */
    public HashMap<GraphNode, NodeState> getStateMap() {
        return stateMap;
    }

    /**
     * Checks if is node visited.
     *
     * @param node the node
     * @return true, if is node visited
     */
    public boolean isNodeVisited(GraphNode node) {
        boolean isVisited = false;

        if (this.stateMap.containsKey(node)) {
            isVisited = this.stateMap.get(node).isVisited();
        }

        return isVisited;
    }

    /**
     * Sets the distance for node.
     *
     * @param node the node
     * @param distance the distance
     */
    public void setDistanceForNode(GraphNode node, double distance) {
        if (!this.stateMap.containsKey(node)) {
            this.stateMap.put(node, new NodeState());
        }

        this.stateMap.get(node).setDistance(distance);
    }

    /**
     * Sets the node visited.
     *
     * @param node the node
     * @param visited the visited
     */
    public void setNodeVisited(GraphNode node, boolean visited) {
        if (!this.stateMap.containsKey(node)) {
            this.stateMap.put(node, new NodeState());
        }

        this.stateMap.get(node).setVisited(visited);
    }

    /**
     * Sets the predecessor for node.
     *
     * @param node the node
     * @param predecessor the predecessor
     */
    public void setPredecessorForNode(GraphNode node, GraphNode predecessor) {
        if (!this.stateMap.containsKey(node)) {
            this.stateMap.put(node, new NodeState());
        }

        this.stateMap.get(node).setPredecessor(predecessor);
    }
}
