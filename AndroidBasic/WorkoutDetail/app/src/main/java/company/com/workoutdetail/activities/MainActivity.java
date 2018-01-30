package company.com.workoutdetail.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import company.com.workoutdetail.R;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button showDetail = findViewById(R.id.detail_button);
    showDetail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            WorkoutDetailActivity.showDetail(MainActivity.this, 0);
        }
    });
    }
}
