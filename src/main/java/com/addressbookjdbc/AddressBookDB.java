package com.addressbookjdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDB {
    static List<AddressBook> list = new ArrayList<>();
    static String URL = "jdbc:mysql://localhost:3306/address_book_database?characterEncoding=utf8";
    static String USERNAME = "root";
    static String PASSWORD = "chinni@68";

/*UC16
	 * Ability for the AddressBook Service to retrieve all the Entries from the DB
	 * @param It retrieve the All entries in Address Book.
	 * @return It returns the Address Book data in list.
	 */    public static List<AddressBook> retrieveAlltheEntriesInAddressBook() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!...");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("connection success \n");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from address_book");

            while (rs.next())

                System.out.println(rs.getString("firstName") + " " + rs.getString("lastName")
                        + " " + rs.getString("address") + " " +rs.getString("Department_Type") + " "
                        +rs.getString("city") + " " +rs.getString("state") + " " +
                        rs.getString("email") + " " + rs.getInt("phoneNumber")+ " " +
                        rs.getInt("zip"));
            list.add(new AddressBook(rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
                    rs.getString("Department_Type"), rs.getString("city"), rs.getString("state"),
                    rs.getString("email"), rs.getInt("phoneNumber"), rs.getInt("zip")));
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            System.out.println("\nThe total size is Address book : " + list.size());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

/*UC17
	 * Ability to update the Contact Information in the address book for a person and ensure that the Contact Information in the
	 * memory is in Sync with the DB
	 * @param Department_Type
	 * @param firstName
	 * @param lastName
	 * @return
	 */
    public static int updateContactInfo(String Department_Type, String firstName, String lastName) {
        String query = String.format(
                "UPDATE address_book SET Department_Type='%s' WHERE firstName='%s' and lastName='%s';", Department_Type,
                firstName, lastName);
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!...");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("connection success");
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // listDrivers()
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
