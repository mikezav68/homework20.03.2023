import java.util.Objects;

public class Main {
    private static final String SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
    public static void main(String[] args) {
        if (validate("mikezav68", "passat1987", "passat1987")) {
            System.out.println("Логин и пароль корректные");
        }
    }
    private static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть не более 20 символов");
        }
        if (Objects.isNull(password) || password.length() >= 20) {
            throw new WrongPasswordException("Длина пароля должна быть менее 20 символов");
        }
        for (int i = 0; i < login.toCharArray().length; i++) {
            if (!SYMBOLS.contains(Character.toString(login.toCharArray()[i]))) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            }
        }
        for (int i = 0; i < password.toCharArray().length; i++) {
            if (!SYMBOLS.contains(Character.toString(password.toCharArray()[i]))) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}