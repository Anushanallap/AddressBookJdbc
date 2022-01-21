package com.addressbookjdbc;

public class AddressBook {
    String First_name;
    String Last_name;
    String address;
    String phoneNum;
    String zip;
    String city;
    String state;
    String email;

    public AddressBook() {
        super();
    }

    public AddressBook(String F_name, String L_name, String Addr, String MobileNum, String ZipCode, String City,
                       String State, String Mail) {
        First_name = F_name;
        Last_name = L_name;
        address = Addr;
        phoneNum = MobileNum;
        zip = ZipCode;
        city = City;
        state = State;
        email = Mail;
        Object department_type = null;
        Object Department_Type = department_type;
    }

    public AddressBook(String firstName, String lastName, String address, String department_type, String city, String state, String email, int phoneNumber, int zip) {
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartment_Type() {
        String Department_Type = new String();
        return Department_Type;
    }
    public void setDepartment_Type(String department_Type) {
        String Department_Type = department_Type;
    }

    @Override
    public String toString() {
        String Department_Type = null;
        return "Address [First_name=" + First_name + ", Last_name=" + Last_name + ", address=" + address + ", phoneNum="
                + phoneNum + ", zip=" + zip + ", city=" + city + ", state=" + state + ", email=" + email + ",Department_Type=" + Department_Type +"]";
    }

    public void display() {
        System.out.println("\n First Name : " + First_name + "\n Last Name : " + Last_name + "\n Address : " + address
                + "\n Emial : " + email + "\n Phone No : " + phoneNum + "\n Zip Code : " + zip + "\n City : " + city
                + "\n State : " + state);
        System.out.println("  ");
    }

}
