package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	
	
	@Override
	public File rename(File originFile) {
		
		// 원본파일 뽑기
		String originName = originFile.getName(); // "aaa.jpg"
		
		// 수정파일명 만들기 (규칙) 최대한 이름이 겹치지 않도록
		// 파일이 업로드된 시간(년월일시분초) + 5자리 랜덤값(10000 ~ 99999) + 확장자
		
		
		//업로드 시간
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	
		// 랜덤값 추출
		int ranNum = (int)(Math.random() * 90000) + 10000; // 10000 ~ 99999
		
		// 확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = "Dakchigo_" + currentTime + "_" + ranNum + ext;
	
		return new File(originFile.getParent(), changeName);
		//getParent 원본파일 디렉토리 알아내는 법
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
