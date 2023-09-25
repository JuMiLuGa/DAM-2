package com.example.menucontextual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);

        registerForContextMenu(et1);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menucontextual,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int numero = item.getItemId();

        switch (numero){
            case R.id.maiusculas:
                et1.setText(et1.getText().toString().toUpperCase());
                return true;
            case R.id.minusculas:
                et1.setText(et1.getText().toString().toLowerCase());
                return true;

        }
        return super.onContextItemSelected(item);

    }
}