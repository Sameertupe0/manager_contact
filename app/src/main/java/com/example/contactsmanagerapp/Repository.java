package com.example.contactsmanagerapp;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    // The Available Data Sources :
    // Room Database
    private  final  ContactDAO contactDAO;

    ExecutorService executorService;

    Handler handler;

    public Repository(Application application) {


        ContactsDatabase contactsDatabase = ContactsDatabase.getInstance(application);
        this.contactDAO = contactsDatabase.getContactDAO();


        // Database activities so that it cannot handle by main thread instead it is happening in background
        executorService = Executors.newSingleThreadExecutor();

        // Use for updating the UI
        handler = new Handler(Looper.getMainLooper());
    }

    // Methods in DAO being executed from Repository
    public void addContact(Contacts contacts){



        // Executing Task on Separate Thread
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contacts);
            }
        });



    }

    public void deleteContact(Contacts contacts){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contacts);
            }
        });


    }

    public LiveData<List<Contacts>> getAllContacts(){
        return contactDAO.getAllContacts();

    }

}
