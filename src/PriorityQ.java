/**
 * The PriorityQ class implements the Priority Queue data structure
 * using a doubly linked list. The class contains multiple methods 
 * allow the user to manipulate the data inside the priority queue.
 * 
 * @author Riley Tittle
 * @version 10.27.2023
 */
public class PriorityQ {
	private LinkedList priorityList;
	private Link currentCountry;
	/**
	 * PriorityQ method is the constructor for the PriorityQ class.
	 * It creates the LinkedList to use for the priority queue and sets 
	 * currentCountry to the first item in the LinkedList, which will help
	 * us print the queue.
	 */
	public PriorityQ(){
		priorityList = new LinkedList();
		currentCountry = priorityList.first;
	}
	/**
	 * insert method inserts a new Country object into the PriorityQ.
	 * @param country the new Country object to be inserted into the priority queue.
	 */
	public void insert(Country country){
		priorityList.insert(country);
		currentCountry = priorityList.first;
	}
	/**
	 * remove method removes the highest priority item from the PriorityQ, which
	 * is always the first item.
	 * @return the highest priority Country in the queue
	 */
	public Country remove(){
		return priorityList.delete();
	}
	/**
	 * printPriorityQ recursively prints the PriorityQ from highest priority to lowest.
	 */
	public void printPriorityQ(){
		if(currentCountry == null){
			System.out.println("No items in the Priority Queue\n");
			return;
		}
		else{
			if(currentCountry != null)
				currentCountry.country.print();
			//base case: when the current link's next variable points to null
			if(currentCountry.next == null){
				currentCountry = priorityList.first;
				return;
			}
			if(currentCountry != null){
				currentCountry = currentCountry.next;
				printPriorityQ();
			}
		}
	}
	/**
	 * isEmpty checks to see whether the PriorityQ is empty or not and returns 
	 * a boolean value based on what it finds.
	 * @return true if the PriorityQ is empty, false otherwise.
	 */
	public boolean isEmpty(){
		if(priorityList.isEmpty()){
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * intervalDelete method delets all Country objects from the PriorityQ whose
	 * happiness index falls within a user-supplied interval of numbers. The input 
	 * must be provided in the format of [x,y] where x is less that y. It returns true
	 * if any country objects were found and deleted, false otherwise.
	 * @param bottom the lower of the two numbers in the user-supplied interval
	 * @param top the higher of the two numbers in the user-supplied interval
	 * @return true if any country objects were found and deleted, false otherwise.
	 */
	public boolean intervalDelete(double bottom, double top) {
		int numItemsDeleted = 0;
		Link currentCountry = priorityList.first;
		while(currentCountry != null) {
			if(currentCountry.country.getHappyIndex() >= bottom && currentCountry.country.getHappyIndex() <= top) {
				if(currentCountry == priorityList.first) {
					priorityList.delete();
					numItemsDeleted++;
				}
				else if(currentCountry.next == null) {
					currentCountry.previous.next = null;
					numItemsDeleted++;
				}
				else {
					currentCountry.next.previous = currentCountry.previous;
					currentCountry.previous.next = currentCountry.next;
					numItemsDeleted++;
				}
			}
			currentCountry = currentCountry.next;
		}
		if(numItemsDeleted > 0){
			this.currentCountry = priorityList.first;
			return true;
		}
		else return false;
	}//end intervalDelete
	/**
	 * The Link class implements a Link object that will be used to create a 
	 * LinkedList object used by the PriorityQ. It holds the value of the next link
	 * in the list, the previous link in the list, and a Country object.
	 * 
	 * @author Riley Tittle
	 * @version 10.27.2023
	 */
	private class Link {
		public Country country;
		public Link previous;
		public Link next;
		/**
		 * The Link method is the constructor the Link class. It gives the 
		 * Country object to the new Link being created.
		 * @param country the Country object that the new Link will hold.
		 */
		public Link(Country country){
			this.country = country;
			previous = null;
			next = null;
		}//end Link constructor
	}//end Link class
	/**
	 * The LinkedList class implements the doubly linked list data structure that 
	 * will be used by the PriorityQ class to create the PriorityQ.
	 * It holds the reference to the location of the first Link in
	 * the list. It also provides many methods to be used to manipulate the data.
	 * 
	 * @author Riley Tittle
	 * @version 10.27.2023
	 */
	private class LinkedList {
		public Link first;
		/**
		 * LinkedList method is the constructor of the LinkedList class, it sets 
		 * the first variable to null, signifying the list is empty.
		 */
		public LinkedList(){
			first = null;
		}
		/**
		 * isEmpty checks whether the LinkedList is empty or not and returns a 
		 * boolean value.
		 * @return true if empty, false otherwise.
		 */
		public boolean isEmpty() {
			return first == null;
		}
		/**
		 * insert method inserts a new Link into the LinkedList according to the priority
		 * of the Link's Country object's happiness index. The higher the happiness index,
		 * the closer to the front of the list the Link will be.
		 * @param country the Country object to assign to the new Link
		 */
		public void insert(Country country){ 
			Link newLink = new Link(country);
			Link currentLink = first;
			//if list is empty
			if(isEmpty()){
				first = newLink;
			}
			//if the newLink is higher priority than the first link
			else if(newLink.country.getHappyIndex() > first.country.getHappyIndex()){
				newLink.next = first;
				first.previous = newLink;
				first = newLink;
			}
			else{
				currentLink = currentLink.next;
				while(currentLink.next != null){
					if(newLink.country.getHappyIndex() > currentLink.country.getHappyIndex()){
						newLink.next = currentLink;
						newLink.previous = currentLink.previous;
						currentLink.previous.next = newLink;
						currentLink.previous = newLink;
						break;
					}
					else{
						currentLink = currentLink.next;
					}
				}//end while loop
				if(currentLink.next == null){
					if(newLink.country.getHappyIndex() < currentLink.country.getHappyIndex()){
						newLink.previous = currentLink;
						currentLink.next = newLink;
					}
					else if(newLink.country.getHappyIndex() > currentLink.country.getHappyIndex()){
						newLink.next = currentLink;
						newLink.previous = currentLink.previous;
						currentLink.previous.next = newLink;
						currentLink.previous = newLink;
					}
				}//end if
			}//end else
		}//end insert method
		/**
		 * delete method deletes the first Link from the LinkedList and returns the 
		 * Country object it was holding.
		 * @return the Country object that the deleted Link was holding.
		 */
		public Country delete() {
			Country temp = first.country;
			first = first.next;
			if(first != null)
				first.previous = null;
			return temp;
		}
	}//end LinkedList class
}//end PriorityQ class
