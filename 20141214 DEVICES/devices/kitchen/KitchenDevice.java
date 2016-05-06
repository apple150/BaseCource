package devices.kitchen;

import devices.Device;

public abstract class KitchenDevice extends Device {
	public KitchenDevice(String model,String type, String manufacturer, int power ) {
		super(model,type,manufacturer,power);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Category: Kitchen "+super.toString();
	}

}
