package com.vulinh.qrgenerator;

import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.vulinh.qrgenerator.utils.QRUtils;
import com.vulinh.qrgenerator.utils.StringUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

import static com.vulinh.qrgenerator.utils.StringUtils.EMPTY;

/**
 * @author LinhNV42
 */
public class QRCodeForm extends javax.swing.JFrame {

    private static final long serialVersionUID = -6206617812773457626L;

    private static final int INITIAL_SIZE = 200;
    private static final int MAX_SIZE = 800;
    private static final int SIZE_INCREMENT = 5;
    private static final int SIZE_STEP = 5;

    private static final JFileChooser PNG_FILE_SAVER;

    static {
        PNG_FILE_SAVER = new JFileChooser();
        PNG_FILE_SAVER.setSelectedFile(new File("qr-code.png")); // Doesn't matter, it doesn't need to exist, just like my love life
        PNG_FILE_SAVER.setFileFilter(new FileNameExtensionFilter("PNG Files (*.png)", "png"));
    }

    private transient BitMatrix currentBitMatrix;
    private transient String lastContent;

    public QRCodeForm() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();
        textAreaScroll1 = new javax.swing.JScrollPane();
        textContent = new javax.swing.JTextArea();
        buttonGenerate = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        labelLength = new javax.swing.JLabel();
        checkboxWordWrap = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        submenuSaveImage = new javax.swing.JMenuItem();
        submenuClear = new javax.swing.JMenuItem();
        separator1 = new javax.swing.JPopupMenu.Separator();
        submenuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QR Code Generator");

