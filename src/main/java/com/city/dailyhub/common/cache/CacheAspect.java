package com.city.dailyhub.common.cache;

import com.alibaba.fastjson.JSON;
import com.city.dailyhub.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * @version v1.0
 * @ClassName: CacheAspect
 * @Description: 定义缓存，存储数据
 * @Author: CitySpring
 */
@Aspect
@Component
@Slf4j
public class CacheAspect {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 定义切点，注解放哪里，哪里就是切点
    @Pointcut("@annotation(com.city.dailyhub.common.cache.Cache)")
    public void pt(){};

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        try{
            Signature signature = pjp.getSignature();
            //类名
            String className = pjp.getTarget().getClass().getSimpleName();
            //调用的方法名
            String methodName = signature.getName();

            Class[] parameterTypes = new Class[pjp.getArgs().length];
            Object[] args = pjp.getArgs();
            //参数
            String params = "";
            for(int i=0; i<args.length; i++) {
                if(args[i] != null) {
                    params += JSON.toJSONString(args[i]);
                    parameterTypes[i] = args[i].getClass();
                }else {
                    parameterTypes[i] = null;
                }
            }
            if (StringUtils.isNotEmpty(params)) {
                params = DigestUtils.md5Hex(params);//加密 以防出现key过长以及字符转义获取不到的情况
            }
            Method method = pjp.getSignature().getDeclaringType().getMethod(methodName, parameterTypes);

            Cache annotation = method.getAnnotation(Cache.class);//获取Cache注解
            long expire = annotation.expire();//缓存过期时间
            String name = annotation.name();//缓存名称

            //先从redis获取
            String redisKey = name + "::" + className+"::"+methodName+"::"+params;
            String redisValue = redisTemplate.opsForValue().get(redisKey);
            if (StringUtils.isNotEmpty(redisValue)){
                log.info("=====缓存获取=====CLASS: {}=====METHOD: {}",className,methodName);
                return JSON.parseObject(redisValue, Result.class);
            }

            Object proceed = pjp.proceed();  // 调用原方法
            redisTemplate.opsForValue().set(redisKey,JSON.toJSONString(proceed), Duration.ofMillis(expire));
            log.info("=====存入缓存=====CLASS: {}=====METHOD: {}",className,methodName);
            return proceed;
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }

        return Result.fail("系统错误", -999);
    }

}