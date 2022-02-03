import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ContractGeneratorTest {

    Map<String, String> map;

    @Before
    public void beforeMethod(){
        map = new HashMap<>();
        map.put("Company Name", "Evisort");
        map.put("Company products", "products and service");
    }

    @Test
    public void contractGeneratorTest1(){

        String blob = "{{Company Name}} is committed to a policy of vigorous, lawful, and ethical competition which is based on the merits of our {{Company products}}.";
        String expected = "Evisort is committed to a policy of vigorous, lawful, and ethical competition which is based on the merits of our products and service.";

        assertEquals(expected, ContractGenerator.contractGenerator(blob, map));

    }

    @Test(expected = IllegalArgumentException.class)
    public void contractGeneratorTest2(){

        String blob = "{Company Name}} is committed to a policy of vigorous, lawful, and ethical competition which is based on the merits of our {{Company products}}.";

        ContractGenerator.contractGenerator(blob, map);

    }

    @Test(expected = IllegalArgumentException.class)
    public void contractGeneratorTest3(){

        String blob = "{{Company Name} is committed to a policy of vigorous, lawful, and ethical competition which is based on the merits of our {{Company products}}.";

        ContractGenerator.contractGenerator(blob, map);

    }

    @Test(expected = IllegalArgumentException.class)
    public void contractGeneratorTest4(){

        String blob = "{{Company Name}} is committed to a policy of vigorous, lawful, and ethical competition which is based on the merits of our {{Company products}";

        ContractGenerator.contractGenerator(blob, map);

    }

    @Test(expected = IllegalArgumentException.class)
    public void contractGeneratorTest5(){

        String blob = "{{";

        ContractGenerator.contractGenerator(blob, map);

    }

    @Test(expected = IllegalArgumentException.class)
    public void contractGeneratorTest6(){

        String blob = "{{abc";

        ContractGenerator.contractGenerator(blob, map);

    }

    @Test(expected = IllegalArgumentException.class)
    public void contractGeneratorTest7(){

        String blob = "}}";

        ContractGenerator.contractGenerator(blob, map);

    }

    @Test
    public void contractGeneratorTest8(){

        String blob = "{{Company Nam}} is committed to a policy of vigorous, lawful, and ethical competition which is based on the merits of our {{Company products}}.";
        String expected = " is committed to a policy of vigorous, lawful, and ethical competition which is based on the merits of our products and service.";

        assertEquals(expected, ContractGenerator.contractGenerator(blob, map));

    }







}