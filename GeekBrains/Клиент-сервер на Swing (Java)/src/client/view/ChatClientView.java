package client.view;

import client.presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ChatClientView extends JFrame implements View {

    private static final int HEIGHT = 300;
    private static final int WIDTH = 500;
    private static final int HORIZONTAL_POSITION = 100;
    private static final int VERTICAL_POSITION = 100;

    private Presenter presenter;
    private JTextArea textArea;
    private SettingsWindow settingsWindow;
    private SendMessagePanel sendMessagePanel;


    public ChatClientView() {

        setSize(WIDTH, HEIGHT);
        setLocation(
                HORIZONTAL_POSITION + new Random().nextInt(50),
                VERTICAL_POSITION + new Random().nextInt(50)
        );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Chat client");

        settingsWindow = new SettingsWindow();
        textArea = new JTextArea();
        textArea.setEditable(false);

        sendMessagePanel = new SendMessagePanel();
        add(settingsWindow, BorderLayout.NORTH);
        add(new JScrollPane(textArea));
        add(sendMessagePanel, BorderLayout.SOUTH);
        settingsWindow.setVisible(true);
    }

    @Override
    public void showWindow() {
        setVisible(true);
    }

    @Override
    public void printMessage(String message) {
        textArea.setText(message);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setConnected(boolean connected) {
        if (connected) {
            settingsWindow.setVisible(false);
            sendMessagePanel.enableButton();
        } else {
            settingsWindow.setVisible(true);
            sendMessagePanel.disableButton();
        }
    }

    private class SettingsWindow extends JPanel {

        public SettingsWindow() {
            super(new GridLayout(2,3));
            JTextField hostField = new JTextField("127.0.0.1");
            JTextField portField = new JTextField("3345");
            JTextField nickNameField = new JTextField("petya");
            JPasswordField passwordField = new JPasswordField("password");
            JButton loginButton = new JButton("login");
            loginButton.addActionListener(e -> {
                boolean connected =
                        presenter.connect(
                                hostField.getText(),
                                portField.getText(),
                                nickNameField.getText(),
                                passwordField.getPassword().toString()
                        );
                setVisible(!connected);
                setConnected(connected);
            });
            add(hostField);
            add(portField);
            add(new JPanel());
            add(nickNameField);
            add(passwordField);
            add(loginButton);
        }
    }

    private class SendMessagePanel extends JPanel{

        private JTextField newMessageField;

        private JButton sendButton;

        public SendMessagePanel() {
            super(new BorderLayout());
            newMessageField = new JTextField();
            newMessageField.addActionListener(e -> {
                sendMessage();
            });
            sendButton = new JButton("send");
            sendButton.setEnabled(false);
            sendButton.addActionListener(e -> {
                sendMessage();
            });
            add(newMessageField);
            add(sendButton, BorderLayout.EAST);
        }

        public void enableButton() {
            sendButton.setEnabled(true);
        }

        public void disableButton() {
            sendButton.setEnabled(false);
        }


        private void sendMessage() {
            if (!newMessageField.getText().isEmpty()) {
                presenter.sendMessage(newMessageField.getText());
                newMessageField.setText("");
            }
        }

    }

}
