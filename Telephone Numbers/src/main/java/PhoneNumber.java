import java.util.Objects;

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
            if ((fromNumber>toNumber)) {
                System.out.println("fromNumber>toNumber");
                throw new IllegalArgumentException();
            }
        }
        if (fromNumber!=null){
            if (firstTelephoneNumberCode>999 || firstTelephoneNumberCode<900){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return firstTelephoneNumberCode == that.firstTelephoneNumberCode && Objects.equals(fromNumber, that.fromNumber) && Objects.equals(toNumber, that.toNumber);
    }

    @Override
    public int hashCode() {
        if(fromNumber!=null) return this.fromNumber+this.firstTelephoneNumberCode;
        else return this.firstTelephoneNumberCode;
    }
}
