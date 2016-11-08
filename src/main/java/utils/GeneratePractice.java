package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bill.witt on 11/7/2016.
 */
public class GeneratePractice {

    public static String randomPractice() {

        List<String> practices = new ArrayList<>();
        practices.add(".NET");
        practices.add("IxD");
        practices.add("JAVA");
        practices.add("MOBILE");
        practices.add("PMO");
        practices.add("QA");
        practices.add("SCRIPTED");

        int rand = new Random().nextInt(practices.size());
        System.out.println(practices.get(rand));
        return practices.get(rand);
    }

}
