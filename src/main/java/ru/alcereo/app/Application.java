package ru.alcereo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alcereo on 06.01.18.
 */
@SpringBootApplication
@RestController
public class Application {

    @Autowired
    public Application(DataKeeper dataKeeper) {
        this.dataKeeper = dataKeeper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final DataKeeper dataKeeper;

    @GetMapping("test")
    public String testGet(){
        return dataKeeper.getData();
    }
}
