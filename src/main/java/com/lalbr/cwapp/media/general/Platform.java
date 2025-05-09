package com.lalbr.cwapp.media.general;

public enum Platform {

    Steam,
    Uplay,

    Netflix,
    Amazon_Prime;

    public static String toString(Platform platform) {
        return switch (platform) {
            case Steam -> "Steam";
            case Uplay -> "Uplay";
            case Netflix -> "Netflix";
            case Amazon_Prime -> "Amazon Prime";
        };
    }
}
