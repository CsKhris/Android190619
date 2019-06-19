package com.cs.android190619;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Layout에 생성한 View 들 중에서 Code로 수정할 View 변수
    private TextView result;
    private Button btn;

    private String [] gender = {"Man", "Woman"};
    private Button singledialog;

    private String [] hobbies = {"Soccer", "Game", "TV", "Programming"};
    private Button multidialog;
    //Index들의 선택 여부를 저장하기 위한 배열
    private Boolean [] bSelect = {false, false, false, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View 변수들에 참조를 대입
        result = (TextView)findViewById(R.id.result);
        btn = (Button)findViewById(R.id.btn);

        //Button을 눌렀을 때 Event 처리
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose Want Comp")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setItems(R.array.itc, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Resource에 작성한 문자열 배열을 가져오기
                                String [] itcs =
                                        getResources().getStringArray(R.array.itc);
                                result.setText(itcs[i]);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });

        //단일항목 선택 대화상자 출력
        singledialog = (Button)findViewById(R.id.singledialog);
        singledialog.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose Your Gender")
                        .setSingleChoiceItems(gender, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface,
                                                int i) {
                                String item = gender[i];
                                Toast.makeText(
                                        MainActivity.this, item,
                                        Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });

        //다중 선택 대화상자 출력
        multidialog = (Button)findViewById(R.id.multidialog);
        multidialog.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("다중 선택 대화상자")
                        .setMultiChoiceItems(hobbies, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                //선택이 변경된 항목의 값으로 배열의 값을 변경
                                bSelect[i] = b;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String hobby = "";
                                int idx=0;

                                for(boolean b : bSelect){
                                    if(b) {
                                        hobby = hobby + hobbies[idx];
                                        bSelect[idx] = false;
                                    }
                                    idx = idx + 1;
                                }
                                result.setText(hobby);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });
    }
}
