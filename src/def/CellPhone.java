package def;

import java.util.Scanner;

public class CellPhone {
    private long serialNum;
    private String brand;
    private int year;
    private double price;

    // Parameterized constructor
    public CellPhone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    // Copy constructor
    public CellPhone(CellPhone other, long newSerialNum) {
        this.serialNum = newSerialNum;
        this.brand = other.brand;
        this.year = other.year;
        this.price = other.price;
    }

    // Clone method
    public CellPhone clone() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new serial number for the clone: ");
        long newSerialNum = scanner.nextLong();
        return new CellPhone(this, newSerialNum);
    }

    // Getters and Setters
    public long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return "[" + serialNum + ": " + brand + " " + price + " " + year + "]";
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CellPhone other = (CellPhone) obj;
        return brand.equals(other.brand) && year == other.year && price == other.price;
    }
}
