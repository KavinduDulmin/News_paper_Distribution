package com.example.newspaperdistribution;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        String UserID = "DD";
        String password = "PP";
        EditText etUId;
        EditText etUPw;
        TextView etErrMessage;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            etUId = (EditText) findViewById(R.id.etUId);
            etUPw = (EditText) findViewById(R.id.etUPw);
            etErrMessage = (TextView) findViewById(R.id.etErrMessage);

        }

        public void btnLogin(View V)
        {
            if (etUId.getText().toString().equalsIgnoreCase(UserID) && etUPw.getText().toString().equals(password)) {
                Intent i = new Intent(this, Home.class);

                startActivity(i);
            } else
            {
                etErrMessage.setText("Invalid username and password");
            }
        }

    }