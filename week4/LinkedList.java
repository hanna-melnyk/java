package ss.week4;

public class LinkedList<Element> {

    private int size;
    private Node first;

    /**
     * @ensures the list is empty
     */
    public LinkedList () {
        size = 0;
        first = null;
    }

    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index-1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }

    /**
     * @ensures the size of the list has decreased by one
     * @param element the Element to remove
     */
    public void remove(Element element) {
    // TODO: implement, see exercise P-4.5
        Node nodeBefore = findBefore(element);

        if (nodeBefore != null && nodeBefore.next != null) {
            Node nodeToRemove = nodeBefore.next;
            if (nodeToRemove.element.equals(element)) {
                nodeBefore.next = nodeToRemove.next;
                nodeToRemove.element = null;
                size--;
            }
        } else if (first != null && first.element.equals(element)) {
            Node nodeToRemove = first;
            first = first.next;
            nodeToRemove.element = null;
            size--;
        }
    }


    /** @return the Node immediately before the ﬁrst
     occurrence of the speciﬁed Element. If the speciﬁed Element is ﬁrst in the list, or is not contained
     in the list, the method returns null*/
    public Node findBefore(Element element) {
        if (first == null || first.element.equals(element)) {
            return null;
        }

        Node current = first;
        while (current.next != null && !current.next.element.equals(element)) {
            current = current.next;
        }

        if (current.next == null) {
            return null;
        }

        return current;
    }

    /**
     * @requires the index to be within the bounds of the list
     * @param index the index to get the element at 
     * @return the element at index index
     */
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * @requires i to be within the bounds of the list
     * @param i the index to get the Node at
     * @return the Node at index i
     */
    private Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    /**
     * @ensures the result to be 0 or greater
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
