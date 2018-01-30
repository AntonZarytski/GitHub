package company.com.workoutdetail.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import company.com.workoutdetail.R;
import company.com.workoutdetail.models.Workout;
import company.com.workoutdetail.models.WorkoutList;

public class WorkoutDetailActivity extends AppCompatActivity {
    private static final String WORKOUT_INDEX = "WORKOUT_INDEX";
    private Button plusBtn;
    private Button minusBtn;
    private TextView countOfRepeatTextView;
    private SeekBar seekBar;
    private TextView weight;
    private Integer repeatCount = 0;
    private Integer currentIndex;
    private Workout workout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);
        fetchWorkOut();
        initViews();
        initListeners();

    }

    public static void showDetail(Context context, int index){
        Intent intent = new Intent(context, WorkoutDetailActivity.class);
        intent.putExtra(WORKOUT_INDEX, index);
        context.startActivity(intent);
    }

    public void fetchWorkOut(){
        Intent intent = getIntent();
        currentIndex = intent.getIntExtra(WORKOUT_INDEX, 1);
        workout = WorkoutList.getInstance(this).getWorkouts().get(currentIndex);
    }

    private void initListeners() {
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatCount++;
                countOfRepeatTextView.setText(repeatCount.toString());
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatCount--;
                if (repeatCount < 0)
                    repeatCount = 0;
                countOfRepeatTextView.setText(repeatCount.toString());
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weight.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initViews() {
        plusBtn = findViewById(R.id.plus_btn);
        minusBtn = findViewById(R.id.minus_btn);
        countOfRepeatTextView = findViewById(R.id.count_of_repeat_text_view);
        countOfRepeatTextView.setText(repeatCount.toString());
        seekBar = findViewById(R.id.seekBar);
        weight = findViewById(R.id.count_of_weight_text_view);
    }
}
