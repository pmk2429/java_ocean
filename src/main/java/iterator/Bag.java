package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Bag<T> {

	private ArrayList<T> data;	
	
	public Bag(){
		data = new ArrayList<T>();
	}
	
	public void add(T e){
		data.add(e);
	}
	
	public String toString(){
		return data.toString();
	}
	
	public class BagIterator<T> implements Iterator<T>{

		private int index;
		
		public BagIterator(){
			index = 0;
		}
		
		@Override
		public boolean hasNext() {
			
			return index < data.size();
		}

		@Override
		@SuppressWarnings("unchecked")
		public T next() {
			return (T)data.get(index++);
		}
		
		public void remove(){
			data.remove(index);
		}
		
	}
	
	public Iterator<T> iterator(){
		return new BagIterator<T>();
	}
}
