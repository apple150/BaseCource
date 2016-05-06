
public class DictionaryNew {
	
	/**
	 * �������� ������ �� ����� ������� �.�. �� ����� ���������� 
	 */
	public static boolean Analiz(char s, String symbols) {
		boolean flag=false;
		for (int i=0; i<symbols.length(); i++) {
			if (s==symbols.charAt(i)) {
				flag=true; break;				
			}
		}
		return flag;
	}
	
	/**
	 * �������� ������ ������������ � ���-��� ��� 
	 */
	public static String AccumulationStr(String word, String SummaStr) {
		String temp="";
		String FindWord= "*"+word+"@"; //������� ����� � ��������������� ���������
		int zn= SummaStr.indexOf(FindWord);
		if (zn == -1) {
			temp=SummaStr+FindWord+"1@";
		} else { //� ������ ���������� �� ����� ������� ������
			int kk=zn+FindWord.length(); //�������� ��			
			String ii=SummaStr.charAt(kk)+"";
			int sum=Integer.parseInt(ii);
			sum++;
			ii=sum+"";
			
			temp=SummaStr.substring(0,kk);
			int iZn=SummaStr.indexOf("@",kk);
			int iCount=0;
			if (iZn-kk==1) { //���� ��� ����� 1-� �����				
				String kkk=SummaStr.charAt(kk)+"";				
				iCount=Integer.parseInt(kkk);
				iCount++;
			} else { //���� ��� ����� ������ ��� 1-� �����
				iCount=Integer.valueOf(SummaStr.substring(kk,iZn));
				iCount++;
			}
			if (iCount>0) { //����������� ������ �������� ���-�� ���� � �������� ������
				temp=temp+iCount+"@"+SummaStr.substring(iZn+1);;
			}			
		}
		return temp;
	}
	
	/**
	 * ����� ���������������� ������ � ���-��� ��� ������������ � ������������ ����������
	 */
	public static void PrintAccumulationStr(String SummaStr) {
		if (!SummaStr.isEmpty()) {
			System.out.println(SummaStr+'\n');
			String temp=SummaStr;
			int p=0, n=0, z=0, kolvo=0;			
			String zn="", cnt="";
			String MaxStr="";
			int max=0;
			while(p != -1) {
				p = temp.indexOf('*', p);
				if(p != -1) {
					kolvo++;
					n=temp.indexOf('@', p) ;				
					z=temp.indexOf('@', n+1) ;					
					zn=temp.substring(p+1, n);					
					cnt=temp.substring(n+1, z);
					int intCnt=Integer.parseInt(cnt);
					if (intCnt > max) {
						max=intCnt;
						MaxStr=zn;
					}
					System.out.println(kolvo+". "+zn+" - "+cnt+" ���");
					p=z;
				}
			}
			if (MaxStr.length()==1) System.out.println("\n������������ ����������� ����� - ("+MaxStr+") - "+max+" ���.  ����� - "+kolvo+" ����.");
			else System.out.println("\n������������ ����������� ����� - ("+MaxStr+") - "+max+" ���.  ����� - "+kolvo+" ����.");			
		}		
	}
	
	public static void main(String[] args) {
		String str = ""; 
		str = "  ���������, ������ ��������� ?�, ������ ?���������� !!,.������� .,�������.� �������,. �.����������������, �������!  � ���������, � � � � � � � � � � � � � � �  � ����������������";
		//str = "  ���������, ���� ���������";
		System.out.println(str);
		
		String symbols=" ,.!?;:";	//������� ������� � ����� �� ������
		String word="";
		String SummaStr="";
		int iterator=0, count=0;
		int len=str.length()-1; //������ ������		
		for (int i=0; i <= len; i++) {			
			if (Analiz(str.charAt(i), symbols)) { //���� ��� ���� �� ��������
				if (count > 0) {
					iterator++; word=str.substring(i-count, i); SummaStr=AccumulationStr(word, SummaStr); 					
					count=0;
				}
			} else if (len == i) {
				iterator++;  word=str.substring(i-count, i+1); 	SummaStr=AccumulationStr(word, SummaStr); 			
			} else count++;
		}		
		System.out.println("� ������ - "+iterator+" ����"+'\n');
		PrintAccumulationStr(SummaStr);
				
	}

}
