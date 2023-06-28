package com.example.demo.cloud;

import com.amazonaws.services.lambda.runtime.Context;
import org.springframework.cloud.function.adapter.aws.SpringBootStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LambdaHandler extends SpringBootStreamHandler {
}
