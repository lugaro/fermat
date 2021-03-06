package com.bitdubai.sub_app.crypto_broker_identity.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bitdubai.fermat_android_api.layer.definition.wallet.AbstractFermatFragment;
import com.bitdubai.fermat_android_api.layer.definition.wallet.interfaces.ReferenceAppFermatSession;
import com.bitdubai.fermat_api.layer.all_definition.exceptions.InvalidParameterException;
import com.bitdubai.fermat_cbp_api.all_definition.enums.Frequency;
import com.bitdubai.fermat_cbp_api.layer.identity.crypto_broker.exceptions.CantGetCryptoBrokerIdentityException;
import com.bitdubai.fermat_cbp_api.layer.sub_app_module.crypto_broker_identity.interfaces.CryptoBrokerIdentityInformation;
import com.bitdubai.fermat_cbp_api.layer.sub_app_module.crypto_broker_identity.interfaces.CryptoBrokerIdentityModuleManager;
import com.bitdubai.fermat_pip_api.layer.network_service.subapp_resources.SubAppResourcesProviderManager;
import com.bitdubai.sub_app.crypto_broker_identity.R;
import com.bitdubai.sub_app.crypto_broker_identity.util.FragmentsCommons;

import java.util.ArrayList;
import java.util.List;


/**
 * FERMAT-ORG
 * Developed by Lozadaa on 04/04/16.
 * Updated by Jose Cardozo josejcb (josejcb89@gmail.com) on 16/06/16.
 */

public class GeolocationBrokerIdentityFragment
        extends AbstractFermatFragment<ReferenceAppFermatSession<CryptoBrokerIdentityModuleManager>, SubAppResourcesProviderManager> {

    EditText accuracy;
    Spinner frequency;
    Toolbar toolbar;
    int accuracyData;
    Frequency frequencyData;


    public static GeolocationBrokerIdentityFragment newInstance() {
        return new GeolocationBrokerIdentityFragment();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = getToolbar();
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_left));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootLayout = inflater.inflate(R.layout.fragment_cbp_identity_geolocation, container, false);
        initViews(rootLayout);
        return rootLayout;
    }


    private void initViews(View layout) {
        // Spinner Drop down elements
        List<Frequency> dataSpinner = new ArrayList<>();
        dataSpinner.add(Frequency.LOW);
        dataSpinner.add(Frequency.NORMAL);
        dataSpinner.add(Frequency.HIGH);

        // Spinner element
        accuracy = (EditText) layout.findViewById(R.id.accuracy);
        frequency = (Spinner) layout.findViewById(R.id.spinner_frequency);
        frequency.setBackgroundColor(Color.parseColor("#f9f9f9"));

        try {
            ArrayAdapter<Frequency> dataAdapter = new ArrayAdapter<>(getActivity(), R.layout.cbp_iden_spinner_item, dataSpinner);
            dataAdapter.setDropDownViewResource(R.layout.cbp_iden_spinner_item);
            frequency.setAdapter(dataAdapter);

            setValues(frequency, accuracy, dataAdapter);

            frequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    try {
                        frequencyData = Frequency.getByCode(parent.getItemAtPosition(position).toString());
                        ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#616161"));
                        (parent.getChildAt(0)).setBackgroundColor(Color.parseColor("#F9f9f9"));
                    } catch (InvalidParameterException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } catch (CantGetCryptoBrokerIdentityException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        saveIdentityGeolocation();
    }

    private void saveIdentityGeolocation() {
        if (accuracy.getText().length() == 0) {
            Toast.makeText(getActivity(), "Accuracy is empty, please add a value", Toast.LENGTH_SHORT).show();
        } else {
            accuracyData = Integer.parseInt(accuracy.getText().toString());

            appSession.setData(FragmentsCommons.FREQUENCY_DATA, frequencyData);
            appSession.setData(FragmentsCommons.ACCURACY_DATA, accuracyData);
        }
    }

    private void setValues(Spinner frequency, EditText accuracy, ArrayAdapter<Frequency> dataAdapter) throws CantGetCryptoBrokerIdentityException {
        final CryptoBrokerIdentityInformation identityInfo = (CryptoBrokerIdentityInformation) appSession.getData(FragmentsCommons.IDENTITY_INFO);

        if (identityInfo != null) {
            final String accuracyString = Long.toString(identityInfo.getAccuracy());
            accuracy.setText(accuracyString);

            if (!(identityInfo.getFrequency() == null)) {
                int spinnerPosition = dataAdapter.getPosition(identityInfo.getFrequency());
                frequency.setSelection(spinnerPosition);
            }
        } else {
            accuracy.setText("0");
            frequency.setSelection(0);
        }
    }
}