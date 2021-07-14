package com.cedar.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author zhangnan
 * @date 2021/4/8 13:42
 */
public class TimeServer {

    public void bind(int port) throws IOException {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();


        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());


        } catch (Exception e) {

        }

    }


    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        Thread.sleep(1);
        Date date1 = new Date();
        System.out.println(date.equals(date1));
    }
}
