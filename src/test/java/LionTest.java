import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void doesHaveMane() throws Exception {
        Lion lionMale = new Lion("Самец", feline);
        boolean actual = lionMale.doesHaveMane();
        assertTrue("Это самец, у него есть грива", actual);
    }

    @Test
    public void doesHaveManeOfWho() {
        try {
            Lion lionWhoIs = new Lion("Оно", feline);
            assertTrue(lionWhoIs.doesHaveMane());
        } catch (Exception exception) {
            String actual = exception.getMessage();
            assertEquals("Используйте допустимые значения пола животного - самей или самка", actual);
        }
    }

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(50);
        int actual = lion.getKittens();
        assertEquals("Котенок не единственный", 50, actual);
    }


    @Test
    public void getFood() throws Exception {
        Lion lionFemale = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lionFemale.getFood();
        assertEquals("Что-то не так", (List.of("Животные", "Птицы", "Рыба")), actual);
    }


    @Test
    public void getFoodWithString() throws Exception {
        Lion lionOne = new Lion("Самка", feline);
        lionOne.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}

