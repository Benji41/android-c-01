package com.reynoso.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.reynoso.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.tvHobbies.setText("Hobbies: ");
        mainBinding.btnEnterHobbie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainBinding.tvHobbies.getText().toString().equals("Hobbies: ")){
                    mainBinding.tvHobbies.append(mainBinding.etvHobbies.getText().toString().trim());
                    mainBinding.tvHobbies.setVisibility(View.VISIBLE);
                }else {
                    mainBinding.tvHobbies.append(", "+mainBinding.etvHobbies.getText().toString().trim());
                }
                mainBinding.etvHobbies.setText("");
                //hide keyboard
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });
    }
}