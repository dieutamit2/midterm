package com.example.midterm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {

    private final String updateSQL = "UPDATE USER_INFO SET " +
            " Name = '%s' ," +
            " Des = '%s" +
            " Link ='%s' , " +
            " Price = '%s' " +
            "  WHERE USER_NAME = '%s' " +
            " AND PASSWORD = '%s'";
    String userName, password;
    private DataBaseConnection dataBaseConnection;
    private Button btnInsert;
    private EditText emailInfoTxt, fullNameTxt, contactTxt, addressTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_data);
        initConnection();
        initData();
        initScreen();
    }

    private void initConnection() {
        dataBaseConnection = new DataBaseConnection(this, "UserInfoApp.sqlite", null, 1);
        dataBaseConnection.createTable();
    }

    private void initScreen() {
        emailInfoTxt = this.findViewById(R.id.email_info_txt);
        fullNameTxt = this.findViewById(R.id.full_name_txt);
        contactTxt = this.findViewById(R.id.contract_txt);
        addressTxt = this.findViewById(R.id.address_txt);

        btnInsert = findViewById(R.id.insert_btn);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String insertSQL = String.format(updateSQL,
                        emailInfoTxt.getText(),
                        fullNameTxt.getText(),
                        contactTxt.getText(),
                        addressTxt.getText(),
                        userName,
                        password);
                dataBaseConnection.readQuery(insertSQL);
                finish();
            }
        });

    }

    private void initData() {
        userName = getIntent().getSerializableExtra("userName") != null
                ? getIntent().getSerializableExtra("userName").toString() : "";
        password = getIntent().getSerializableExtra("password") != null
                ? getIntent().getSerializableExtra("password").toString() : "";
    }
}
