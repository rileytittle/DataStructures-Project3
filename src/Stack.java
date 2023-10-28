/**
 * The Stack class implements a Stack data structure using a double
 * ended singly linked list. It has multiple methods that allow you
 * to manipulate the data inside the Stack.
 * 
 * @author Riley Tittle
 * @version 10.27.2023
 */
public class Stack {
	private LinkedList stackList;
	private Link currentCountry;
	
	/**
	 * Stack is the constructor for the Stack method.
	 * It creates the linked list and begins to keep track of the first country, 
	 * which will later be used to print out the Stack.
	 */
	public Stack(){
		stackList = new LinkedList();
		currentCountry = stackList.first;
	}//end Stack constructor
	/**
	 * the push method pushes a new Country object onto the top of the stack.
	 * @param country the new Country object to be added onto the stack.
	 */
	public void push(Country country){
		stackList.insertFirst(country);
		currentCountry = stackList.first;
	}
	/**
	 * the pop method removes the Country object from the top of the stack and
	 * returns it.
	 * @return the Country object at the top of the stack.
	 */
	public Country pop(){
		return stackList.deleteFirst();
	}
	/**
	 * the printStack method recursively prints the entire stack from top
	 * to bottom to the console.
	 */
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
	/**
	 * the isEmpty method checks to see whether the Stack is empty and returns 
	 * a boolean value based on whether it is or not.
	 * @return true if the Stack is empty, false otherwise.
	 */
	public boolean isEmpty(){
		if(stackList.isEmpty()){
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * The Link class implements a Link object that will be used to create a 
	 * LinkedList object used by the Stack. It holds the value of the next link
	 * in the list and a Country object.
	 * 
	 * @author Riley Tittle
	 * @version 10.27.2023
	 */
	private class Link {
		public Country country;
		public Link next;
		/**
		 * The Link method is the constructor for the Link class
		 * @param country the Country object that the Link will hold.
		 */
		public Link(Country country){
			this.country = country;
		}//end Link constructor
	}//end Link class
	/**
	 * The LinkedList class implements the double ended linked list
	 * data structure that will be used by the Stack class to create the Stack.
	 * It holds the reference to the location of the first and the last link in
	 * the list. It also provides many methods to be used to manipulate the data.
	 * 
	 * @author Riley Tittle
	 * @version 10.27.2023
	 */
	private class LinkedList {
		public Link first;
		public Link last;
		/**
		 * The LinkedList method is the constructor for the LinkedList class.
		 * It sets the first and last variables to null, signifying the list is
		 * empty.
		 */
		public LinkedList(){
			first = null;
			last = null;
		}
		/**
		 * the isEmpty class checks to the see if the LinkedList is empty, 
		 * returning a boolean value based on whether it is or not.
		 * @return true if the LinkedList is empty, false otherwise.
		 */
		public boolean isEmpty(){
			return first == null;
		}
		/**
		 * insertFirst method inserts a Link into the front LinkedList with the value
		 * of the country object that gets assigned to it.
		 * @param country the Country object that the new link in the linked list
		 * will hold
		 */
		public void insertFirst(Country country){
			Link newLink = new Link(country);
			if(isEmpty()){
				last = newLink;
			}
			newLink.next = first;
			first = newLink;
		}
		/**
		 * deleteFirst method deletes the first Link in the LinkedList and returns the
		 * country object it was holding.
		 * @return the Country object the deleted Link was holding.
		 */
		public Country deleteFirst(){
			Country temp = first.country;
			if(first.next == null){
				last = null;
			}
			first = first.next;
			return temp;
		}
	}//end LinkedList class
}//end Stack class
