package ec.com.jmgorduez.Bowling.utils;

import ec.com.jmgorduez.Bowling.domain.FinalFrame;
import ec.com.jmgorduez.Bowling.domain.abstractions.IFrame;

public class Constants {

    public static final String FILE_PATH = "C:\\Users\\JuanMa\\projects\\java\\Bowling\\inputFile\\";
    //public static final String FILE_PATH = "/home/jm/projects/java/Bank-OCR/inputFiles/";

    public static final Integer ONE = 1;
    public static final Integer TWO = 2;
    public static final Integer THREE = 3;
    public static final Integer FOUR = 4;
    public static final Integer FIVE = 5;
    public static final Integer SIX = 6;
    public static final Integer SEVEN = 7;
    public static final Integer EIGHT = 8;
    public static final Integer NINE = 9;
    public static final Integer ZERO = 0;
    public static final Integer TEN = 10;
    public static final Integer TWELVE = 12;

    public static final String BLANK_SPACE_STRING = " ";
    public static final String STRIKE_FRAME_STRING = "X";

    public static final Character CHARACTER_MISS = '-';
    public static final Character CHARACTER_STRIKE = 'X';

    public static final FinalFrame STRIKE_FINAL_FRAME = new FinalFrame(TEN, TEN, TEN);
    public static final IFrame EMPTY_FRAME = null;
}
