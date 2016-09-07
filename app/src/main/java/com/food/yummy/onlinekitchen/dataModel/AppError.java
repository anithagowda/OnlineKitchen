package com.food.yummy.onlinekitchen.dataModel;

/**
 * Created by harry on 9/6/16.
 */
public class AppError {

    public enum Error {
        Food2ForkError
    }

    public static String getFriendlyMessage(Error err) {
        switch (err) {
            case Food2ForkError: return "Server is down. Please try again later";
        }
        return "Unknown Error. Please try again later";
    }
}
