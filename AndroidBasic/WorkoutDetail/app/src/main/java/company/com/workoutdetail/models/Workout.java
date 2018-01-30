package company.com.workoutdetail.models;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Anton&&Natasha on 30.01.2018.
 */

public class Workout {
    private String tittle;
    private String description;
    private int lastRecordsReps = 0;
    private Date lastRecordDate;
    private int imageResId;

    public Workout(Context context, int tittle, int description, int imageResId) {
        this.tittle = context.getString(tittle);
        this.description = context.getString(description);
        lastRecordDate = new Date();
        this.imageResId = imageResId;
    }
    public String getFormattedDate(){
        return new SimpleDateFormat("DD MMMM YYYY",
                new Locale("ru", "Ru")).format(lastRecordDate);
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLastRecordsReps() {
        return lastRecordsReps;
    }

    public void setLastRecordsReps(int lastRecordsReps) {
        if(lastRecordsReps > this.lastRecordsReps){
            this.lastRecordsReps = lastRecordsReps;
            lastRecordDate = new Date();
        }

    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
