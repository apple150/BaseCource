package devices.kitchen;

public class MicrowaveOwen extends KitchenDevice {

	private boolean isGrill;
	
	public MicrowaveOwen (String model, String manufacturer, int power, boolean isGrill ) {
		super(model,"Mocrowave Owen",manufacturer,power);
		this.isGrill = isGrill;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" is Grill Present:"+isGrill;
	}
	
}
