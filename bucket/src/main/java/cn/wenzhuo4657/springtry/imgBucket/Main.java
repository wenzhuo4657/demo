package cn.wenzhuo4657.springtry.imgBucket;


import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.*;
import java.net.URI;

public class Main {

    private static String accessKeyId = "bbdca83781e8762046d3653340f651ac";
    private static String secretAccessKey = "d56ef524754ee743037d0d2de91d7fef54d7830aa123baf43db9786628e3e4c4";
    private static String endpoint = "https://5a6bedf9483210bec5716c0eeb8dfd72.r2.cloudflarestorage.com";
    private static String bucketName = "imageback";

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\25370\\Pictures\\个人使用\\95DB6D95CA0AD9209C2ED96C20E19F7C.jpg");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        // 创建S3客户端
        S3Client s3 = S3Client.builder()
                .endpointOverride(URI.create(endpoint))
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
                .build();



        // 上传文件
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(file.getName())
                .build();


        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;

        // 读取文件内容到字节数组
        while ((bytesRead = bis.read(buffer, 0, buffer.length)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }

        // 获取完整的字节数组
        byte[] fileContent = baos.toByteArray();

        PutObjectResponse response = s3.putObject(
                putObjectRequest,
                software.amazon.awssdk.core.sync.RequestBody.fromBytes(fileContent)
        );


        // 关闭S3客户端
        s3.close();

    }
}