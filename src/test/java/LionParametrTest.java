import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParametrTest {
    private final String sex;
    private final boolean mane;

    public LionParametrTest(String sex, boolean mane) {
        this.sex = sex;
        this.mane = mane;
    }

    @Parameterized.Parameters
    public static Object[][] AllOfLions() {
        return new Object[][]{
                {"Самец",true},
                {"Самка", false}
        };
    }

    Feline feline = Mockito.mock(Feline.class);

    @Test
    public void doesHaveMane() throws Exception {
        Lion lionMale = new Lion(sex, feline);
        Boolean actual = lionMale.doesHaveMane();
        assertEquals(mane, actual);
    }


    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(50);
        int actual = lion.getKittens();
        assertEquals("Котенок не единственный", 50, actual);
    }


    @Test
    public void getFood() throws Exception {
        Lion lionFemale = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lionFemale.getFood();
        assertEquals("Что-то не так", (List.of("Животные", "Птицы", "Рыба")), actual);
    }
}

