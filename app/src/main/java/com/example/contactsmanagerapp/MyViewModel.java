package com.example.contactsmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends AndroidViewModel{

    // if you need to use context inside your viewmodel
    // you should use AndroidViewModel (AVM)
    // because it contain the application context



    // AndroidViewModel class is a subclass of ViewModel
    // and similar to them, they are designed to store and
    // manage UI-related data are responsible to
    //prepare & provide data for UI and automatically
    // allow data to survive configuration change.

    private  Repository repository;

    // Create Live Data
    private LiveData<List<Contacts>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public  LiveData<List<Contacts>> getAllContacts(){
        allContacts = repository.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contacts contacts){
        repository.addContact(contacts);
    }
    public void deleteContact(Contacts contacts){
        repository.deleteContact(contacts);
    }

    //
}
