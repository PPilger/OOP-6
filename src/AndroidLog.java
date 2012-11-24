import java.util.*;

/**
 * A class which contains the log of an Android's lifespan. Its mandatory to use
 * addIfValid instead of add, other methods which manipulate the List in another
 * mannor than adding elements at the end, are without impact on the list (e.g.
 * removeFirst() returns an element without removing).
 * 
 * @author Koegler Alexander
 * 
 */
public class AndroidLog extends LinkedList<Android> {
	private static final long serialVersionUID = 1L;
	private int androidID;
	private Android addIt = null;
	private final AndroidLog itsMe = this;

	/**
	 * Adds an Android's configuration to its log-history If AndroidLog is empty
	 * it's added as first element, else the new Android's configuration is
	 * validated with the first configuration of itself.
	 * 
	 * @param e
	 *            new Android/configuration
	 * @return error() if configuration is not valid, else valid()
	 */
	public ValidationCode addIfValid(Android e) {
		// if this is the first element added to the list, the androidID will be
		// set
		if (peekFirst() == null) {
			androidID = e.getSerialNum();
			super.add(e);
			return new Valid();
		} else {
			// need to be as valid as the first Android
			ValidationCode vc = e.validate(peekFirst());

			// if valid add to list
			addIt = e;
			vc.executeIfValid(new AddTo());
			addIt = null;
			return vc;
		}
	}

	private class AddTo implements ValidationCode.Operation {
		@Override
		public void execute() {
			if (addIt != null) {
				itsMe.add(addIt);
			}
		}
	}

	@Override
	public boolean add(Android e) {
		return false;
	}

	// Overwritten following methods, which may not change the log in contrast
	// to the implementation of super class

	@Override
	public void add(int index, Android element) {
		// not allowed to corrupt log of an android's life
	}

	@Override
	public boolean addAll(Collection<? extends Android> c) {
		return false;
		// not allowed to corrupt log of an android's life
	}

	@Override
	public boolean addAll(int index, Collection<? extends Android> c) {
		return false;
		// not allowed to corrupt log of an android's life
	}

	@Override
	public void addFirst(Android e) {
		// not allowed to corrupt log of an android's life
	}

	@Override
	public void clear() {
		// not allowed to corrupt log of an android's life
	}

	@Override
	public void push(Android e) {
		// not allowed to corrupt log of an android's life
	}

	@Override
	public Android pop() {
		// not allowed to corrupt log of an android's life
		return super.getFirst();
	}

	@Override
	public Android remove(int index) {
		return super.get(index);
		// not allowed to corrupt log of an android's life
	}

	@Override
	public Android remove() {
		return super.getFirst();
		// not allowed to corrupt log of an android's life
	}

	@Override
	public boolean remove(Object o) {
		return false;
		// / not allowed to corrupt log of an android's life
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
		// not allowed to corrupt log of an android's life
	}

	@Override
	public Android removeFirst() {
		return super.getFirst();
		// not allowed to corrupt log of an android's life
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		return false;
		// not allowed to corrupt log of an android's life
	}

	@Override
	public Android removeLast() {
		return super.getLast();
		// not allowed to corrupt log of an android's life
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		return false;
		// not allowed to corrupt log of an android's life
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		// not allowed to corrupt log of an android's life
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
		// not allowed to corrupt log of an android's life
	}

	@Override
	public boolean offerFirst(Android e) {
		return false;
		// not allowed to corrupt log of an android's life
	}

	@Override
	public Android pollFirst() {
		return super.getFirst();
		// not allowed to corrupt log of an android's life
	}

	@Override
	public Android poll() {
		return super.getFirst();
		// not allowed to corrupt log of an android's life
	}

	@Override
	public Android pollLast() {
		return super.getLast();
		// not allowed to corrupt log of an android's life
	}

	@Override
	public Android set(int index, Android element) {
		return super.get(index);
		// not allowed to corrupt log of an android's life
	}

}
