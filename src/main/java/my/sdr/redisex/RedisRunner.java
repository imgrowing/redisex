package my.sdr.redisex;

import my.sdr.redisex.dto.InvoicePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

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
        InvoicePoint dto = new InvoicePoint();
        dto.setInvoiceNumber("1001");
        dto.setLat(36.1234);
        dto.setLon(132.1234);
        dto.setAddr("서울시 강남구 111-222");
//        valueOps.set(dto.getInvoiceNumber(), dto, 60, TimeUnit.SECONDS);
        InvoicePoint inv = valueOps.get(dto.getInvoiceNumber()); // for warming up
        System.out.println("inv : " + inv);
        System.out.println("before: " + System.currentTimeMillis());
        valueOps.set(dto.getInvoiceNumber(), dto);

        InvoicePoint invoicePoint = valueOps.get(dto.getInvoiceNumber());
        System.out.println("after : " + System.currentTimeMillis());
        System.out.println("invoicePoint : " + invoicePoint);
    }
}
