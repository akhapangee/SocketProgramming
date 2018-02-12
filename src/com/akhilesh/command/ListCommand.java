/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.command;

import com.akhilesh.util.Client;
import java.io.IOException;

/**
 *
 * @author Akhilesh
 */
public class ListCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws IOException {
        StringBuilder userList = new StringBuilder();
        for (Client c : provider.getClients()) {
            userList.append(c.getUserName()+" -> "+c.getStatus()).append("\r\n");
        }
        writer.println("Users in the chat room: \r\n****************************\r\n" + userList.toString());

    }

}
