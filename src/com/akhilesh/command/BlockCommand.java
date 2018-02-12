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
public class BlockCommand extends ChatCommand {
    
    @Override
    public void execute(String[] tokens) throws IOException {
        if (tokens.length == 2) {
            Client buddy = provider.getByUserName(tokens[1]);
            if (buddy != null) {
                if (!client.isBlocked(tokens[1])) {
                    client.blockClient(buddy);
                    writer.println(buddy.getUserName() + " blocked successfully.");
                    System.out.println("BlockList size: "+client.getAllBlockedClients().size()+" during blocking");
                } else {
                    writer.println(tokens[1] + " already in blocked list");
                }
            } else {
                writer.println(tokens[1] + " not found");
            }
        }
    }
    
}
