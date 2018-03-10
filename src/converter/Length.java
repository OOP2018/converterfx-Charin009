package converter;

/**
 * Enum that collect Length unit.
 * @author Charin Tantrakul 
 *
 */
public enum Length {
	MILE(1609.344),
	KILOMETER(1000.0),
	METER(1.0),
	CENTIMETER(0.01),
	FOOT(0.30480),
	WA(2.000),
	AU(149597870700.0);
	
	private final double VALUE;
	
	/**
	 * Constructor of Length enum.
	 * @param value length in meter unit.
	 */
	private Length (double value) {
		this.VALUE = value;
	}
	
	/**
	 * Get value of Length
	 * @return
	 */
	public double getValue() {
		return this.VALUE;
	}
	
}
