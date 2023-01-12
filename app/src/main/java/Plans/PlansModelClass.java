package Plans;

public class PlansModelClass {
    String mscl,exc,reps;

    public String getMscl() {
        return mscl;
    }

    public String getExc() {
        return exc;
    }

    public void setExc(String exc) {
        this.exc = exc;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public PlansModelClass(String mscl, String exc, String reps) {
        this.mscl = mscl;
        this.exc = exc;
        this.reps = reps;
    }
}
