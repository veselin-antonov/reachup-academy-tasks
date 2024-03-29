package tasks.colors;

public enum Colors {
    BLACK("\u001b[30m"),
    RED("\u001b[31m"),
    GREEN("\u001b[32m"),
    YELLOW("\u001b[33m"),
    BLUE("\u001b[34m"),
    MAGENTA("\u001b[35m"),
    CYAN("\u001b[36m"),
    WHITE("\u001b[37m"),
    RESET("\u001b[0m"),
    BRIGHT_BLACK("\u001b[30;1m"),
    BRIGHT_RED("\u001b[31;1m"),
    BRIGHT_GREEN("\u001b[32;1m"),
    BRIGHT_YELLOW("\u001b[33;1m"),
    BRIGHT_BLUE("\u001b[34;1m"),
    BRIGHT_MAGENTA("\u001b[35;1m"),
    BRIGHT_CYAN("\u001b[36;1m"),
    BRIGHT_WHITE("\u001b[37;1m"),
    BACKGROUND_BLACK("\u001b[40m"),
    BACKGROUND_RED("\u001b[41m"),
    BACKGROUND_GREEN("\u001b[42m"),
    BACKGROUND_YELLOW("\u001b[43m"),
    BACKGROUND_BLUE("\u001b[44m"),
    BACKGROUND_MAGENTA("\u001b[45m"),
    BACKGROUND_CYAN("\u001b[46m"),
    BACKGROUND_WHITE("\u001b[47m"),
    BACKGROUND_BRIGHT_BLACK("\u001b[40;1m"),
    BACKGROUND_BRIGHT_RED("\u001b[41;1m"),
    BACKGROUND_BRIGHT_GREEN("\u001b[42;1m"),
    BACKGROUND_BRIGHT_YELLOW("\u001b[43;1m"),
    BACKGROUND_BRIGHT_BLUE("\u001b[44;1m"),
    BACKGROUND_BRIGHT_MAGENTA("\u001b[45;1m"),
    BACKGROUND_BRIGHT_CYAN("\u001b[46;1m"),
    BACKGROUND_BRIGHT_WHITE("\u001b[47;1m"),

    BACKGROUND, FOREGROUND;

    String color;

    Colors(){}

    Colors(String color) {
        this.color = color;
    }

    public static String getByCode(int code, ColorType colorType) {
        if (code < 0 || code > 255) {
            throw new IndexOutOfBoundsException();
        }
        return String.format("\u001b[%d;5;%dm", colorType == ColorType.FOREGROUND ? 38 : 48, code);
    }

    public static String getByCode(int code) {
        return getByCode(code, ColorType.FOREGROUND);
    }

    @Override
    public String toString() {
        return color;
    }
}
