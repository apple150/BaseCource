/**
 * ���������
 */
interface MyIterator {
	Object next();
	boolean hasNext();
}

/**
 * ����� ������
 */
public class MyArray {
	int a [];
	
	public MyArray (int size) { //����������� ������������� �������������� ���-�� ���������
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
	MyIterator Iterator() {  
		return new IntIterator();
	}

	private class IntIterator implements MyIterator {
		int curNum = 0;
		public IntIterator() {} //����������� �� ��������� (����� � �� ����)
		
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
}