package com.karma.politic;

import com.karma.politic.fragment.MlaFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CandidateSelection extends Activity {

	Spinner stateSpinner;
	Spinner districtSpinner;
	Spinner consitituencySpinner;

	Button btnProceed;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.candidateslection);
		stateSpinner = (Spinner) findViewById(R.id.spinnerState);
		consitituencySpinner = (Spinner) findViewById(R.id.spinnerConstituency);
		districtSpinner = (Spinner) findViewById(R.id.spinnerDistrict);

		ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(CandidateSelection.this, R.layout.sample,
				getResources().getStringArray(R.array.SpinnerState));
		stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		stateSpinner.setAdapter(stateAdapter);

		ArrayAdapter<String> distAdapter = new ArrayAdapter<String>(CandidateSelection.this, R.layout.sample,
				getResources().getStringArray(R.array.SpinnerMahareshtraDistrict));
		distAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		districtSpinner.setAdapter(distAdapter);

		ArrayAdapter<String> conAdapter = new ArrayAdapter<String>(CandidateSelection.this, R.layout.sample,
				getResources().getStringArray(R.array.Constituency));
		conAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		consitituencySpinner.setAdapter(conAdapter);

		setListner();

	}

	private void setListner() {

		stateSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String[] state = getResources().getStringArray(R.array.SpinnerState);
				if (state[position].equals("Maharashtra")) {

					ArrayAdapter<String> distAdapter = new ArrayAdapter<String>(CandidateSelection.this,
							android.R.layout.simple_spinner_item,
							getResources().getStringArray(R.array.SpinnerMahareshtraDistrict));

					distAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					districtSpinner.setAdapter(distAdapter);

					return;
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

		districtSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String district[] = getResources().getStringArray(R.array.SpinnerMahareshtraDistrict);

				if (district[position].equals("Mumbai")) {
					ArrayAdapter<String> conAdapter = new ArrayAdapter<String>(CandidateSelection.this,
							android.R.layout.simple_spinner_item,
							getResources().getStringArray(R.array.SpinnerMumbaiContituency));
					conAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					consitituencySpinner.setAdapter(conAdapter);

					return;

				}

				if (district[position].equals("Kolhapur")) {
					ArrayAdapter<String> conAdapter = new ArrayAdapter<String>(CandidateSelection.this,
							android.R.layout.simple_spinner_item,
							getResources().getStringArray(R.array.SpinnerKolhapurContituency));

					conAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					consitituencySpinner.setAdapter(conAdapter);

					return;

				}

				if (district[position].equals("Pune")) {
					ArrayAdapter<String> talukaAdapter = new ArrayAdapter<String>(CandidateSelection.this,
							android.R.layout.simple_spinner_item,
							getResources().getStringArray(R.array.SpinnerPuneContituency));
					talukaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					consitituencySpinner.setAdapter(talukaAdapter);

					return;

				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void proceedButton(View v) {

		// stateSpinner;
		// districtSpinner;
		// consitituencySpinner;
		startActivity(new Intent(this, TabMainActivity.class));
	}
}
