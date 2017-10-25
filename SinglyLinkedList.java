class MyLinkedList{
    //head node which will point to  LinkedList
    //node blueprint
    private static class Node{
      //node element
      private int data;
      //node pointer
      private Node next;

      //constructor to initialize data  and pointer
      public Node(int data){
        this.data=data;
        this.next=null;
      }
    }
    //method to diplay the linked list
    public static void display(Node node){
      Node current=node;
      while (current!=null) {
        System.out.print("["+current.data+"]-->");
        current=current.next;
      }
      System.out.println(current);
    }

    //method to add a node into the linnked List
    // public static void add(Node node,int index){
    //   (index-1).next=node;
    //   node.next=index;
    // }


    public static void main(String[] args) {

      //first node
      head=new Node(10);
      Node second=new Node(20);
      Node third=new Node(30);
      Node fourth=new Node(40);
      Node fifth=new Node(50);

      //we have created 5 nodes and now we have tp connect them
      head.next=second;
      second.next=third;
      third.next=fourth;
      fourth.next=fifth;

      //displaying LinkedList
      display(head);
      Node node=new Node(35);
      // add(node,3);

    }
}
