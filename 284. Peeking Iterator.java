// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer             peek = null;
    private Iterator<Integer>   iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
        if ( iter.hasNext() )
            peek = iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer next = peek;
        if ( iter.hasNext() ) 
            peek = iter.next();
        else 
            peek = null;
        return next;
	}

	@Override
	public boolean hasNext() {
        return peek != null;
	}
}
