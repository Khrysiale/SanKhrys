
/**
 * Classe qui represente les transformations applicables sur les objets.
 * TODO: Devrait probablement utiliser des matrices.
 */
public class Transform implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3266403340042405082L;
	private float scale;
	private float rotate;
	private Vec2 translate;
	
	public Transform() {
		this.scale = 1.0f;
		this.rotate = 0.0f;
		this.translate = new Vec2(0.0f, 0.0f);
	}
	
	public Transform(float scale) {
		this();
		this.scale = scale;
	}
	
	public Transform(float scale, float rotate) {
		this();
		this.scale = scale;
		this.rotate = rotate;
	}

	public Transform(float scale, float rotate, Vec2 translate) {
		this.scale = scale;
		this.rotate = rotate;
		this.translate = translate;
	}
	
	public void apply(Transform tr) {
		this.scale *= tr.getScale();
		this.rotate += tr.getRotate();
		this.translate.add(tr.getTranslate());
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public float getRotate() {
		return rotate;
	}

	public void setRotate(float rotate) {
		this.rotate = rotate;
	}

	public Vec2 getTranslate() {
		return translate;
	}

	public void setTranslate(Vec2 translate) {
		this.translate = translate;
	}
	
	public void scale(float scaleFactor) {
		this.scale *= scaleFactor;
	}
	
	public void rotate(float angle) {
		this.rotate += angle;
	}
	
	public void translate(Vec2 v) {
		this.translate.add(v);
	}
}