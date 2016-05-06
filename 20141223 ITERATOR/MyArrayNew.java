/**
 * ���������
 */
interface MyIteratorNew {
	Object next();
	boolean hasNext();
}

/**
 * ����� ������
 */
public class MyArrayNew {
	int a [];
	
	public MyArrayNew (int size) { //����������� ������������� �������������� ���-�� ���������
		a = new int[size];
	}
	
	int Get (int num) { //���������� �������� ����������� �������� �������
		return a[num];
	}
	
	void Set (int num, int val) { //������������� �������� ����������� �������� �������
		a[num] = val;
	}
	
	int Size() { //���������� ����� ���-�� ��������� � �������
		return a.length;
	}
	
	/**
	 * �������� ������-������� (��������)
	 * ��������� � ����������� ������ 
	 * ������������� ������������ � ����������
	 */
	MyIteratorNew Iterator() {  
		return new MyIteratorNew() {
			int curNum = 0;
			public Object next() {
				if (curNum < a.length) {
					curNum ++;
					return new Integer(a[curNum-1]);					
				} else return null;				
			}
			
			public boolean hasNext() { //�������� �� �� ������ ������� �������� ������ ���-�� ����� �������
				if (curNum < a.length) return true;				
				else return false;				
			}			
		};
	}
	
	/*
	private class IntIteratorNew implements MyIteratorNew {
		int curNum = 0;
		public IntIteratorNew() {} //����������� �� ��������� (����� � �� ����)
		
		public Object next() { //��������� �������� ���������� �������� �������
			if (curNum < a.length) {
				curNum ++;
				return new Integer(a[curNum-1]);
			} else return null;
		}	
		
		public boolean hasNext() { //�������� �� �� ������ ������� �������� ������ ���-�� ����� �������
			if (curNum < a.length) return true;				
			else return false;				
		}
	}
	*/
}