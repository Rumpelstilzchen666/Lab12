package Ex4;

public class TestTelNumber {
    public static void main(String[] args) {
        String[] telNumbers = new String[]{
                "89175655655",
                "+79175655655",
                "+111104289652211"
        };
        for(String telNumber : telNumbers) {
            System.out.println(telNumber + " -> " + new TelNumber(telNumber).toString());
        }
    }
}
