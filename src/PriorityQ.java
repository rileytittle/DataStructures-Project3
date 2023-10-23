
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

	public Country remove() {
		Country temp = priorityList.delete();
		currentCountry = priorityList.first;
		return temp;
	}

	public void printPriorityQ(){
		currentCountry.country.print();
		//base case: when the current link's next variable points to null
		if(currentCountry.next == null){
			return;
		}
		currentCountry = currentCountry.next;
		printPriorityQ();
	}

	public boolean isEmpty(){
		if(priorityList.isEmpty()){
			return true;
		}
		else {
			return false;
		}
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
			if(isEmpty()){
				first = newLink;
			}
			else if(newLink.country.getHappyIndex() > first.country.getHappyIndex()){
				first.previous = newLink;
				newLink.next = first;
				first = newLink;
			}
			else{
				while(newLink.country.getHappyIndex() < currentLink.country.getHappyIndex()){
					if(currentLink.next != null){
						currentLink = currentLink.next;
					}
					else {
						currentLink.next = newLink;
						newLink.previous = currentLink;
					}
				}
				newLink.next = currentLink;
				newLink.previous = currentLink.previous;
				if(!(currentLink.previous == null)){
					currentLink.previous.next = newLink;
				}
				currentLink.previous = newLink;
			}
		}

		public Country delete() {
			Country temp = first.country;
			first = first.next;
			return temp;
		}
	}//end LinkedList class
}//end PriorityQ class
