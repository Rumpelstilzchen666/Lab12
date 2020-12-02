package Ex5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        System.out.println("Введите адрес файла");
        try (Scanner fileNameScanner = new Scanner(System.in)) {
            Scanner fileScanner = new Scanner(new File(fileNameScanner.nextLine()));
            final ArrayList<Line> words = new ArrayList<>();
            while(fileScanner.hasNext()) {
                words.add(new Line(fileScanner.next()));
            }
            fileScanner.close();
            System.out.println(getLineInABCOrder(null, words));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getLineInABCOrder(Line line, ArrayList<Line> lines) {
        Line tempLine1, tempLine2;
        String tempResult;
        final int len = lines.size();
        for(int i = 0; i < len; i++) {
            if(line == null || line.appendable(lines.get(i))) {
                tempLine1 = lines.remove(i);
                tempLine2 = (line == null ? tempLine1 : line).copy();
                if(line != null) {
                    tempLine2.append(tempLine1);
                }
                tempResult = getLineInABCOrder(tempLine2, lines);
                lines.add(i, tempLine1);
                if(tempResult != null) {
                    return tempResult;
                }
            }
        }
        if(lines.isEmpty()) {
            return (line == null ? "" : line.text.toString());
        }
        return null;
    }
}
