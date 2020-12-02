package Ex3;

import java.util.StringTokenizer;

public class Shirt {
    private final String id, name, color;
    private final Size size;

    public Shirt(String shirtString) {
        StringTokenizer stShirt = new StringTokenizer(shirtString, ",");
        id = stShirt.nextToken();
        name = stShirt.nextToken();
        color = stShirt.nextToken();
        size = Size.getSize(stShirt.nextToken());
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id = " + id +
                ", name = " + name +
                ", color = " + color +
                ", size = " + size +
                '}';
    }

    private enum Size {
        S("S"), M("M"), L("L"), XL("XL");
        private final String txt;

        Size(String txt) {
            this.txt = txt;
        }

        public static Size getSize(String size) {
            return switch (size.toUpperCase()) {
                case "S" -> S;
                case "M" -> M;
                case "L" -> L;
                case "XL" -> XL;
                default -> throw new IllegalStateException(
                        "Unexpected value: " + size);
            };
        }

        @Override
        public String toString() {
            return txt;
        }
    }
}
