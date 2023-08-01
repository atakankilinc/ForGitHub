 package com.atakankilinc.ilkuygulama;

 import android.content.DialogInterface;
 import android.content.SharedPreferences;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.TextView;
 import android.widget.Toast;

 import androidx.appcompat.app.AlertDialog;
 import androidx.appcompat.app.AppCompatActivity;

 import java.lang.reflect.MalformedParametersException;

 public class MainActivity extends AppCompatActivity {

     Button saveButton;
     Button deleteButton;
     TextView textView;
     EditText editText;
     SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.savebutton);
        deleteButton = findViewById(R.id.deletebutton);
        editText = findViewById(R.id.editTextNumber2);
        textView = findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.atakankilinc.ilkuygulama",MODE_PRIVATE);
        int storedAge = sharedPreferences.getInt("storedAge",0);
        textView.setText("Your age:"+storedAge);
        Toast.makeText(MainActivity.this,"Started",Toast.LENGTH_LONG).show();
    }
    public void save(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Save");
        alertDialog.setMessage("Are you sure");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!editText.getText().toString().matches("")) {
                    int userAge = Integer.parseInt(editText.getText().toString());
                    textView.setText("Your age:" + userAge);
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_LONG).show();
                    sharedPreferences.edit().putInt("storedAge",userAge).apply();
                }
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"No saved",Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.show();
    }
    }







