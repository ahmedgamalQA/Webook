package DataDriven;

import com.github.javafaker.Faker;

import java.text.Normalizer;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateFakeData {
    private final Faker arabicFake;
    private final Faker englishFake;

    public GenerateFakeData() {
        this.arabicFake = new Faker(new Locale("ar-EG"));
        this.englishFake = new Faker();
    }

    public String fakeFirstName() {
        return englishFake.name().firstName();
    }
    public String fakeLastName() {
        return englishFake.name().lastName();
    }
    public String fakeEmail() {
        String username = englishFake.name().firstName().toLowerCase();
        String numbers = englishFake.number().digits(4);

        // Append @gmail.com to the username
        return username +numbers+"@gmail.com";

    }

    public String fakePassword() {
        String letters = englishFake.lorem().characters(5, true, false); // 5 letters, case sensitive
        String numbers = englishFake.number().digits(3);
        return letters + numbers; // Combine to meet the 8-character minimum, with at least 1 letter and 1 number
    }

    public String fakeMobileNumberKSA() {
        String remainingDigits = englishFake.number().digits(7);
        return "55" + remainingDigits;
    }
}
