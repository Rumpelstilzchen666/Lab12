package Ex2;

import org.jetbrains.annotations.NotNull;

import java.util.StringTokenizer;

public class Address {
    private String country, region, city, street, house, building, flat;

    public Address(String address) {
        setAddress(parseAddress(address, ","));
    }

    public Address(String address, String delimiters) {
        if(delimiters.contains("-") && address.contains("-")) {
            setAddress(address.split("[" + delimiters + "][ \\t]"));
        }
        else {
            setAddress(parseAddress(address, delimiters));
        }
    }

    private String[] parseAddress(String address, String delimiters) {
        StringTokenizer addressTokenizer =
                new StringTokenizer(address, delimiters);
        String[] addressParts = new String[addressTokenizer.countTokens()];
        for(int i = 0; i < addressParts.length; i++) {
            addressParts[i] = addressTokenizer.nextToken();
        }
        return addressParts;
    }

    private void setAddress(String @NotNull [] addressParts) {
        for(int i = 0; i < addressParts.length; i++) {
            addressParts[i] = addressParts[i].trim();
        }

        if(addressParts.length < 1 || addressParts[0].equals(""))
            return;
        country = addressParts[0];
        if(addressParts.length < 2 || addressParts[1].equals(""))
            return;
        region = addressParts[1];
        if(addressParts.length < 3 || addressParts[2].equals(""))
            return;
        city = addressParts[2];
        if(addressParts.length < 4 || addressParts[3].equals(""))
            return;
        street = addressParts[3];
        if(addressParts.length < 5 || addressParts[4].equals(""))
            return;
        house = addressParts[4];
        if(addressParts.length < 6 || addressParts[5].equals(""))
            return;
        building = addressParts[5];
        if(addressParts.length < 7 || addressParts[6].equals(""))
            return;
        flat = addressParts[6];
    }

    @Override
    public String toString() {
        String s = "";
        if(country != null) {
             s = "Страна = " + country;
            if(region != null) {
                s += ", Регион = " + region;
                if(city != null) {
                    s += ", Город = " + city;
                    if(street != null) {
                        s += ", Улица = " + street;
                        if(house != null) {
                            s += ", Дом = " + house;
                            if(building != null) {
                                s += ", Корпус = " + building;
                                if(flat != null) {
                                    s += ", Квартира = " + flat;
                                }
                            }
                        }
                    }
                }
            }
        }
        return "Address{" + s + '}';
    }
}

//StringTokenizer почти в 2 раза быстрее, чем split(), но последний принимает
//регулярки, а StringTokenizer - просто набор возможных разделителей. Из-за
//этого StringTokenizer не позволяет нормально обработать названия с дефисом,
//вроде Орехово-Зуево или Пенсильвания-авеню - он зоспринимает их как 2 разных
//Этот ужас решает проблему StringTokenizer с Орехово-Зуево (но это не точно),
//но не с Солт-Лейк-Сити, и замедляет программу более чем в 1.5 раза, тем самым
//нивелируя все его плюсы
/*
        String str, str2, strDelim = "";
        char flag = 0;
        StringTokenizer addressTokenizer =
            new StringTokenizer(address, ",.;-", true);
        if(addressTokenizer.hasMoreTokens()) {
            str = addressTokenizer.nextToken();
            if(addressTokenizer.hasMoreTokens()) {
                strDelim = addressTokenizer.nextToken();
                while(addressTokenizer.hasMoreTokens()) {
                    flag = 0;
                    if(strDelim.equals("-")) {
                        str2 = addressTokenizer.nextToken();
                        if(addressTokenizer.hasMoreTokens()) {
                            strDelim = addressTokenizer.nextToken();
                        }
                        if(str2.charAt(0) != ' ') {
                            flag = 1;
                            System.out.println(str.trim() + '-' + str2);
                            if(addressTokenizer.hasMoreTokens()) {
                                flag = 0;
                                str = addressTokenizer.nextToken();
                            }
                        }
                        else {
                            flag = 2;
                            System.out.println(str.trim());
                            str = str2;
                        }
                    }
                    else {
                        System.out.println(str.trim());
                        str = addressTokenizer.nextToken();
                    }
                    if(flag != 2 && addressTokenizer.hasMoreTokens()) {
                        strDelim = addressTokenizer.nextToken();
                    }
                }
            }
            if(flag != 1) {
                System.out.println(str.trim());
            }
        }
 */
