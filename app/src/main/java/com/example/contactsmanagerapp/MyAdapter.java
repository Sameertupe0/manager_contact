package com.example.contactsmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsmanagerapp.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Contacts> contactsArrayList;

    public MyAdapter(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creating new View holder for items in recyclerview
        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.contact_list_item,parent,false);

        return new MyViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // Called By recyclerView when it needs to display or update an item
        //at a specific position in the list or grid

        Contacts currentContact = contactsArrayList.get(position);

        holder.contactListItemBinding.setContact(currentContact);



    }

    @Override
    public int getItemCount() {

        if(contactsArrayList !=  null){
            return contactsArrayList.size();
        }else{
            return 0;
        }

    }

    public void setContactsArrayList(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;

        // Inform the associated RecyclerView that the underlying
        //dataset has changed , and the RecyclerView should refresh
        // its view to reflect these changes
        notifyDataSetChanged();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ContactListItemBinding contactListItemBinding;


        public MyViewHolder(@NonNull ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }

}
