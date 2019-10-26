package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class GUI extends JFrame implements classes.Socket {
    private JButton buttonTurbo;
    private JButton buttonNorth;
    private JButton buttonSouth;
    private JButton buttonReverse;
    private JButton buttonWest;
    private JButton buttonEast;
    private JLabel labelInput;
    private JTextField textInput;
    private JButton buttonSubmit;
    private JLabel labelwebcamIp;
    private JTextField textWebcam;
    private JButton buttonWebcam;
    private JButton buttonWebcamLeft;
    private JButton buttonWebcamMiddle;
    private JButton buttonWebcamRight;
    private String ip;
    private String ipWebcam;


    public GUI() {
        super("FPV Bot Control");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.initializeComponents();
        this.orderComponents();
        this.registerListener();
        Image icon = Toolkit.getDefaultToolkit().getImage("robot3-icon.png");
        this.setIconImage(icon);







    }

    private void initializeComponents() {
        this.labelInput = new JLabel("IP-Address:");
        this.textInput = new JTextField();
        this.buttonSubmit = new JButton("Set IP");
        this.buttonTurbo = new JButton("Turbo");
        this.buttonNorth = new JButton("Forward");
        this.buttonSouth = new JButton("Stop");
        this.buttonWest = new JButton("Left");
        this.buttonEast = new JButton("Right");
        this.buttonReverse = new JButton("Reverse");
        this.labelwebcamIp = new JLabel("Webcam IP:");
        this.textWebcam = new JTextField();
        this.buttonWebcam = new JButton("Open FPV Cam");
        this.buttonWebcamLeft = new JButton("Pivot Cam Left");
        this.buttonWebcamMiddle = new JButton("Pivot Cam Middle");
        this.buttonWebcamRight = new JButton("Pivot Cam Right");
    }

    private void orderComponents() {
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //set background color of the JFrame
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        c.fill = 2;
        c.insets = new Insets(4, 4, 4, 4);

        //label ip control
        c.gridx = 0;
        c.gridy = 0;
        this.getContentPane().add(this.labelInput, c);
        //textfield for ip
        c.gridx = 1;
        c.gridwidth = 3;
        this.getContentPane().add(this.textInput, c);
        //button submit
        c.gridx = 4;
        this.getContentPane().add(this.buttonSubmit, c);
        //reset cell width
        c.gridwidth = 1;
        //turbo button
        c.gridx = 2;
        c.gridy = 1;
        this.getContentPane().add(this.buttonTurbo, c);
        //button north
        c.gridx = 2;
        c.gridy = 2;
        this.getContentPane().add(this.buttonNorth, c);
        //button west
        c.gridx = 1;
        c.gridy = 3;
        this.getContentPane().add(this.buttonWest, c);
        //button east
        c.gridx = 3;
        this.getContentPane().add(this.buttonEast, c);
        //button south
        c.gridx = 2;
        c.gridy = 4;
        this.getContentPane().add(this.buttonSouth, c);
        //button reverse
        c.gridy = 5;
        this.getContentPane().add(this.buttonReverse, c);
        //label webcam ip input
        c.gridy = 6;
        c.gridx = 0;
        this.getContentPane().add(labelwebcamIp, c);
        //textfield for ip input
        c.gridx = 1;
        //set gridwith to 3 cells
        c.gridwidth = 3;
        this.getContentPane().add(textWebcam, c);
        //reset gridwidth to 1
        c.gridwidth = 1;
        c.gridx = 4;
        this.getContentPane().add(buttonWebcam, c);
        //buttonWebcamLeft
        c.gridx = 0;
        c.gridy = 7;
        this.getContentPane().add(buttonWebcamLeft, c);
        //buttonWebcamMiddle
        c.gridx = 2;
        this.getContentPane().add(buttonWebcamMiddle, c);
        //buttonwebcamRight
        c.gridx = 4;
        this.getContentPane().add(buttonWebcamRight, c);


    }

    private void registerListener() {
        this.buttonNorth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test Drive");

                try {

                    GUI.this.forward_on();

                } catch (IOException var3) {
                    var3.printStackTrace();
                }

            }
        });
        this.buttonSouth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test Stop");

                try {
                    GUI.this.turnOff();
                    GUI.this.reverseOff();
                } catch (IOException var3) {
                    var3.printStackTrace();
                }

            }
        });
        this.buttonWest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test Turn Left");

                try {
                    GUI.this.turnLeft();
                } catch (IOException var3) {
                    var3.printStackTrace();
                }

            }
        });
        this.buttonEast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test Trun Right");

                try {
                    GUI.this.turnRight();
                } catch (IOException var3) {
                    var3.printStackTrace();
                }

            }
        });
        this.buttonTurbo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test Turbo On");

                try {
                    GUI.this.turbo_on();
                } catch (IOException var3) {
                    var3.printStackTrace();
                }

            }
        });
        this.buttonReverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test Reverse On");

                try {
                    GUI.this.reverseOn();
                } catch (IOException var3) {
                    var3.printStackTrace();
                }

            }
        });
        this.buttonSubmit.addActionListener(new ActionListener() {
            private GUI socket;

            public void actionPerformed(ActionEvent e) {
                GUI.this.ip = GUI.this.textInput.getText();

            }
        });

        //actionlistener for submit webcam button
        this.buttonWebcam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.this.ipWebcam = GUI.this.textWebcam.getText();
                OpenWebcam openWebcam = new OpenWebcam(ipWebcam);
            }
        });


        //action listener buttonWebcamLeft
        this.buttonWebcamLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI.this.servo_left();
                }catch (IOException var3) {
                    var3.printStackTrace();
                }
            }
        });

        //action listener buttonWebcamMiddle
        this.buttonWebcamMiddle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI.this.servo_middle();
                }catch (IOException var3) {
                    var3.printStackTrace();
                }
            }
        });

        //action listener buttonWebcamRight
        this.buttonWebcamRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI.this.servo_right();
                }catch (IOException var3) {
                    var3.printStackTrace();
                }
            }
        });

    }


    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

    public void forward_on() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOn = "GET /?forward=on";
        this.sendMessage(socket, messageOn);
    }

    public void leftOn() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOn = "GET /?left=on";
        this.sendMessage(socket, messageOn);
    }

    public void leftOff() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOff = "GET /?left=off";
        this.sendMessage(socket, messageOff);
    }

    public void rightOn() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOn = "GET /?right=on";
        this.sendMessage(socket, messageOn);
    }

    public void rightOff() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOff = "GET /?right=off";
        this.sendMessage(socket, messageOff);
    }

    public void reverseOn() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOn = "GET /?return=on";
        this.sendMessage(socket, messageOn);
    }

    public void reverseOff() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOff = "GET /?return=off";
        this.sendMessage(socket, messageOff);
    }

    public void turnLeft() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOn = "GET /?turnLeft";
        this.sendMessage(socket, messageOn);
    }

    public void turnRight() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOn = "GET /?turnRight";
        this.sendMessage(socket, messageOn);
    }

    public void turnOff() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOff = "GET /?turnOff";
        this.sendMessage(socket, messageOff);
    }

    public void turbo_on() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        String messageOn = "GET /?turbo=on";
        this.sendMessage(socket, messageOn);
    }

    public String servo_left() throws IOException {
        java.net.Socket socket = new java.net.Socket(this.ip, this.port);
        String messageOn = "GET /?servo=left";
        this.sendMessage(socket, messageOn);
        String receiveMessage = this.readMessage(socket);
        receiveMessage = receiveMessage.substring(0, receiveMessage.indexOf(" "));
        return receiveMessage;
    }

    public String servo_middle() throws IOException {
        java.net.Socket socket = new java.net.Socket(this.ip, this.port);
        String messageOn = "GET /?servo=middle";
        this.sendMessage(socket, messageOn);
        String receiveMessage = this.readMessage(socket);
        receiveMessage = receiveMessage.substring(0, receiveMessage.indexOf(" "));
        return receiveMessage;
    }

    public String servo_right() throws IOException {
        java.net.Socket socket = new java.net.Socket(this.ip, this.port);
        String messageOn = "GET /?servo=right";
        this.sendMessage(socket, messageOn);
        String receiveMessage = this.readMessage(socket);
        receiveMessage = receiveMessage.substring(0, receiveMessage.indexOf(" "));
        return receiveMessage;
    }

    public void sendMessage(Socket socket, String message) throws IOException {
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.print(message);
        printWriter.flush();
    }

    public String readMessage(Socket socket) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] buffer = new char[200];
        int amountChars = bufferedReader.read(buffer, 0, 200);
        String message = new String(buffer, 0, amountChars);
        return message;
    }



    public String getWebcamIp() {
        return GUI.this.ipWebcam;
    }
}
