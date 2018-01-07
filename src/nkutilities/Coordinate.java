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
package nkutilities;

import java.io.Serializable;

/**
 * The Class Coordinate.
 *
 * @author Nils Kuttkat
 */
public class Coordinate implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6195811232944223107L;
	
	/** The y. */
	protected int x, y;

	/**
	 * Instantiates a new coordinate.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Equals.
	 *
	 * @param coordinate the coordinate
	 * @return true, if successful
	 */
	public boolean equals(Coordinate coordinate) {
		boolean equals = false;

		if (coordinate != null) {
			equals = this.getX() == coordinate.getX()
					&& this.getY() == coordinate.getY();
		}

		return equals;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	/**
	 * Translate.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the coordinate
	 */
	public Coordinate translate(int x, int y) {
		return new Coordinate(this.x + x, this.y + y);
	}
}
