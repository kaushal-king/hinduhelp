package com.hindu.hinduhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hindu.hinduhelp.apiinterface.Api;
import com.hindu.hinduhelp.apiinterface.ApiClient;
import com.hindu.hinduhelp.apiinterface.CommanResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {
    EditText fn,ln,mn,ma,add,pin;
    Spinner st,dist;
    ProgressBar r;
    Button b;
    ArrayAdapter<String> adapter;


    String[] AndhraPradesh = new String[] {
            "Adilabad",
            "Anantapur",
            "Chittoor",
            "Kakinada",
            "Guntur",
            "Hyderabad",
            "Karimnagar",
            "Khammam",
            "Krishna",
            "Kurnool",
            "Mahbubnagar",
            "Medak",
            "Nalgonda",
            "Nizamabad",
            "Ongole",
            "Hyderabad",
            "Srikakulam",
            "Nellore",
            "Visakhapatnam",
            "Vizianagaram",
            "Warangal",
            "Eluru",
            "Kadapa"
    };
    String[] ArunachalPradesh = new String[] {
            "Anjaw",
            "Changlang",
            "East Siang",
            "Kurung Kumey",
            "Lohit",
            "Lower Dibang Valley",
            "Lower Subansiri",
            "Papum Pare",
            "Tawang",
            "Tirap",
            "Dibang Valley",
            "Upper Siang",
            "Upper Subansiri",
            "West Kameng",
            "West Siang"
    };

    String[] Assam = new String[] {
            "Baksa",
            "Barpeta",
            "Bongaigaon",
            "Cachar",
            "Chirang",
            "Darrang",
            "Dhemaji",
            "Dima Hasao",
            "Dhubri",
            "Dibrugarh",
            "Goalpara",
            "Golaghat",
            "Hailakandi",
            "Jorhat",
            "Kamrup",
            "Kamrup Metropolitan",
            "Karbi Anglong",
            "Karimganj",
            "Kokrajhar",
            "Lakhimpur",
            "Marigaon",
            "Nagaon",
            "Nalbari",
            "Sibsagar",
            "Sonitpur",
            "Tinsukia",
            "Udalguri"
    };
    String[] Bihar = new String[] {
            "Araria",
            "Arwal",
            "Aurangabad",
            "Banka",
            "Begusarai",
            "Bhagalpur",
            "Bhojpur",
            "Buxar",
            "Darbhanga",
            "East Champaran",
            "Gaya",
            "Gopalganj",
            "Jamui",
            "Jehanabad",
            "Kaimur",
            "Katihar",
            "Khagaria",
            "Kishanganj",
            "Lakhisarai",
            "Madhepura",
            "Madhubani",
            "Munger",
            "Muzaffarpur",
            "Nalanda",
            "Nawada",
            "Patna",
            "Purnia",
            "Rohtas",
            "Saharsa",
            "Samastipur",
            "Saran",
            "Sheikhpura",
            "Sheohar",
            "Sitamarhi",
            "Siwan",
            "Supaul",
            "Vaishali",
            "West Champaran",
            "Chandigarh",
    };
    String[] Chhattisgarh = new String[] {
            "Bastar",
            "Bijapur",
            "Bilaspur",
            "Dantewada",
            "Dhamtari",
            "Durg",
            "Jashpur",
            "Janjgir-Champa",
            "Korba",
            "Koriya",
            "Kanker",
            "Kabirdham (Kawardha)",
            "Mahasamund",
            "Narayanpur",
            "Raigarh",
            "Rajnandgaon",
            "Raipur",
            "Surguja"
    };
    String[] DadraandNagarHaveli = new String[] {
            "Dadra and Nagar Haveli"
    };
    String[] DamanandDiu = new String[] {
            "Daman",
            "Diu"
    };
    String[] Delhi = new String[] {
            "Central Delhi",
            "East Delhi",
            "New Delhi",
            "North Delhi",
            "North East Delhi",
            "North West Delhi",
            "South Delhi",
            "South West Delhi",
            "West Delhi"
    };
    String[] Goa = new String[] {
            "North Goa",
            "South Goa"
    };
    String[] Gujarat = new String[] {
            "Ahmedabad",
            "Amreli district",
            "Anand",
            "Banaskantha",
            "Bharuch",
            "Bhavnagar",
            "Dahod",
            "The Dangs",
            "Gandhinagar",
            "Jamnagar",
            "Junagadh",
            "Kutch",
            "Kheda",
            "Mehsana",
            "Narmada",
            "Navsari",
            "Patan",
            "Panchmahal",
            "Porbandar",
            "Rajkot",
            "Sabarkantha",
            "Surendranagar",
            "Surat",
            "Vyara",
            "Vadodara",
            "Valsad"
    };
    String[] Haryana = new String[] {
            "Ambala",
            "Bhiwani",
            "Faridabad",
            "Fatehabad",
            "Gurgaon",
            "Hissar",
            "Jhajjar",
            "Jind",
            "Karnal",
            "Kaithal",
            "Kurukshetra",
            "Mahendragarh",
            "Mewat",
            "Palwal",
            "Panchkula",
            "Panipat",
            "Rewari",
            "Rohtak",
            "Sirsa",
            "Sonipat",
            "Yamuna Nagar"
    };
    String[] HimachalPradesh = new String[] {
            "Bilaspur",
            "Chamba",
            "Hamirpur",
            "Kangra",
            "Kinnaur",
            "Kullu",
            "Lahaul and Spiti",
            "Mandi",
            "Shimla",
            "Sirmaur",
            "Solan",
            "Una"
    };
    String[] JammuandKashmir = new String[] {
            "Anantnag",
            "Badgam",
            "Bandipora",
            "Baramulla",
            "Doda",
            "Ganderbal",
            "Jammu",
            "Kargil",
            "Kathua",
            "Kishtwar",
            "Kupwara",
            "Kulgam",
            "Leh",
            "Poonch",
            "Pulwama",
            "Rajauri",
            "Ramban",
            "Reasi",
            "Samba",
            "Shopian",
            "Srinagar",
            "Udhampur"
    };
    String[] Jharkhand = new String[] {
            "Bokaro",
            "Chatra",
            "Deoghar",
            "Dhanbad",
            "Dumka",
            "East Singhbhum",
            "Garhwa",
            "Giridih",
            "Godda",
            "Gumla",
            "Hazaribag",
            "Jamtara",
            "Khunti",
            "Koderma",
            "Latehar",
            "Lohardaga",
            "Pakur",
            "Palamu",
            "Ramgarh",
            "Ranchi",
            "Sahibganj",
            "Seraikela Kharsawan",
            "Simdega",
            "West Singhbhum"
    };
    String[] Karnataka = new String[] {
            "Bagalkot",
            "Bangalore Rural",
            "Bangalore Urban",
            "Belgaum",
            "Bellary",
            "Bidar",
            "Bijapur",
            "Chamarajnagar",
            "Chikkamagaluru",
            "Chikkaballapur",
            "Chitradurga",
            "Davanagere",
            "Dharwad",
            "Dakshina Kannada",
            "Gadag",
            "Gulbarga",
            "Hassan",
            "Haveri district",
            "Kodagu",
            "Kolar",
            "Koppal",
            "Mandya",
            "Mysore",
            "Raichur",
            "Shimoga",
            "Tumkur",
            "Udupi",
            "Uttara Kannada",
            "Ramanagara",
            "Yadgir"
    };
    String[] Kerala = new String[] {
            "Alappuzha",
            "Ernakulam",
            "Idukki",
            "Kannur",
            "Kasaragod",
            "Kollam",
            "Kottayam",
            "Kozhikode",
            "Malappuram",
            "Palakkad",
            "Pathanamthitta",
            "Thrissur",
            "Thiruvananthapuram",
            "Wayanad"
    };
    String[] MadhyaPradesh = new String[] {
            "Alirajpur",
            "Anuppur",
            "Ashok Nagar",
            "Balaghat",
            "Barwani",
            "Betul",
            "Bhind",
            "Bhopal",
            "Burhanpur",
            "Chhatarpur",
            "Chhindwara",
            "Damoh",
            "Datia",
            "Dewas",
            "Dhar",
            "Dindori",
            "Guna",
            "Gwalior",
            "Harda",
            "Hoshangabad",
            "Indore",
            "Jabalpur",
            "Jhabua",
            "Katni",
            "Khandwa (East Nimar)",
            "Khargone (West Nimar)",
            "Mandla",
            "Mandsaur",
            "Morena",
            "Narsinghpur",
            "Neemuch",
            "Panna",
            "Rewa",
            "Rajgarh",
            "Ratlam",
            "Raisen",
            "Sagar",
            "Satna",
            "Sehore",
            "Seoni",
            "Shahdol",
            "Shajapur",
            "Sheopur",
            "Shivpuri",
            "Sidhi",
            "Singrauli",
            "Tikamgarh",
            "Ujjain",
            "Umaria",
            "Vidisha"
    };
    String[] Maharashtra = new String[] {
            "Ahmednagar",
            "Akola",
            "Amravati",
            "Aurangabad",
            "Bhandara",
            "Beed",
            "Buldhana",
            "Chandrapur",
            "Dhule",
            "Gadchiroli",
            "Gondia",
            "Hingoli",
            "Jalgaon",
            "Jalna",
            "Kolhapur",
            "Latur",
            "Mumbai City",
            "Mumbai suburban",
            "Nandurbar",
            "Nanded",
            "Nagpur",
            "Nashik",
            "Osmanabad",
            "Parbhani",
            "Pune",
            "Raigad",
            "Ratnagiri",
            "Sindhudurg",
            "Sangli",
            "Solapur",
            "Satara",
            "Thane",
            "Wardha",
            "Washim",
            "Yavatmal"
    };
    String[] Manipur = new String[] {
            "Bishnupur",
            "Churachandpur",
            "Chandel",
            "Imphal East",
            "Senapati",
            "Tamenglong",
            "Thoubal",
            "Ukhrul",
            "Imphal West"
    };
    String[] Meghalaya = new String[] {
            "East Garo Hills",
            "East Khasi Hills",
            "Jaintia Hills",
            "Ri Bhoi",
            "South Garo Hills",
            "West Garo Hills",
            "West Khasi Hills"
    };
    String[] Mizoram = new String[] {
            "Aizawl",
            "Champhai",
            "Kolasib",
            "Lawngtlai",
            "Lunglei",
            "Mamit",
            "Saiha",
            "Serchhip"
    };
    String[] Nagaland = new String[] {
            "Dimapur",
            "Kohima",
            "Mokokchung",
            "Mon",
            "Phek",
            "Tuensang",
            "Wokha",
            "Zunheboto"
    };
    String[] Orissa = new String[] {
            "Angul",
            "Boudh (Bauda)",
            "Bhadrak",
            "Balangir",
            "Bargarh (Baragarh)",
            "Balasore",
            "Cuttack",
            "Debagarh (Deogarh)",
            "Dhenkanal",
            "Ganjam",
            "Gajapati",
            "Jharsuguda",
            "Jajpur",
            "Jagatsinghpur",
            "Khordha",
            "Kendujhar (Keonjhar)",
            "Kalahandi",
            "Kandhamal",
            "Koraput",
            "Kendrapara",
            "Malkangiri",
            "Mayurbhanj",
            "Nabarangpur",
            "Nuapada",
            "Nayagarh",
            "Puri",
            "Rayagada",
            "Sambalpur",
            "Subarnapur (Sonepur)",
            "Sundergarh"
    };
    String[] Pondicherry = new String[] {
            "Karaikal",
            "Mahe",
            "Pondicherry",
            "Yanam"
    };
    String[] Punjab = new String[] {
            "Amritsar",
            "Barnala",
            "Bathinda",
            "Firozpur",
            "Faridkot",
            "Fatehgarh Sahib",
            "Fazilka",
            "Gurdaspur",
            "Hoshiarpur",
            "Jalandhar",
            "Kapurthala",
            "Ludhiana",
            "Mansa",
            "Moga",
            "Sri Muktsar Sahib",
            "Pathankot",
            "Patiala",
            "Rupnagar",
            "Ajitgarh (Mohali)",
            "Sangrur",
            "Nawanshahr",
            "Tarn Taran"
    };
    String[] Rajasthan = new String[] {
            "Ajmer",
            "Alwar",
            "Bikaner",
            "Barmer",
            "Banswara",
            "Bharatpur",
            "Baran",
            "Bundi",
            "Bhilwara",
            "Churu",
            "Chittorgarh",
            "Dausa",
            "Dholpur",
            "Dungapur",
            "Ganganagar",
            "Hanumangarh",
            "Jhunjhunu",
            "Jalore",
            "Jodhpur",
            "Jaipur",
            "Jaisalmer",
            "Jhalawar",
            "Karauli",
            "Kota",
            "Nagaur",
            "Pali",
            "Pratapgarh",
            "Rajsamand",
            "Sikar",
            "Sawai Madhopur",
            "Sirohi",
            "Tonk",
            "Udaipur"
    };
    String[] Sikkim = new String[] {
            "East Sikkim",
            "North Sikkim",
            "South Sikkim",
            "West Sikkim"
    };
    String[] TamilNadu = new String[] {
            "Ariyalur",
            "Chennai",
            "Coimbatore",
            "Cuddalore",
            "Dharmapuri",
            "Dindigul",
            "Erode",
            "Kanchipuram",
            "Kanyakumari",
            "Karur",
            "Madurai",
            "Nagapattinam",
            "Nilgiris",
            "Namakkal",
            "Perambalur",
            "Pudukkottai",
            "Ramanathapuram",
            "Salem",
            "Sivaganga",
            "Tirupur",
            "Tiruchirappalli",
            "Theni",
            "Tirunelveli",
            "Thanjavur",
            "Thoothukudi",
            "Tiruvallur",
            "Tiruvarur",
            "Tiruvannamalai",
            "Vellore",
            "Viluppuram",
            "Virudhunagar"
    };
    String[] Tripura = new String[] {
            "Dhalai",
            "North Tripura",
            "South Tripura",
            "Khowai",
            "West Tripura"
    };
    String[] UttarPradesh = new String[] {
            "Agra",
            "Allahabad",
            "Aligarh",
            "Ambedkar Nagar",
            "Auraiya",
            "Azamgarh",
            "Barabanki",
            "Budaun",
            "Bagpat",
            "Bahraich",
            "Bijnor",
            "Ballia",
            "Banda",
            "Balrampur",
            "Bareilly",
            "Basti",
            "Bulandshahr",
            "Chandauli",
            "Chhatrapati Shahuji Maharaj Nagar",
            "Chitrakoot",
            "Deoria",
            "Etah",
            "Kanshi Ram Nagar",
            "Etawah",
            "Firozabad",
            "Farrukhabad",
            "Fatehpur",
            "Faizabad",
            "Gautam Buddh Nagar",
            "Gonda",
            "Ghazipur",
            "Gorakhpur",
            "Ghaziabad",
            "Hamirpur",
            "Hardoi",
            "Mahamaya Nagar",
            "Jhansi",
            "Jalaun",
            "Jyotiba Phule Nagar",
            "Jaunpur district",
            "Ramabai Nagar (Kanpur Dehat)",
            "Kannauj",
            "Kanpur",
            "Kaushambi",
            "Kushinagar",
            "Lalitpur",
            "Lakhimpur Kheri",
            "Lucknow",
            "Mau",
            "Meerut",
            "Maharajganj",
            "Mahoba",
            "Mirzapur",
            "Moradabad",
            "Mainpuri",
            "Mathura",
            "Muzaffarnagar",
            "Panchsheel Nagar district (Hapur)",
            "Pilibhit",
            "Shamli",
            "Pratapgarh",
            "Rampur",
            "Raebareli",
            "Saharanpur",
            "Sitapur",
            "Shahjahanpur",
            "Sant Kabir Nagar",
            "Siddharthnagar",
            "Sonbhadra",
            "Sant Ravidas Nagar",
            "Sultanpur",
            "Shravasti",
            "Unnao",
            "Varanasi"
    };
    String[] Uttarakhand = new String[] {
            "Almora",
            "Bageshwar",
            "Chamoli",
            "Champawat",
            "Dehradun",
            "Haridwar",
            "Nainital",
            "Pauri Garhwal",
            "Pithoragarh",
            "Rudraprayag",
            "Tehri Garhwal",
            "Udham Singh Nagar",
            "Uttarkashi"
    };
    String[] WestBengal = new String[] {
            "Birbhum",
            "Bankura",
            "Bardhaman",
            "Darjeeling",
            "Dakshin Dinajpur",
            "Hooghly",
            "Howrah",
            "Jalpaiguri",
            "Cooch Behar",
            "Kolkata",
            "Maldah",
            "Paschim Medinipur",
            "Purba Medinipur",
            "Murshidabad",
            "Nadia",
            "North 24 Parganas",
            "South 24 Parganas",
            "Purulia",
            "Uttar Dinajpur"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fn=(EditText) findViewById(R.id.firstname);
        ln=(EditText) findViewById(R.id.lastname);
        mn=(EditText) findViewById(R.id.mobileno);
        ma=(EditText) findViewById(R.id.mail);
        add=(EditText) findViewById(R.id.address);
        pin=(EditText) findViewById(R.id.pincode);
        r=(ProgressBar) findViewById(R.id.regprog);
        b=(Button) findViewById(R.id.regbut);
r.setVisibility(View.INVISIBLE);

        st=(Spinner) findViewById(R.id.State);
        dist=(Spinner) findViewById(R.id.district);

        st.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String stateName = adapterView.getItemAtPosition(i).toString();

                setDistrict(stateName);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
    public void setDistrict(String str)
    {
        switch(str) {
            case "Andhra Pradesh" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , AndhraPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Arunachal Pradesh" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , ArunachalPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Assam" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Assam);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Bihar" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Bihar);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Chhattisgarh" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Chhattisgarh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Dadra and Nagar Haveli" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , DadraandNagarHaveli);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Daman and Diu" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , DamanandDiu);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Delhi" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Delhi);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Goa" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Goa);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Gujarat" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Gujarat);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Haryana" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Haryana);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Himachal Pradesh" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , HimachalPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Jammu and Kashmir" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , JammuandKashmir);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Jharkhand" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Jharkhand);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Karnataka" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Karnataka);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Kerala" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Kerala);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Madhya Pradesh" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , MadhyaPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Maharashtra" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Maharashtra);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Manipur" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Manipur);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Meghalaya" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Meghalaya);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Mizoram" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Mizoram);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Nagaland" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Nagaland);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Orissa" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Orissa);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Pondicherry" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Pondicherry);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Punjab" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Punjab);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Rajasthan" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Rajasthan);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Sikkim" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Sikkim);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Tamil Nadu" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , TamilNadu);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Tripura" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Tripura);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Uttar Pradesh" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , UttarPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "Uttarakhand" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , Uttarakhand);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional
            case "West Bengal" :
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , WestBengal);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dist.setAdapter(adapter);
                break; // optional



            default :
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }


    }

    public void pass(View view) {
        boolean v=true;
        String fname=fn.getText().toString();
        String lname=ln.getText().toString();
        String mobno=mn.getText().toString();
        String email=ma.getText().toString();
        String addr=add.getText().toString();
        String pincode=pin.getText().toString();

        String state=st.getSelectedItem().toString();
        String diste=dist.getSelectedItem().toString();


        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String MobilePattern = "[0-9]{10}";

        v=true;



        if (fname.isEmpty()){
            fn.setError("Enter Firstname");
            v=false;
        }
        if (lname.isEmpty()){
            ln.setError("Enter Lastname");
            v=false;
        }

        if (mobno.isEmpty() || !mobno.matches(MobilePattern)){

            mn.setError("Enter Mobile Number");
            v=false;
        }


        if (addr.isEmpty()){
            add.setError("Enter address");
            v=false;
        }


        if (pincode.isEmpty()){
            pin.setError("Enter pincode");
            v=false;
        }

        if (v == true) {

            r.setVisibility(View.VISIBLE);
            b.setVisibility(View.INVISIBLE);
            Api api= ApiClient.getClient().create(Api.class);

            Call<CommanResponse> call =api.createUser("loginregistration",fname,lname,
                    mobno,email,addr,pincode,state,diste);
            call.enqueue(new Callback<CommanResponse>() {
                @Override
                public void onResponse(Call<CommanResponse> call, Response<CommanResponse> response) {
                    if (response.body().getSuccess()==200) {



                        Toast.makeText(Registration.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), Loginactivity.class);
                        startActivity(i);



                    }
                    else
                    {
                        Toast.makeText(Registration.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                        b.setVisibility(View.VISIBLE);
                        r.setVisibility(View.INVISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<CommanResponse> call, Throwable t) {
                    Toast.makeText(Registration.this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
                    b.setVisibility(View.VISIBLE);
                    r.setVisibility(View.INVISIBLE);
                }
            });

        }


    }

    public void sigin(View view) {
        super.onBackPressed();
        finish();
    }

    public void loginback(View view) {
        super.onBackPressed();
        finish();
    }
}
