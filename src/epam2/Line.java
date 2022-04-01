package epam2;

public class Line {
    private String l;

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    @Override
    public String toString() {
        return "line{" +
                "l='" + l + '\'' +
                '}';
    }
}
