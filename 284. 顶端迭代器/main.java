// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> que;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    que = new LinkedList<>();
        while (iterator.hasNext()) 
            que.offer(iterator.next());
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (que.isEmpty()) return null;
        return que.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (que.isEmpty()) return null;
	    return que.poll();
	}

	@Override
	public boolean hasNext() {
	    return !que.isEmpty();
	}
}