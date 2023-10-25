
public class PriorityQ {
	private LinkedList priorityList;
	private Link currentCountry;

	public PriorityQ(){
		priorityList = new LinkedList();
		currentCountry = priorityList.first;
	}

	public void insert(Country country){
		priorityList.insert(country);
		currentCountry = priorityList.first;
	}

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

	public boolean isEmpty(){
		if(priorityList.isEmpty()){
			return true;
		}
		else {
			return false;
		}
	}
	//untested but I think it will work.
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
	}
	private class Link {
		public Country country;
		public Link previous;
		public Link next;

		public Link(Country country){
			this.country = country;
			previous = null;
			next = null;
		}//end Link constructor
	}//end Link class

	private class LinkedList {
		public Link first;

		public LinkedList(){
			first = null;
		}

		public boolean isEmpty() {
			return first == null;
		}

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
		public Country delete() {
			Country temp = first.country;
			first = first.next;
			if(first != null)
				first.previous = null;
			return temp;
		}
	}//end LinkedList class
}//end PriorityQ class
