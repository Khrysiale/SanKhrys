public class Tuple2<P,Q> implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5287054812869613240L;
	private P first;
	private Q second;
	
	public Tuple2(P first, Q second) {
		this.first = first;
		this.second = second;
	}
	
	public P getFirst() {
		return first;
	}
	
	public Q getSecond() {
		return second;
	}

	public void setFirst(P first) {
		this.first = first;
	}

	public void setSecond(Q second) {
		this.second = second;
	}
	
}