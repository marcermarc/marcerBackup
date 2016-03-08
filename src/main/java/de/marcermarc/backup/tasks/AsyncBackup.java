package de.marcermarc.backup.tasks;

import de.marcermarc.backup.controller.BackupController;
import de.marcermarc.backup.controller.PluginController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class AsyncBackup implements Runnable {

    static final int BUFFER = 2048;

    private PluginController pluginController;
    private BackupController backupController;

    public AsyncBackup(PluginController pluginController) {
        this.pluginController = pluginController;
        this.backupController = pluginController.getBackup();
    }

    @Override
    public void run() {

        backupController.startBackup();

        try {

            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("./backup/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".zip")));

            zipOutputStream.setMethod(ZipOutputStream.DEFLATED);

            ArrayList<String> folders = backupController.getWorldFolder();

            byte data[] = new byte[BUFFER];

            for (String folder : folders) {

                zipOutputStream.putNextEntry(new ZipEntry(folder));

                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(folder), BUFFER);

                int count;
                while ((count = bufferedInputStream.read(data, 0, BUFFER)) != -1) {
                    zipOutputStream.write(data, 0, count);
                }

                bufferedInputStream.close();
            }

            zipOutputStream.close();

        } catch (Exception e) {
            System.out.println("backup failed: " + e.getMessage());
        }

        backupController.endBackup();

    }
}
