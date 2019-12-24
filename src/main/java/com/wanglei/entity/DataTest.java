package com.wanglei.entity;

/*import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.wanglei.entity.CalculateUtils;
import com.wanglei.entity.Car;
import com.wanglei.entity.FileUtils;
import com.wanglei.service.CarService;*/

/*@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")*/
public class DataTest {

	/*@Autowired
	CarService service;
	
	@Test
	public void testImport() throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		List<String> lines = FileUtils.readByLines("D://cardata.txt");
		for (String carStr : lines) {
			Car car = new Car();
			String[] carData = carStr.split("\\,");
			if(carData.length!=4) {
				System.out.println("长度不合法"+carData);
				continue;
			}
			//车牌号
			car.setCarno(carData[0]); 
			//经度
			car.setLongitude(Double.parseDouble(carData[1]));
			//纬度
			car.setLatitude(Double.parseDouble(carData[2]));
			//抓拍时间
			car.setZptime(format.parse(carData[3]));
			//距离
			car.setDistance(CalculateUtils.getDistance(car.getLongitude(), car.getLatitude(), 116.18, 39.30));
			System.out.println(" car is "+car);
			service.add(car);
		}
	}*/
}
