package cis.base;

/**
 * An interface to provide some standard constants in CIS applications.
 * @author bjm
 * @since 20210401
 */
public interface CisStandards {
        
    //Some contants that can be used for i/o in our projects.
    //https://www.santhoshreddymandadi.com/java/coloring-java-output-on-console.html
    public static final String BLACK = "\033[30m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";

    public static final String PROMPT_SYMBOL = "-->";
    public static final String LINEFEED = System.lineSeparator();
}
