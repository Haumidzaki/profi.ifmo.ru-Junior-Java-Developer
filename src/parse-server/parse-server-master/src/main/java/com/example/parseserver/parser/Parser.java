package com.example.parseserver.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@EnableScheduling
@Component
public class Parser {
    @Autowired
    private ParserConfig config;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private TaskExecutor taskExecutor;

    @Scheduled(fixedRate = 60000)
//    @Bean
    public void start() throws IOException {
        System.out.println("Start...");

        Document document = Jsoup.connect(config.getLink()).get();
        Elements elements = document.select(".course-item a");

        for (Element element: elements){
            System.out.println(element.absUrl("href"));
            ParserThread thread = context.getBean(ParserThread.class);
            thread.setLink(element.absUrl("href"));
            taskExecutor.execute(thread);
        }
    }

//    public static void main(String[] args) {
//        ParserConfig parserConfig = new ParserConfig();
//        Parser parser = new Parser();
//        parser.config = parserConfig;
//        parser.start();
//    }
}
