/**
 * Copyright 2019-2029 longxiaonan(https://github.com/longxiaonan)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zhirui.lmwy.common.utils;

import com.zhirui.lmwy.common.utils.web.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.Ansi;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * <p>
 * 打印项目信息
 * </p>
 *
 * @auth longxiaonan
 * @date 2019-05-08
 **/
@Slf4j
public class PrintApplicationInfo {


    /**
     * 执行之前，打印前置条件提示。设计网址为：http://patorjk.com/software/taag/#p=testall&c=bash&f=Graffiti&t=volcano
     */
    public static void printTip() {
        StringBuffer tip = new StringBuffer();
        tip.append("=====================================================================================\n");
        tip.append("                                                                                   \n");
        tip.append("                                                                                   \n");
        tip.append("           ██╗   ██╗ ██████╗ ██╗      ██████╗ █████╗ ███╗   ██╗ ██████╗     \n");
        tip.append("           ██║   ██║██╔═══██╗██║     ██╔════╝██╔══██╗████╗  ██║██╔═══██╗    \n");
        tip.append("           ██║   ██║██║   ██║██║     ██║     ███████║██╔██╗ ██║██║   ██║    \n");
        tip.append("           ╚██╗ ██╔╝██║   ██║██║     ██║     ██╔══██║██║╚██╗██║██║   ██║    \n");
        tip.append("            ╚████╔╝ ╚██████╔╝███████╗╚██████╗██║  ██║██║ ╚████║╚██████╔╝    \n");
        tip.append("             ╚═══╝   ╚═════╝ ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝     \n");
        tip.append("                                                                         2.1.0                \n");
        tip.append("                                                                                   \n");
        tip.append("=====================================================================================\n");
        log.info("\n{}", Ansi.ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(tip.toString()).reset().toString());

    }

    /**
     * 启动成功之后，打印项目信息
     */
    public static void print(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();

        // 项目名称
        String projectFinalName = environment.getProperty("info.project-finalName");
        // 项目版本
        String projectVersion = environment.getProperty("info.project-version");
        // 项目profile
        String profileActive = environment.getProperty("spring.profiles.active");
        // 项目路径
        String contextPath = environment.getProperty("server.servlet.context-path");
        // 项目端口
        String port = environment.getProperty("server.port");

        log.info("projectFinalName : {}", projectFinalName);
        log.info("projectVersion : {}", projectVersion);
        log.info("profileActive : {}", profileActive);
        log.info("contextPath : {}", contextPath);
        log.info("port : {}", port);

        String startSuccess = " ____    __                    __        ____                                                   \n" +
                "/\\  _`\\ /\\ \\__                /\\ \\__    /\\  _`\\                                                 \n" +
                "\\ \\,\\L\\_\\ \\ ,_\\    __     _ __\\ \\ ,_\\   \\ \\,\\L\\_\\  __  __    ___    ___     __    ____    ____  \n" +
                " \\/_\\__ \\\\ \\ \\/  /'__`\\  /\\`'__\\ \\ \\/    \\/_\\__ \\ /\\ \\/\\ \\  /'___\\ /'___\\ /'__`\\ /',__\\  /',__\\ \n" +
                "   /\\ \\L\\ \\ \\ \\_/\\ \\L\\.\\_\\ \\ \\/ \\ \\ \\_     /\\ \\L\\ \\ \\ \\_\\ \\/\\ \\__//\\ \\__//\\  __//\\__, `\\/\\__, `\\\n" +
                "   \\ `\\____\\ \\__\\ \\__/.\\_\\\\ \\_\\  \\ \\__\\    \\ `\\____\\ \\____/\\ \\____\\ \\____\\ \\____\\/\\____/\\/\\____/\n" +
                "    \\/_____/\\/__/\\/__/\\/_/ \\/_/   \\/__/     \\/_____/\\/___/  \\/____/\\/____/\\/____/\\/___/  \\/___/ \n" +
                "                                                                                                \n" +
                "                                                                                                ";

        String homeUrl = "http://" + IpUtil.getLocalhostIp() + ":" + port + contextPath;
        String swaggerUrl = "http://" + IpUtil.getLocalhostIp() + ":" + port + contextPath + "docs";
        log.info("home:{}", homeUrl);
        log.info("docs:{}", swaggerUrl);
        log.info("javasea-volcano project start success...........");
        log.info("\n{}", AnsiUtil.getAnsi(Ansi.Color.BLUE, startSuccess));
    }

}
