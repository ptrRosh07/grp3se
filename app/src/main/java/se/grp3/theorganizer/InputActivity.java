package se.grp3.theorganizer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    DataBaseHelper db;
    EditText eTitle;
    EditText eText;
    String title,text;
    public static SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        db=new DataBaseHelper(getApplicationContext());
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);


        eTitle=(EditText) findViewById(R.id.title);
        eText=(EditText) findViewById(R.id.text);



        Button create = (Button) findViewById(R.id.createBtn);
        create.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                title = eTitle.getText().toString();
                text = eText.getText().toString();

                if(title.length() == 0){
                    SharedPreferences.Editor editor = pref.edit();

                    int idName = pref.getInt("name", 0);
                    idName++;
                    title="new document "+idName ;
                    editor.putInt("name",idName);
                    editor.commit();

                };

                if( text.length() == 0){
                    Toast.makeText(getApplicationContext(), "Title or Text is/are empty",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.insertNote(title,text);
                    Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                    Intent goToNext = new Intent(InputActivity.this, MainActivity.class);
                    startActivity(goToNext);
                    finish();}
            }
        });
    }
}
