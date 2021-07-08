package com.example.sqlandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlandroid2.maindb.MainDB;
import com.example.sqlandroid2.mainmodel.MainModel;

public class MainActivity extends AppCompatActivity {
    Button btnCreate, btnList;
    EditText edId, edName;
    MainDB mainDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edId = findViewById(R.id.ed_id);
        edName = findViewById(R.id.ed_name);
        btnCreate = findViewById(R.id.btn_create);
        btnList = findViewById(R.id.btn_list);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDB = new MainDB(MainActivity.this);
                MainModel mainModel = new MainModel();
                mainModel.setMainId(edId.getText().toString());
                mainModel.setMainName(edName.getText().toString());


                if (mainDB.insertMain(mainModel) > 0){
                    Toast.makeText(MainActivity.this, "Create user thành công !!", Toast.LENGTH_SHORT).show();
                    edId.setText("");
                    edName.setText("");
                }else {
                    Toast.makeText(MainActivity.this, "Create user không thành công !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}