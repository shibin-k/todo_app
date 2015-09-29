package com.example.skunnathparamba.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText todoItem;
    Button saveButton;
    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Bundle extras = getIntent().getExtras();
        String item_text = extras.getString(Constant.ITEM_KEY);
        itemPosition = extras.getInt(Constant.ITEM_POSITION);
        todoItem = (EditText)findViewById(R.id.editTodoItem);
        todoItem.setText(item_text);
        todoItem.setSelection(todoItem.getText().length());

        setupOnSaveListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupOnSaveListener() {
        saveButton = (Button) findViewById(R.id.save_item);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(Constant.ITEM_KEY, todoItem.getText().toString());
                data.putExtra(Constant.ITEM_POSITION, itemPosition);
                setResult(RESULT_OK, data);
                EditItemActivity.this.finish();
            }
        });
    }
}
