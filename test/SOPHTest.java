import org.junit.Test;

/**
 * Created by qiuqian on 9/29/17.
 */
public class SOPHTest {

    SOPH soph = new SOPH(60, "c2", 10000, 43);

    @Test
    public void acceptanceTest(){
        System.out.println(soph.acceptanceProbability(2183, 2233, 28));
    }
}
