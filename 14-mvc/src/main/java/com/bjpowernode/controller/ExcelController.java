package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Author:单雪瑞
 * 2020/4/1 18:45
 */
@Controller
@RequestMapping("/student")
public class ExcelController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getExcel.do")//导出
    public void  getExcel(HttpServletResponse response) throws Exception {




        response.setContentType("application/vnd.ms-excel;charset=UTF-8");

        response.setHeader("Content-Disposition","attachment;filename="+new String("用户表.xlsx".getBytes(),"iso-8859-1"));


        List<Student> studentList = studentService.searchStudent();

        ExcelUtil<Student> excelUtil = new ExcelUtil<Student>();

        XSSFWorkbook wb = excelUtil.getWorkBook(studentList, "kuangRenMingDan", Student.class);

        wb.write(response.getOutputStream());
    }


    @RequestMapping("/importExcel.do")//导入
    public String importExcel(MultipartFile multipartFile, HttpServletRequest request) throws Exception {

        String s = studentService.UploadExcel(multipartFile);
        return "upload";
    }


    @RequestMapping("/testExcel.do")
    public String testExcel(MultipartFile multipartFile, HttpServletRequest request) throws Exception {

        System.out.println(multipartFile.getContentType());
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getName());
        System.out.println(multipartFile.isEmpty());
        System.out.println(multipartFile.getSize());

        byte[] bytes = multipartFile.getBytes();

        for (byte aByte : bytes) {
            System.out.println(aByte);
        }

        //      InputStream（字节输入流）是抽象类，不是接口。
//        服务器端上的使用 getInputStream方法得到的是一个输入流，getInputStream方法得到的输入流其实就是从客户端发送给服务器端的数据流。
        InputStream inputStream = multipartFile.getInputStream();
        System.out.println("inputStream.available():"+inputStream.available());
        System.out.println("multipartFile.getSize():"+multipartFile.getSize());

        byte[] bytes1 = new byte[3];
        int read = inputStream.read(bytes1);
        System.out.println(read);

        int read1 = inputStream.read();
        System.out.println(read1);
        int read2 = inputStream.read();
        System.out.println(read2);
        int read3 = inputStream.read();
        System.out.println(read3);
        int read4 = inputStream.read();
        System.out.println(read4);
        int read5 = inputStream.read();
        System.out.println(read5);
        int read6 = inputStream.read();
        System.out.println(read6);



        File file = new File("E:\\b.txt");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.lastModified());

        FileInputStream fileInputStream = new FileInputStream(file);

        int count = 0;
        while ((count = fileInputStream.read(bytes1))!=-1){

            System.out.println(count);

            System.out.println(new String(bytes1,0,count));

        }

        return "upload";
    }
}
