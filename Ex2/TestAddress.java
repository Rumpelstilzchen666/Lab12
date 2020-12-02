package Ex2;

public class TestAddress {
    public static void main(String[] args) {
        String[] addressesA = new String[]{
                "      Россия     	,	   Московская   область, Москва,  проспект Вернадского, 78, И  	, 204",
                "США, округ Колумбия,       Вашингтон, Пенсильвания-авеню, 1600     ",
                "   Россия,     Московская область  	 , Москва,	 Академика Королёва, 12		,	",
                "США, 	  	штат Юта, 	Солт-Лейк-Сити",
                " , 	 "
        };
        String[] addressesB = new String[]{
                "      Россия     	-	   Московская   область; Москва,  проспект Вернадского- 78, И  	. 204",
                "США. округ Колумбия,       Вашингтон- Пенсильвания-авеню- 1600     ",
                "   Россия;	     Московская область     		, Москва-	 	 Академика Королёва, 12		- 	",
                "США, 	  	штат Юта. 	Солт-Лейк-Сити",
                " - 	 "
        };


        for(String address : addressesA) {
            System.out.println(address);
            System.out.println(new Address(address).toString() + '\n');
        }

        System.out.println("-------------------");

        for(String address : addressesB) {
            System.out.println(address);
            System.out.println(new Address(address, ".,;-").toString() + '\n');
        }
    }
}
