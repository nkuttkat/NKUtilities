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
package nkutilities.math;

/**
 *
 * @author Nils Kuttkat
 */
public class Vector2D {

    double a, b;

    public Vector2D(double a, double b) {
        this.setA(a);
        this.setB(b);
    }

    public Vector2D() {
        this(0, 0);
    }

    public final void setA(double a) {
        this.a = a;
    }

    public final void setB(double b) {
        this.b = b;
    }

    public final double getA() {
        return a;
    }

    public final double getB() {
        return b;
    }

    public void multiply(double factor) {
        this.setA(a * factor);
        this.setB(b * factor);
    }

    public Vector2D add(Vector2D vector) {
        return new Vector2D(a + vector.getA(), b + vector.getB());
    }
}
