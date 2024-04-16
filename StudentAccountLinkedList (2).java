import java.util.*;
//Student class represents a student with a name and a letter grade.
class Student {
    private String name;
    private char letterGrade;

    
 //Makes a new Student object with a given name and letter grade.

    public Student(String name, char letterGrade) {
        this.name = name;
        this.letterGrade = letterGrade;
    }

     //Gets the name of the student.
     
      //@return The name of the student.
     
    public String getName() {
        return name;
    }
     //Gets the letter grade of the student.
    //@return The letter grade of the student
    public char getLetterGrade() {
        return letterGrade;
    }
    
  //Returns a string representation of the student: "name (letterGrade)".
     
    public String toString() {
        return name + " (" + letterGrade + ")";
    }
}

/**
 *Node class represents a node in a doubly linked list, which contains a Student object.
 */
class Node {
    public Node next;
    public Node prev;
    public Student data;

    /**
     * Makes a new Node with the given Student data.
     *
     * @param student The Student data to be stored in the node.
     */
    public Node(Student student) {
        data = student;
        next = null;
        prev = null;
    }
}

/**
 StudentAccountLinkedList class represents a doubly linked list of Student objects.
 */
public class StudentAccountLinkedList {
    private Node head;
    private Node tail;

    /**
     * Makes an empty doubly linked list of Student objects.
     */
    public StudentAccountLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Checks if the linked list is empty.
     * @return true if the list is empty, false if not.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Gets the size of the linked list.
     * @return The size of the linked list.
     */
    public int size() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    /**
     * Adds a new Student to the beginning of the linked list.
     */
    public void addHead(String name, char letterGrade) {
        Student student = new Student(name, letterGrade);
        Node nNode = new Node(student);

        if (isEmpty()) {
            head = nNode;
            tail = nNode;
        } else {
            nNode.next = head;
            head.prev = nNode;
            head = nNode;
        }
    }

    /**
     * Adds a new Student to the end of the linked list.
     */
    public void addTail(String name, char letterGrade) {
        Student student = new Student(name, letterGrade);
        Node nNode = new Node(student);

        if (isEmpty()) {
            head = nNode;
            tail = nNode;
        } else {
            tail.next = nNode;
            nNode.prev = tail;
            tail = nNode;
        }
    }

    /**
     * @param n, The index at which to insert the student.
     * @param name, The name of the student to be added.
     * @param letterGrade, The letter grade of the student to be added.
     */
    public void add(int n, String name, char letterGrade) {
        if (n < 0 || n > size()) {
            System.out.println("Invalid.");
            return;
        }
        if (n == 0) {
            addHead(name, letterGrade);
        } else if (n == size()) {
            addTail(name, letterGrade);
        } else {
            Student student = new Student(name, letterGrade);
            Node nNode = new Node(student);

            Node curr = head;
            for (int i = 0; i < n - 1; i++) {
                curr = curr.next;
            }
            nNode.next = curr.next;
            nNode.prev = curr;
            curr.next.prev = nNode;
            curr.next = nNode;
        }
    }

    /**
     * @return true if the student is found, false otherwise.
     */
    public boolean isFound(String name) {
        Node curr = head;
        while (curr != null) {
            if (curr.data.getName().equals(name)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * @return The number of students with a grade greater than or equal to the specified grade.
     */
    public int countGreaterOrEqualTo(char letterGrade) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.data.getLetterGrade() >= letterGrade) {
                count++;
            }
            curr = curr.next;
        }
        return count;
    }

    /**
     * Removes a Student at the specified index from the linked list.
     * @return A message indicating which student was removed.
     */
    public String removeElement(int n) {
        if (n < 0 || n >= size()) {
            return "Invalid.";
        }

        Node curr = head;
        if (n == 0) {
            head = curr.next;
            if (head != null) {
                head.prev = null;
            }
            return curr.data.getName() + " removed.";
        } else {
            for (int i = 0; i < n; i++) {
                curr = curr.next;
            }
            curr.prev.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = curr.prev;
            } else {
                tail = curr.prev;
            }
            return curr.data.getName() + " removed.";
        }
    }

    /**
     * Removes all elements from the linked list.
     */
    public void removeAll() {
        head = null;
        tail = null;
    }

    /**
     * @return A string representation of the linked list.
     */
    public String toString() {
        String result = "";
        Node curr = head;
        while (curr != null) {
            result += curr.data.toString();
            if (curr.next != null) {
                result += " -> ";
            }
            curr = curr.next;
        }
        return result;
    }

      /**
       * The main method for testing the StudentAccountLinkedList class.
       */
    public static void main(String[] args) {
        StudentAccountLinkedList list = new StudentAccountLinkedList();

        // Add students to the list
        list.addHead("Evan", 'A');
        list.addTail("Andre", 'C');
        list.addTail("Johnny", 'D');

        // Display the elements in the list
        System.out.println("Elements in the list: " + list.toString());

        // Display the size of the list
        System.out.println("Size of the list: " + list.size());

        // Check if a specific student is in the list
        String findName = "Andre";
        System.out.println("Is '" + findName + "' in the list? " + list.isFound(findName));

        // Count the number of students with a grade 'B' or higher
        char grade = 'B';
        int count = list.countGreaterOrEqualTo(grade);
        System.out.println("Number of students with grade '" + grade + "' or higher: " + count);

        // Remove the 2nd element in the list
        int rIndex = 1;
        System.out.println(list.removeElement(rIndex));

        // Display the size of the list
        System.out.println("Size of the list after removal: " + list.size());

        // Display the elements in the list after removal
        System.out.println("Elements in the list after removal: " + list.toString());

        // Remove all elements in the list
        list.removeAll();

        // Display the size of the list after removeAll
        System.out.println("Size of the list after removeAll: " + list.size());

        // Display the elements in the list after removeAll
        System.out.println("Elements in the list after removeAll: " + list.toString());
      }

}
