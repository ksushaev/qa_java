import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getFoodWithString() throws Exception {
        Lion lionOne = new Lion("Самка", feline);
        lionOne.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void anotherSexOfLion() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Оно", feline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}

