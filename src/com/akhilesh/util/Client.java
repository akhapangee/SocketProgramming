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
public class Client {

    private Socket socket;
    private String userName;
    private String status;
    private List<Client> blockList = new ArrayList<>();

    public Client(Socket socket, String userName, String status) {
        this.socket = socket;
        this.userName = userName;
        this.status = status;
    }

    /**
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void blockClient(Client c) {
        blockList.add(c);
    }

    public List<Client> getAllBlockedClients() {
        return blockList;
    }

    public Client() {
    }

    public boolean isBlocked(String userName){
        for(Client c: blockList){
            if(c.getUserName().equalsIgnoreCase(userName)){
               return true;
            }
        }
       return false;
    }
}
