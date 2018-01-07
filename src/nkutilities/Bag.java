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

import java.util.*;

/**
 * The Class Bag.
 *
 * @param <E> the element type
 * @author Nils Kuttkat
 */
public class Bag<E> extends AbstractSet<E> implements Set<E> {

    /**
     * The Class BagIterator.
     *
     * @author Nils Kuttkat
     */
    private class BagIterator implements Iterator<E> {

        /**
         * The counter.
         */
        int counter = 0;

        /**
         * The key iterator.
         */
        Iterator<E> keyIterator = map.keySet().iterator();

        /**
         * The last.
         */
        E last = null;

        /**
         * The next.
         */
        E next = null;

        /**
         * Instantiates a new bag iterator.
         */
        public BagIterator() {
        }

        /*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return keyIterator.hasNext() || counter > 0;
        }

        ;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
        public E next() {
            if (counter == 0) {
                next = keyIterator.next();
                counter = map.get(next) - 1;
                last = next;
                return next;
            } else {
                counter--;
                return last;
            }
        }

        /*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#remove()
         */
        @Override
        public void remove() {
        }
    ;
    }

	/** The map. */
	private final java.util.HashMap<E, Integer> map;

    ;

	/**
	 * Instantiates a new bag.
	 */
	public Bag() {
        map = new HashMap<>();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#add(java.lang.Object)
     */
    @Override
    public boolean add(E o) {
        return map.put(o, this.occurencesOf(o) + 1) == null;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#addAll(java.util.Collection)
     */
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (Iterator<? extends E> i = collection.iterator(); i.hasNext();) {
            this.add(i.next());
        }

        return true;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#clear()
     */
    @Override
    public void clear() {
        map.clear();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#iterator()
     */
    @Override
    public Iterator<E> iterator() {
        return new BagIterator();
    }

    /**
     * Occurences of.
     *
     * @param o the o
     * @return the int
     */
    public int occurencesOf(E o) {
        Integer value;
        value = map.get(o);
        if (value == null) {
            return 0;
        } else {
            return value;
        }
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#remove(java.lang.Object)
     */
    @Override
    public boolean remove(Object o) {
        return !(map.remove(o) == null);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
     */
    @Override
    public int size() {
        int size = 0;

        for (Iterator<E> i = this.iterator(); i.hasNext();) {
            size += 1;
            i.next();
        }

        return size;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#toString()
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        Iterator<E> iterator = this.iterator();
        buffer.append("Bag(");

        if (iterator.hasNext()) {
            buffer.append(iterator.next());
            while (iterator.hasNext()) {
                Object nextElement = iterator.next();
                buffer.append(",").append(nextElement);
            }
        }

        buffer.append(")");
        return buffer.toString();
    }
}
