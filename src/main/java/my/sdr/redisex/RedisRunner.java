package my.sdr.redisex;

import my.sdr.redisex.dto.InvoicePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisRunner implements ApplicationRunner {


    @Autowired
    private RedisTemplate<String, InvoicePoint> redisTemplateStringObj;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplateObjObj;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("redisTemplateStringObj : " + redisTemplateStringObj);
        System.out.println("redisTemplateObjObj : " + redisTemplateObjObj);

        ValueOperations<String, InvoicePoint> valueOps = redisTemplateStringObj.opsForValue();
        InvoicePoint dto1 = new InvoicePoint();
        dto1.setInvoiceNumber("1001");
        dto1.setLat(36.1234);
        dto1.setLon(132.1234);
        dto1.setAddr("서울시 강남구 111-222");
//        valueOps.set(dto1.getInvoiceNumber(), dto1, 60, TimeUnit.SECONDS);
        InvoicePoint inv = valueOps.get(dto1.getInvoiceNumber()); // for warming up
        System.out.println("inv : " + inv);
        System.out.println("before: " + System.currentTimeMillis());
        valueOps.set(dto1.getInvoiceNumber(), dto1);

        InvoicePoint invoicePoint = valueOps.get(dto1.getInvoiceNumber());
        System.out.println("after : " + System.currentTimeMillis());
        System.out.println("invoicePoint : " + invoicePoint);

        HashOperations<String, String, InvoicePoint> hashOps = redisTemplateStringObj.opsForHash();
        InvoicePoint dto2 = new InvoicePoint();
        dto2.setInvoiceNumber("1002");
        dto2.setLat(36.1234);
        dto2.setLon(132.1234);
        dto2.setAddr("서울시 강남구 111-222");
        hashOps.put("invoicePoints", dto1.getInvoiceNumber(), dto1);
        hashOps.put("invoicePoints", dto2.getInvoiceNumber(), dto2);
        List<InvoicePoint> invoicePoints = hashOps.multiGet("invoicePoints", Arrays.asList(dto1.getInvoiceNumber(), dto2.getInvoiceNumber()));
        System.out.println("HMGET: " + invoicePoints);
    }
}
