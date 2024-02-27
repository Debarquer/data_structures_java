public class LinkedList {
    Node head;

    public void Insert(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if(head == null) {
            head = newNode;
        }
        else {
            Node n = head;
            while(n.next != null) {
                n = n.next;
            }

            n.next = newNode;
        }
    }

    public void InsertAtStart(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (head != null) {
            newNode.next = head;
        } else {
            newNode.next = null;
        }

        head = newNode;
    }

    public void InsertAt(int index, int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if(head == null) {
            if(index != 0) {
                System.out.println("LinkedList error: Invalid index at " + index);
                return;
            }
            head = newNode;
        }
        else {
            Node n = head;

            if(index == 0) {
                InsertAtStart(data);
                return;
            }
            else if (n.next == null) {
                System.out.println("LinkedList error: Invalid index at " + index);
                return;
            }

            for(int i = 0; i < index - 1; i++) {
                if(n.next == null) {
                    System.out.println("LinkedList error: Invalid index at " + index);
                    return;
                }
                n = n.next;
            }

            newNode.next = n.next;
            n.next = newNode;
        }
    }

    public void Delete(int index) {
        if(index == 0 && head != null) {
            head = head.next;
        }
        else if(head == null) {
            System.out.println("LinkedList error: Invalid index at " + index);
        }
        else {
            Node n = head;
            for(int i = 0; i < index - 1; i++) {
                if(n.next == null) {
                    System.out.println("LinkedList error: Invalid index at " + index);
                    return;
                }
                n = n.next;
            }

            if(n.next == null) {
                System.out.println("LinkedList error: Delete error: No element exists at " + index);
            }
            else {
                if(n.next.next != null) {
                    n.next = n.next.next;
                }
                else {
                    n.next = null;
                }
            }
        }
    }

    public void Show() {
        Node node = head;
        while(node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}
