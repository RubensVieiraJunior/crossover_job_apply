package com.dev.frontend.panels.list;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dev.frontend.services.Services;


public class SalesOrderDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public SalesOrderDataModel() 
	{
		super(new String[]{"Order Number","Customer","Total Price"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_SALESORDER;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		//TODO by the candidate (OK)
		/*
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
//		String[][] sampleData = new String [][]{{"22423","(01)Customer 1","122.5"},{"22424","(02)Customer 2","3242.5"}};
		JSONArray jsaList = (JSONArray) list;
		int jsaListSize = jsaList.size();
		
		String[][] arrayData = new String[jsaListSize][3];
		for (int i = 0; i < jsaListSize; i++) {
			JSONObject jsSalesOrder = ((JSONObject) jsaList.get(i));
			Map mapCustomer = (Map) jsSalesOrder.get("customer");
			
			arrayData[i][0] = (String) jsSalesOrder.get("orderNum");
			arrayData[i][1] = "(" + mapCustomer.get("code") + ")" + mapCustomer.get("name");
			arrayData[i][2] = (String) jsSalesOrder.get("totalPrice");
		}
		
		return arrayData;

	}
}
