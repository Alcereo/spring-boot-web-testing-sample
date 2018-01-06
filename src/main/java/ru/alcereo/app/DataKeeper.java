package ru.alcereo.app;

import org.springframework.stereotype.Service;

/**
 * Created by alcereo on 06.01.18.
 */
@Service
public class DataKeeper {

    private String data = "some bean data";

    public DataKeeper() {
    }

    public DataKeeper(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
