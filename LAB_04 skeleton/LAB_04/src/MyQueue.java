import java.util.NoSuchElementException;

public class MyQueue<E> implements Queue<E> {

	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;

	@Override
	public void enqueue(E item) {
		Node<E> oldlast = last;
		last = new Node<>(item,null );
		if (isEmpty()) first = last;
		else oldlast.setNext(last);
		size ++;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) return null;
		E oldfirst = first.getItem();
		first = first.getNext();
		size --;
		if (isEmpty()) last = null;
		return oldfirst;
	}

	@Override
	public E pop() {
		if (isEmpty()) return null;
		Node<E> oldlast = last;
		Node<E> next = first.getNext();
		if (next == null) {
			first = null;
			last = null;
		}
		else {
			while (next.getNext().getItem() != last.getItem()) {
				next = next.getNext();
			}
			next.setNext(null);
			last = next;
		}
		size --;
		return oldlast.getItem();
	}

	@Override
	public void clear() {
//		first.setItem(null);
//		Node<E> next = first.getNext();
//		while (next != last) {
//			next.setItem(null);
//			next = next.getNext();
//		}
//		size =
		first = null;
		last = null;
		size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public String toString() {
		Node<E> cursor = first;
		StringBuffer sb = new StringBuffer("(");
		while (cursor != null) {
			sb.append(cursor.getItem());
			if (cursor != last) {
				sb.append(' ');
			}
			cursor = cursor.getNext();
		}
		sb.append(")");
		return sb.toString();
	}

}
