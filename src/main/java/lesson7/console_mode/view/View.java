package lesson7.console_mode.view;

import lesson7.console_mode.presenter.Presenter;


public interface View {
    void setPresenter(Presenter presenter);
    void start();
}
