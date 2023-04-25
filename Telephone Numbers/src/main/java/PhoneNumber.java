public class PhoneNumber
{
    private int firstTelephoneNumberCode;
    private Integer fromNumber;
    private Integer toNumber;


    public PhoneNumber(int firstTelephoneNumberCode, Integer fromNumber, Integer toNumber)
    {
        if ((fromNumber==null && toNumber!=null) || (fromNumber!=null && toNumber==null)) {
            System.out.println("Диапазон должен быть двухсторонним");
            throw new IllegalArgumentException();
        }
        if (fromNumber!=null){
            if (firstTelephoneNumberCode%1000<100){
                System.out.println("Проверьте параметры номера телефона");
                throw new IllegalArgumentException();
            }
        }
        this.firstTelephoneNumberCode = firstTelephoneNumberCode;
        this.fromNumber = fromNumber;
        this.toNumber = toNumber;
    }

    public int getFirstTelephoneNumberCode() {
        return firstTelephoneNumberCode;
    }

    public Integer getFromNumber() {
        return fromNumber;
    }

    public Integer getToNumber() {
        return toNumber;
    }
}
