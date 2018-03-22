import controller.domain.Kweet;
import controller.domain.Profile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class KweetTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void Kweet()
    {
        Profile testProfile = new Profile("daan");
        Executable nameForgotten = () -> {
            Kweet baseKweet = new Kweet(null, "vette shit bro");
        };

        assertThrows(InvalidParameterException.class, nameForgotten, "name forgotten");
        Executable tooLongMessage = () -> {
            Kweet baseKweet = new Kweet(testProfile, "vette shit broabcdehjfshlfkjsdhljgslkjfdhgfjsdhflkjfhdslkjhflskdjhfljshdljfhlksjdhlkfjhsdljhflkjshdlkfjgsdhgfkdshagkafhdgskdhfbvbviauhegreguatehagshtgshdhfkdshgfakdhgdkjhsadgfkadshgkfhgsdkjhgfskfdkjhsdgkfhgbrugrursydgrsgfrskygfdskyfgrskdhrgfksdhgfdkjgruygfrskuygrkgfrygrskuygrfkuygfskyrgfsygfysgfygfkysdhgsdfhgshgfkjsgrkurgkfdgksjfkjgdfgdkhfgrksdgdrkugrekfukfudrgkrugdrsughrkgrdsgdkusdrlg");
        };

        assertThrows(InvalidParameterException.class, tooLongMessage, "message too long");
    }
}