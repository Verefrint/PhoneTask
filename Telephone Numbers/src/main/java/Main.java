import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Map<PhoneOperator, PhoneNumber> tableWithPhoneNumbersAndOperators=new HashMap<>();
    static
    {
        tableWithPhoneNumbersAndOperators.put(new PhoneOperator("MegaphoneMoscow"), new PhoneNumber(926, null, null));
        tableWithPhoneNumbersAndOperators.put(new PhoneOperator("BilainMoscow"), new PhoneNumber(905, null, null));
        tableWithPhoneNumbersAndOperators.put(new PhoneOperator("Tele2Moscow"), new PhoneNumber(900, null, null));
        tableWithPhoneNumbersAndOperators.put(new PhoneOperator("MegaphoneBelgorod"), new PhoneNumber(929, 000, 005));
        tableWithPhoneNumbersAndOperators.put(new PhoneOperator("Tele2Kurgan"), new PhoneNumber(951, 262, 277));
        tableWithPhoneNumbersAndOperators.put(new PhoneOperator("MegaphoneIaroslavl"), new PhoneNumber(951, 280, 286));
    }

    public static Map<PhoneOperator, PhoneNumber> getTableWithPhoneNumbersAndOperators() {
        return tableWithPhoneNumbersAndOperators;
    }

    public static void main(String[] args)
    {
        //Воспринимает номер в таком формате +79290054946
        Scanner scanner=new Scanner(System.in);
        String phoneNumber=scanner.nextLine();
        System.out.println(phoneOperatorSearcher(phoneNumber).getNameOfCompany());
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
            int otherThreeDigits=Integer.parseInt(phoneNumber.substring(5, 8));
            for (PhoneOperator phoneOperator: tableWithPhoneNumbersAndOperators.keySet())
            {
                PhoneNumber currentPhoneNumber=tableWithPhoneNumbersAndOperators.get(phoneOperator);
                int firstTelephoneNumberCode= currentPhoneNumber.getFirstTelephoneNumberCode();

                if (firstTelephoneNumberCode!=ourFirstTelephoneNumberCode) continue;
                else
                {
                    Integer fromNumber=currentPhoneNumber.getFromNumber();
                    Integer toNumber= currentPhoneNumber.getToNumber();

                    if (fromNumber==null)
                    {
                        resultPhoneOperator=phoneOperator;
                    }
                    else
                    {
                        if (otherThreeDigits>=fromNumber && otherThreeDigits<=toNumber) {
                            resultPhoneOperator=phoneOperator;
                            return resultPhoneOperator;
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