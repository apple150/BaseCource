import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import devices.Device;
import devices.kitchen.MicrowaveOwen;
import devices.kitchen.Refrigerator;


public class MainDevices {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Device md[] = new Device[3];
		md[0] = new Refrigerator("d4", "Atlant", 900, "red");
		md[1] = new Refrigerator("a4", "Atlant", 700, "while");
		md[2] = new MicrowaveOwen("o3", "LG", 400, true);
		

		//System.currentTimeMillis()
		
		for(int i=0;i<3;i++)
		{
			System.out.println(md[i]);
		}
		
		
		
		
		
		ArrayList<Device>  devices = new ArrayList<Device>();
		String man[] = {"Bosch","LG","Atlant"};
		String color[]={"white","metallic","red","black"};
		
		for(int i=0;i<9;i++)
		{
			int typen = (int)(Math.random()*2);
			int mann = (int)(Math.random()*3);
			int colorn = (int)(Math.random()*4);
			int state = (int)(Math.random()*2);
			if(typen == 0)
			{
				devices.add(new Refrigerator("Model"+i, man[mann], (int)(Math.random()*4+1)*500, color[colorn]));
			}
			else
			{
				devices.add(new MicrowaveOwen("Model"+i, man[mann], (int)(Math.random()*4+1)*200, true));
				
			}
			if(state == 0)
			{
				devices.get(i).off();
			}
			else
			{
				devices.get(i).on();
			}
			
		}
		//StringBuffer
		
		//System.currentTimeMillis()
		
		int p =0;
		for(int i=0;i<devices.size();i++)
		{
			System.out.println(devices.get(i));
			if(devices.get(i).getOn())
			{
				p += devices.get(i).getPower();
			}
		}
		System.out.println("Sum power:"+p);

		
	/*	Iterator<Device> it = devices.iterator();
		
		while(it.hasNext())
		{
			Device d = it.next();
			System.out.println(d);
		}
		
		GregorianCalendar gc = new GregorianCalendar();
		long t1 = gc.getTimeInMillis();
		
		//......
		
		gc = new GregorianCalendar();
		long t2 = gc.getTimeInMillis();
		
		StringBuffer sb = new StringBuffer("Test String");
		
		sb.append(" last");
		
		String s = "Test String";
		s =  s + " last"; 
				
		String st = null;
		
	/*
		List l = new  ArrayList();
		
		l.add("test");
		l.add("test2");
		
		Map m = new HashMap();
		
		m.put("first", "Test value");
		m.put("second", "Test value1");
		m.put("third", "Test value2");
		
		Set k = m.keySet();
		Iterator i = k.iterator();
		while(i.hasNext())
		{
			System.out.println(m.get(i.next()));
		}
		
	//	List<String> ls = new ArrayList<String>();
		
		//System.out.println(m.get("first"));
		
		*/

	}

}
