package data_structure.linked_list;

import java.util.Iterator;

public class SequenceList<T> implements Iterable <T> {
	private T[] eles;
	private int N;
	public SequenceList (int caqacity){
		eles = (T[]) new Object [caqacity];
		N = 0;
		}
	public void clear(){
		N=0;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int length(){
		return N;
	}
	public T get(int i){
		if(i<0|| i>=N){
			throw new RuntimeException("��ǰԪ�ز�����");
		}
		return eles[i];
	}
	public void insert(T t){
		if(N==eles.length){
			resize(eles.length*2);
		}
		eles[N++] = t;
	}
	public void insert(int i,T t){
		if(i<0||i>N){
			throw new RuntimeException("�����λ�ò��Ϸ�");
		}
		if(N==eles.length){
			resize(eles.length*2);
		}
		for(int index=N-1;index>i;index--){
			eles[index]=eles[index-1];
		}
		eles[i]=t;
		N++;
	}
	public T remove(int i){
		if(i<0|| i>N-1){
			throw new RuntimeException("��ǰҪɾ����Ԫ�ز�����");
		}
		T result = eles[i];
		for (int index=i;index<N-1;index++){
			eles[index]=eles[index+1];
		}
		N--;
		if(N>0 && N<eles.length/4){
			resize(eles.length/2);
		}
		return result;
	}
	public int indexOf(T t){
		if(t==null){
			throw new RuntimeException("���ҵ�Ԫ�ز��Ϸ�");
		}
		for (int i = 0;i<N;i++){
			if(eles[i].equals(t)){
				return i ;
			}
		}
		return - 1;
	}
	public void showEles(){
		for(int i = 0;i<N;i++){
			System.out.print(eles[i]+" ");
		}
		System.out.println();
	}
	@Override
	public Iterator iterator(){
		return new SIerator();
	}
	
	private class SIerator implements  Iterator{
		private int cur;
		public SIerator(){
			this.cur=0;
		}
	@Override
	public boolean hasNext(){
			return cur<N;
		}
	@Override
	public T next(){
			return eles[cur++];
		}

	}
	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		T[]temp = eles;
		eles = (T[])new Object[newSize];
		for(int i= 0; i<N;i++){
		eles[i] = temp[i];
		}	
	}
	public int capacity(){
		return eles.length;
	}
	
	
}
