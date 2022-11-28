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

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getWorking_muscles() {
        return working_muscles;
    }

    public void setWorking_muscles(String working_muscles) {
        this.working_muscles = working_muscles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] imageView1) {
        this.image = imageView1;
    }


    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }


}
