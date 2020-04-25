package com.zhaogongzuo.controller;


import com.zhaogongzuo.domain.Student;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import org.csource.fastdfs.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.io.ByteArrayInputStream;

import java.io.InputStream;


/**
 * Author:单雪瑞
 * 2020/3/1 15:14
 *
 *                  用ftp往LINUX上传文件
 *
 */
@Controller
public class Test {
    //服务器ip地址
    private static String url = "192.168.183.128";
    //FTP端口，默认是21（注意：SSH默认22）
    private static int port = 21;
    //登录用户名
    private static String username = "test01";// admin 两个都行，都是我添加的
    //登录密码
    private static String password = "123456";


    @RequestMapping("/index")
    public ModelAndView index(MultipartFile multipartFile) throws Exception{



        FTPClient ftp = new FTPClient();

        ftp.setControlEncoding("UTF-8");

        //连接FTP服务器
        ftp.connect(url, port);

        ftp.login(username, password);

        //如果reply的值是230,表示连接成功，530可能是用户名或者密码错误
        //500可能是/home/test目录不存在
        int reply = ftp.getReplyCode();
        System.out.println(reply);

        byte[] bytes = multipartFile.getBytes();

        InputStream input = new ByteArrayInputStream(bytes);


        ftp.enterLocalPassiveMode();

        //需要添加这行代码，不然上传的文件为空
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        String filename = "over";

        boolean g = ftp.storeFile(filename, input);

        System.out.println("上传服务器：" + g);

        input.close();
        ftp.logout();
















        Student student = new Student();
        student.setName("二狗");
        student.setAge(22);
        student.setId(922);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("result");
        return modelAndView;
    }


    @RequestMapping("/xiazai")
    public ResponseEntity<byte[]> xiazai() throws Exception {


        ClientGlobal.init("fastdfs.conf");
        //创建TrackerClient 用于加载所有的TrackerServer到上下文中
        TrackerClient tc = new TrackerClient();
        //创建连接 用于连接到TrackerServer
        TrackerServer ts = tc.getConnection();
        //创建StorageServer 用于获取所有注册到TrackerServer中的Storage信息
        StorageServer ss = tc.getStoreStorage(ts);
        //创建StorageClient 对象 用于具体的操作FastDFS用
        StorageClient sc = new StorageClient(ts, ss);

        byte[] bytes = sc.download_file("group1", "M00/00/00/wKi3gF5gwXmAb3QzAAlqEUKPfAM427.jpg");

        System.out.println("下载");
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }



        HttpHeaders header = new HttpHeaders();
        //设置响应类型 ,APPLICATION_OCTET_STREAM表示当前的响应要以文件的方式进行响应 ，浏览器会直接弹出一个下载的保存窗口
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //设置文件下载时的默认名
        header.setContentDispositionFormData("FastDFSFPictureName","earth");
        //指定响应时的内容大小，用于在下载时显示现在进度
//        header.setContentLength(creditor.getFilesize());
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, header, HttpStatus.OK);
        return responseEntity;
    }

}
