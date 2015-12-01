package com.jung;

import com.bank.AccountUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class BankingProjectActivity extends Activity implements View.OnClickListener{
	
	AccountUtil au = new AccountUtil();
	EditText edName;
	EditText edDeposit;
	EditText edWithdraw;
	Button deposit;
	Button withdraw;
	Button create;
	Button confirm;
	TextView txtConfirm;
	TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        edName = (EditText)findViewById(R.id.edName);
        result = (TextView)findViewById(R.id.result);
        
        create = (Button)findViewById(R.id.create);
        create.setOnClickListener(this);
        
        confirm = (Button)findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
        
        edDeposit = (EditText)findViewById(R.id.edDeposit);
        
        deposit = (Button)findViewById(R.id.deposit);
        deposit.setOnClickListener(this);
        
        edWithdraw = (EditText)findViewById(R.id.edWithdraw);
        
        withdraw = (Button)findViewById(R.id.withdraw);
        withdraw.setOnClickListener(this);
        
        txtConfirm = (TextView)findViewById(R.id.txtConfirm); 
                
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.banking_project, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String name = edName.getText().toString();
		if (v.getId() == R.id.create){
			int success = au.newAccount(name);
			if (success == 1){
				result.setText("New account successfully created: " + au.getNames());
				edDeposit.setText("");
				edWithdraw.setText("");
				txtConfirm.setText("");
			} else {
				result.setText("Account has not been created");
			}
		} else if (v.getId() == R.id.deposit){
			int amount = Integer.parseInt(edDeposit.getText().toString());
			au.deposit(name, amount);
			int jangum = au.confirm(name);
			txtConfirm.setText(jangum+"");
		} else if (v.getId() == R.id.withdraw){
			int amount = Integer.parseInt(edWithdraw.getText().toString());
			int enough = au.withdraw(name, amount);
			au.withdraw(name, amount);
			if (enough == -1){
				txtConfirm.setText("Not enough money");
			} else{
			int jangum = au.confirm(name);
			txtConfirm.setText(jangum+"");}
		} else if (v.getId() == R.id.confirm){
			int jangum = au.confirm(name);
			
			edDeposit.setText("");
			edWithdraw.setText("");
			
			txtConfirm.setText(jangum + "");
		}
		
	}
}
