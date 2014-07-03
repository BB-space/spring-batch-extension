package com.guesthouse.spring.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;

/**
 * 테스트 환경의 Local XML화일과 RC및 Live 환경의 URL 경로를 구분하기 위한 Resource 관리 클래스 
 * To-do : Profile 분리를 좀더 심플하게 고민해볼것.
 * @author cowboy76
 *
 */
public class JobUtil {
	protected static Logger log = LoggerFactory.getLogger(JobUtil.class);
	
	public static Resource getResource(final String resourcePath) {
		
		if (resourcePath == null) {
			return null;
		}
		
		Resource resource = null;
		
		String profile = System.getProperty("spring.profiles.active");			 
		if (!StringUtils.hasText(profile) || ("loc").equals(profile)) {
			resource = new ClassPathResource(resourcePath);
			return resource;
		} 
		
		try {
			resource = new UrlResource(resourcePath);
		} catch (Exception e) {			
			log.error("resource error : {}", e.toString());
			return null;
		} 
		
		return resource;
	}
}