        panelImage.setBorder(javax.swing.BorderFactory.createTitledBorder("Image (click the image to save as a PNG file)"));
        panelImage.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelImageMouseClicked(evt);
            }
        });

        labelImage.setText("Empty");
        labelImage.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelImageLayout = new javax.swing.GroupLayout(panelImage);
        panelImage.setLayout(panelImageLayout);
        panelImageLayout.setHorizontalGroup(
                panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 678, Short.MAX_VALUE)
                                .addGroup(panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                          .addGroup(panelImageLayout.createSequentialGroup()
                                                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                                                    .addComponent(labelImage)
                                                                                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelImageLayout.setVerticalGroup(
                panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                          .addGroup(panelImageLayout.createSequentialGroup()
                                                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                                                    .addComponent(labelImage)
                                                                                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelContent.setBorder(javax.swing.BorderFactory.createTitledBorder("Content"));

        textContent.setColumns(20);
        textContent.setFont(new java.awt.Font("Consolas", Font.PLAIN, 18)); // NOI18N
        textContent.setLineWrap(true);
        textContent.setRows(5);
        textContent.setText("Nguyễn Vũ Linh");
        textContent.setWrapStyleWord(true);
        textContent.setMargin(new java.awt.Insets(10, 10, 10, 10));
        textContent.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textContentKeyReleased(evt);
            }
        });
        textAreaScroll1.setViewportView(textContent);

        buttonGenerate.setText("Generate");
        buttonGenerate.addActionListener(this::buttonGenerateActionPerformed);

        buttonClear.setText("Clear");
        buttonClear.addActionListener(this::buttonClearActionPerformed);

        labelLength.setText("Length: 0");

        checkboxWordWrap.setSelected(true);
        checkboxWordWrap.setText("Word wrap");
        checkboxWordWrap.addActionListener(this::checkboxWordWrapActionPerformed);

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
                panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                  .addGroup(panelContentLayout.createSequentialGroup()
                                                              .addComponent(labelLength)
                                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                              .addComponent(buttonClear)
                                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                              .addComponent(buttonGenerate))
                                  .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                  .addGroup(panelContentLayout.createSequentialGroup()
                                                              .addComponent(checkboxWordWrap)
                                                              .addGap(0, 0, Short.MAX_VALUE))
        );
        panelContentLayout.setVerticalGroup(
                panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                  .addGroup(panelContentLayout.createSequentialGroup()
                                                              .addComponent(checkboxWordWrap)
                                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                              .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                              .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                          .addComponent(buttonGenerate)
                                                                                          .addComponent(buttonClear)
                                                                                          .addComponent(labelLength)))
        );

        menuFile.setText("File");

        submenuSaveImage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuSaveImage.setText("Save Image");
        submenuSaveImage.addActionListener(this::submenuSaveImageActionPerformed);
        menuFile.add(submenuSaveImage);

        submenuClear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuClear.setText("Clear Image");
        submenuClear.addActionListener(this::submenuClearActionPerformed);
        menuFile.add(submenuClear);
        menuFile.add(separator1);

        submenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        submenuExit.setText("Exit");
        submenuExit.addActionListener(this::submenuExitActionPerformed);
        menuFile.add(submenuExit);

        jMenuBar1.add(menuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                                      .addContainerGap()
                                      .addComponent(panelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                      .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                      .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                                      .addContainerGap()
                                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addComponent(panelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                      .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                      .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        generateQRCode();
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        clearContent();
    }//GEN-LAST:event_buttonClearActionPerformed

    private void textContentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textContentKeyReleased
        analyzeContent();
    }//GEN-LAST:event_textContentKeyReleased

    private void analyzeContent() {
        String content = textContent.getText();
        int length = content.length();
        labelLength.setText("Length: " + length + ", Step: " + length / SIZE_STEP + ", Size: " + getResizeValue(content));
    }

    private void checkboxWordWrapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxWordWrapActionPerformed
        textContent.setLineWrap(checkboxWordWrap.isSelected());
    }//GEN-LAST:event_checkboxWordWrapActionPerformed

    private void panelImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelImageMouseClicked
        saveImage();
    }//GEN-LAST:event_panelImageMouseClicked

    private void labelImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelImageMouseClicked
        saveImage();
    }//GEN-LAST:event_labelImageMouseClicked

    private void submenuSaveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuSaveImageActionPerformed
        saveImage();
    }//GEN-LAST:event_submenuSaveImageActionPerformed

    private void submenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_submenuExitActionPerformed

    private void submenuClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuClearActionPerformed
        clearContent();
    }//GEN-LAST:event_submenuClearActionPerformed

    private void generateQRCode() {
        String content = StringUtils.trim(textContent.getText());
        if (StringUtils.isBlank(content)) {
            showError("Please enter content!");
            return;
        }
        if (content.equals(lastContent)) {
            return;
        } else {
            lastContent = content;
        }
        labelImage.setText(StringUtils.EMPTY);
        try {
            currentBitMatrix = QRUtils.generateQRCode(content, getResizeValue(content));
            labelImage.setIcon(new ImageIcon(QRUtils.toBufferedImage(currentBitMatrix)));
            textContent.requestFocus();
        } catch (WriterException ex) {
            showError(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void saveImage() {
        if (Objects.isNull(labelImage.getIcon()) || Objects.isNull(currentBitMatrix)) {
            return;
        }
        int dialogResult = PNG_FILE_SAVER.showSaveDialog(this);
        if (dialogResult != JFileChooser.CANCEL_OPTION) {
            try {
                String canonicalPath = PNG_FILE_SAVER.getSelectedFile().getCanonicalPath();

                // Must be PNG to be master race
                if (!canonicalPath.endsWith(".png")) {
                    canonicalPath = canonicalPath.concat(".png");
                }

                MatrixToImageWriter.writeToPath(currentBitMatrix, "PNG", Paths.get(canonicalPath));
                showMessage("Exported image successfully at " + canonicalPath);
            } catch (IOException ex) {
                showError("Unable to save to file, reason:\n\n" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    private void clearContent() {
        if (Objects.nonNull(labelImage.getIcon())) {
            labelImage.setText(EMPTY);
            labelImage.setIcon(null);
        }

        textContent.setText(EMPTY);
        lastContent = EMPTY;
        textContent.requestFocus();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private static int getResizeValue(String content) {
        int length = content.length();
        int actualSize = INITIAL_SIZE + SIZE_INCREMENT * (length / SIZE_STEP);
        return Math.min(actualSize, MAX_SIZE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JCheckBox checkboxWordWrap;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelLength;
    private javax.swing.JMenu menuFile;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelImage;
    private javax.swing.JPopupMenu.Separator separator1;
    private javax.swing.JMenuItem submenuClear;
    private javax.swing.JMenuItem submenuExit;
    private javax.swing.JMenuItem submenuSaveImage;
    private javax.swing.JScrollPane textAreaScroll1;
    private javax.swing.JTextArea textContent;
    // End of variables declaration//GEN-END:variables
}
