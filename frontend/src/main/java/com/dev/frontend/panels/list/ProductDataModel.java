package com.dev.frontend.panels.list;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dev.frontend.services.Services;


public class ProductDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public ProductDataModel() 
	{
		super(new String[]{"Code","Description","Price","Quantity"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_PRODUCT;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		//TODO by the candidate (OK)
		/*
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
//		String[][] sampleData = new String [][]{{"01","Product 1","12.5","25"},{"02","Product 2","10","8"}};
		JSONArray jsaList = (JSONArray) list;
		int jsaListSize = jsaList.size();
		
		String[][] arrayData = new String[jsaListSize][4];
		for (int i = 0; i < jsaListSize; i++) {
			JSONObject jsProduct = ((JSONObject) jsaList.get(i));
			arrayData[i][0] = (String) jsProduct.get("code");
			arrayData[i][1] = (String) jsProduct.get("description");
			arrayData[i][2] = (String) jsProduct.get("price");
			arrayData[i][3] = (String) jsProduct.get("quantity");
		}
		
		return arrayData;
	}
}
