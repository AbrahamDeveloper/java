import java.security.SecureRandom;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        int length = 10; // Specify the desired length of the password
        
        String password = generateRandomPassword(length);
        
        System.out.println("Randomly Generated Password: " + password);
    }
    
    private static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        
        return password.toString();
    }
}
