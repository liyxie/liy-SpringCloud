package com.liy.common.core.util;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.liy.common.core.domain.R;
import com.liy.common.core.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.http.server.reactive.ServerHttpResponse;
import java.io.IOException;
import reactor.core.publisher.Mono;

/**
 * @Author LiY
 * 客户端响应
 */

@Component
@Slf4j
public class WebUtil {

//    /**
//     * 将字符串渲染到客户端
//     *
//     * @param response 渲染对象
//     * @param string 待渲染的字符串
//     */
//    public static void renderString(HttpServletResponse response, String string)
//    {
//        try
//        {
//            log.info(string);
//            response.setStatus(200);
//            response.setContentType("application/json");
//            response.setCharacterEncoding("utf-8");
//            response.getWriter().print(string);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    public static void renderString(HttpServletResponse response, String mag, Integer code)
//    {
//        try
//        {
//            log.info(mag);
//            response.setStatus(code);
//            response.setContentType("application/json");
//            response.setCharacterEncoding("utf-8");
//            response.getWriter().print(mag);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }

    public static Mono<Void> renderString(ServerHttpResponse response, String mag, ResultCode resultCode)
    {
            log.info(mag);
            response.setStatusCode(HttpStatus.OK);
            response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

//            response.setContentType("application/json");
//            response.setCharacterEncoding("utf-8");

            R<?> result = R.fail(resultCode.getCode(), mag);
            DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(result).getBytes());

            return response.writeWith(Mono.just(dataBuffer));
    }

    public static Mono<Void> renderString(ServerHttpResponse response, String mag)
    {


        return renderString(response, mag, ResultCode.FAILED );
    }


}
