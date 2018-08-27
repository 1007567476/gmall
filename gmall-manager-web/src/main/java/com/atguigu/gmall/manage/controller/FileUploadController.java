package com.atguigu.gmall.manage.controller;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

/*    @RequestMapping(value = "fileUpload",method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile[] files){
    return "https://m.360buyimg.com/babel/jfs/t5137/20/1794970752/352145/d56e4e94/591417dcN4fe5ef33.jpg";
    }

}*/


    //@Value 注解 可以从配置文件中直接取值   使用@Value 注解必须在spring 容器中才能使用
    @Value("${fileServer.url}")
    private String fileUrl; //fileUrl = http://192.168.207.103


    //百度控件能够支持多数据长传 MultipartFile
    @RequestMapping(value = "fileUpload",method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException, MyException {

        String imgUrl=fileUrl;

        if (file!=null) {
            String configFile = this.getClass().getResource("/tracker.conf").getFile();
            ClientGlobal.init(configFile);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            //获取文件名称
            String filename = file.getOriginalFilename();
            //获取后缀名
            String extName = StringUtils.substringAfterLast(filename, ".");

         //   String orginalFilename = "D://Mywork//谷粒商城//03 后台管理spu-图片上传//001.jpg";
          //  String[] upload_file = storageClient.upload_file(orginalFilename, "jpg", null);
            String[] upload_file = storageClient.upload_file(file.getBytes(), extName, null);
            imgUrl=fileUrl ;

            //  s = group1
          //  s = M00/00/00/wKjPZ1uCy1mAQNs2AAAxx4JSqtM795.jpg
            for (int i = 0; i < upload_file.length; i++) {
                String path = upload_file[i];
                imgUrl+="/"+path;
            }

        }
        //回显图片上传路径
       // return "https://m.360buyimg.com/babel/jfs/t5137/20/1794970752/352145/d56e4e94/591417dcN4fe5ef33.jpg";
        return imgUrl;

    }
}

