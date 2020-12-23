package com.pdf.merger.utility.util;

import java.util.UUID;

public class Constants {

    public static final String OUTPUT_FILE_LOCATION = "C:\\SankyMergePdf\\MergedFiles\\";

    public static final String OUTPUT_FILE_EXTENSION = ".pdf";

    public static String getRandomizedFileName() {
        return UUID.randomUUID() + OUTPUT_FILE_EXTENSION;
    }
}
