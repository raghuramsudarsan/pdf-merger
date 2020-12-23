package com.pdf.merger.utility.actionevent;

import com.pdf.merger.utility.components.FileChooseComponent;
import com.pdf.merger.utility.main.PdfMergerMain;
import com.pdf.merger.utility.util.FileSelectionUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterchangeListListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        int[] selectedFiles = FileSelectionUtil.fileList.getSelectedIndices();
        if(selectedFiles == null || selectedFiles.length == 0 || selectedFiles.length>2) {
            PdfMergerMain.throwAnAlert("Please select only 2 files to reorder.");
            return;
        }

        ListModel<String> listContent = FileSelectionUtil.fileList.getModel();
        String firstFileName = listContent.getElementAt(selectedFiles[0]);
        String secondFileName = listContent.getElementAt(selectedFiles[1]);

        List<String> updatedFileNames = new ArrayList<>();
        for(int i=0; i<FileSelectionUtil.fileNames.size(); i++) {
            if(i==selectedFiles[0]) {
                updatedFileNames.add(secondFileName);
            } else if(i==selectedFiles[1]) {
                updatedFileNames.add(firstFileName);
            } else {
                updatedFileNames.add(FileSelectionUtil.fileNames.get(i));
            }
        }

        FileSelectionUtil.fileList.setListData(updatedFileNames.toArray());
        FileSelectionUtil.fileList.repaint();
    }
}