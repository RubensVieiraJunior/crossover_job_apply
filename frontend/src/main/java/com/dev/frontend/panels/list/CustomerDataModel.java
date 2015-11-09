package com.dev.frontend.panels.list;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dev.frontend.services.Services;

public class CustomerDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747613655L;

	public CustomerDataModel()
	{
		super(new String[] { "Code", "Name", "Phone", "Current Credit" }, 0);
	}

	@Override
	public int getObjectType()
	{
		return Services.TYPE_CUSTOMER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list)
	{
		//TODO by the candidate (OK)
		/*
		 * This method use list returned by Services.listCurrentRecords and should convert it to array of rows
		 * each row is another array of columns of the row
		 */
//		String[][] sampleData = new String [][]{{"01","Customer 1","+201011121314","23.4"},{"02","Customer 2","+201112131415","1.4"}};
		JSONArray jsaList = (JSONArray) list;
		int jsaListSize = jsaList.size();
		
		String[][] arrayData = new String[jsaListSize][4];
		for (int i = 0; i < jsaListSize; i++) {
			JSONObject jsCustomer = ((JSONObject) jsaList.get(i));
			arrayData[i][0] = (String) jsCustomer.get("code");
			arrayData[i][1] = (String) jsCustomer.get("name");
			arrayData[i][2] = (String) jsCustomer.get("phone1");
			arrayData[i][3] = (String) jsCustomer.get("currentCredit");
		}
		
		return arrayData;
	}
}
