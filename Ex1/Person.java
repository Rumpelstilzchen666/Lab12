package Ex1;

public class Person {
    private final String surname, firstName, middleName;

    public Person(final String surname, final String firstName,
            final String middleName) {
        this.surname = (surname == null || surname.equals("") ? null :
                surname.trim());
        this.firstName = (firstName == null || firstName.equals("") ? null :
                firstName.trim());
        this.middleName = (middleName == null || middleName.equals("") ? null :
                middleName.trim());
    }

    public String getLongName() {
        if(firstName != null && middleName != null)
            return surname + ' ' + firstName + ' ' + middleName;
        if(firstName != null)
            return surname + ' ' + firstName;
        if(middleName != null)
            return surname + ' ' + middleName;
        return surname;
    }

    public String getShortName() {
        if(firstName != null && middleName != null)
            return surname + ' ' + firstName.charAt(0) + "." +
                    middleName.charAt(0) + ".";
        if(firstName != null)
            return surname + ' ' + firstName.charAt(0) + ".";
        if(middleName != null)
            return surname + ' ' + middleName.charAt(0) + ".";
        return surname;
    }
}
