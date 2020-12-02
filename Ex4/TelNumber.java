package Ex4;

public class TelNumber {
    final String telNum;

    public TelNumber(final String telNum) {
        StringBuilder telNumBuilder = new StringBuilder(telNum);
        if(telNumBuilder.charAt(0) == '8') {
            telNumBuilder.replace(0, 1, "+7");
        }
        telNumBuilder.insert(telNumBuilder.length() - 7, '—')
                .insert(telNumBuilder.length() - 4, '—');
        this.telNum = telNumBuilder.toString();
    }

    @Override
    public String toString() {
        return telNum;
    }
}
