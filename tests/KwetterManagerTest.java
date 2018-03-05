import domain.Kweet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KwetterManagerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //    @Test(expected = InvalidParameterException.class)
    @Test
    void createKweet() {

        Executable nameForgotten = () -> {
            Kweet baseKweet = new Kweet("", "vette shit bro", new Date(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        };

        assertThrows(InvalidParameterException.class, nameForgotten, "name forgotten");
        Executable tooLongMessage = () -> {
            Kweet baseKweet = new Kweet("koen", "vette shit broabcdehjfshlfkjsdhljgslkjfdhgfjsdhflkjfhdslkjhflskdjhfljshdljfhlksjdhlkfjhsdljhflkjshdlkfjgsdhgfkdshagkafhdgskdhfbvbviauhegreguatehagshtgshdhfkdshgfakdhgdkjhsadgfkadshgkfhgsdkjhgfskfdkjhsdgkfhgbrugrursydgrsgfrskygfdskyfgrskdhrgfksdhgfdkjgruygfrskuygrkgfrygrskuygrfkuygfskyrgfsygfysgfygfkysdhgsdfhgshgfkjsgrkurgkfdgksjfkjgdfgdkhfgrksdgdrkugrekfukfudrgkrugdrsughrkgrdsgdkusdrlg", new Date(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        };

        assertThrows(InvalidParameterException.class, tooLongMessage, "message too long");

    }
}