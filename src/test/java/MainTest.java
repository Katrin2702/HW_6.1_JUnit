import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getUsers() {
        User user1 = new User("kat333", "pass123", "kat333@gmail.com", 24);
        User user2 = new User("safer", "55gk06", "safer@gmail.com", 18);
        User user3 = new User("usermod666", "njg556hg", "usermod@gmail.com", 32);
        User user4 = new User("star13", "64wddx5", "star13@gmail.com", 14);
        String [] expectedLogin = {user1.getLogin(), user2.getLogin(), user3.getLogin(), user4.getLogin()};


        User [] result = Main.getUsers();
        String [] resultLogin = {result[0].getLogin(), result[1].getLogin(), result[2].getLogin(), result[3].getLogin()};

        assertArrayEquals(expectedLogin, resultLogin);


    }

    @Test
    void getUserByLoginAndPassword() throws UserNotFoundException {
        String login = "kat333", password = "pass123";
        User expected = new User("kat333", "pass123", "kat333@gmail.com", 24);

        User result = Main.getUserByLoginAndPassword(login, password);

        assertEquals(expected.getLogin(), result.getLogin());
    }

    @Test
    void validateUser() throws AccessDeniedException {
        User user = new User("safer", "55gk06", "safer@gmail.com", 18);
        String expected = "Доступ предоставлен";

        String result = Main.validateUser(user);

        assertEquals(expected, result);

    }
}