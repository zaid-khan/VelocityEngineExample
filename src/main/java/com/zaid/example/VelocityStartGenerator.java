package com.zaid.example;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class VelocityStartGenerator {

    static String inputTemplate = "src/main/resources/velocity_templates/java_example.vm";
    static String className = "VelocityExample";
    static String message = "Hello World!";
    static String outputFile = "src/main/java/com/zaid/example/" + className + ".java";

    public static void main(String[] args) throws IOException {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        VelocityContext context = new VelocityContext();
        context.put("className", className);
        context.put("message", message);

        Writer writer = new FileWriter(outputFile);
        Velocity.mergeTemplate(inputTemplate, "UTF-8", context, writer);
        writer.flush();
        writer.close();

        System.out.println("Generated " + outputFile);
    }
}