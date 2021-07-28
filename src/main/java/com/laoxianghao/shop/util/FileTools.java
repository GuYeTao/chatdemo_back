package com.laoxianghao.shop.util;

import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileTools {


    public static String writeFile(String root,String path, MultipartFile file){

        String originName = file.getOriginalFilename();
        String newName = rename(originName);
        try {
            file.transferTo(new File(root+path + newName));
        }catch(IOException e){
            e.printStackTrace();
        }
        return path+newName;
    }

    public static String rename(String originName){
        int index = originName.lastIndexOf(".");
        String fileName = UUID.randomUUID().toString();

        String fullName = index>0?fileName+originName.substring(index):fileName;
//        fullName="${file.uploadPath}"+fullName;
        return fullName;
    }


    /**
     * 删除指定文件夹或文件
     * @param path 文件夹或文件路径
     * @return Boolean 删除成功返回true，删除失败返回false。
     */
    @PostMapping("/file/delete/custom/path")
    public static Boolean uploadCustomPathFile(@RequestParam("path") String path){
        return FileSystemUtils.deleteRecursively(new File(path));
    }

}
