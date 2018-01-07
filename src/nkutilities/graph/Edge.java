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

/**
 * The Class Edge points to a {@link GraphNode} considering a specific weight.
 * Edges will be used for pathfinding algorithms.
 *
 * @author Nils Kuttkat
 */
public class Edge implements Comparable<Edge> {

	/** The node the edge is pointing at. */
	private GraphNode node;

	/** The weight or rather distance of this edge. */
	private double weight;

	/**
	 * Instantiates a new edge.
	 * 
	 * @param node
	 *            the node
	 * @param weight
	 *            the weight
	 */
	public Edge(GraphNode node, double weight) {
		this.node = node;
		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Edge edge) {
		int returnValue = 0;

		if (this.getWeight() < edge.getWeight()) {
			returnValue = -1;
		} else if (this.getWeight() > edge.getWeight()) {
			returnValue = 1;
		}

		return returnValue;
	}

	/**
	 * Two Edges are considered as equal if they point at the same node. This
	 * ensures that there can only be one edge at a time associated to an object
	 * pointing at a particular node. The egdes are stored in a {@link HashSet}.
	 *
	 * @param object the object
	 * @return equals returns equal if both edges point at the same node
	 */
	@Override
	public boolean equals(Object object) {
		boolean equals = false;
		Edge edge = (Edge) object;

		if (edge == this) {
			equals = true;
		} else if (object instanceof Edge) {
			equals = edge.getNode() == this.getNode();
		}

		return equals;
	}

	/**
	 * Gets the node the edge is pointig at.
	 * 
	 * @return the node
	 */
	public GraphNode getNode() {
		return node;
	}

	/**
	 * Gets the weight of this edge.
	 * 
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Two Edges pointing at the same node will return the same hash code. This
	 * method is overridden to ensure that the {@link #equals(Object) equals}
	 * method is called.
	 * 
	 * @return the node's hash code the edge is pointing at
	 */
	@Override
	public int hashCode() {
		return node.hashCode();
	}

	/**
	 * Sets the node the edge is pointing at.
	 *
	 * @param node the new node
	 */
	public void setNode(GraphNode node) {
		this.node = node;
	}

	/**
	 * Sets the weight of this edge.
	 * 
	 * @param weight
	 *            the new weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
