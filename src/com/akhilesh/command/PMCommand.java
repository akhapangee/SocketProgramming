/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.command;

import com.akhilesh.util.Client;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Akhilesh
 */
public class PMCommand extends ChatCommand {
    
    @Override
    public void execute(String[] tokens) throws IOException {
        if (tokens.length == 3) {
            Client buddy = provider.getByUserName(tokens[1]);
            
            if (buddy != null) {
                PrintStream ps = new PrintStream(buddy.getSocket().getOutputStream());
                if (buddy.getStatus().equalsIgnoreCase("online")) {
                    System.out.println("BlockList size: "+client.getAllBlockedClients().size()+" during pm");
                    if (!client.isBlocked(tokens[1])) {
                        ps.println("(PM from " + client.getUserName() + ") >" + tokens[2]);
                    } else {
                        writer.println("You are blocked by user: " + tokens[1]);
                    }
                } else {
                    writer.println(tokens[1] + " is " + buddy.getStatus());
                }
            } else {
                writer.println(tokens[1] + " not found!");
            }
            
        } else {
            writer.println("Not enough parameters");
        }
    }
    
}
