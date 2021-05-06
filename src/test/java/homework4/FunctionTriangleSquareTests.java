package homework4;


import com.geekbrains.FunctionTriangleSquare;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionTriangleSquareTests {
    private static Logger logger = LoggerFactory.getLogger(FunctionTriangleSquareTests.class);

      FunctionTriangleSquare functionTriangleSquare = new FunctionTriangleSquare();

    @BeforeAll
    static void beforeAll() {
        logger.info("Выполнится перед всем тестовым набором");
    }

    @BeforeEach
    void setUp() {
        logger.info("Выполнится перед каждым тестом");
    }

    @ParameterizedTest
    @CsvSource({"1.1, 2.1, 3.1, 0.5822531665864961"})
    void testIsABorCPositive(double a,double b, double c, double result){
        Assertions.assertEquals(functionTriangleSquare.squareTriangle(a, b, c), result);
    }
    @ParameterizedTest
    @CsvSource({"1.0, 2.0, 3.0, 0.0"})
    void testIsABandC123(double a,double b, double c, double result){
        Assertions.assertEquals(functionTriangleSquare.squareTriangle(a, b, c), result);
    }
    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 0.0, 0.0"})
    void testIsABandCequal0(double a,double b, double c, double result){
        Assertions.assertEquals(functionTriangleSquare.squareTriangle(a, b, c), result);
    }

    @ParameterizedTest
    @CsvSource({"123.0, 456.0, 789.0, NaN"})
    void testIsABandCThrowsNaN(double a,double b, double c, double result){
        Assertions.assertEquals(functionTriangleSquare.squareTriangle(a, b, c), result);
    }

    @ParameterizedTest
    @CsvSource({"-1.0, -5.0, -3.0, NaN"})
    void testIfABandCNegative(double a,double b, double c, double result){
        Assertions.assertEquals(functionTriangleSquare.squareTriangle(a, b, c), result);
    }


    @AfterEach
    void tearDown() {
        logger.debug("Выполнится после каждого теста");
    }

    @AfterAll
    static void afterAll() {
        logger.debug("Выполнится после всех тестовых наборов");
    }
}
