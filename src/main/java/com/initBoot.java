package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mapper.SysMenuMapper;
import com.model.*;
import com.model.Admin;
import com.service.IYueService;
import com.service.impl.testAsyncService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessageOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.service.IAdminService;

@Controller
@SpringBootApplication
@PropertySource("classpath:test.properties")// 用来指定配置文件的位置
@ImportAutoConfiguration(RedissonAutoConfiguration.class)
@EnableAsync
@EnableCaching
public class initBoot {

    @Resource
    IAdminService adminService;

    @Resource
    IYueService yueService;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    ExecutorService newFixedThreadPool;

    @Value("${test.aa}")
    private String aa;

    @Autowired
    private RedissonClient redisson;

    @Autowired
    testAsyncService testAsync;

    @Resource
    SysMenuMapper sysMenuMapper;

//	@Resource
//	Admin admins;
//	@Autowired  // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装  
//	JmsMessageOperations jmsMessagingTemplate;  

//	@Autowired
//	MongoTemplate mongoTemplate;


    @RequestMapping("/test1")
    public String test1() {
        return "test1";
    }

    @RequestMapping("/testRunAsync1")
    @ResponseBody
    public String testRunAsync1() {
        for (int i = 0; i < 50; i++) {
            testAsync.runAsync1();
        }
        return "testRunAsync1。。。。..";
    }

    @RequestMapping("/testRunAsync2")
    @ResponseBody
    public String testRunAsync2() {
        for (int i = 0; i < 50; i++) {
            testAsync.runAsync2();
        }
        return "testRunAsync2";
    }

    @RequestMapping("/toBaidu")
    public String toBaidu() {
        String redirectUrl = "https://www.baidu.com";
        return "redirect:" + redirectUrl;
    }

