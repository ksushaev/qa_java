import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void getOneKittensTest() {
        int actual = feline.getKittens();
        assertEquals("Число котят по умолчанию не возвращается", 1, actual);
    }

    @Test
    public void getCountOfKittensTest() {
        int actual = feline.getKittens(50);
        assertEquals("Число котят не вернулось", 50, actual);
    }

    @Test
    public void whatsFamilyTest() {
        String actual = feline.getFamily();
        assertEquals("Это не кошачьи", "Кошачьи", actual);
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> actual = feline.eatMeat();
        assertEquals("Еда хищника не соответствует", List.of("Животные", "Птицы", "Рыба"), actual);
    }
}
