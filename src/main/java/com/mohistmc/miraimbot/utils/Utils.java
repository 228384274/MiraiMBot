package com.mohistmc.miraimbot.utils;

import net.mamoe.mirai.contact.Member;
import net.mamoe.mirai.contact.User;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageUtils;
import net.mamoe.mirai.utils.BotConfiguration;

public class Utils {
    public static void sendMessage(User sender, MessageChain messages) {
        if (sender instanceof Member) {
            ((Member) sender).getGroup().sendMessage(messages);
        } else {
            sender.sendMessage(messages);
        }
    }

    public static void sendMessage(User sender, String message) {
        sendMessage(sender, MessageUtils.newChain(message));
    }

    public static BotConfiguration defaultConfig() {
        BotConfiguration botConfiguration = new BotConfiguration() {
            {
                fileBasedDeviceInfo("deviceInfo.json");
            }
        };
        botConfiguration.noNetworkLog();
        botConfiguration.noBotLog();
        return botConfiguration;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?[0-9]+.？[0-9]*");
    }
}
