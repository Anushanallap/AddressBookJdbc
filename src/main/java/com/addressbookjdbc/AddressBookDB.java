package com.addressbookjdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDB {
    static List<AddressBook> list = new ArrayList<>();
    static String URL = "jdbc:mysql://localhost:3306/address_book_database?characterEncoding=utf8";
    static String USERNAME = "root";
    static String PASSWORD = "chinni@68";

/*UC16*/
    public static List<AddressBook> retrieveAlltheEntriesInAddressBook() {

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

/*UC17*/

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

/*UC18*/

    public static List<AddressBook> retrieveContactFromDatabase(LocalDate start_date, LocalDate end_date) {
        String query = String.format("select * FROM addressbooksystem where start_date BETWEEN '%s' AND '%s';",
                Date.valueOf(start_date), Date.valueOf(end_date));
        List<AddressBook> addressdata = new ArrayList<>();
        try {

            System.out.println("Driver loaded!...");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("connection success");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                list.add(new AddressBook(rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
                        rs.getString("Department_Type"), rs.getString("city"), rs.getString("state"),
                        rs.getString("email"), rs.getInt("phoneNumber"), rs.getInt("zip")));
            System.out.println(list.size());
            addressdata.forEach(System.out::println);
            stmt.close();
            rs.close();
            con.close();

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
/*UC19*/
    public static List<AddressBook> retrieveContactsByCityorState(String city) {

        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pstmt = con.prepareStatement("SELECT *  FROM address_book WHERE city=?");
            pstmt.setString(1, city);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new AddressBook(rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
                        rs.getString("Department_Type"), rs.getString("city"), rs.getString("state"),
                        rs.getString("email"), rs.getInt("phoneNumber"), rs.getInt("zip")));
                System.out.println(list.size());
                // System.out.println("City = " + city + " \nstate = " + state);

            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
/*UC20*/

    public static int addDatabaseIntoTransaction(String firstName, String lastName,String address,String Department_Type,LocalDate start_date, String city, String state,int zip, int phoneNumber,String email) throws SQLException  {

        String query = String.format("INSERT INTO address_book (`firstName`, `lastName`,`address`,`Department_Type`,`start_date`, `city`, `state`,`zip`, `phoneNumber`,`email`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                firstName, lastName,address,Department_Type,start_date, city, state, zip, phoneNumber, email);
        System.out.println(query);
        Connection con = null;

        int rs = 0;
        try {

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            rs = statement.executeUpdate(query);

            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        }
        return rs;

    }
    }

