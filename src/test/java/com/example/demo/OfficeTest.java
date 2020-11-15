package com.example.demo;

import com.spire.doc.Document;
import com.spire.doc.documents.ImageType;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.widget.PdfPageCollection;
import com.spire.presentation.ISlide;
import com.spire.presentation.Presentation;
import com.spire.presentation.collections.SlideCollection;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import com.spire.xls.collections.WorksheetsCollection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * created by huangyating
 *
 * @Date 2020/11/15
 */
@SpringBootTest
public class OfficeTest {

    @Test
    public void word2Image() throws IOException {

    }

    @Test
    public void excel2Image() throws IOException {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("E:/ideaprojects/springboot-hello/src/main/resources/测试excel.xlsx");
        WorksheetsCollection worksheets = workbook.getWorksheets();
        for (int i = 0; i < worksheets.size(); i++) {
            Worksheet worksheet = worksheets.get(i);
            //保存到图片
            BufferedImage bufferedImage = worksheet.toImage(1, 1, worksheet.getLastRow(), worksheet.getLastColumn());

            //写出图片到文件
            File file = new File("E:/ideaprojects/springboot-hello/src/main/resources/images/" + String.format(("Img-excel-%d.png"),i));
            ImageIO.write(bufferedImage, "PNG", file);
        }
    }

    @Test
    public void ppt2Image() throws Exception {
        Presentation presentation = new Presentation();
        presentation.loadFromFile("E:/ideaprojects/springboot-hello/src/main/resources/测试ppt.pptx");
        SlideCollection slides = presentation.getSlides();
        for (int i = 0; i < slides.size(); i++) {
            ISlide iSlide = slides.get(i);
            BufferedImage image = iSlide.saveAsImage();
            //写出图片到文件
            File file = new File("E:/ideaprojects/springboot-hello/src/main/resources/images/" + String.format(("Img-presentation-%d.png"),i));
            ImageIO.write(image, "PNG", file);
        }
    }

    @Test
    public void pdf2Image() throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromFile("E:/ideaprojects/springboot-hello/src/main/resources/测试pdf.pdf");
        int count = pdfDocument.getPages().getCount();
        for (int i = 0; i < count; i++) {
            BufferedImage image = pdfDocument.saveAsImage(i);
            //写出图片到文件
            File file = new File("E:/ideaprojects/springboot-hello/src/main/resources/images/" + String.format(("Img-pdf-%d.png"),i));
            ImageIO.write(image, "PNG", file);
        }

    }
}
