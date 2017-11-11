package com.mianbaopailib.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by shidawei on 16/7/31.
 */
public class UQiNiu {

    private String accessKey;

    private String secretKey;

    private String bucketname;

    Auth auth;

    public UQiNiu(String accessKey, String secretKey,String bucketname) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucketname = bucketname;
        auth = Auth.create(accessKey, secretKey);
    }


    /**
     * 上传文件
     * @param bytes
     * @param savefile
     * @param token
     */
    private String upload(byte[] bytes,String savefile,String token) throws QiniuException {
        UploadManager uploadManager = new UploadManager();
        Response res = uploadManager.put(bytes, savefile,token);
        //打印返回的信息
        ULog.d("sssss", res.bodyString());
        return res.bodyString();
    }

    /**
     * 上传图片文件
     * @param file 来源文件
     * @param savefile 存储文件名
     * @param replace 覆盖
     */
    public String uploadImage( MultipartFile file,String savefile,boolean replace) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new IOException("上传图片不能为空");
        }
        if(replace){
            return upload(file.getBytes(),savefile,auth.uploadToken(bucketname, savefile));
        }else{
            String pic_type = file.getContentType();
            if(pic_type.equals("image/jpeg")){
                savefile =   savefile.concat(".jpg");
            } else if (pic_type.equals("image/png")){
                savefile = savefile.concat(".png");
            } else if(pic_type.equals("image/bmp")){
                savefile =  savefile.concat(".bmp");
            } else if(pic_type.equals("image/gif")){
                savefile = savefile.concat(".gif");
            } else if(pic_type.equals("image/png")){
                savefile = savefile.concat(".gif");
            } else savefile = savefile.concat(".jpg");
            return upload(file.getBytes(),savefile,auth.uploadToken(bucketname));
        }
    }

}
