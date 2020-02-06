package chapter2.chapter2_1;

import java.util.Arrays;

public class Transaction implements Comparable<Transaction> {
  private String customer; // customer
  private Date date; // date
  private double amount;

  public Transaction(String customer, Date date, double amount) {
    this.customer = customer;
    this.date = date;
    this.amount = amount;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public int compareTo(Transaction that) {
    if (this.amount > that.amount) return +1;
    if (this.amount < this.amount) return -1;
    return 0;
  }

  public static void main(String[] args) {
    Transaction[] transactions = new Transaction[3];
    transactions[0] = new Transaction("Big", new Date(5, 22, 1939), 123.45);
    transactions[1] = new Transaction("Medium", new Date(5, 22, 1939), 50.5);
    transactions[2] = new Transaction("Small", new Date(5, 22, 1939), 11.99);

    Arrays.sort(transactions);

    for (Transaction transaction : transactions) {
      System.out.println("Customer: " + transaction.customer + "\tAmount: " + transaction.amount);
    }
  }
}
