package Ex5;

public class Line implements Cloneable {
    public StringBuilder text;
    public char firstLetter, lastLetter;

    public Line(final String word) {
        this.text = new StringBuilder(word);
        if(word.isEmpty()) {
            this.firstLetter = '\0';
            this.lastLetter = '\0';
        }
        else {
            this.firstLetter = word.toLowerCase().charAt(0);
            this.lastLetter = word.toLowerCase().charAt(word.length() - 1);
        }
    }

    public Line(final Line line) {
        this.text = new StringBuilder(line.text);
        this.firstLetter = line.firstLetter;
        this.lastLetter = line.lastLetter;
    }

    public boolean appendable(final Line line) {
        return lastLetter == line.firstLetter ||
                lastLetter == '\0' || line.firstLetter == '\0';
    }

    public boolean append(final String line) {
        return append(new Line(line));
    }

    public boolean append(final Line line) {
        if(appendable(line)) {
            text.append(' ').append(line.text);
            lastLetter = line.lastLetter;
            return true;
        }
        return false;
    }

    protected Line copy() {
        return new Line(text.toString());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Line{" +
                "text = " + text +
                ", firstLetter = " + firstLetter +
                ", lastLetter = " + lastLetter +
                '}';
    }
}
