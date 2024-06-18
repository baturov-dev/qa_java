package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String kindOfAnimal;
    private final List<String> expected;

    public AnimalTest(String kindOfAnimal, List<String> expected) {
        this.kindOfAnimal = kindOfAnimal;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getListOfMealDataForHerbivoreAndPredator() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}

        };
    }

    @Test
    public void testOfAnimalGetFoodPositive() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(kindOfAnimal);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testOfAnimalGetFoodException() throws Exception {
        Animal animal = new Animal();
        String invalidKindOfAnimal = "неизвестно";
        Exception actualException = null;
        animal.getFood(invalidKindOfAnimal);
        Assert.assertNotNull(actualException);
    }

    @Test
    public void testOfAnimalGetFamily() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }
}