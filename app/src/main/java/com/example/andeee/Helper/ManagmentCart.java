package com.example.andeee.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.andeee.Domain.Foods;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private TinyDB tinyDB;
    private FirebaseAuth mAuth;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
        this.mAuth = FirebaseAuth.getInstance();
    }

    public void insertFood(Foods item) {
        ArrayList<Foods> listpop = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listpop.size(); i++) {
            if (listpop.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if (existAlready) {
            listpop.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listpop.add(item);
        }
        String userEmail = getUserEmail();
        tinyDB.putListObject("CartList_" + userEmail, listpop);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Foods> getListCart() {
        String userEmail = getUserEmail();
        return tinyDB.getListObject("CartList_" + userEmail);
    }

    public Double getTotalFee() {
        ArrayList<Foods> listItem = getListCart();
        double fee = 0;
        for (int i = 0; i < listItem.size(); i++) {
            fee = fee + (listItem.get(i).getPrice() * listItem.get(i).getNumberInCart());
        }
        return fee;
    }

    public void minusNumberItem(ArrayList<Foods> listItem, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listItem.get(position).getNumberInCart() == 1) {
            listItem.remove(position);
        } else {
            listItem.get(position).setNumberInCart(listItem.get(position).getNumberInCart() - 1);
        }
        String userEmail = getUserEmail();
        tinyDB.putListObject("CartList_" + userEmail, listItem);
        changeNumberItemsListener.change();
    }

    public void plusNumberItem(ArrayList<Foods> listItem, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listItem.get(position).setNumberInCart(listItem.get(position).getNumberInCart() + 1);
        String userEmail = getUserEmail();
        tinyDB.putListObject("CartList_" + userEmail, listItem);
        changeNumberItemsListener.change();
    }

    private String getUserEmail() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            return currentUser.getEmail();
        }
        return "";
    }
}