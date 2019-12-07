package com.hqt.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hqt.bean.User;
import com.hqt.utils.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext-redis.xml")
public class Week2 {
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void testDate(){
		List<User> userlList=new ArrayList<User>();
		for (int i = 0; i < 100000; i++) {
			User user=new User();
			user.setId(i+1);
			
			//姓名随机汉字
			String randomChinese = StringUtils.getRandomChinese(3);
			user.setName(randomChinese);
			
			
			//性别随机男和女
			Random random=new Random();
			String sex=random.nextBoolean()?"男":"女";
			user.setSex(sex);
			
			
			//随机号码&13开头
			String phone ="13"+StringUtils.getRandomNumber(9);
			user.setPhone(phone);
			
			
			//随机邮箱 
			int random2 = (int) (Math.random()*20);
			int len=random2<3?random2+3:random2;
			String randomChinese2 = StringUtils.getRandomChinese(len);
			String randomEmailSuffex = StringUtils.getRandomEmailSuffex();
			
			user.setEmial(randomChinese2+randomEmailSuffex);
			
			
			//随机出生日期
			String randomBirthday = StringUtils.randomBirthday();
			user.setBirthday(randomBirthday);
			
			userlList.add(user);
		}
		
		
	}
}
