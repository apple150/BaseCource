/*	
 * 	������� � 30  		CountWords
 * 	06.12.2014
 * 	
 * 	������� ���� � �������, ���������, 
 * 	���������� � ������ ���-�� ������ ���������� � ����.
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountWords {

	/**
	 * �������� ������ �� ����� ������� �.�. �� ����� ���������� 
	 */
	public static boolean AnalizLetter(char c) {
		boolean flag=false;
		if ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='�' && c<='�') || (c>='�' && c<='�')) flag=true;
		return flag;
	}
	
	/**
	 * ������ �� ���� ���������� 
	 */	
	public static boolean AnalizSymbols(char c) {
		String symbols=",.!?;:";  //������� ����� ����� ASCII ��� 32 � 44 (44 �������, 32 �� �������, �� � Internet ��� ������ 32)
		boolean flag=false;
		for (int i=0; i < symbols.length(); i++) {
			//System.out.println("c-"+c+" ASCI-"+(int)c+"   -   "+symbols.charAt(i)+" "+(int)symbols.charAt(i)+"  i-"+i);
			if (c == symbols.charAt(i)) {
				flag = true; break;				
			}
		}
		return flag;
	}	
	
	public static void main(String[] args) {
		String NameFile = "readme.txt";
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader(NameFile));
			try {
				Map <String, Integer> map = new HashMap<String, Integer> ();
				
				int count=0, first=0, countWord=0, countSymbols=0, countAll=0, countProbel=0, smvl=0;
				String word="";
				String res = fr.readLine();
				while (res != null) {							
					smvl=res.length();
					for (int i=0; i < res.length(); i++) {
						countAll++; //������� ��� �������
						System.out.println(res.charAt(i)+" "+(int)res.charAt(i));
						if ((int)res.charAt(i)==32) {
							countProbel++;
							System.out.println(res.charAt(i)+" "+(int)res.charAt(i)+"  i-"+i);
						} else if (AnalizSymbols(res.charAt(i))) {						
							countSymbols++;
							//System.out.println(res.charAt(i)+" "+(int)res.charAt(i)+"  i-"+i);
						} else if (AnalizLetter(res.charAt(i))) { //���� ��� �����
							if (first == 0) first=i;
							count++;	
							if ((i==res.length()-1) || (AnalizLetter(res.charAt(i+1))==false)) {
								i++; countAll++;
								word=res.substring(i-count, i); countWord++;
								//System.out.println("����� - "+word);
								//int value = map.get(word);
								if (map.containsKey(word)==false) map.put(word, new Integer(1));					
								else map.put(word, new Integer(map.get(word)+1));								
								first=0; count=0;	
							}
						} 
					}							
					System.out.println(res);
					//System.out.println("� ����� - "+NameFile+" "+countSymbols+" ������ ����������");
					res = fr.readLine();
				}
				
				/*
				System.out.println("\n�������  ���������");
				Set<String> keys = map.keySet();  //�������� ����� � ��������� SET
				Iterator<String> iterator = keys.iterator();  //������ �������� �� SET
				while (iterator.hasNext()) {
					String s = iterator.next();
					System.out.println("��������/����:  "+map.get(s)+" - "+s);
				}
				*/
				System.out.println("\n� ����� - "+NameFile+" "+countAll+" ���� ������ �����, �������, ����� ����������");
				System.out.println("������ ����� "+NameFile+" �������� "+smvl+" ���� ��������");
				System.out.println("� ����� - "+NameFile+" "+countProbel+" ��������");
				System.out.println("� ����� - "+NameFile+" "+countSymbols+" ������ ����������");
				System.out.println("� ����� - "+NameFile+" "+countWord+" ����");		
				System.out.println("� ������� HASHMAP - "+map.size()+" ��������������� ��������");				
			} catch (Exception e) {
				System.out.println("�������� � ������� ����� "+NameFile);
			}
		} catch (FileNotFoundException e) {
			System.out.println("���� "+NameFile+" �����������");
		} finally {
			try {
				fr.close();
			} catch (Exception e) {
				System.out.println("��� ����������� ������� ���� "+NameFile);
			}
		}		
	}
}
