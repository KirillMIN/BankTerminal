package Services;

import java.security.SecureRandom;

public class PasswordCreatorService {

    // Метод генерации случайного буквенно-цифрового пароля определенной длины
    public static String generateRandomPassword(int len, int randNumOrigin, int randNumBound)
    {
        SecureRandom random = new SecureRandom();
        return random.ints(randNumOrigin, randNumBound + 1)
                .filter(i -> Character.isAlphabetic(i) || Character.isDigit(i))
                .limit(len)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

}
