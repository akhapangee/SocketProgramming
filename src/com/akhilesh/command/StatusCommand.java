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
public class StatusCommand extends ChatCommand{

    @Override
    public void execute(String[] tokens) throws IOException {
        if(tokens.length == 2){
            client.setStatus(tokens[1]);
        }
    }
    
}
