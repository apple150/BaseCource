package devices;

public abstract class Device {
	protected boolean isOn;
	protected int power;
	protected String manufacturer;
	protected String type;
	protected String model;
	
	public void on()
	{
		isOn = true;
	}
	public void off()
	{
		isOn = false;
	}
	
	public boolean getOn()
	{
		return isOn;
	}
	public int getPower() {
		return power;
	}

	public Device(String model,String type, String manufacturer, int power ) {
		isOn = false;
		this.model = model;
		this.type = type;
		this.manufacturer = manufacturer;
		this.power = power;
	}

	@Override
	public synchronized String toString() {
		return "Type:"+type+" Model:"+ model+" Manufacturer:"+manufacturer+"Power:"+power+" is On:"+isOn;
	}



}
