package com.wms.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/wms_project?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Kuala_Lumpur&allowPublicKeyRetrieval=true"
                        , "root", "SY6880")
                .globalConfig(builder -> {
                    builder.author("maxy31") // 设置作者
                            .outputDir("src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.wms") // ⚠️ 建议：这里只写包名，不要写 "java/..."
                            .entity("entity")
                            .mapper("mapper") // 这里对应 Java 接口的包名
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(
                                    OutputFile.xml, //以此为 Key
                                    "src\\main\\resources\\mappers" // 指定 XML 生成的绝对路径
                            ));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .entityBuilder()
                            .enableLombok() // 启用 Lombok
                            .enableTableFieldAnnotation() // 启用字段注解
                            .controllerBuilder()
                            .enableRestStyle(); // 启用 REST 风格
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎
                .execute(); // 执行生成
    }
}
