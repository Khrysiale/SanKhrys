public class Vec2 implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3530913255487168455L;
	/**
	 * 
	 */
	
	public float x;
	public float y;
	
	public Vec2 copy() {
		return new Vec2(this.x,this.y);
	}
	
	public Vec2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2 add(Vec2 v) {
		this.x += v.x;
		this.y += v.y;
		return this;
	}
	
	public Vec2 sub(Vec2 v) {
		this.x -= v.x;
		this.y -= v.y;
		return this;
	}
	
	public Vec2 mul(float scalar) {
		this.x *= scalar;
		this.y *= scalar;
		return this;
	}
	
	public float distanceSq(Vec2 p) {
		return (p.x-x) * (p.x-x) + (p.y-y) * (p.y-y);
	}
	
	public float distance(Vec2 p) {
		return (float) Math.sqrt(distanceSq(p));
	}
	
	public Vec2 rotate(float rad) {
		float x_ = x;
		float y_ = y;
		this.x = (float) (x_*Math.cos(rad) + y_*Math.sin(rad));
		this.y = (float) (-x_*Math.sin(rad) + y_*Math.cos(rad));
		return this;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	
	public Vec2 round() {
		x = Math.round(x);
		y = Math.round(y);
		return this;
	}
	
	public boolean equals(Vec2 v) {
		return Math.abs(x-v.x) < 0.01f && Math.abs(y-v.y) < 0.01f;
	}
}