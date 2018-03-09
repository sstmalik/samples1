
package codingTest;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * 
 * Coding Test program for Pimco. This iterator decorates the underlying
 * iterator, only allowing through those elements that match the specified
 * {@link Predicate Predicate}.
 * 
 * @author Malik
 */
public class FilteringIterator<E> implements Iterator<E> {

	// underlying iterator instance.
	private Iterator<? extends E> iterator;
	// predicate
	private IObjectTest<E> filterTester;

	// The next object in the iteration
	private E nextObject;
	// Whether the next object has been calculated yet
	private boolean nextObjectSet = false;

	/**
	 * @param iterator
	 * @param filter
	 *            Constructor Takes an underlying Iterator and the filter tester
	 */
	/**
	 * @param iterator
	 * @param filter
	 */
	public FilteringIterator(Iterator<E> iterator, IObjectTest<E> filter) {
		super();
		this.iterator = iterator;
		this.filterTester = filter;

	}

	/**
	 * Returns true if the underlying iterator contains an object that matches
	 * the predicate.
	 * 
	 * @return if another element satisfying predicate exists
	 */
	@Override
	public boolean hasNext() {
		return nextObjectSet || setNextObject();
	}

	/**
	 * return the next object which matches the given predicate throws
	 * NullPointerException if either the iterator or predicate are null
	 * 
	 * @return next item in the filtering iterator that satisfies predicate
	 */
	@Override
	public E next() {
		if (!nextObjectSet) {
			if (!setNextObject()) {
				throw new NoSuchElementException();
			}
		}
		nextObjectSet = false;
		return nextObject;
	}

	/**
	 * Sets nextObject to the next object that matches the test condition . If
	 * there are no objects tha match test cocndition then return false else
	 * return true.
	 * 
	 * @return next predicate in iterator
	 */
	private boolean setNextObject() {
		while (iterator.hasNext()) {
			final E object = iterator.next();
			if (filterTester.test(object)) {
				nextObject = object;
				nextObjectSet = true;
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes from the underlying collection of the base iterator the last
	 * element returned by this iterator. This method can only be called if
	 * next() was called, but not after hasNext(), because the hasNext() call
	 * changes the base iterator.
	 * 
	 * @throws IllegalStateException
	 *             if hasNext() has already been called.
	 */
	@Override
	public void remove() {
		if (nextObjectSet) {
			throw new IllegalStateException("remove() cannot be called");
		}
		iterator.remove();
	}

}
