package dev.hci.messageapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String PHONE = "0947009497";

    private final String SENT = "SMS_SENT";
    private final String DELIVERED = "SMS_DELIVERED";
    private final String FAILURE = "GENERIC_ERROR";
    private final String NO_SERVICE = "NO_SERVICE";
    private final String NULL_PDU = "NULL_PDU";
    private final String RADIO_OFF = "RADIO_OFF";
    private final String NOT_DELIVERED = "SMS_NOT_DELIVERED";
    private final String SNS_RECEIVED = "SNS_RECEIVED_ACTION";
    private PendingIntent sentPI;
    private PendingIntent deliveredPI;
    private BroadcastReceiver smsSentReceiver;
    private BroadcastReceiver smsDeliveredReceiver;
    private IntentFilter intentFilter;
    private boolean registerIntentReceiver;
    private boolean registerSentReceiver;
    private boolean registerDeliveredReceiver;
    public static int status;
    private SmsManager smsManager;

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView txtSMSMessage = findViewById(R.id.txtSMSMessage);
            txtSMSMessage.setText(intent.getExtras().getString("sms"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},1);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.INTERNET}, 1);

        status = 2;
        if (status == 2) {
            setupIntent();
            registeringIntentReceiver();
        }
    }

    private void registeringSentReceiver() {
        registerReceiver(smsSentReceiver, new IntentFilter(SENT));
        registerSentReceiver = true;
    }

    private void registeringDeliveredReceiver() {
        registerReceiver(smsDeliveredReceiver, new IntentFilter(DELIVERED));
        registerDeliveredReceiver = true;
    }

    private void registeringIntentReceiver() {
        registerReceiver(intentReceiver, intentFilter);
        registerIntentReceiver = true;
    }

    private void setupIntent() {
        sentPI = PendingIntent.getBroadcast(MainActivity.this, 0, new Intent(SENT), 0);
        deliveredPI = PendingIntent.getBroadcast(MainActivity.this, 0, new Intent(DELIVERED), 0);
        intentFilter = new IntentFilter();
        intentFilter.addAction(SNS_RECEIVED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (status == 2) {
            Log.d("onResume", "onResume");
            smsSentReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    switch (getResultCode()) {
                        case RESULT_OK:
                            Toast.makeText(getBaseContext(), SENT, Toast.LENGTH_SHORT).show();
                            Log.d("Receiver: ", SENT);
                            break;
                        case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                            Toast.makeText(getBaseContext(), FAILURE, Toast.LENGTH_SHORT).show();
                            Log.d("Receiver: ", FAILURE);
                            break;
                        case SmsManager.RESULT_ERROR_NO_SERVICE:
                            Toast.makeText(getBaseContext(), NO_SERVICE, Toast.LENGTH_SHORT).show();
                            Log.d("Receiver: ", NO_SERVICE);
                            break;
                        case SmsManager.RESULT_ERROR_NULL_PDU:
                            Toast.makeText(getBaseContext(), NULL_PDU, Toast.LENGTH_SHORT).show();
                            Log.d("Receiver: ", NULL_PDU);
                            break;
                        case SmsManager.RESULT_ERROR_RADIO_OFF:
                            Toast.makeText(getBaseContext(), RADIO_OFF, Toast.LENGTH_SHORT).show();
                            Log.d("Receiver: ", RADIO_OFF);
                            break;
                    }
                }
            };
            smsDeliveredReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    switch (getResultCode()) {
                        case RESULT_OK:
                            Toast.makeText(getBaseContext(), DELIVERED, Toast.LENGTH_SHORT).show();
                            Log.d("Receiver: ", DELIVERED);
                            break;
                        case SmsManager.RESULT_CANCELLED:
                            Toast.makeText(getBaseContext(), NOT_DELIVERED, Toast.LENGTH_SHORT).show();
                            Log.d("Receiver: ", NOT_DELIVERED);
                            break;
                    }
                }
            };
            registeringSentReceiver();
            registeringDeliveredReceiver();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (status != 0) {
            Log.d("onPause", "onPause");
            if (intentReceiver != null && registerIntentReceiver) {
                unregisterReceiver(intentReceiver);
                registerIntentReceiver = false;
            }

            if (smsSentReceiver != null && registerSentReceiver) {
                unregisterReceiver(smsSentReceiver);
                registerSentReceiver = false;
            }
            if (smsDeliveredReceiver != null && registerDeliveredReceiver) {
                unregisterReceiver(smsDeliveredReceiver);
                registerDeliveredReceiver = false;
            }
            status = 0;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "onDestroy");
        if (intentReceiver != null && registerIntentReceiver) {
            unregisterReceiver(intentReceiver);
            registerIntentReceiver = false;
        }

        if (smsSentReceiver != null && registerSentReceiver) {
            unregisterReceiver(smsSentReceiver);
            registerSentReceiver = false;
        }
        if (smsDeliveredReceiver != null && registerDeliveredReceiver) {
            unregisterReceiver(smsDeliveredReceiver);
            registerDeliveredReceiver = false;
        }
    }

    private void sendSMS(String phoneNumber, String message) {
        smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
    }

    public void onSendSMS(View view) {
        status = 0;
        sendSMS(PHONE, "Message Demo - Mobile Programming");
    }

    public void onSendSMSIntent(View view) {
        status = 0;

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("smsto:" + Uri.encode(PHONE)));

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:"));
        intent.putExtra("address", "0947009497");
        intent.putExtra("sms_body",
                "Intent Message Demo - Mobile Programming");
        startActivity(intent);
    }

    public void onSMSFeedBack(View view) {
        status = 1;
        smsManager = SmsManager.getDefault();

        setupIntent();
        registeringIntentReceiver();
        smsSentReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode()) {
                    case RESULT_OK:
                        Toast.makeText(getBaseContext(), SENT, Toast.LENGTH_SHORT).show();
                        Log.d("Receiver: ", SENT);
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), FAILURE, Toast.LENGTH_SHORT).show();
                        Log.d("Receiver: ", FAILURE);
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), NO_SERVICE, Toast.LENGTH_SHORT).show();
                        Log.d("Receiver: ", NO_SERVICE);
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), NULL_PDU, Toast.LENGTH_SHORT).show();
                        Log.d("Receiver: ", NULL_PDU);
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), RADIO_OFF, Toast.LENGTH_SHORT).show();
                        Log.d("Receiver: ", RADIO_OFF);
                        break;
                }
            }
        };
        smsDeliveredReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode()) {
                    case RESULT_OK:
                        Toast.makeText(getBaseContext(), DELIVERED, Toast.LENGTH_SHORT).show();
                        Log.d("Receiver: ", DELIVERED);
                        break;
                    case SmsManager.RESULT_CANCELLED:
                        Toast.makeText(getBaseContext(), NOT_DELIVERED, Toast.LENGTH_SHORT).show();
                        Log.d("Receiver: ", NOT_DELIVERED);
                        break;
                }
            }
        };
        registeringSentReceiver();
        registeringDeliveredReceiver();
        smsManager.sendTextMessage(PHONE, null,
                "Message with Feedback - PRM", sentPI, deliveredPI);

    }

    public void onSendEmail(View view) {
        String[] mail = {"laica97@gmail.com"};
        SendEmail(mail, mail, "Mail from Android", "Test Email");

    }

    private void SendEmail(String[] address, String[] cc, String subject, String message) {
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setData(Uri.parse("mailto:"));
        mailIntent.putExtra(Intent.EXTRA_EMAIL, address);
        mailIntent.putExtra(Intent.EXTRA_CC, cc);
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        mailIntent.putExtra(Intent.EXTRA_TEXT, message);
        mailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(mailIntent, "Email"));
    }

    public void onGoogleMap(View view) {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
}