package mvp;

public class UserPresenter {
    private final UserModel model;
    private final LoginView view;

    public UserPresenter(UserModel model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    public void attemptLogin(String username, String password) {
        if (model.authenticate(username, password)) {
            view.displaySuccess();
        } else {
            view.displayError();
        }
    }
}
