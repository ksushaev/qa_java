import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundOfCat() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Кошка говорит не так", "Мяу", actual);
    }

    @Test
    public void getFoodOfCat() throws Exception {
        Cat cat = new Cat(feline);
        List<String> foodForFeline = List.of("Животные", "Птицы", "Рыба");
        Mockito.when((feline).eatMeat()).thenReturn(foodForFeline);
        assertEquals(foodForFeline, cat.getFood());
    }
}
