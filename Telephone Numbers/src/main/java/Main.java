import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Map<Integer, Map<PhoneNumber, PhoneOperator>> tableWithPhoneNumbersAndOperators=new HashMap<>();
    static
    {
        Map<PhoneNumber, PhoneOperator> for926=new HashMap<>();
        for926.put(new PhoneNumber(926, null, null), new PhoneOperator("MegaphoneMoscow"));
        Map<PhoneNumber, PhoneOperator> for905=new HashMap<>();
        for905.put(new PhoneNumber(905, null, null), new PhoneOperator("BilainMoscow"));
        Map<PhoneNumber, PhoneOperator> for900=new HashMap<>();
        for900.put(new PhoneNumber(900, null, null), new PhoneOperator("Tele2Moscow"));
        Map<PhoneNumber, PhoneOperator> for929=new HashMap<>();
        for929.put(new PhoneNumber(929,0,5999999), new PhoneOperator("MegaphoneBelgorod"));
        Map<PhoneNumber, PhoneOperator> for951=new HashMap<>();
        for951.put(new PhoneNumber(951, 2620000, 2779999), new PhoneOperator("Tele2Kurgan"));
        for951.put(new PhoneNumber(951, 2800000, 2869999), new PhoneOperator("MegaphoneIaroslavl"));
        Map<PhoneNumber, PhoneOperator> for999=new HashMap<>();
        for999.put(new PhoneNumber(999, 3030000, 3999999), new PhoneOperator("MegaphoneSaintPetesburg"));
        for999.put(new PhoneNumber(999, 2030000, 2999999), new PhoneOperator("MegaphoneSaintPetesburg"));
        for999.put(new PhoneNumber(999, 4500000, 9999999), new PhoneOperator("MegaphoneSaintPetesburg"));
        for999.put(new PhoneNumber(999, 1030000, 1999999), new PhoneOperator("MegaphoneMoscow"));
        tableWithPhoneNumbersAndOperators.put(926,for926);
        tableWithPhoneNumbersAndOperators.put(905,for905);
        tableWithPhoneNumbersAndOperators.put(900,for900);
        tableWithPhoneNumbersAndOperators.put(929,for929);
        tableWithPhoneNumbersAndOperators.put(951,for951);
        tableWithPhoneNumbersAndOperators.put(999,for999);
    }

    public static Map<Integer, Map<PhoneNumber, PhoneOperator>> getTableWithPhoneNumbersAndOperators() {
        return tableWithPhoneNumbersAndOperators;
    }

    public static void main(String[] args)
    {
        //Воспринимает номер в таком формате +79290054946
        Scanner scanner=new Scanner(System.in);
        String phoneNumber=scanner.nextLine();
        PhoneOperator phoneOperatorObject=phoneOperatorSearcher(phoneNumber);
        if (phoneOperatorObject==null) System.out.println("Такого номера нет в базе данных");
        else System.out.println(phoneOperatorObject.getNameOfCompany());
        scanner.close();
    }

    public static boolean isPhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^\\+(\\d[()]?){11}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find()) return true;
        else return false;
    }

    public static PhoneOperator phoneOperatorSearcher(String phoneNumber){
        boolean isPhoneNumber=isPhoneNumber(phoneNumber);

        if (isPhoneNumber)
        {
            PhoneOperator resultPhoneOperator=null;
            int ourFirstTelephoneNumberCode=Integer.parseInt(phoneNumber.substring(2, 5));
            int otherDigits=Integer.parseInt(phoneNumber.substring(5, 12));
            Map<PhoneNumber, PhoneOperator> mapFromBiggerTable=tableWithPhoneNumbersAndOperators.get(ourFirstTelephoneNumberCode);

            for (PhoneNumber currentPhoneNumberObject: mapFromBiggerTable.keySet())
            {
                int firstTelephoneNumberCode= currentPhoneNumberObject.getFirstTelephoneNumberCode();

                if (firstTelephoneNumberCode!=ourFirstTelephoneNumberCode) continue;
                else
                {
                    Integer fromNumber=currentPhoneNumberObject.getFromNumber();

                    if (fromNumber==null)
                    {
                        resultPhoneOperator=mapFromBiggerTable.get(currentPhoneNumberObject);
                        break;
                    }
                    else
                    {
                        Integer toNumber= currentPhoneNumberObject.getToNumber();

                        if (otherDigits>=fromNumber && otherDigits<=toNumber) {
                            resultPhoneOperator=mapFromBiggerTable.get(currentPhoneNumberObject);
                            break;
                        }
                    }
                }
            }
            return resultPhoneOperator;
        }else {
            System.out.println("Это не номер телефона");
            return null;
        }

    }

}