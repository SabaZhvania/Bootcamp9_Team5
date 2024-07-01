package ge.tbcitacademy.util;

import ge.tbcitacademy.data.Constants;

import java.security.SecureRandom;

import static ge.tbcitacademy.data.Constants.CHARACTERS;

public class RandomPassUtil { ;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomPassword(){
        StringBuilder password = new StringBuilder(Constants.PASS_LENGTH);
        for (int i = 0; i < Constants.PASS_LENGTH; i++) {
            password.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return password.toString();
    }
}
