package com.example.andeee.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.andeee.Domain.Foods;
import com.google.firebase.auth.AuthResult;

import com.example.andeee.R;
import com.example.andeee.databinding.ActivityLoginBinding;
import com.example.andeee.databinding.ActivityPaymentBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;

public class PaymentActivity extends AppCompatActivity {
ActivityPaymentBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences preferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        String userEmail = preferences.getString("email", "default_value");
        binding.emailInput.setText(userEmail);
        Intent intent = getIntent();
        binding.totalAmountText.setText("Total Amount: $"+intent.getStringExtra("total"));

        ArrayList<Parcelable> listCard = intent.getParcelableArrayListExtra("listCard");
        Log.d("HOANG",listCard.toString());





        setVariable();
    }

    private String getUserEmail() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            return currentUser.getEmail();
        }
        return "";
    }
    private void setVariable() {

        binding.backBtn.setOnClickListener(v -> finish());

        binding.confirmPaymentBtn.setOnClickListener(v -> {
            Toast.makeText(PaymentActivity.this, "Payment success", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(PaymentActivity.this, MainActivity.class));

        });
    }
}