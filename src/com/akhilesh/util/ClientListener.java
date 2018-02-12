/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.util;

import com.akhilesh.command.ChatCommand;
import com.akhilesh.command.ChatCommandFactory;
import com.akhilesh.command.ExitCommand;
import com.akhilesh.command.ListCommand;
import com.akhilesh.command.PMCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author Akhilesh
 */
public class ClientListener extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private PrintStream out;
    private Client client;
    private ClientProvider provider;

    public ClientListener(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintStream(socket.getOutputStream());
    }

    public void setProvider(ClientProvider provider) {
        this.provider = provider;
    }

    @Override
    public void run() {
        try {
            login();
            while (!isInterrupted()) {
                out.println("(Me) >");
                String line = reader.readLine();
                String[] tokens = line.split(";;");

                ChatCommand command = ChatCommandFactory.getCommand(tokens[0]);
                if (command != null) {
                    command.setClient(client);
                    command.setProvider(provider);
                    command.setWriter(out);
                    command.execute(tokens);
                } else {
                    broadcastMessage(client.getUserName() + " says> " + line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void login() throws IOException {
        out.println("Welcome to Chat Server!\r\n"
                + "Time and date now: " + new Date() + "\r\n"
                + "******************************************");
        out.println("Enter your user name: ");
        out.print(">");
        String userName = reader.readLine();
        while (checkUserAlreadyExists(userName)) {
            out.println("User already exists! Enter your new user name: ");
            out.print(">");
            userName = reader.readLine();
        }
        out.println("Enter your password: ");
        out.print(">");
        String password = reader.readLine();
        out.println("******************************************");
        out.println("Thank you " + userName + "!\r\n"
                + "You are logged in now\r\n"
                + "******************************************");
        client = new Client(socket, userName, "online");
        provider.addClient(client);
        broadcastMessage(userName + " has entered the chat room");

    }

    private void broadcastMessage(String message) throws IOException {
        for (Client c : provider.getClients()) {
            if (!c.equals(client)) {
                PrintStream out = new PrintStream(c.getSocket().getOutputStream());
                out.println(message);
            }
        }
    }

    private boolean checkUserAlreadyExists(String userName) {
        for (Client c : provider.getClients()) {
            if (userName.equalsIgnoreCase(c.getUserName())) {
                return true;
            }
        }
        return false;
    }
}
