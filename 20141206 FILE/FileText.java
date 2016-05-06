/*	
 * 	������� � 30  		FileText
 * 	06.12.2014
 * 	
 * 	������� ���� � �������, ���������, 
 * 	���������� � ������ ���-�� ������ ���������� � ����.
 * 	
 *  � Copyright		Sergey Buglak		(������ ������) 
 *		e-mail:  	Apple150@mail.ru 
*/

import java.io.*;
import java.util.*;
/*
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
*/

public class FileText {

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
			if (c == symbols.charAt(i)) {
				flag = true; break;				
			}
		}
		return flag;
	}

	/**
	 * ������ �� ����� 
	 */	
	public static boolean AnalizNumber(char c) {
		boolean flag=false;
		if (c>='0' && c<='9') flag=true;
		return flag;
	}	
	
	/**
	 * ���������� ��� LinkedList<Integer>
	 */
	static Comparator<Integer> compareLinkedListInteger = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };		
    
	public static void main(String[] args) {
		String NameFile = "readme3.txt";
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader(NameFile)); //��������� ����			
			try {				
				Map <String, Integer> map = new HashMap<String, Integer> (); //�������������� ���������
				List<Integer> linkedList = new LinkedList<Integer>();
				
				int count=0, first=0, countWord=0, countSymbols=0, countAll=0, countProbel=0, countNumber=0, countOther=0, countLetters=0;
				int firstNumb=0, countNumb=0, countZifr=0;
				char c=' ';
				String word="";				
				String res = fr.readLine();
				while (res != null) {
					for (int i=0; i < res.length(); i++) {
						countAll++; //������� ��� �������
						c=res.charAt(i); //����� ������ �� ������						
						if (c==' ') countProbel++; //���� �������
						else if (AnalizSymbols(c)) countSymbols++; //���� ����� ����������
						else if (AnalizNumber(c)) { //���� �����
							countNumber++; //���� �����
							if (firstNumb ==0) firstNumb=i;
							countNumb++; //��� �������� ����� ���������� �� ���������� ����
							if ((i==res.length()-1) || (AnalizNumber(res.charAt(i+1))==false)) {
								i++;
								if (i != res.length()) {
									countAll++;
									if (res.charAt(i)==' ') countProbel++; //���� �������																																							
									else if (AnalizSymbols(res.charAt(i)))  countSymbols++; //���� ����� ����������
									else if (AnalizLetter(res.charAt(i))) {
										countLetters++;
										if (first == 0) first=i;
										count++;
									} else countOther++;
								}
								word=res.substring(i-countNumb, i); countZifr++;
								linkedList.add(Integer.parseInt(word)); //��������� �������� ����� � ������ LinkedList
								firstNumb=0; countNumb=0;
							}
						} else if (AnalizLetter(c)) { //���� ��� �����
							countLetters++;
							if (first == 0) first=i;
							count++;	
							if ((i==res.length()-1) || (AnalizLetter(res.charAt(i+1))==false)) {
								i++; 
								if (i != res.length()) {
									countAll++;
									if (res.charAt(i)==' ') countProbel++; //���� �������								
									else if (AnalizNumber(res.charAt(i))) {
										countNumber++; //���� ����� ��� �������� ����� ���������� �� ���������� ����
										if (firstNumb ==0) firstNumb=i;
									} else if (AnalizSymbols(res.charAt(i)))  countSymbols++; //���� ����� ����������										
									else countOther++;
								}
								word=res.substring(i-count, i); countWord++;
								if (map.containsKey(word)==false) map.put(word, new Integer(1));
								else map.put(word, new Integer(map.get(word)+1));
								first=0; count=0;
							}
						} else countOther++;
					}
					System.out.println(res);
					res = fr.readLine();					
				}
				//����� ������  ��  �������
				System.out.println("\n� ����� - "+NameFile+":"); 
				System.out.println("\t(�������+��������+���.������� (���)) - ("+countProbel+"+"+countSymbols+"+"+countOther+"="+(countProbel+countSymbols+countOther)+")");
				System.out.println("\t(����� / ������� �����) - ("+countNumber+" / "+countZifr+")");
				System.out.println("\t(����� / �����) - ("+countLetters+" / "+countWord+")");
				System.out.println("\t����� ("+countAll+") �������� (���+����+����) - ("+(countProbel+countSymbols+countOther)+"+"+countNumber+"+"+countLetters+"="+(countProbel+countSymbols+countOther+countNumber+countLetters)+")");
				System.out.println("\t(������������ ���� / ����� ����) - ("+map.size()+" / "+countWord+")");
				
				
				if (linkedList.size() > 0) {
					System.out.println("\n������� ������ LINKEDLIST");
					System.out.println("��������� �������� �������:\t"+linkedList+"  - "+linkedList.size()+" ���������");
					int countArray=0;
					Iterator<Integer> iteratorList = linkedList.iterator();
					while(iteratorList.hasNext()) {
						countArray+=iteratorList.next();
					}
					System.out.println("����� ������� �����:\t\t"+countArray);
					
					for (int i=0; i<linkedList.size(); i++) {
						for (int j=i+1; j<linkedList.size(); j++) {
							if (linkedList.get(i) == linkedList.get(j)) { linkedList.remove(j); j--;}
						} 
					}
					
					System.out.println("������ � ������. ����������:\t"+linkedList+"  - "+linkedList.size()+" ���������");
					Collections.sort(linkedList, compareLinkedListInteger);
					System.out.println("��������������� ������:\t\t"+linkedList+"  - "+linkedList.size()+" ���������");
	
					countArray=0;
					iteratorList = linkedList.iterator();
					while(iteratorList.hasNext()) {
						countArray+=iteratorList.next();
					}
					System.out.println("����� ������� �����:\t\t"+countArray);
				} else System.out.println("\n� ������ ����������� ����� !!!");
				
				
				System.out.println("\n������� (��������� �������)  HASHMAP");
				Set<String> keys = map.keySet();  //�������� ����� � ��������� SET
				Iterator<String> iterator = keys.iterator();  //������ �������� �� SET
				while (iterator.hasNext()) {
					String s = iterator.next();
					System.out.println("\t��������/����:  "+map.get(s)+" - "+s);
				}											
				/*
				System.out.println("\n� ����� - "+NameFile+" "+countAll+" ���� ������ �����, �������, ����� ����������");				
				System.out.println("\n� ����� - "+NameFile+" "+countProbel+" ��������");
				System.out.println("� ����� - "+NameFile+" "+countSymbols+" ������ ����������");
				System.out.println("� ����� - "+NameFile+" "+countOther+" ������ ��������");
				System.out.println("\n� ����� - "+NameFile+" "+countLetters+" ����");
				System.out.println("� ����� - "+NameFile+" "+countWord+" ����");		
				System.out.println("\n� ����� - "+NameFile+" "+countNumber+" ����");
				System.out.println("� ����� - "+NameFile+" "+countZifr+" ���� 1-�������, 2-�������, 3-�������");
				System.out.println("\n� ������� HASHMAP - "+map.size()+" ��������������� ��������");
				*/
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
