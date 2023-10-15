package com.example.accessingdatajpa;
import jakarta.persistence.*;


@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Long id = null;
    private String name = null;
    private String address = null;
    private String number = null;


    public BuddyInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public BuddyInfo(BuddyInfo buddyClone) {
        this.name = buddyClone.name;
        this.address = buddyClone.address;
        this.number = buddyClone.number;
    }

    public BuddyInfo() {

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return number;
    }

    public void setPhoneNumber(String number) {
        this.number = number;
    }

    public String toString() {
        return "Name: " + name + "      Address: " + address + "        Phone Number: " + number + "\n";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName("Mo");
        buddy.setAddress("615 Rathbone");
        buddy.setPhoneNumber("6137947758");

        System.out.println("Name: "+ buddy.getName() + "\tAddress: " + buddy.getAddress() + "\tPhone Number: " + buddy.getPhoneNumber());
    }
}