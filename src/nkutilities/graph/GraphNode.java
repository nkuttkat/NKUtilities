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

import java.util.HashMap;
import java.util.HashSet;

/**
 * The Class GraphNode defines methods to connect nodes to each other.
 *
 * @author Nils Kuttkat
 */
public class GraphNode {

	/** The edges of this node. */
	private HashMap<Object, HashSet<Edge>> edges;

	/**
	 * Instantiates a new node.
	 */
	public GraphNode() {
		this.edges = new HashMap<Object, HashSet<Edge>>();
	}

	/**
	 * Gets the edges.
	 * 
	 * @return the edges
	 */
	public HashMap<Object, HashSet<Edge>> getEdges() {
		return this.edges;
	}

	/**
	 * Gets the edges associated to the given object.
	 * 
	 * @param object
	 *            The object whose edges will be considered
	 * @return A set of edges associated to the given object
	 */
	public HashSet<Edge> getEdgesFor(Object object) {
		HashSet<Edge> edges = new HashSet<Edge>();

		if (this.edges.containsKey(object)) {
			edges = this.edges.get(object);
		}

		return edges;
	}

	/**
	 * Checks if this node is connected to other nodes.
	 * 
	 * @return true, if this node is connected to others
	 */
	public boolean hasEdges() {
		return !this.edges.isEmpty();
	}

	/**
	 * Checks if this node has edges associated to the given object.
	 * 
	 * @param object
	 *            The object whose edges will be considered
	 * @return true, if this node is connected to others
	 */
	public boolean hasEdges(Object object) {
		return !this.edges.isEmpty() && this.edges.containsKey(object);
	}

	/**
	 * Removes all edges associated to the given object.
	 * 
	 * @param object
	 *            The object whose edges will be considered
	 */
	public void removeEdges(Object object) {
		this.edges.remove(object);
	}

	/**
	 * Sets an edge associated to the given object. If there is already an edge
	 * pointing at the same node as the given edge this method will replace the
	 * existing edge.
	 * 
	 * @param object
	 *            The object whose edges will be considered
	 * @param edge
	 *            the edge
	 */
	public void setEdge(Object object, Edge edge) {
		if (!this.edges.containsKey(object)) {
			this.edges.put(object, new HashSet<Edge>());
		}

		// remove the edge first if there is already a node pointing at the same
		// node as edge
		if (this.edges.get(object).contains(edge)) {
			this.edges.get(object).remove(edge);
		}

		this.edges.get(object).add(edge);
	}

	/**
	 * Sets an edge associated to the given object.
	 * 
	 * @param object
	 *            The object whose edges will be considered
	 * @param node
	 *            The node the edge is pointing at
	 */
	public void setEdge(Object object, GraphNode node) {
		this.setEdge(object, node, 1.0);
	}

	/**
	 * Sets an edge associated to the given object.
	 * 
	 * @param object
	 *            The object whose edges will be considered
	 * @param node
	 *            The node the edge is pointing at
	 * @param weight
	 *            The weight
	 */
	public void setEdge(Object object, GraphNode node, java.lang.Double weight) {
		Edge edge;

		if (weight == null) {
			weight = 1.0;
		}

		edge = new Edge(node, weight);
		this.setEdge(object, edge);
	}

	/**
	 * Sets an edge associated to the given object.
	 * 
	 * @param object
	 *            The object whose edges will be considered
	 * @param node
	 *            The node the edge is pointing at
	 * @param weight
	 *            The weight
	 */
	public void setEdge(Object object, GraphNode node, java.lang.Integer weight) {
		this.setEdge(object, node, weight.doubleValue());
	}
}
