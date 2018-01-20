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
package nkutilities.graph.test;

import java.util.ArrayList;

import nkutilities.graph.DijkstraPathfinder;
import nkutilities.graph.GraphNode;

/**
 * The Class TestStandardGraph.
 *
 * @author Nils Kuttkat
 */
public class TestStandardGraph {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ArrayList<GraphNode> path = new ArrayList<GraphNode>();
		GraphNode a, b, c, d, e, z, y, x, u;
		Object relation = new Object();
		Object relation1 = new Object();
		DijkstraPathfinder graph = new DijkstraPathfinder();

		a = new TestNode("a");
		b = new TestNode("b");
		c = new TestNode("c");
		d = new TestNode("d");
		e = new TestNode("e");
		z = new TestNode("z");
		y = new TestNode("y");
		x = new TestNode("x");
		u = new TestNode("u");

		a.setEdge(relation, b, 3);
		a.setEdge(relation, c, 1);
		b.setEdge(relation, z, 1);
		c.setEdge(relation, b, 3);
		c.setEdge(relation, y, 1);
		c.setEdge(relation, d, 10);
		c.setEdge(relation, e, 7);
		y.setEdge(relation, u, 1);
		u.setEdge(relation, x, 4);
		x.setEdge(relation, d, 4);
		e.setEdge(relation, d, 2);

		a.setEdge(relation1, b, 3);
		a.setEdge(relation1, c, 1);
		b.setEdge(relation1, z, 1);
		c.setEdge(relation1, b, 1);
		c.setEdge(relation1, y, 1);
		c.setEdge(relation1, d, 10);
		c.setEdge(relation1, e, 7);
		y.setEdge(relation1, u, 1);
		u.setEdge(relation1, x, 4);
		x.setEdge(relation1, d, 4);
		e.setEdge(relation1, d, 2);

		path = graph.findPath(relation, a, x);

		for (GraphNode node : path) {
			System.out.println(node);
		}
		System.out.println();
		System.out.println();

		path = graph.findPath(relation1, a, d);

		for (GraphNode node : path) {
			System.out.println(node);
		}
	}

}
