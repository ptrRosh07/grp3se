package se.grp3.theorganizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CollabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collab);

        Button createCollab = (Button) findViewById(R.id.createCollab);
        createCollab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNext = new Intent(CollabActivity.this, CreateCollabActivity.class);
                startActivity(goToNext);
            }
        });

        Button monitorCollab = (Button) findViewById(R.id.monitorCollab);
        monitorCollab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNext = new Intent(CollabActivity.this, MonitorCollabActivity.class);
                startActivity(goToNext);
            }
        });
    }
}
