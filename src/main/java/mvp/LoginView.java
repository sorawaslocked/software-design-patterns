package mvp;

public interface LoginView {
    void login();
    void displaySuccess();
    void displayError();
    void setPresenter(UserPresenter presenter);
}
