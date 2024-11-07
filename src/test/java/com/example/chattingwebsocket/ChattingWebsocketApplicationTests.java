package com.example.chattingwebsocket;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class ChattingWebsocketApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Result");
        System.out.println("Result");
        System.out.println("Result");
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz".length());
        String s="Nội Dung Bài Viết\n" +
                "Bước 1: Tải DynamoDB Local\n" +
                "Bước 2: Cài đặt Java\n" +
                "Bước 3: Chạy DynamoDB Local\n" +
                "Bước 4: Cài đặt AWS CLI\n" +
                "Bước 5: Kết nối đến DynamoDB Local từ Terminal\n" +
                "Bước 6: Kết nối đến DynamoDB Local từ Spring Boot\n" +
                "Bước 1: Tải DynamoDB Local\n" +
                "DynamoDB Local được cung cấp bởi AWS, bạn có thể tải về từ liên kết này:\n" +
                "\n" +
                "DynamoDB Local Download\n" +
                "Sau khi tải về, bạn giải nén file vào một thư mục trên máy của mình.\n" +
                "\n" +
                "Bước 2: Cài đặt Java\n" +
                "DynamoDB Local yêu cầu Java để chạy. Nếu bạn chưa có Java trên máy hãy cài đặt JDK từ Oracle hoặc sử dụng OpenJDK.\n" +
                "\n" +
                "Bước 3: Chạy DynamoDB Local\n" +
                "Mở terminal và chuyển đến thư mục mà bạn đã giải nén DynamoDB Local và chạy lệnh sau để khởi động DynamoDB Local:\n" +
                "\n" +
                "java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb\n" +
                "– sharedDb là tuỳ chọn để sử dụng một database chung cho tất cả các ứng dụng truy cập.\n" +
                "\n" +
                "Bước 4: Cài đặt AWS CLI\n" +
                "Cài đặt và thiết lập AWS CLI theo hướng dẫn Cài Đặt AWS CLI Với Homebrew\n" +
                "\n" +
                "Cấu hình access key và secret key như sau:\n" +
                "\n" +
                "$ aws configure\n" +
                "AWS Access Key ID: awsAccessKey2024\n" +
                "AWS Secret Access Key: awsSecret2024\n" +
                "Default region name: ap-southeast-1\n" +
                "Default output format: json\n" +
                "Bước 5: Kết nối đến DynamoDB Local từ Terminal\n" +
                "$ aws dynamodb list-tables --endpoint-url http://localhost:8000\n" +
                "Bước 6: Kết nối đến DynamoDB Local từ Spring Boot\n" +
                "Để kết nối Spring Boot với DynamoDB Local bạn có thể thực hiện các bước sau:\n" +
                "\n" +
                "– Thêm dependency DynamoDB SDK vào pom.xml:\n" +
                "<dependency>\n" +
                "<groupId>software.amazon.awssdk</groupId>\n" +
                "<artifactId>dynamodb</artifactId>\n" +
                "</dependency>\n" +
                "\n" +
                "– Cấu hình DynamoDB trong application.properties hoặc application.yml:\n" +
                "\n" +
                "aws:\n" +
                "  region: us-west-2\n" +
                "  dynamodb:\n" +
                "    endpoint: http://localhost:8000\n" +
                "– Cấu hình DynamoDB Client trong Spring Boot:\n" +
                "\n" +
                "import software.amazon.awssdk.services.dynamodb.DynamoDbClient;\n" +
                "import software.amazon.awssdk.regions.Region;\n" +
                "import org.springframework.context.annotation.Bean;\n" +
                "import org.springframework.context.annotation.Configuration;\n" +
                "import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;\n" +
                "import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;\n" +
                "import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;\n" +
                "\n" +
                "@Configuration\n" +
                "public class DynamoDbConfig {\n" +
                "\n" +
                "    @Bean\n" +
                "    public DynamoDbClient dynamoDbClient() {\n" +
                "        return DynamoDbClient.builder()\n" +
                "                .endpointOverride(URI.create(\"http://localhost:8000\"))\n" +
                "                .region(Region.AP_SOUTHEAST_1) // ap-southeast-1: Default region name\n" +
                "                .credentialsProvider(StaticCredentialsProvider.create(\n" +
                "                        // awsAccessKey2024: AWS Access Key ID\n" +
                "                        // awsSecret2024: AWS Secret Access Key\n" +
                "                        AwsBasicCredentials.create(\"awsAccessKey2024\", \"awsSecret2024\")))\n" +
                "                .build();\n" +
                "    }\n" +
                "}";
        System.out.println(s.length());
    }

//    public String addBinary(String a, String b) {
//        String str_shorter = a.length() > b.length() ? b : a;
//        String str_longer = a.length() > b.length() ? a : b;
//        while (str_shorter.length() < str_longer.length())
//            str_shorter = '0' + str_shorter;
//
//        String sumBinary = "";
//        int carry = 0;
//
//        for (int i = str_longer.length() - 1; i >= 0; i--) {
//            if ((int)str_longer.charAt(i)+(int)str_shorter.charAt(i))
//
//            return "";
//        }
//
//    }
}
