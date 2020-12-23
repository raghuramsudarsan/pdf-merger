package com.pdf.merger.utility.actionevent;

import com.pdf.merger.utility.components.FileChooseComponent;
import com.pdf.merger.utility.util.FileSelectionUtil;
import com.pdf.merger.utility.util.MergeUtil;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileSelectionActionListener extends Component implements ActionListener {

    private static final String FILE_FILTER_DESCRIPTION = "PDF Documents";
    private static final String FILE_FILTER_EXTENSION = "pdf";

    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.addChoosableFileFilter(
                new FileNameExtensionFilter(FILE_FILTER_DESCRIPTION,FILE_FILTER_EXTENSION));
        fileChooser.setAcceptAllFileFilterUsed(false);

        if(JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)) {
            File[] files = fileChooser.getSelectedFiles();
            FileSelectionUtil.fileNames = Arrays.stream(files).map(File::getPath).collect(Collectors.toList());
            System.out.println("File Names : "+FileSelectionUtil.fileNames);

            FileSelectionUtil.fileList.removeAll();
            FileSelectionUtil.fileList.setVisible(true);
            FileSelectionUtil.fileList.setListData(FileSelectionUtil.fileNames.toArray());

            FileChooseComponent.mergeButton.setVisible(true);

            FileChooseComponent.interchangeButton.setVisible(true);
        }
    }
}
