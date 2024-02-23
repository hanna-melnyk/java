package ss.week4;

public class DoublyLinkedList<Element> {

    private int size;
    private Node head;

    /**
     * @ensures the list is empty (size is 0)
     */
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    /**
     * Inserts a new Element at a given index in the list.
     * @requires element is not null
     * @requires the index to be within the bounds of the list
     * @ensures the size of the list to increase by one
     * @ensures the Element in the list at index index to be element
     * @param index The index at which to insert the Element
     * @param element The element to add
     */
    public void add(int index, Element element) {
        // TODO: implement, see exercise P-4.4
        assert element != null: "Assertion: element is null";
        assert index <= (size+1) : "Assertion: index is not within bounds of a list";
        size ++;
        Node oldNode = getNode(index); // get the node that we want to modify
        Node updatedNode = new Node(element); // create a new node with element that we want to insert


        //updatedNode>oldNode
        updatedNode.next = oldNode; // make our new node next pointer (updatedNode.next) point to oldNode
        updatedNode.previous = oldNode.previous; // make our new node previous pointer (updatedNode.previous) point to oldNode.previous


        //previousNode>updatedNode<oldNode
        oldNode.previous.next = updatedNode; // make our previous node next pointer (oldNode.previous.next) point to our new node (updatedNode)
        oldNode.previous = updatedNode; // make our old node previous pointer (oldNode.previous) point to our new node (updatedNode)
    }

    /**
     * Removes an element at a given index
     * @requires the index to be within the bounds of the list
     * @ensures the size of the list to decrease by one
     * @param index the index to remove the element at
     */
    public void remove(int index) {
        // TODO: implement, see exercise P-4.4
        assert index <= (size+1): "Assertion: index is not within bounds of a list";
        Node nodeToReplace = getNode(index);
        Node previousNode = nodeToReplace.previous;
        Node nextNode = nodeToReplace.next;
        previousNode.next = nodeToReplace.next;
        nextNode.previous = nodeToReplace.previous;
        size--;


    }

    /**
     * @requires the index to be within the bounds of the list
     */
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     * @requires i to be between -1 and the size of the list
     */
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
