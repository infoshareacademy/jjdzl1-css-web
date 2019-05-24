package com.infoshare.academy.cdi;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

@RequestScoped
public class FileUploadProcessorBean implements FileUploadProcessor {

    @Override
    public String readImagesPath(String path) throws IOException {
        try {
            Properties properties = new Properties();
            FileInputStream inputStream = (FileInputStream) Thread.currentThread()
                    .getContextClassLoader()
                    .getResource("settings.properties")
                    .openStream();
            properties.load(inputStream);
            return properties.getProperty(path);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    @Override
    public String uploadImageFile(Part image,String path) throws IOException {
        String fileName = image.getSubmittedFileName();
        try {
            String uploadPath = readImagesPath(path) + File.separator + fileName;
            File targetFile = new File(uploadPath);
            InputStream inputStream = image.getInputStream();
            String mimetype = Files.probeContentType(targetFile.toPath());
            if (mimetype != null && !mimetype.split("/")[0].equals("image")) {
                return null;
            }
            Files.copy(inputStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return uploadPath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
