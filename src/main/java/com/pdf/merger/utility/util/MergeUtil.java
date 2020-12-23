package com.pdf.merger.utility.util;

import org.apache.commons.lang.StringUtils;

import javax.swing.filechooser.FileFilter;
import java.io.File;


public class MergeUtil {

    public static FileFilter getFileFilter() {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                if(file != null) {
                    if(file.isDirectory()) {
                        System.out.println("Directory : "+file);
                        return true;
                    } else {
                        System.out.println("Not a Directory : "+file);
                        return file.getName().toLowerCase().endsWith(".pdf");
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "No Description Brah!";
            }
        };
        return fileFilter;
    }
}
