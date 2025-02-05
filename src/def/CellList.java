package def;

public class CellList {
    class CellNode {
        private CellPhone cellPhone;
        private CellNode next;

        // Default constructor
        public CellNode() {
            this.cellPhone = null;
            this.next = null;
        }

        // Parameterized constructor
        public CellNode(CellPhone cellPhone, CellNode next) {
            this.cellPhone = cellPhone;
            this.next = next;
        }

        // Copy constructor
        public CellNode(CellNode other) {
            this.cellPhone = new CellPhone(other.cellPhone, other.cellPhone.getSerialNum());
            this.next = other.next;
        }

        // Clone method
        public CellNode clone() {
            return new CellNode(this);
        }

        // Getters and Setters
        public CellPhone getCellPhone() {
            return cellPhone;
        }

        public void setCellPhone(CellPhone cellPhone) {
            this.cellPhone = cellPhone;
        }

        public CellNode getNext() {
            return next;
        }

        public void setNext(CellNode next) {
            this.next = next;
        }
    }

    private CellNode head;
    private int size;

    // Default constructor
    public CellList() {
        this.head = null;
        this.size = 0;
    }

    // Copy constructor
    public CellList(CellList other) {
        if (other.head == null) {
            this.head = null;
            this.size = 0;
        } else {
            this.head = new CellNode(other.head);
            CellNode current = this.head;
            CellNode otherCurrent = other.head.next;
            while (otherCurrent != null) {
                current.next = new CellNode(otherCurrent);
                current = current.next;
                otherCurrent = otherCurrent.next;
            }
            this.size = other.size;
        }
    }

    // Add to the start of the list
    public void addToStart(CellPhone phone) {
        head = new CellNode(phone, head);
        size++;
    }

    // Insert at a specific index
    public void insertAtIndex(CellPhone phone, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addToStart(phone);
        } else {
            CellNode previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            previous.next = new CellNode(phone, previous.next);
            size++;
        }
    }

    // Delete from a specific index
    public void deleteFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            head = head.next;
        } else {
            CellNode previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            previous.next = previous.next.next;
        }
        size--;
    }

    // Replace a node's object at a specific index
    public void replaceAtIndex(CellPhone phone, int index) {
        if (index < 0 || index >= size) return;
        CellNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.cellPhone = phone;
    }

    // Find a node by serial number
    public CellNode find(long serialNum) {
        CellNode current = head;
        int iterations = 0;
        while (current != null) {
            iterations++;
            if (current.cellPhone.getSerialNum() == serialNum) {
                System.out.println("Found after " + iterations + " iterations.");
                return current;
            }
            current = current.next;
        }
        System.out.println("Not found after " + iterations + " iterations.");
        return null;
    }

    // Check if the list contains a phone with a specific serial number
    public boolean contains(long serialNum) {
        return find(serialNum) != null;
    }

    // Show the contents of the list
    public void showContents() {
        CellNode current = head;
        System.out.println("The current size of the list is " + size + ". Here are the contents:");
        while (current != null) {
            System.out.print(current.cellPhone + " ---> \n");
            current = current.next;
        }
        System.out.println("X");
    }
}

