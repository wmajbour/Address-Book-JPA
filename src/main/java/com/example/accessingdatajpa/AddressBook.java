package com.example.accessingdatajpa;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn
    @OneToMany(fetch = FetchType.EAGER)
    public List<BuddyInfo> buddies;


    public AddressBook() {
        buddies = new ArrayList<>();
    }

    public int size() {
        return buddies.size();
    }

    public void clear() {
        buddies = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo newBuddy) {
        buddies.add(newBuddy);
    }

    public void removeBuddy(int i) {
        if (i >= 0 && i < buddies.size()) {
            buddies.remove(i);
        }
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public BuddyInfo getBuddy(int i) {
        if (i >= 0 && i < buddies.size()) {
            return buddies.get(i);
        }
        return null;
    }

    public List<BuddyInfo> getBuddies(){
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies){
        this.buddies = buddies;

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Address Book by ID: ").append(id).append("\n");
        for(BuddyInfo buddy : buddies){
            sb.append(buddy).append("\n");
        }
        return sb.toString();
    }

}
