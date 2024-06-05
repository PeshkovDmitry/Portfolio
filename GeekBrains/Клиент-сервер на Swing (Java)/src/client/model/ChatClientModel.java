package client.model;

import client.presenter.Presenter;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatClientModel implements Model{

    private Socket socket;

    private Presenter presenter;

    private String currentMessage = "";

    private String oldMessage = "";

    @Override
    public boolean connect(String host, int port) {
        try {
            socket =  new Socket(host, port);
            presenter.printMessage("Вы успешно подключились!");
            currentMessage = presenter.getNickname() + " успешно подключился к беседе";
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try (DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                         DataInputStream ois = new DataInputStream(socket.getInputStream())) {
                        boolean work = true;
                        while (work) {
                            String message = (currentMessage.equals(oldMessage)
                                    ? " "
                                    : currentMessage);
                            oldMessage = currentMessage;
                            oos.writeUTF(message);
                            oos.flush();
                            Thread.sleep(100);
                            String in = ois.readUTF();
                            if (in.equals("exit")) {
                                oos.close();
                                ois.close();
                                socket.close();
                                presenter.printMessage("Сервер разорвал соединение");
                                presenter.setConnected(false);
                                work = false;
                            } else {
                                presenter.printMessage(in);
                            }
                            Thread.sleep(100);
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                        presenter.printMessage("Не удалось отправить сообщение");
                    }
                }
            }).start();
            return true;
        } catch (IOException e) {
            presenter.printMessage("Не удалось подключиться к серверу");
            return false;
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void sendMessage(String message) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println();
        currentMessage = presenter.getNickname() + " " + dateFormat.format(date) + ": " + message;
    }

}
