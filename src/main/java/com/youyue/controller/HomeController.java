package com.youyue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by dllo on 17/11/9.
 */
@Controller
public class HomeController {

    /**
     * 访问localhost:8080/ 时进入的页面
     */
//    @RequestMapping(value = {"/",""})
    @RequestMapping("/")
    public String home(){
        return "success";
    }

    @RequestMapping("/file")
    public String file(){
        return "fileUpload";
    }


    @RequestMapping(value = "/login")
    public String login(String[] ids, String departmentId, String postId, Model model){

        System.out.println(departmentId);
        System.out.println(postId);
        System.out.println(Arrays.toString(ids));

//        数据回显
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("postId", postId);
        model.addAttribute("ids", ids);

//        return "forward:/hr/findAll";     // 转发
        return "redirect:main";     //重定向
    }

    @RequestMapping("/main")
    public String main(){
        return "error";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(MultipartFile picture,
                             HttpServletRequest request,
                             HttpServletResponse response) throws IOException {

//        System.out.println(picture);

        if (picture == null) {
            try {
                throw new Exception("文件为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(picture.getSize()>10000000)
        {
            try {
                throw new Exception("上传失败：文件大小不能超过10M");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        String rootPath = "/Users/dllo/Desktop/temp";

        String path = request.getServletContext().getRealPath("files");

        File dirFile = new File(path);

        if (!dirFile.exists() || dirFile.isFile()){
            dirFile.mkdirs();   // 创建这个目录
        }


//        构建要存储的文件对象
        File file = new File(dirFile, picture.getOriginalFilename());

        picture.transferTo(file);

        System.out.println(file.getAbsolutePath());

//        System.out.println(request.getSession().getServletContext().getRealPath("files"));



        return "success";
    }

}
