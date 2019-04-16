package com.infoshare.academy.cdi;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

@RequestScoped
public class FileUploadProcessorBeen implements FileUploadProcessor {
    @Override
    public String readImagesPath() throws IOException {
       try{
           Properties properties=new Properties();

           FileInputStream inputStream=(FileInputStream) Thread.currentThread()
                   .getContextClassLoader()
                   .getResource("settings.properties")
                   .openStream();
           properties.load(inputStream);
           return properties.getProperty("image-path");
       }catch (IOException e){
           throw new FileNotFoundException();
       }
    }

    @Override
    public String uploadImageFile(Part image) throws IOException {

        String fileName= image.getSubmittedFileName();

        try{
            String uplodPath= readImagesPath() + File.separator + fileName;
            File targetFile= new File(uplodPath);
            InputStream inputStream=image.getInputStream();
            Files.copy(inputStream,targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return  uplodPath;
        }catch (IOException e){
            e.printStackTrace();
        }
        return fileName;
    }
}
