package devices.kitchen;

public class Refrigerator extends KitchenDevice {

	private String color;
	
	public Refrigerator(String model, String manufacturer, int power, String color ) {
		super(model,"Refrigerator",manufacturer,power);
		this.color = color;
	}
	@Override
	public String toString() {
	
		return super.toString()+ " Color:"+color;
	}
	
}
