
public class Stack {
	private LinkedList stackList;
	private Link currentCountry;
	
	public Stack(){
		stackList = new LinkedList();
		currentCountry = stackList.first;
	}//end Stack constructor
	
	public void push(Country country){
		stackList.insertFirst(country);
		currentCountry = stackList.first;
	}
	
	public Country pop(){
		return stackList.deleteFirst();
	}
	
	public void printStack(){
		currentCountry.country.print();
		//base case: when the current link's next variable points to null
		if(currentCountry.next == null){
			currentCountry = stackList.first;
			return;
		}
		currentCountry = currentCountry.next;
		printStack();
	}
	
	public boolean isEmpty(){
		if(stackList.isEmpty()){
			return true;
		}
		else {
			return false;
		}
	}
	private class Link {
		public Country country;
		public Link next;
		
		public Link(Country country){
			this.country = country;
		}//end Link constructor
	}//end Link class
	
	private class LinkedList {
		public Link first;
		public Link last;
		
		public LinkedList(){
			first = null;
			last = null;
		}
		
		public boolean isEmpty(){
			return first == null;
		}
		
		public void insertFirst(Country country){
			Link newLink = new Link(country);
			if(isEmpty()){
				last = newLink;
			}
			newLink.next = first;
			first = newLink;
		}
		
		public Country deleteFirst(){
			Country temp = first.country;
			if(first.next == null){
				last = null;
			}
			first = first.next;
			return temp;
		}
	}//end LinkedList class
}
