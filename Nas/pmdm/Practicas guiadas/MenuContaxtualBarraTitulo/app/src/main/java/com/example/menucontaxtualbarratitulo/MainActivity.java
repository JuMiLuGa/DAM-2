package com.example.menucontaxtualbarratitulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    ActionMode am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);

        et1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (am!=null)
                    return true;
                am=startActionMode(amc);
                return true;
            }
        });

    }

    ActionMode.Callback amc = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menucontextualbarra, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.maiusculas:
                    et1.setText(et1.getText().toString().toUpperCase());
                    mode.finish();
                    return true;
                case R.id.minusculas:
                    et1.setText(et1.getText().toString().toLowerCase());
                    mode.finish();
                    return true;

            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            am=null;
        }
    };


}