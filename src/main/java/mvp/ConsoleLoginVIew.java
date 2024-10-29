package mvp;

import java.util.Scanner;

public class ConsoleLoginVIew implements LoginView {
    private final Scanner scanner;
    private UserPresenter presenter;

    public ConsoleLoginVIew() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void login() {
        System.out.println();
        System.out.println("******* LOGIN FORM *******");
        System.out.print("Enter username: ");
        String surname = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println();

        presenter.attemptLogin(surname, password);
    }

    @Override
    public void displaySuccess() {
        System.out.println("You successfully logged in!");
    }

    @Override
    public void displayError() {
        System.out.println("Something went wrong!");
    }

    @Override
    public void setPresenter(UserPresenter presenter) {
        this.presenter = presenter;
    }
}
