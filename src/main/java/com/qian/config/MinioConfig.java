package com.qian.config;

import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {

    private String url;
    private String accessKey;
    private String secretKey;
    private String bucket;

//    @Bean
//    public MinioClient minioClient() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
//        MinioClient client = MinioClient.builder()
//                .endpoint(url)
//                .credentials(accessKey, secretKey)
//                .build();
////       创建bucket
//        if(!client.bucketExists(BucketExistsArgs.builder().bucket(bucket).build())){
//            client.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
//        }
//        return client;
//    }
//
//    public String upLoadFile(@Qualifier("minioClient") MinioClient minioClient, @org.jetbrains.annotations.NotNull MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
//        if (file.isEmpty()||file.getSize() == 0){
//            return "文件为空";
//        }
//        String filename = file.getOriginalFilename();
//        String newName = "pic/"+ UUID.randomUUID().toString().replace("-","") +filename.substring(filename.lastIndexOf("."));
//        InputStream inputStream = file.getInputStream();
//        minioClient.putObject(
//                PutObjectArgs.builder().bucket(bucket).object(newName).stream(
//                        inputStream, file.getSize(),-1
//                ).build()
//        );
//        inputStream.close();
//    }

    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException, InvalidBucketNameException, InsufficientDataException, XmlPullParserException, ErrorResponseException, NoSuchAlgorithmException, IOException, NoResponseException, InvalidKeyException, InvalidResponseException, InternalException, RegionConflictException {
        MinioClient client = new MinioClient(url, accessKey, secretKey);
        if (!client.bucketExists(bucket)){
            client.makeBucket(bucket);
        }
        return client;
    }

//    public String uploadFile(@Qualifier("minioClient") MinioClient minioClient, MultipartFile file) throws IOException, InvalidArgumentException, InvalidBucketNameException, InsufficientDataException, XmlPullParserException, ErrorResponseException, NoSuchAlgorithmException, NoResponseException, InvalidKeyException, InvalidResponseException, InternalException {
//        if (file.isEmpty() || file.getSize()==0){
//            return "文件为空";
//        }
//        String fileName = file.getOriginalFilename();
//        String newName = "pic/"+ UUID.randomUUID().toString().replace("-","")+fileName.substring(fileName.lastIndexOf("."));
//        InputStream inputStream = file.getInputStream();
//        minioClient.putObject(bucket,newName,inputStream,"application/octet-stream");
//        inputStream.close();
//        String url = minioClient.getObjectUrl(bucket,newName);
//        return url;
//    }



}
