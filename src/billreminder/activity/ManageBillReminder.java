package billreminder.activity;

import publics.Publics;
import main.activity.R;
import model.bill.BillReminderAdapter;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TabHost;

public class ManageBillReminder extends TabActivity {
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.manage_bill_reminder);
		
		TabHost th = getTabHost();
		th.addTab(th.newTabSpec("Main").setIndicator("View paid bill").setContent(R.id.tab_paidbill));
		th.addTab(th.newTabSpec("Main2").setIndicator("View upcoming bill").setContent(R.id.tab_upcomingbill));
		
		ListView lv_paidBill = (ListView)findViewById(R.id.lv_paidBill);
		lv_paidBill.setAdapter(new BillReminderAdapter(this));
		
		//
		ListView lv_upcomingBill = (ListView)findViewById(R.id.lv_upcomingBill);
		lv_upcomingBill.setAdapter(new BillReminderAdapter(this));
		
		
		lv_upcomingBill.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intentUpdateAccount = new Intent(ManageBillReminder.this, BillDetail.class);
				startActivityForResult(intentUpdateAccount,Publics.REQ_VIEW_ACCOUNT);
				
			}
		});
		
		lv_paidBill.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intentUpdateAccount = new Intent(ManageBillReminder.this, BillDetail.class);
				startActivityForResult(intentUpdateAccount,Publics.REQ_VIEW_ACCOUNT);			
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Add");
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId()==0) //add
		{
			Intent intent = new Intent(this,NewBillReminder.class);
			startActivityForResult(intent, 1);
		}
		return super.onOptionsItemSelected(item);
	}
}