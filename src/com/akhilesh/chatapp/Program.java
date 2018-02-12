/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.chatapp;

import com.akhilesh.util.ClientListener;
import com.akhilesh.util.ClientProvider;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Akhilesh
 */
public class Program {
    
    public static void main(String[] args) {
        try {
            int port = 9000;
            ServerSocket server = new ServerSocket(port);
            System.out.println("The server is running at port: " + port);
            ClientProvider provider = new ClientProvider();
            while (true) {
                Socket socket = server.accept();
                System.out.println("Request is coming from " + socket.getInetAddress().getHostName());
                
                ClientListener listener = new ClientListener(socket);
                listener.setProvider(provider);
                listener.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
