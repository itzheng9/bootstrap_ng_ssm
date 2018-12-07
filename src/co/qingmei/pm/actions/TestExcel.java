package co.qingmei.pm.actions;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

public class TestExcel {


   public  static  void  main(String  []  sdfsdf) throws IOException {

       FileInputStream  fis  =  new FileInputStream("d:\\workbook222.xls");

       HSSFWorkbook  wb =  new HSSFWorkbook(fis);

       HSSFSheet  s1 = wb.getSheetAt(0);

       Iterator<Row> it = s1.rowIterator();


       while(  it.hasNext()) {

           Row row = it.next();
           if(row.getRowNum()<2)
               continue;
            String  name= row.getCell(0).getStringCellValue();
            String  clssss = row.getCell(1).getStringCellValue();
           double bishiScore = row.getCell(2).getNumericCellValue();
           double jishiScore = row.getCell(3).getNumericCellValue();


           System.out.println(name + ","+ clssss +","+ bishiScore + ","+jishiScore);

       }

       fis.close();




   }


    public  static void 鏍煎紡鍖栧啓鐢靛瓙琛ㄦ牸鏂囦欢(String []   ssss) throws IOException {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("琛ㄥ崟涓�");

        //榛樿琛岄珮搴�
        sheet.setDefaultRowHeightInPoints(40);

        //鍒楀搴�
        sheet.setColumnWidth(0, 100 * 50);
        sheet.setColumnWidth(1, 100 * 50);
        sheet.setColumnWidth(2, 100 * 50);
        sheet.setColumnWidth(3, 100 * 50);





        HSSFRow row = sheet.createRow(0);

        HSSFCell cell=row.createCell(0);
        cell.setCellValue("瀛﹀憳鑰冭瘯鎴愮哗涓�瑙堣〃");


        CellStyle  cs= wb.createCellStyle();
        //cs.setAlignment(HorizontalAlignment.CENTER);//妯悜灞呬腑瀵圭嚎鏈�


        HSSFFont  ff= wb.createFont();
        ff.setFontName("榛戜綋");
        ff.setFontHeight((short) 800);
        ff.setColor(HSSFColor.RED.index);

        cs.setFont(ff);


        cell.setCellStyle(cs);


        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

        HSSFRow row2 = sheet.createRow(1);
        HSSFCell cell1=row2.createCell(0);
        cell1.setCellValue("濮撳悕");
        HSSFCell cell2=row2.createCell(1);
        cell2.setCellValue("鐝骇");
        HSSFCell cell3=row2.createCell(2);
        cell3.setCellValue("绗旇瘯");
        HSSFCell cell4=row2.createCell(3);
        cell4.setCellValue("鏈鸿瘯");


        HSSFRow row3 = sheet.createRow(2);
        HSSFCell cell31=row3.createCell(0);
        cell31.setCellValue("鏈辨槦瀹�");
        HSSFCell cell32=row3.createCell(1);
        cell32.setCellValue("杞�31");
        HSSFCell cell33=row3.createCell(2);
        cell33.setCellValue("99");
        HSSFCell cell34=row3.createCell(3);
        cell34.setCellValue("88");

        HSSFRow row4 = sheet.createRow(3);
        HSSFCell cell41=row4.createCell(0);
        cell41.setCellValue("鏈辨槦瀹�");
        HSSFCell cell42=row4.createCell(1);
        cell42.setCellValue("杞�31");
        HSSFCell cell43=row4.createCell(2);
        cell43.setCellValue("99");
        HSSFCell cell44=row4.createCell(3);
        cell44.setCellValue("88");

        HSSFRow row5 = sheet.createRow(4);
        HSSFCell cell51=row5.createCell(0);
        cell51.setCellValue("鏈辨槦瀹�");
        HSSFCell cell52=row5.createCell(1);
        cell52.setCellValue("杞�31");
        HSSFCell cell53=row5.createCell(2);
        cell53.setCellValue("99");
        HSSFCell cell54=row5.createCell(3);
        cell54.setCellValue("88");
        

        //杈撳嚭Excel鏂囦欢
        FileOutputStream output=new FileOutputStream("d:\\workbook222.xls");
        wb.write(output);
        output.flush();


        //鍜寃eb缁撳悎
//        HttpServletResponse  resp= null ;
//        OutputStream  os= resp.getOutputStream();
//        wb.write(os);
//        output.flush();



    }
    public  static void    main1(String[] args) throws IOException {
        //鍒涘缓HSSFWorkbook瀵硅薄
        HSSFWorkbook wb = new HSSFWorkbook();
//鍒涘缓HSSFSheet瀵硅薄
        HSSFSheet sheet = wb.createSheet("琛ㄥ崟涓�");
//鍒涘缓HSSFRow瀵硅薄
        HSSFRow row = sheet.createRow(0);
//鍒涘缓HSSFCell瀵硅薄
        HSSFCell cell=row.createCell(0);
//璁剧疆鍗曞厓鏍肩殑鍊�
        cell.setCellValue("鍗曞厓鏍间腑鐨勪腑鏂噑dfsdffsdfsd");
//杈撳嚭Excel鏂囦欢
        FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
        wb.write(output);
        output.flush();
    }
}
