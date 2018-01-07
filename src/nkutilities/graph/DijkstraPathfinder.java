/* 
 * Copyright (C) 2018 Nils Kuttkat <nkuttkat@gmail.com>
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
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * The Class DijkstraPathfinder uses the Dijkstra algorithm for pathfinding.
 * 
 * @author Nils Kuttkat
 */
public class DijkstraPathfinder extends AbstractPathfinder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see util.graph.AbstractGraph#findPath(java.lang.Object,
	 * util.graph.GraphNode, util.graph.GraphNode)
	 */
	@Override
	public ArrayList<GraphNode> findPath(Object object, GraphNode startNode, GraphNode targetNode) {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		GraphNode currentNode = startNode;

		this.clearState();
		this.setDistanceForNode(currentNode, 0);

		// while the current visited node is not the target node...
		while (currentNode != targetNode) {
			HashSet<Edge> edges = currentNode.getEdgesFor(object);
			double currentDistance = this.getDistanceForNode(currentNode);

			this.setNodeVisited(currentNode, true);

			// take a look at all the neighbors of currentNode
			for (Edge edge : edges) {
				GraphNode neighbor = edge.getNode();

				if (!this.isNodeVisited(neighbor)) {
					double distanceToNeighbor = edge.getWeight();

					// set the neighbors distance if it is smaller than the current distance
					if (this.getDistanceForNode(neighbor) > currentDistance	+ distanceToNeighbor) {
						this.setDistanceForNode(neighbor, currentDistance + distanceToNeighbor);
						this.setPredecessorForNode(neighbor, currentNode);
						// associate the neighbor to the new distance (using a temporary Edge) and
						// put it into a PriorityQueue
						queue.add(new Edge(neighbor, currentDistance + distanceToNeighbor));
					}
				}
			}

			if (!queue.isEmpty()) {
				currentNode = queue.remove().getNode();
			} else {
				break;
			}
		}

		return this.getPath(targetNode);
	}

	/**
	 * Gets the path.
	 * 
	 * @param targetNode
	 *            the target node
	 * @return the path
	 */
	protected ArrayList<GraphNode> getPath(GraphNode targetNode) {
		ArrayList<GraphNode> path = new ArrayList<GraphNode>();
		GraphNode node = targetNode;

		if (this.getDistanceForNode(targetNode) < Double.POSITIVE_INFINITY) {

			while (node != null) {
				path.add(0, node); // add at the beginning (similar to a Stack)
				node = this.getPredecessorForNode(node);
			}
		}

		return path;
	}

}
