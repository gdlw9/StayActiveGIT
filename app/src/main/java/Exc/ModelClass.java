package Exc;

import android.widget.ImageView;

import java.io.InputStream;

public class ModelClass {
    String exercise,working_muscles,description;
    byte[] image;
    boolean isVisible;

    public ModelClass(String exercise, String working_muscles, String description, byte[] image, boolean isVisible) {
        this.exercise = exercise;
        this.working_muscles = working_muscles;
        this.description = description;
        this.image = image;
        this.isVisible = false;
    }
    public String getExercise() {
        return exercise;
    }

    public String getWorking_muscles() {
        return working_muscles;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }

    public boolean isVisible() {
        return isVisible;
    }
    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
