package com.infoshare.academy.cdi;

import javax.servlet.http.Part;
import java.io.IOException;

public interface FileUploadProcessor {

    String readImagesPath(String path) throws IOException;

    String uploadImageFile(Part image,String path) throws IOException;
}
