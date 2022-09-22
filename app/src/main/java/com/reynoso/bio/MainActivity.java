package com.reynoso.bio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et_hobbies;
    private Button btn_getHobby;
    private TextView tv_showHobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_hobbies = findViewById(R.id.etv_hobbies);
        btn_getHobby = findViewById(R.id.btn_enterHobbie);
        tv_showHobbies = findViewById(R.id.tv_hobbies);
        tv_showHobbies.setText("Hobbies: ");
        btn_getHobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_showHobbies.getText().toString().equals("Hobbies: ")){
                    tv_showHobbies.append(et_hobbies.getText().toString().trim());
                }else {
                    tv_showHobbies.append(", "+et_hobbies.getText().toString().trim());
                }
                tv_showHobbies.setVisibility(View.VISIBLE);
                et_hobbies.setText("");
                //hide keyboard
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });



    }
}