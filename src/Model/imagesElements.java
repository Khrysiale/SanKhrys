package Model;

public class imagesElements extends Elements implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8004412123951782438L;
	
	/**
	 * Importation de l'image à l'appel de la classe
	 * doit obtenir les parametres d'en-tête de l'image, ainsi que son format
	 * 
	 * 
	 */
	
	private int width;
	private int height;
	private int id;
	private String format;
	
	

	/**
	 * 
	 * constructeur par défaut
	 * on importe l'image ici
	 */
	
	void imagesElements(){
		System.out.println("CREATION  DE L'IMAGE ICI");
	}
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
