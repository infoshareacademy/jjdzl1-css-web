package com.infoshare.academy.cdi;

import javax.servlet.http.Part;
import java.io.IOException;

public interface FileUploadProcessor {

    String readImagesPath() throws IOException;

    String uploadImageFile(Part image) throws IOException;
}
