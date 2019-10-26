package classes;

import java.io.*;

public interface Socket {

    int port = 80;

    public void setIp(String ip);

    public void forward_on() throws IOException;

    public void leftOn() throws IOException;

    public void leftOff() throws IOException;

    public void rightOn() throws IOException;

    public void rightOff() throws IOException;

    public void reverseOn() throws IOException;

    public void reverseOff() throws IOException;

    public void turnLeft() throws IOException;

    public void turnRight() throws IOException;

    public void turnOff() throws IOException;

    public void turbo_on() throws IOException;

    public String servo_left() throws IOException;

    public String servo_middle() throws IOException;

    public String servo_right() throws IOException;

    public void sendMessage(java.net.Socket socket, String message) throws IOException;

    public String readMessage(java.net.Socket socket) throws IOException;
}
