package com.wux.controller;

import com.google.code.kaptcha.servlet.KaptchaExtend;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by wuxiang
 * on 2018/5/11.
 */
@Controller
public class FileupAndDownloadController {
    @Autowired
    private KaptchaExtend kaptchaExtend;

    /**
     * 将文件上传到F:/upload 目录下
     * @param source
     * @throws IOException
     */
    @RequestMapping(value = "fileup/to/f/{dirname}", method = RequestMethod.POST)
    public String fileup(MultipartFile source, @PathVariable("dirname") String dirname) throws IOException {
        String filename = source.getOriginalFilename();
        filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
        File dir = new File("f:/" + dirname);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir, filename);
        source.transferTo(file);
        System.out.println("有文件上传F:/upload/-----" + filename);
        return "redirect:/index.jsp";
    }

    /**
     * 文件上传后存储在服务器中，比如说在Tomcat中的项目目录下
     * @param source
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "fileup/project", method = RequestMethod.POST)
        public String fileup(MultipartFile source, HttpServletRequest request) throws IOException {
        String filename = source.getOriginalFilename();
        filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
        // 项目部属服务器后，其根目录在磁盘的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        // 指定文件上传路径，如果不存在则创建该目录，upload目录与项目根目录同级。
        String webappsPath = new File(realPath).getParent();
        File dir = new File(webappsPath + "/upload");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir, filename);
        source.transferTo(file);
        System.out.println("有文件上传服务器/upload/-----" + filename);
        return "redirect:/index.jsp";
    }

    /**
     * 从服务器下载，资源文件
     * @param filename
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("download/{filename:.+}")
    public String download(@PathVariable("filename") String filename, HttpServletRequest request, HttpServletResponse
            response) throws IOException {
        System.out.println(filename);
//        response.setHeader("content-disposition", "attachment;fimename=" + filename);
//        response.setHeader("content-disposition", "attachment;fimename=" + filename);
        String realPath = request.getSession().getServletContext().getRealPath("/");// 项目部属后的目录
        String parent = new File(realPath).getParent(); //
        String resourcePath = parent + "/upload/" + filename;// 被下载的资源路径
        InputStream inputStream = new FileInputStream(resourcePath);
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        return null;
    }

    /**
     * 向客户端写出验证码图片
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 下面一句语句做两件事
         * 1.生成随机4位字符，并将其保存在session作用域中，key="code",value="xxxx"
         * 2.将随机的xxxx生成图片，响应给客户端。
         */
        kaptchaExtend.captcha(request,response);
    }
}