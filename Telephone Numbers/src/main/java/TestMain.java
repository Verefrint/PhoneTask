import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain
{
    @Test
    public void getMegaphoneIaroslavlResult(){
        PhoneOperator phoneOperator=Main.phoneOperatorSearcher("+79512832825");
        assertEquals("MegaphoneIaroslavl", phoneOperator.getNameOfCompany());
    }
    @Test
    public void getTele2KurganResult(){
        PhoneOperator phoneOperator=Main.phoneOperatorSearcher("+79512622774");
        assertEquals("Tele2Kurgan", phoneOperator.getNameOfCompany());
    }
    @Test
    public void getMegaphoneMoscowlResult(){
        PhoneOperator phoneOperator=Main.phoneOperatorSearcher("+79263556847");
        assertEquals("MegaphoneMoscow", phoneOperator.getNameOfCompany());
    }
    @Test
    public void getMegaphoneBelgorodResult(){
        PhoneOperator phoneOperator=Main.phoneOperatorSearcher("+79290054946");
        assertEquals("MegaphoneBelgorod", phoneOperator.getNameOfCompany());
    }
    @Test
    public void getMegaphoneSaintPetesburgResult(){
        PhoneOperator phoneOperator=Main.phoneOperatorSearcher("+79993032324");
        assertEquals("MegaphoneSaintPetesburg", phoneOperator.getNameOfCompany());
    }
    @Test
    public void getMegaphoneMoscowResult(){
        PhoneOperator phoneOperator=Main.phoneOperatorSearcher("+79991033445");
        assertEquals("MegaphoneMoscow", phoneOperator.getNameOfCompany());
    }
}
