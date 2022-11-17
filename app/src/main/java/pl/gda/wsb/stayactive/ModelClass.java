package pl.gda.wsb.stayactive;

public class ModelClass {
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

    public int getImageView1() {
        return imageView1;
    }

    public void setImageView1(int imageView1) {
        this.imageView1 = imageView1;
    }


    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    String exercise,working_muscles,description;
    int imageView1;
    boolean isVisible;


    public ModelClass(String exercise, String working_muscles, String description, int imageView1, boolean isVisible) {
        this.exercise = exercise;
        this.working_muscles = working_muscles;
        this.description = description;
        this.imageView1 = imageView1;

        this.isVisible = false;
    }
}
