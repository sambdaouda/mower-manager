package io.mowitnow.mower.manager;

public class Mower {
	private Position position;
	private Orientation orientation;
	private String instructions;
	
	/**
	 * Contrôler la tondeuse avec les instructions
	 * @param topCorner
	 */
	public void control(Position topCorner) {
		Position pTmp = new Position(this.position.getX(), this.position.getY());
		Orientation oTmp = this.orientation;
		char o;
		
		// Effectuer les instructions correspondant à la tondeuse courante
		for(int i = 0; i < instructions.length(); i++) {
			o = instructions.charAt(i);
			if (o == 'D' || o == 'G') {
				oTmp = pivot(o, oTmp);
			
			} else if (o == 'A') {
				pTmp = move(pTmp, oTmp);
			}
				
		}
		
		// Affection éventuelle des nouvelles valeurs
		if (pTmp.getX() >= 0 && pTmp.getX() <= topCorner.getX() 
				&& pTmp.getY() >= 0 && pTmp.getY() <= topCorner.getY()) {
			this.position.setX(pTmp.getX());
			this.position.setY(pTmp.getY());
			this.orientation = oTmp;
		}
		
		// Affichage de la position finale
		System.out.println(String.format("%d %d %s", this.position.getX(), 
				this.position.getY(), this.orientation));
	}
	
	/**
	 * Pivoter la tondeuse de 90 degrés à droite ou à gauche
	 * @param o
	 * @param orientation
	 * @return
	 */
	public Orientation pivot(char o, Orientation ort) {
		return o == 'D' ? ort.nextElement() : ort.previousElement();
	}
	
	/**
	 * Avancer la tondeuse d'une case dans la direction à laquelle elle fait face
	 * @param position
	 * @param orientaion
	 * @return
	 */
	public Position move(Position ps, Orientation ort) {
		int xTmp = ps.getX();
		int yTmp = ps.getY();
		
		switch(ort) {
			case N:
				yTmp++;
				break;
			
			case E:
				xTmp++;
				break;

			case S:
				yTmp--;
				break;
		
			case W:
				xTmp--;
				break;
				
		default:
			break;
		}
		
		return new Position(xTmp, yTmp);
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
