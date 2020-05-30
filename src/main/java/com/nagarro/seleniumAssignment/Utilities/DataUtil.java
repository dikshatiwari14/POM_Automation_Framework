package com.nagarro.seleniumAssignment.Utilities;

import java.util.Hashtable;
import com.nagarro.seleniumAssignment.Base.Base;

public class DataUtil extends Base {
	
	public static Object[][] getData(ExcelReader xls, String testCaseName){
		String sheetName="TestData";
		// reads data for only testCaseName
		
		int testStartRowNum=1;
		log.debug(xls.getCellData(sheetName, 0, testStartRowNum));
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
			testStartRowNum++;
		}
		log.debug("Test starts from row - "+ testStartRowNum);
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		
		// calculate rows of data
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		log.debug("Total rows are  - "+rows );
		
		//calculate total cols
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}
		log.debug("Total cols are  - "+cols );
		Object[][] data = new Object[rows][1];
		//read the data
		int dataRow=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++){
				String key=xls.getCellData(sheetName,cNum,colStartRowNum);
				String value= xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
				// 0,0 0,1 0,2
				//1,0 1,1
			}
			data[dataRow][0] =table;
			dataRow++;
		}
		return data;
	}
}
