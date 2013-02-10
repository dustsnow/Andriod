package gitmad.app.WhereUAt;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ResultActivity extends Activity implements OnClickListener {
	private String result = "not set";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		Log.d("Demo", "Atlanta, GA : the location");
		TextView resultView = (TextView) this.findViewById(R.id.result_value_label);
		resultView.setText("Atlanta, GA");

		View returnButton = findViewById(R.id.back_to_menu_button);
		returnButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View arg0) {
		this.finish();		
	}

}
