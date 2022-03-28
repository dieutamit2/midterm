package com.example.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imgView;
    private Button btnEdit;
    private EditText emailTxt, userTxt, passwordTxt;
    private DataBaseConnection dataBaseConnection;
    private final String INSERT_USER_TABLE = "INSERT INTO USER_INFO VALUES(null, '%s', '%s','%s', '', '', '', '')";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initConnection();
        initScreen();
    }

    private void initConnection() {
        dataBaseConnection = new DataBaseConnection(this,"UserInfoApp.sqlite",null,1);
        dataBaseConnection.createTable();
    }

    private void initScreen() {
        imgView = this.findViewById(R.id.img_srcImage);
        imgView.setImageResource(R.drawable.logo);

        btnEdit = findViewById(R.id.sign_up_btn);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String insertSQL = String.format(INSERT_USER_TABLE, emailTxt.getText(), userTxt.getText(), passwordTxt.getText());
                dataBaseConnection.readQuery(insertSQL);
                onClickGoToInsert();
                finish();
            }
        });

        emailTxt = this.findViewById(R.id.email_txt);
        userTxt = this.findViewById(R.id.user_txt);
        passwordTxt = this.findViewById(R.id.password_txt);
    }

    public void onClickGoToInsert() {
        Intent intent = new Intent(this, InsertActivity.class);
        intent.putExtra("userName", userTxt.getText());
        intent.putExtra("password", passwordTxt.getText());
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }
}