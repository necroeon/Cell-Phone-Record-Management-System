package def;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization {
    public static void main(String[] args) {
        // Create two empty CellList objects
        CellList list1 = new CellList();
        CellList list2 = new CellList();

        // Open and read the file
        try {
            Scanner fileScanner = new Scanner(new File("Cell_Info.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                // Skip empty lines
                if (line.isEmpty()) continue;

                // Parse data from the line
                String[] data = line.split("\\s+"); // Split by any whitespace
                long serialNum = Long.parseLong(data[0]);
                String brand = data[1];
                double price = Double.parseDouble(data[2]);
                int year = Integer.parseInt(data[3]);

                // Create a CellPhone object
                CellPhone phone = new CellPhone(serialNum, brand, year, price);

                // Add to the list, avoiding duplicates
                if (!list1.contains(serialNum)) {
                    list1.addToStart(phone);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File 'Cell_Info.txt' not found.");
            return;
        }

        // Display the contents of the initialized list
        System.out.println("Contents of the CellList:");
        list1.showContents();

        // Prompt the user to search for serial numbers
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a serial number to search: ");
        long serialToSearch = scanner.nextLong();
        CellList.CellNode resultNode = list1.find(serialToSearch);

        if (resultNode != null) {
            System.out.println("Phone found: " + resultNode.getCellPhone());
        } else {
            System.out.println("Phone with serial number " + serialToSearch + " not found.");
        }

        // Test the functionality of constructors/methods
        System.out.println("\nTesting other methods...");
        CellPhone testPhone = new CellPhone(9999999, "TestBrand", 2023, 699.99);
        list1.addToStart(testPhone); // Add to start
        System.out.println("After adding a test phone at the start:");
        list1.showContents();

        // Test replacing at an index
        list1.replaceAtIndex(testPhone, 2); // Replace at index 2
        System.out.println("After replacing at index 2:");
        list1.showContents();

        // Test deletion
        list1.deleteFromIndex(0); // Delete from start
        System.out.println("After deleting the first node:");
        list1.showContents();

        scanner.close();
    }
}
