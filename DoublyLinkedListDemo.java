class DoublyLinkedListDemo{

  //head node;
  private Node head;

  //tail node
  private  Node tail;

  //length of the linked list
  private int length;

  //constrcutor to initialize them
  DoublyLinkedListDemo(){
    this.head=null;
    this.tail=null;
    this.length=0;
  }

  //this inner class represent a node
  private class Node{
    private int data;
    private Node next;
    private Node previous;
    Node(int data){
      this.data=data;
      this.next=null;
      this.previous=null;
    }
  }

  //method to show whether linkedlist is empty or not
  public boolean isEmpty(){
    return length==0;
  }

  //method to display in forward direction
  public void displayForward(){
    if (isEmpty()) {
      return;
    }
    Node current=head;
    while (current!=null) {
      System.out.print(current.data+"-->");
      current=current.next;
    }
    System.out.println(current);
  }

  //display method to display in backward direction
	private void  displayBackward(){
		if (tail==null) {
			return;
		}
		Node current=tail;
		while(current!=null){
			System.out.print(current.data+"-->");
			current=current.previous;
		}
		System.out.println(current);
	}

  //method to insert a node at first
  public void insertFirst(int data){
    Node node=new Node(data);
    if ((isEmpty())) {
      head=node;
      tail=node;
    }else {
      node.next=head;
      head.previous=node;
      head=node;
    }
  length++;
  }

  //method to insert a node at last
  public void insertLast(int data){
    Node node=new Node(data);
    if (isEmpty()) {
      head=node;
      tail=node;
    }else {
      tail.next=node;
      node.previous=tail;
      tail=node;
    }
		length++;
  }

  //method to insert a node at specific index
  public void insertAt(int index,int data){
    if (index==0) {
      insertFirst(data);
      return;
    }
    if (index==length) {
      insertLast(data);
      return;
    }
    Node node =new Node(data);
    if (index>length) {
      return;
    }
    int count=0;
    if (length-index>=length/2) {
      Node current=head;
      while (current!=null &&  count<index-1) {
        current=current.next;
        count++;
      }
      Node nextNode=current.next;
      current.next=node;
      node.previous=current;
      node.next=nextNode;
      nextNode.previous=node;
    }else {
      count=length;
      Node current=tail;
      while (current!=null && count>index+1) {
        current=current.previous;
        count--;
      }
      Node previousNode=current.previous;
      current.previous=node;
      node.next=current;
      node.previous=previousNode;
      previousNode.next=node;
    }
    length++;
  }

  //method to delete very first node of the list
  public void deleteFirst(){
    if (isEmpty()) {
      return;
    }
    head=head.next;
    head.previous=null;
    length--;
  }

  //method to delete last node of the list
  public void deleteLast(){
    if (isEmpty()) {
      return;
    }
    tail=tail.previous;
    tail.next=null;
    length--;
  }

  //method to delete from specific index
  public void deleteAt(int index){
    if (index==0) {
      deleteFirst();
      return;
    }
    if (index==length) {
      deleteLast();
      return;
    }
    if (isEmpty() || index>length) {
      return;
    }
    int count=0;
    if (length-index>length/2) {
      Node current=head;
      while (current!=null && count<index) {
        current=current.next;
        count++;
      }
      Node before=current.previous;
      Node after=current.next;
      before.next=null;
      before.next=after;
      after.previous=null;
      after.previous=before;
      current.next=null;
      current.previous=null;
    }else {
      count=length;
      Node current=tail;
      while (current!=tail && count>index) {
        current=current.previous;
        count--;
      }
      Node before=current.next;
      Node after=current.previous;
      before.previous=null;
      before.previous=after;
      after.next=null;
      after.next=before;
      current.next=null;
      current.previous=null;
    }
    length--;
  }

  //main method
  public static void main(String[] args) {
    DoublyLinkedListDemo dl=new DoublyLinkedListDemo();
    dl.insertLast(10);
    dl.insertLast(20);
    dl.insertLast(30);
    dl.insertLast(40);
    dl.insertLast(50);
    dl.displayForward();
    // dl.displayBackward();
    // // System.out.println(dl.tail.data);
    // // System.out.println(dl.head.data);
    // dl.deleteFirst();
    // dl.displayForward();
    // System.out.println(dl.head.data);
    // dl.deleteLast();
    // dl.displayBackward();
    // System.out.println(dl.tail.data);
    // dl.displayForward();
    // dl.displayBackward();
    System.out.println(dl.length);
    // dl.deleteAt(3);
    dl.displayBackward();
    dl.insertFirst(5);
    dl.displayForward();
    dl.displayBackward();
    dl.insertAt(3,25);
    dl.displayForward();
    System.out.println(dl.length);
    dl.deleteAt(3);
    dl.displayForward();
    System.out.println(dl.length);
    dl.displayBackward();
    dl.deleteAt(0);
    dl.displayForward();
  }
}
