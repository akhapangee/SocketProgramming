/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.command;

import com.akhilesh.util.Client;
import com.akhilesh.util.ClientProvider;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Akhilesh
 */
public abstract class ChatCommand {

    protected Client client;
    protected ClientProvider provider;
    protected PrintStream writer;
    
    
    public abstract void execute(String[] tokens) throws IOException;

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProvider(ClientProvider provider) {
        this.provider = provider;
    }

    public void setWriter(PrintStream writer) {
        this.writer = writer;
    }
    public void broadcastMessage(String message) throws IOException {
        for (Client c : provider.getClients()) {
            if (!c.equals(client)) {
                PrintStream out = new PrintStream(c.getSocket().getOutputStream());
                out.println(message);
            }
        }
    }
   
    
}
