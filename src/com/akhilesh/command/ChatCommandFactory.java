/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.command;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Akhilesh
 */
public class ChatCommandFactory {

    private static Map<String, ChatCommand> commands = initCommands();

    private static Map<String, ChatCommand> initCommands() {
        commands = new HashMap<>();
        commands.put("list", new ListCommand());
        commands.put("pm", new PMCommand());
        commands.put("exit", new ExitCommand());
        commands.put("status", new StatusCommand());
        commands.put("block", new BlockCommand());
        return commands;
    }

    public static ChatCommand getCommand(String key) {
        if (commands.containsKey(key)) {
            return commands.get(key);
        }
        return null;
    }
}
