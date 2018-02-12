/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.util;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akhilesh
 */
public class ClientProvider {

    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getByUserName(String userName) {
        for (Client c : clients) {
            if (userName.equalsIgnoreCase(c.getUserName())) {
                return c;
            }
        }
        return null;
    }

    public Client getBySocket(Socket socket) {
        for (Client c : clients) {
            if (c.equals(socket)) {
                return c;
            }
        }
        return null;
    }
    public void removeClient(Client c){
        clients.remove(c);
    }
}
