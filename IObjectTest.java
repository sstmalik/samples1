package codingTest;


/**
 Predicate interface to test if a condition is satisfied 
 This is to be intended in conjuction with the FilteringIterator
 * @author Malik
 *
 * @param <E>
 */
public interface IObjectTest<E> {
	
	/**
	 * returns if the predicate condition is matched 
	 * @param O
	 * @return
	 */
	boolean test(Object O);
}
