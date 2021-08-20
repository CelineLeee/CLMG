
public class MyQueue<E> implements Queue<E> {

	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;

	@Override
	public void enqueue(E item) {
		// TODO Auto-generated method stub

	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void clear() {

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
