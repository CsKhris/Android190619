package com.cs.android190619;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button loginBtn = (Button)findViewById(R.id.loginbtn);
        loginBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Log.e("확인", "확인");
                //login.xml로 Design 한 View 찾아오기
                final LinearLayout login =
                        (LinearLayout)View.inflate(
                        DialogActivity.this,
                        R.layout.login, null);
                new AlertDialog.Builder(DialogActivity.this)
                        .setTitle("Sign In")
                        .setView(login)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText id = (EditText)login.findViewById(R.id.id);
                                EditText pw = (EditText)login.findViewById(R.id.pw);
                                String inputId = id.getText().toString();
                                String inputPw = pw.getText().toString();
                                Toast.makeText(DialogActivity.this, inputId+":" +inputPw, Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });
    }
}
