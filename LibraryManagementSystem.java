import java.util.*;

class Book {
    private int id;
    private String title;
    private boolean isIssued;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    public void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Status: " + (isIssued ? "Issued" : "Available"));
    }
}

class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) {
            b.display();
        }
    }

    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId && !b.isIssued()) {
                b.issueBook();
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId && b.isIssued()) {
                b.returnBook();
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    lib.addBook(new Book(id, title));
                    break;
                case 2:
                    lib.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    lib.issueBook(issueId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
