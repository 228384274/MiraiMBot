package com.mohistmc.miraimbot.utils;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mohistmc.miraimbot.command.ConsoleSender;
import com.mohistmc.miraimbot.config.ConfigManager;
import com.mohistmc.miraimbot.console.log4j.MiraiBotLogger;
import net.mamoe.mirai.contact.User;
import net.mamoe.mirai.contact.UserOrBot;
import net.mamoe.mirai.utils.BotConfiguration;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static BotConfiguration defaultConfig() {
        BotConfiguration botConfiguration = new BotConfiguration() {
            {
                fileBasedDeviceInfo("device.json");
                setBotLoggerSupplier(bot -> new MiraiBotLogger());
                setNetworkLoggerSupplier(bot -> new MiraiBotLogger());
            }
        };
        if (!ConfigManager.getConfig().getBoolean(ConfigManager.path_log_network, true))
            botConfiguration.noNetworkLog();
        if (!ConfigManager.getConfig().getBoolean(ConfigManager.path_log_bot, true))
            botConfiguration.noBotLog();
        botConfiguration.setProtocol(BotConfiguration.MiraiProtocol.valueOf(ConfigManager.getConfig().getString(ConfigManager.path_protocol,"ANDROID_PHONE")));
        return botConfiguration;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?[0-9]*");
    }

    private static final List<ExecutorService> tasks = Lists.newArrayList();

    public static ExecutorService createThreadPool(int core, int max, String name) {
        ExecutorService s = new ThreadPoolExecutor(core, max,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(512), new ThreadFactoryBuilder().setNameFormat(name).build(), new ThreadPoolExecutor.AbortPolicy());
        tasks.add(s);
        return s;
    }

    public static void stopAllThread() {
        tasks.forEach(ExecutorService::shutdownNow);
    }


    public static void sendMessage(UserOrBot sender, String s) {
        if (sender instanceof ConsoleSender)
            ((ConsoleSender) sender).sendMessage(s);
        else
            ((User) sender).sendMessage(s);
    }
}
