/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.command;

import java.io.IOException;

/**
 *
 * @author Akhilesh
 */
public class ExitCommand extends ChatCommand{

    @Override
    public void execute(String[] tokens) throws IOException {
        provider.removeClient(client);
        broadcastMessage(client.getUserName()+" has left the room");
        writer.println("You have left the room");
        client.getSocket().close();
    }
    
}