    @Async("testPool2")
    public void runAsync1() {
        try {
            System.out.println("in the runAsync1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("testPool2")
    public void runAsync2() {
        try {
            System.out.println("in the runAsync2");

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

    @Bean
    public Executor testPool2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

    @RequestMapping("/mysqlTest")
    @ResponseBody
    Admin mysqlTest() {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("test");
        admin.setAge(25);
        adminService.insertAdmin(admin);
        Admin admin2 = adminService.getAdminById(1);
        return admin2;
    }

    @RequestMapping("/mysqlTest2")
    @ResponseBody
    YueTest1 mysqlTest2() {
        BaseYueTest base = yueService.getBaseYueInfo(1);
        YueTest1 test1 = base;

        List<YueTest2> test2s = base.getYueTest2List();

        System.out.println(JSONObject.toJSONString(test1));
        System.out.println(JSONArray.toJSONString(test2s));
        return test1;
    }

    @RequestMapping("/testThread")
    @ResponseBody
    String testThread() {
        for (int i = 0; i < 30; i++) {
            final int index = i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    try {
                        Thread.sleep(3000);
                        System.out.println("index===========" + index);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });
        }
        return "success";
    }

    @RequestMapping("/testThread2")
    @ResponseBody
    String testThread2() {
        for (int i = 0; i < 30; i++) {
            final int index = i;
            new Thread() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    try {
                        Thread.sleep(2000);
                        redisLock();
                        System.out.println("1111111111111");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }.start();
        }
        return "success";
    }

    private void redisLock() throws Exception {
        RLock testLock = redisson.getLock("test1");
        testLock.lock();
        System.out.println("4444444444444444444");
        Thread.sleep(3000);
        System.out.println("555555555555555555");
        testLock.unlock();
    }

    @RequestMapping("/redisTest")
    @ResponseBody
    Object redisTest() {
//		System.out.println(redisTemplate.getKeySerializer());
//		// System.out.println("admins==========="+admins.getName());
//		StringRedisSerializer serializer = new StringRedisSerializer();
//		redisTemplate.setKeySerializer(serializer);
//		StringBuilder sb = new StringBuilder();
//		sb.append("return redis.call('decr',KEYS[1])");
//		//redisTemplate.opsForValue().set("test", "this is test");
//		RedisScript<String> script = new DefaultRedisScript<String>(sb.toString(),String.class);
//		List<String> keys = new ArrayList<String>();
//		keys.add("luatest");
//		List<Integer> args = new ArrayList<Integer>();
//		args.add(2);
        stringRedisTemplate.opsForValue().set("luatest", "5");
        stringRedisTemplate.opsForList().set("abc", 1, "5");
        //stringRedisTemplate.opsForHash()
//		List<String> list = stringRedisTemplate.opsForList().index(key, index)
//		long abc = stringRedisTemplate.opsForValue().increment("luatest", -1);
//		
//		//int abc = redisTemplate.execute(script, keys, args);
//		return abc;
        return stringRedisTemplate.opsForValue().get("luatest");
    }

    @RequestMapping("/redisStringMapTest")
    @ResponseBody
    Object redisStringMapTest() {
//		System.out.println(redisTemplate.getKeySerializer());
//		// System.out.println("admins==========="+admins.getName());
//		StringRedisSerializer serializer = new StringRedisSerializer();
//		redisTemplate.setKeySerializer(serializer);
//		StringBuilder sb = new StringBuilder();
//		sb.append("return redis.call('decr',KEYS[1])");
//		//redisTemplate.opsForValue().set("test", "this is test");
//		RedisScript<String> script = new DefaultRedisScript<String>(sb.toString(),String.class);
//		List<String> keys = new ArrayList<String>();
//		keys.add("luatest");
//		List<Integer> args = new ArrayList<Integer>();
//		args.add(2);
        Map<String, String> map = new HashMap<String, String>();
        map.put("abc", "12");
        map.put("bcd", "35");
        stringRedisTemplate.opsForValue().set("userName", JSON.toJSONString(map));
//		long abc = stringRedisTemplate.opsForValue().increment("luatest", -1);
//		
//		//int abc = redisTemplate.execute(script, keys, args);
//		return abc;
        return stringRedisTemplate.type("userName");
    }

    @RequestMapping("/redisHashTest")
    @ResponseBody
    Object redisHashTest() {
//		StringRedisSerializer serializer = new StringRedisSerializer();
//		redisTemplate.setKeySerializer(serializer);
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put("userName", "mayue", "26");
        hashOperations.put("userName", "zhouxiaoyan", "34");

        hashOperations.get("userName", "zhouxiaoyan");
        //hashOperations.


//		Map<String,String> map = new HashMap<String,String>();
//		map.put("mayue", "26");
//		redisTemplate.opsForHash().putAll("userName2", map);
        return hashOperations.get("userName1", "zhouxiaoyan");
    }

    @RequestMapping("/redisHashTestString")
    @ResponseBody
    Object redisHashTestString() {
        //stringRedisTemplate.opsForHash().put("userName", "mayue", "26");
        //redisTemplate.opsForHash().delete("userName", "zhouxiaoyan");
        return stringRedisTemplate.opsForHash().get("userName", "mayue");
    }

    @RequestMapping("/redisHashTestDel")
    @ResponseBody
    Object redisHashTestDel() {
        //stringRedisTemplate.opsForHash().put("userName", "mayue", "26");
        //stringRedisTemplate.opsForHash().delete("userName", "zhouxiaoyan");
        System.out.println(stringRedisTemplate.hasKey("userName"));
        stringRedisTemplate.delete("userName");
        System.out.println(stringRedisTemplate.hasKey("userName"));
        return stringRedisTemplate.opsForHash().entries("userName");
    }

    @RequestMapping("/redisincreTest")
    @ResponseBody
    Object redisincreTest() {
//		System.out.println(redisTemplate.getKeySerializer());
//		// System.out.println("admins==========="+admins.getName());
//		StringRedisSerializer serializer = new StringRedisSerializer();
//		redisTemplate.setKeySerializer(serializer);
//		StringBuilder sb = new StringBuilder();
//		sb.append("return redis.call('decr',KEYS[1])");
////		//redisTemplate.opsForValue().set("test", "this is test");
//		RedisScript<String> script = new DefaultRedisScript<String>(sb.toString(),String.class);
//		List<String> keys = new ArrayList<String>();
//		keys.add("luatest");
//		List<Integer> args = new ArrayList<Integer>();
//		args.add(2);
        Long abc = stringRedisTemplate.opsForValue().increment("luatest", -1);

//		int b = -15;
//		String aaa = "return redis.call('incrby', KEYS[1], " + b + ");";
//
//		RedisScript<Integer> script = new DefaultRedisScript<Integer>(aaa, Integer.class);
//		List<String> keys = new ArrayList<String>();
//		keys.add("luatest");

//		List<Integer> argv = new ArrayList<Integer>();
//		argv.add(-2);

//		redisTemplate.execute(script, keys);
        // int abc = redisTemplate.execute(script, keys, args);
        //redisTemplate.opsForHash().get("", "");
        return abc;
    }

    @RequestMapping("/redisListTest")
    @ResponseBody
    Object redisListTest() {
        List<String> aa = new ArrayList<String>();
        aa.add("qwe");
        aa.add("rty");
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        listOperations.leftPushAll("aa", aa);
        return listOperations.size("aa");
    }

    @RequestMapping("/redisListTestLot")
    @ResponseBody
    Object redisListTestLot() {
        Random random = new Random();
        int n = random.nextInt(stringRedisTemplate.opsForList().size("aa").intValue());//存放redis长度
        return stringRedisTemplate.opsForList().index("aa", n);
    }

    @RequestMapping("/redisListTestDel")
    @ResponseBody
    Object redisListTestDel() {
        stringRedisTemplate.opsForList().remove("aa", 1, "qwe");
        return stringRedisTemplate.opsForList().size("aa");
    }

    @RequestMapping("/redisIncrementTest")
    @ResponseBody
    Object redisIncrementTest() {
        //stringRedisTemplate.opsForValue().set("test1", "1");

        return stringRedisTemplate.opsForValue().increment("test1", 1);
    }

    @RequestMapping("/redisImageTest")
    @ResponseBody
    String redisImageTest() {
		redisTemplate.opsForValue().set("test", "this is test");
        return "success";
    }

//	@RequestMapping("/mqTest")
//    @ResponseBody
//    void mqTest() {
//		Destination destination = new ActiveMQQueue("mqTest.queue");  
//		jmsMessagingTemplate.convertAndSend(destination, "this is mq message");  
//    }

    @RequestMapping("/mongoTest")
    @ResponseBody
    void mongoTest() {
        // mongoTemplate.
    }

//	@JmsListener(destination = "mqTest.queue")  
//    public void receiveQueue(String text) {  
//        System.out.println("Consumer收到的报文为:"+text);  
//    }  

    public static void main(String[] args) throws Exception {
        SpringApplication.run(initBoot.class, args);
    }

    @RequestMapping("/getAa")
    @ResponseBody
    public String getAa() {

        return aa;
    }

    @RequestMapping(value = "/testLock")
    @ResponseBody
    public String testLock(HttpServletRequest request) throws InterruptedException {
        System.out.println(request.getRemoteAddr() + ":out the testLock");
        RLock testLock = redisson.getLock("test1");
        try {
            System.out.println(request.getRemoteAddr() + ":in the testLock");
            //testLock.lock();
            if (testLock.tryLock()) {
                System.out.println(request.getRemoteAddr() + ":start sleep");
                Thread.sleep(6000L);
                System.out.println(request.getRemoteAddr() + ":end sleep");
                System.out.println(request.getRemoteAddr() + ":end the testLock");
                return "OK";
            } else {
                return "END";
            }
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            testLock.unlock();
        }
        return "";
    }

    @RequestMapping(value = "/testSysMenuMapper")
    @ResponseBody
    public List<SysMenu> testSysMenuMapper(){
        return sysMenuMapper.selectTest(Long.valueOf("4"),"菜单管理");
    }

    @RequestMapping(value = "/testLock2")
    @ResponseBody
    public String testLock2() throws InterruptedException {
        System.out.println("out the testLock");
        //RLock testLock = redisson.getLock("test1");
        try {
            System.out.println("in the testLock");
            //testLock.lock();
            System.out.println("start sleep");
            Thread.sleep(6000L);
            //System.out.println("end sleep");
            System.out.println("end the testLock");
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            //testLock.unlock();
            return "OK";
        }
    }
}
