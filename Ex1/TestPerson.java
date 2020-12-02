package Ex1;

import java.util.Date;

public class TestPerson {
    private static final int N = 10000000;

    public static void main(String[] args) {
        String rus_100_letters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяабвгдеёжзийклмнопрстуфхцчшщъыьэюяабвгдеёжзийклмнопрстуфхцчшщъыьэюяа",
                en_100_letters = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuv";
        String[] surnames = new String[]{
                    "ОченьОченьОченьДлиннаяФамилия",
                    "VeryVeryVeryLongSurname",
                    "ДлиннаяФамилия" + rus_100_letters,
                    "LongSurname" + en_100_letters,
                    "Фамилия",
                    "Ф",
                    "Фамилия",
                    "Фамилия",
                    "Фамилия"
                },
                firstNames = new String[]{
                    "ОченьОченьОченьДлинноеИмя",
                    "VeryVeryVeryLongFirstName",
                    "ДлинноеИмя" + rus_100_letters,
                    "LongFirstName" + en_100_letters,
                    "Имя",
                    "И",
                    "",
                    "Имя",
                    null
                },
                middleNames = new String[]{
                    "ОченьОченьОченьДлинноеОтчество",
                    "VeryVeryVeryLongMiddleName",
                    "ДлинноеОтчество" + rus_100_letters,
                    "LongMiddleName" + en_100_letters,
                    "Отчество",
                    "О",
                    null,
                    null,
                    "Отчество"
                };
        for(int i = 0; i < 10; i++) {
            surnames[0] += rus_100_letters;
            surnames[1] += en_100_letters;
            firstNames[0] += rus_100_letters;
            firstNames[1] += en_100_letters;
            middleNames[0] += rus_100_letters;
            middleNames[1] += en_100_letters;
        }

        System.out.println("Имя создётся " + N + " раз:");
        for(int i = 0; i < surnames.length; i++)
            testPersonNameString(new Person(surnames[i], firstNames[i], middleNames[i]));
    }

    private static void testPersonNameString(Person person) {
        long startTime;
        System.out.println(person.getLongName());
        startTime = new Date().getTime();
        for(int i = 0; i < N; i++)
            person.getLongName();
        System.out.println("Время: " + (new Date().getTime() - startTime) + " мс.");

        System.out.println(person.getShortName());
        startTime = new Date().getTime();
        for(int i = 0; i < N; i++)
            person.getShortName();
        System.out.println("Время: " + (new Date().getTime() - startTime) + " мс.\n");
    }
}
