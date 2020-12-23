package com.pdf.merger.utility.actionevent;

import com.pdf.merger.utility.components.FileChooseComponent;
import com.pdf.merger.utility.main.PdfMergerMain;
import com.pdf.merger.utility.util.Constants;
import com.pdf.merger.utility.util.FileSelectionUtil;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MergeActionEventListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
        ListModel listModel = FileSelectionUtil.fileList.getModel();
        for(int i=0; i<listModel.getSize(); i++) {
            try {
                pdfMergerUtility.addSource((String)listModel.getElementAt(i));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        boolean createOutputDirectory = new File(Constants.OUTPUT_FILE_LOCATION).mkdirs();
        System.out.println("Output file directory has been created : "+createOutputDirectory);

        String destinationFileName = Constants.OUTPUT_FILE_LOCATION + Constants.getRandomizedFileName();


        /*
        pdfWriter.setEncryption(userPassword.getBytes(),
                       ownerPassword.getBytes(),
PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
         */
        try {
            pdfMergerUtility.mergeDocuments();


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        System.out.println("Files Merge Complete. File name : "+destinationFileName);
        PdfMergerMain.throwAnAlert("Merge Complete and could be found here : "+destinationFileName);
    }
}
