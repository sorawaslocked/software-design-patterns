package mvp;

public class Main {
    public static void main(String[] args) {
        UserModel userModel = new UserModel();
        LoginView view = new ConsoleLoginVIew();
        UserPresenter presenter = new UserPresenter(userModel, view);
        view.setPresenter(presenter);

        while (true) {
            view.login();
        }
    }
}
