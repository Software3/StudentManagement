package org.csu.sm.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ltaoj on 2017/8/12.
 */
public class IOUtil {

    public static String saveFile(String targetName, String targetPath, MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            try {
                File targetFile = new File(targetPath, targetName);
                if (!targetFile.exists()) {
                    targetFile.createNewFile();
                }
                multipartFile.transferTo(targetFile);
                return targetName;
            } catch (IOException e) {
                throw e;
            }
        }
        return "";
    }

    public static void removeFile(String targetName, String targetPath) {
        File targetFile = new File(targetPath, targetName);
        if (targetFile.exists()) {
            targetFile.delete();
        }
    }
}
