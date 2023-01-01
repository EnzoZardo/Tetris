package com.mygdx.game;

import java.util.ArrayList;

public class Data {
    public static final int SCREENWIDTH = 680, SCREENHEIGHT = 800, WALLWIDTH = 100, SHAPESIZE = 20, SHAPESPEED = 20, LITTLESHAPESIZE = 15;
    public static final float[] RGBWALLS = {0.5f, 0.5f, 0.75f}, RGBBACKGROUND = {0.5f, 0.5f, 0.9f};
    public static final ArrayList<String[][][]> ALLSHAPES = getALLSHAPES();
    public static final float[][] ALLCOLORS = {{0f, 0f, 1f}, {0f, 1f, 0f}, {1f, 0f, 0f}, {1f, 0f, 1f}, {0f, 1f, 1f}, {1f, 1f, 0f}, {0f, 1f, 0.5f}};

    public static ArrayList<String[][][]> getALLSHAPES() {
        ArrayList<String[][][]> toReturn = new ArrayList<>();
        toReturn.add(new String[][][]
                {
                        {
                            {"X", "X", "X"},
                            {" ", "X", " "},
                            {" ", " ", " "}
                        },
                        {
                            {"X", " ", " "},
                            {"X", "X", " "},
                            {"X", " ", " "}
                        },
                        {
                            {" ", " ", " "},
                            {" ", "X", " "},
                            {"X", "X", "X"}
                        },
                        {
                            {" ", " ", "X"},
                            {" ", "X", "X"},
                            {" ", " ", "X"}
                        }
                });
        toReturn.add(new String[][][]
                {
                        {
                            {"X", " ", " "},
                            {"X", "X", " "},
                            {" ", "X", " "}
                        },
                        {
                            {" ", "X", "X"},
                            {"X", "X", " "},
                            {" ", " ", " "}
                        }
                });
        toReturn.add(new String[][][]
                {
                        {
                                {" ", " ", "X"},
                                {" ", "X", "X"},
                                {" ", "X", " "}
                        },
                        {
                                {"X", "X", " "},
                                {" ", "X", "X"},
                                {" ", " ", " "}
                        }
                });
        toReturn.add(new String[][][]
                {
                        {
                                {" ", " ", " ", " "},
                                {"X", "X", "X", "X"},
                                {" ", " ", " ", " "},
                                {" ", " ", " ", " "}
                        },
                        {
                                {" ", " ", "X", " "},
                                {" ", " ", "X", " "},
                                {" ", " ", "X", " "},
                                {" ", " ", "X", " "}
                        }
                });
        toReturn.add(new String[][][]
                {
                        {
                                {"X", " ", " "},
                                {"X", " ", " "},
                                {"X", "X", " "}
                        },
                        {
                                {" ", " ", " "},
                                {" ", " ", "X"},
                                {"X", "X", "X"}
                        },
                        {
                                {" ", "X", "X"},
                                {" ", " ", "X"},
                                {" ", " ", "X"}
                        },
                        {
                                {"X", "X", "X"},
                                {"X", " ", " "},
                                {" ", " ", " "}
                        }
                });
        toReturn.add(new String[][][]
                {
                        {
                                {" ", " ", "X"},
                                {" ", " ", "X"},
                                {" ", "X", "X"}
                        },
                        {
                                {"X", "X", "X"},
                                {" ", " ", "X"},
                                {" ", " ", " "}
                        },
                        {
                                {"X", "X", " "},
                                {"X", " ", " "},
                                {"X", " ", " "}
                        },
                        {
                                {" ", " ", " "},
                                {"X", " ", " "},
                                {"X", "X", "X"}
                        }
                });
        toReturn.add(new String[][][]
                {
                        {
                                {"X", "X"},
                                {"X", "X"}
                        }
                });
        return toReturn;
    }
}
