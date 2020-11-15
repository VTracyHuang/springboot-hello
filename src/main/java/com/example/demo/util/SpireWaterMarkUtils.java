package com.example.demo.util;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.TextWatermark;
import com.spire.doc.documents.WatermarkLayout;
import com.spire.presentation.IAutoShape;
import com.spire.presentation.PortionEx;
import com.spire.presentation.Presentation;
import com.spire.presentation.ShapeType;
import com.spire.presentation.drawing.FillFormatType;
import com.spire.xls.ExcelVersion;
import com.spire.xls.ViewMode;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

public class SpireWaterMarkUtils {
 
    public static void main(String[] args) throws Exception {
      //ppt加水印
        setPPTWaterMark("E:/ideaprojects/springboot-hello/src/main/resources/测试ppt.pptx", "E:/ideaprojects/springboot-hello/src/main/resources/测试水印ppt.pptx", "测试水印");
    }
 
 
    /**
     * word文字水印 (doc,docx)
     *
     * @param inputPath
     * @param outPath
     * @param markStr
     */
    public static void setWordWaterMark(String inputPath, String outPath, String markStr) {
        Document document = new Document();
        document.loadFromFile(inputPath);
        TextWatermark txtWatermark = new TextWatermark();
        txtWatermark.setText(markStr);
        txtWatermark.setFontSize(40);
        txtWatermark.setColor(Color.GRAY);
        txtWatermark.setLayout(WatermarkLayout.Diagonal);
        document.getSections().get(0).getDocument().setWatermark(txtWatermark);
        document.saveToFile(outPath, FileFormat.Auto);
    }
 
    /**
     * excel设置水印
     * Excel 水印在正常模式下不可见，仅在页面布局模式或打印预览模式可见。
     *
     * @param inputPath
     * @param outPath
     * @param markStr
     */
    public static void setExcelWaterMark(String inputPath, String outPath, String markStr) {
        //加载示例文档
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputPath);
        //设置文本和字体大小
        Font font = new Font("宋体", Font.PLAIN, 40);
        for (Object object : (Iterable) workbook.getWorksheets()) {
            Worksheet sheet = (Worksheet) object;
            //调用DrawText() 方法插入图片
            BufferedImage imgWtrmrk = drawText(markStr, font, Color.GRAY, Color.white, sheet.getPageSetup().getPageHeight(), sheet.getPageSetup().getPageWidth());
 
            //将图片设置为页眉
            sheet.getPageSetup().setLeftHeaderImage(imgWtrmrk);
            sheet.getPageSetup().setLeftHeader("&G");
 
            //将显示模式设置为Layout
            sheet.setViewMode(ViewMode.Layout);
        }
        //保存文档
        if (inputPath.substring(inputPath.lastIndexOf(".") + 1, inputPath.length()).equalsIgnoreCase("xls")) {
            workbook.saveToFile(outPath, ExcelVersion.Version97to2003);
        } else {
            workbook.saveToFile(outPath, ExcelVersion.Version2010);
        }
    }
 
    /**
     * PPT设置水印
     * 限制，10页以内可用
     *
     * @param path
     * @param targetpath
     * @param markStr
     * @throws IOException
     */
    public static void setPPTWaterMark(String path, String targetpath, String markStr) throws Exception {
        //创建presentation对象并加载示例文档
        Presentation presentation = new Presentation();
        presentation.loadFromFile(path);
        //限制，10页以内可用，超过10页的有水印
        if (presentation.getSlides().size() > 10) {

        }
        //设置文本水印的宽和高
        int width = 600;
        int height = 300;
 
        //定义一个长方形区域
        Rectangle2D.Double rect = new Rectangle2D.Double((presentation.getSlideSize().getSize().getWidth() - width) / 2,
                (presentation.getSlideSize().getSize().getHeight() - height) / 2, width, height);
 
        //添加一个shape到定义区域
        for (int i = 0; i < presentation.getSlides().size(); i++) {
            IAutoShape shape = presentation.getSlides().get(i).getShapes().appendShape(ShapeType.RECTANGLE, rect);
 
            //设置shape样式
            shape.getFill().setFillType(FillFormatType.NONE);
            shape.getShapeStyle().getLineColor().setColor(Color.white);
            shape.setRotation(-45);
            shape.getLocking().setSelectionProtection(true);
            shape.getLine().setFillType(FillFormatType.NONE);
 
            //添加文本到shape
            shape.getTextFrame().setText(markStr);
            PortionEx textRange = shape.getTextFrame().getTextRange();
 
            //设置文本水印样式
            textRange.getFill().setFillType(FillFormatType.SOLID);
            textRange.getFill().getSolidColor().setColor(Color.GRAY);
            textRange.setFontHeight(50);
        }
 
        //保存文档
        if (path.substring(path.lastIndexOf(".") + 1, path.length()).equalsIgnoreCase("ppt")) {
            presentation.saveToFile(targetpath, com.spire.presentation.FileFormat.PPT);
        } else {
            presentation.saveToFile(targetpath, com.spire.presentation.FileFormat.PPTX_2010);
        }
    }
 
    private static BufferedImage drawText(String text, Font font, Color textColor, Color backColor, double height, double width) {
        //定义图片宽度和高度
        BufferedImage img = new BufferedImage((int) width, (int) height, TYPE_INT_ARGB);
        Graphics2D loGraphic = img.createGraphics();
 
        //获取文本size
        FontMetrics loFontMetrics = loGraphic.getFontMetrics(font);
        int liStrWidth = loFontMetrics.stringWidth(text);
        int liStrHeight = loFontMetrics.getHeight();
 
        //文本显示样式及位置
        loGraphic.setColor(backColor);
        loGraphic.fillRect(0, 0, (int) width, (int) height);
        loGraphic.translate(((int) width - liStrWidth) / 2, ((int) height - liStrHeight) / 2);
        loGraphic.rotate(Math.toRadians(-45));
 
        loGraphic.translate(-((int) width - liStrWidth) / 2, -((int) height - liStrHeight) / 2);
        loGraphic.setFont(font);
        loGraphic.setColor(textColor);
        loGraphic.drawString(text, ((int) width - liStrWidth) / 2, ((int) height - liStrHeight) / 2);
        loGraphic.dispose();
        return img;
    }
}