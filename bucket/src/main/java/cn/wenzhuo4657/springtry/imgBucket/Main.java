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

    private static String accessKeyId = "2bcbd2ccef26949f5d4b6ef1275eeca7";
    private static String secretAccessKey = "147bfa6078f97d81b67b39649b311dcd8ded1fe9551cc5a82762bfe617d703e3";
    private static String endpoint = "https://5a6bedf9483210bec5716c0eeb8dfd72.r2.cloudflarestorage.com";
    private static String bucketName = "img";

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\14783\\Pictures\\EBBEC497ED07A822CB76D24D76738BA8.jpg");
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