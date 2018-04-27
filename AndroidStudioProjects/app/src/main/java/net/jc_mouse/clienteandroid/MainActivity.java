package net.jc_mouse.clienteandroid;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    /**
     * Controles
     * */
    private Button button;
    private EditText editText2;
    private TextView text;
    private Context context = this;
    private String disparo;
    private String seMovio;


    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    /**
     * Puerto
     * */
    private static final int SERVERPORT = 21857;
    /**
     * HOST
     * */
    private static final String ADDRESS = "172.18.209.113";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.TextView);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sensor == null)
            finish();



        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float y = sensorEvent.values[1];
                if ( y > 2){
                    seMovio = "derecha";
                }
                else if (y < -2){
                    seMovio = "izquierda";
                }
                else{
                    seMovio = "centro";
                }
                MyATaskCliente myATaskYW = new MyATaskCliente();
                myATaskYW.execute();
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        star();
        button = ((Button) findViewById(R.id.button));
        editText2 = (EditText) findViewById(R.id.editText2);
        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        disparo = "true";
                    }
                });

    }//end:onCreate


    public void star(){
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_GAME);
    }
    public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        star();
        super.onResume();
    }





    /**
     * Clase para interactuar con el servidor
     * */
    class MyATaskCliente extends AsyncTask<String,Void,String>{

        /**
         * Ventana que bloqueara la pantalla del movil hasta recibir respuesta del servidor
         * */
        ProgressDialog  progressDialog;

        /**
         * muestra una ventana emergente
         * */
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            progressDialog = new ProgressDialog(context);
            progressDialog.setCanceledOnTouchOutside(false);
           // progressDialog.setTitle("Connecting to server");
           //progressDialog.show();
        }


        @Override
        protected String doInBackground(String... values){

            try {
                //Se conecta al servidor
                InetAddress serverAddr = InetAddress.getByName(ADDRESS);
                Log.i("I/TCP Client", "Connecting...");
                Socket socket = new Socket(serverAddr, SERVERPORT);
                Log.i("I/TCP Client", "Connected to server");

                //envia peticion de cliente
                Log.i("I/TCP Client", "Send data to server");
                PrintStream output = new PrintStream(socket.getOutputStream());
                output.println(seMovio);
                output.println(disparo);
                disparo = "false";


                //recibe respuesta del servidor y formatea a String
                Log.i("I/TCP Client", "Received data to server");
                InputStream stream = socket.getInputStream();
                byte[] lenBytes = new byte[1024];
                stream.read(lenBytes,0,1024);
                String received = new String(lenBytes,"UTF-8").trim();
                Log.i("I/TCP Client", "Received " + received);
                Log.i("I/TCP Client", "");
                //cierra conexion
                socket.close();
                return received;

            }catch (UnknownHostException ex) {
                Log.e("E/TCP Client", "" + ex.getMessage());
                return ex.getMessage();
            } catch (IOException ex) {
                Log.e("E/TCP Client", "" + ex.getMessage());
                return ex.getMessage();
            }
        }

        /**
         * Oculta ventana emergente y muestra resultado en pantalla
         * */
        @Override
        protected void onPostExecute(String value){
            progressDialog.dismiss();
            text.setText(value);
        }
    }
}