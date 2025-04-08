public class Line {
    private Dot d1,d2;
    public Line(Dot d1, Dot d2) {
        this.d1 = new Dot(d1.getX(), d1.getY());
        this.d2 = new Dot(d2.getX(), d2.getY());
    }
    public Dot getD1() {
        return d1;
    }

    public Dot getD2() {
        return d2;
    }
}
