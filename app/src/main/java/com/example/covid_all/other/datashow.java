package com.example.covid_all.other;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_all.R;

public class datashow extends AppCompatActivity {
    String data="!!! તમારે રસી શા માટે લેવી જોઇએ\n" +
            "#COVID-19 રસી મૂકાવવાથીઃ\n" +
            "\n" +
            "->તમારુ COVID-19થી બીમાર થવાનું જોખમ ઘટાડે છે\n" +
            "->જો તમને COVID-19નો ચેપ લાગે તો તમને અત્યંત બીમાર થવા સામે રક્ષણ આપે છે\n" +
            "->તમારા મિત્રો, પરિવાર અને સમુદાયનું રક્ષણ કરવામાં મદદ કરે છે.\n" +
            "->જો મોટાભાગના લોકોનું રસીકરણ થયેલું હોય તો, વાયરસ સરળતાથી ફેલાઇ શકશે નહિં, આનાથી જે લોકો રસી મૂકાવવાને સક્ષમ નથી તેઓનું પણ રક્ષણ થાય છે.\n" +
            "\n" +
            "\n" +
            "#રસીની સલામતી\n" +
            "->તમને પ્રશિક્ષિત આરોગ્ય સંભાળ કર્મચારી દ્વારા રસી આપવામાં આવશે.\n" +
            "->તમામ રસીઓની જેમ, કેટલાક લોકો COVID-19 રસી લીધા પછી હળવી આડઅસરો અનુભવ કરી શકે છે. આમાં નીચેનાનો સમાવેશ થાય છેઃ\n" +
            "->જ્યાં તમે ઈંજેક્શન લીધું છે ત્યાં દુખાવો\n" +
            "->તાવ\n" +
            "->સ્નાયુમાં દુખાવો\n" +
            "->જો તમને રસી વિષે કોઈપણ ચિંતા હોય, તો તમારે તમારા દાક્તર અથવા જી.પી. જોડે વાત કરવી જોઇએ.";
    String data1="!!! તમારે શું યાદ રાખવું જોઇએ\n" +
            "\n" +
            "->તમારા હાથ નિયમિત રીતે ધોતાં રહો. સાબુ અને પાણીનો ઉપયોગ કરો અથવા હેન્ડસેનિટાઇઝરનો ઉપયોગ કરો. આ આપણને કોરોનાવાયરસથી (COVID-19) સુરક્ષિત રહેવામાં મદદ કરે છે, જે ઘણા દિવસો સુધી સપાટીઓ પર રહી શકે છે.\n" +
            "->અન્ય લોકોથી 1.5 મીટરનું અંતર રાખો.\n" +
            "->જ્યારે તમે ઘરની બહાર જાઓ ત્યારે તમારે ચહેરાનો માસ્ક પહેરવો જ જોઇએ. આમાં મકાનની અંદરનો અને બહારનો સમાવેશ થાય છે. આ કરવાથી COVID-19 ફેલાવવાનું જોખમ ઓછું થાય છે.\n" +
            "->તમે તમારા ઘરે મુલાકાતીઓ આવવા દઈ શકો નહિં અથવા તમે બીજાની મુલાકાતે જઈ શકો નહિં.જીવનસાથી ઘરે તમારી મુલાકાત લેવા આવી શકે છે.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datashow);



    }

    public void aarogya(View view) {
        Intent intent=new Intent(datashow.this,gujratitext.class);
        intent.putExtra("gujudata",data1);
        Log.e("tag","llalala");
        startActivity(intent);
    }

    public void rashi(View view) {
        Intent intent=new Intent(datashow.this,gujratitext.class);
        intent.putExtra("gujudata",data);
        Log.e("tag","llalala");
        startActivity(intent);
    }
}