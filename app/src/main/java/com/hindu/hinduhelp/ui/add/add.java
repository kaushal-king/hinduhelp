package com.hindu.hinduhelp.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.hindu.hinduhelp.R;
import com.hindu.hinduhelp.apiinterface.Api;
import com.hindu.hinduhelp.apiinterface.ApiClient;
import com.hindu.hinduhelp.apiinterface.CommanResponse;
import com.hindu.hinduhelp.apiinterface.get_set.User;
import com.hindu.hinduhelp.storage.sareprefrencelogin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class add extends Fragment {
    EditText name,add,phn,email,pincode,disc;
    Spinner st,n,ty,ti,sub;
    Button val;
    User user;
    ProgressBar pr;
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
            "Kadapa","other"

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
            "West Siang","other"
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
            "Udalguri","other"
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
            "Chandigarh","other"
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
            "Surguja","other"
    };
    String[] DadraandNagarHaveli = new String[] {
            "Dadra and Nagar Haveli","other"
    };
    String[] DamanandDiu = new String[] {
            "Daman",
            "Diu","other"
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
            "West Delhi","other"
    };
    String[] Goa = new String[] {
            "North Goa",
            "South Goa","other"
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
            "Valsad","other"
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
            "Yamuna Nagar","other"
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
            "Una","other"
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
            "Udhampur","other"
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
            "West Singhbhum","other"
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
            "Yadgir","other"
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
            "Wayanad","other"
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
            "Vidisha","other"
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
            "Yavatmal","other"
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
            "Imphal West","other"
    };
    String[] Meghalaya = new String[] {
            "East Garo Hills",
            "East Khasi Hills",
            "Jaintia Hills",
            "Ri Bhoi",
            "South Garo Hills",
            "West Garo Hills",
            "West Khasi Hills","other"
    };
    String[] Mizoram = new String[] {
            "Aizawl",
            "Champhai",
            "Kolasib",
            "Lawngtlai",
            "Lunglei",
            "Mamit",
            "Saiha",
            "Serchhip","other"
    };
    String[] Nagaland = new String[] {
            "Dimapur",
            "Kohima",
            "Mokokchung",
            "Mon",
            "Phek",
            "Tuensang",
            "Wokha",
            "Zunheboto","other"
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
            "Sundergarh","other"
    };
    String[] Pondicherry = new String[] {
            "Karaikal",
            "Mahe",
            "Pondicherry",
            "Yanam","other"
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
            "Tarn Taran","other"
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
            "Udaipur","other"
    };
    String[] Sikkim = new String[] {
            "East Sikkim",
            "North Sikkim",
            "South Sikkim",
            "West Sikkim","other"
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
            "Virudhunagar","other"
    };
    String[] Tripura = new String[] {
            "Dhalai",
            "North Tripura",
            "South Tripura",
            "Khowai",
            "West Tripura","other"
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
            "Varanasi","other"
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
            "Uttarkashi","other"
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
            "Uttar Dinajpur","other"
    };



    String[] Medical = new String[] {
            "Doctor", "Hospital", "Blood"
    };
    String[] Travel = new String[] {
            "Train","Bus","Car"
    };

    String[] Accomodation = new String[] {
            "Dharamshala"
    };

    String[] Dharmic = new String[] {
            "Dharmik Book", "Yagya Havan", "Pooja", "Pandit", "Others"
    };

    String[] Legal = new String[] {
            "Legal"
    };

    String[] Government = new String[] {
            "Government"
    };

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add, container, false);
        name=(EditText) root.findViewById(R.id.addname);
        add=(EditText) root.findViewById(R.id.addaddress);
        phn=(EditText) root.findViewById(R.id.addno);
        email=(EditText) root.findViewById(R.id.addemail);
        pincode=(EditText) root.findViewById(R.id.addpincode);
        disc=(EditText) root.findViewById(R.id.adddisc);
        pr=(ProgressBar) root.findViewById(R.id.addprog);

        st=(Spinner) root.findViewById(R.id.add_State);
        n=(Spinner) root.findViewById(R.id.add_district);
        ty=(Spinner) root.findViewById(R.id.add_type);
        ti=(Spinner) root.findViewById(R.id.add_time);
        sub=(Spinner) root.findViewById(R.id.add_type_sub);


       val=(Button) root.findViewById(R.id.add_btn);

        user= sareprefrencelogin.getInstance(getContext()).getuser();
        String s=user.getFname()+" "+user.getLname();
        name.setText(s);
        add.setText(user.getAddress());
        phn.setText(user.getMobileno());
        email.setText(user.getEmail());
        pincode.setText(user.getPincode());





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








        ty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String type = adapterView.getItemAtPosition(i).toString();

                setsubtype(type);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




       val.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
val.setVisibility(View.GONE);
                pr.setVisibility(View.VISIBLE);

               String fname=name.getText().toString();
               String adr=add.getText().toString();
               String mobno=phn.getText().toString();
               String mail=email.getText().toString();
               String pin=pincode.getText().toString();
               String discc=disc.getText().toString();


               String state=st.getSelectedItem().toString();
               String dis=n.getSelectedItem().toString();
               String htype=ty.getSelectedItem().toString();
               String need=ti.getSelectedItem().toString();
               String subq=sub.getSelectedItem().toString();


               String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
               String MobilePattern = "[0-9]{10}";


               if (fname.isEmpty()){
                   name.setError("Enter Fullname");

               }
               if (adr.isEmpty()){
                   add.setError("Enter Address");

               }
               if (pin.isEmpty()){
                   pincode.setError("Enter pincode");

               }

               if (mobno.isEmpty() || !mobno.matches(MobilePattern)){

                   phn.setError("Enter Mobile Number");

               }
              

               String dat =new SimpleDateFormat("dd-MM-yyyy", Locale.US).format(new Date());
String h="Request Under Processing";
               Api api= ApiClient.getClient().create(Api.class);

               Call<CommanResponse> call =api.addhelp("helpadd",fname,mobno,mail,adr,pin,state,dis,htype,need,
                       dat,"0",h,h,discc,user.getId()+"",subq);
               call.enqueue(new Callback<CommanResponse>() {
                   @Override
                   public void onResponse(Call<CommanResponse> call, Response<CommanResponse> response) {
                       if (response.body().getSuccess()==200) {

val.setVisibility(View.VISIBLE);
pr.setVisibility(View.GONE);
                           Toast.makeText(getContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();


                       }
                       else
                       {
                           Toast.makeText(getContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                       }
                   }

                   @Override
                   public void onFailure(Call<CommanResponse> call, Throwable t) {
                       Toast.makeText(getContext(), t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
                   }
               });
           }

       });




        return root;
    }


    public void setDistrict(String str)
    {
        switch(str) {
            case "Andhra Pradesh" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , AndhraPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Arunachal Pradesh" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , ArunachalPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Assam" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Assam);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Bihar" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Bihar);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Chhattisgarh" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Chhattisgarh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Dadra and Nagar Haveli" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , DadraandNagarHaveli);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Daman and Diu" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , DamanandDiu);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Delhi" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Delhi);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Goa" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Goa);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Gujarat" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Gujarat);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Haryana" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Haryana);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Himachal Pradesh" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , HimachalPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Jammu and Kashmir" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , JammuandKashmir);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Jharkhand" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Jharkhand);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Karnataka" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Karnataka);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Kerala" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Kerala);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Madhya Pradesh" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , MadhyaPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Maharashtra" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Maharashtra);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Manipur" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Manipur);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Meghalaya" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Meghalaya);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Mizoram" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Mizoram);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Nagaland" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Nagaland);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Orissa" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Orissa);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Pondicherry" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Pondicherry);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Punjab" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Punjab);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Rajasthan" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Rajasthan);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Sikkim" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Sikkim);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Tamil Nadu" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , TamilNadu);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Tripura" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Tripura);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Uttar Pradesh" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , UttarPradesh);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "Uttarakhand" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , Uttarakhand);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional
            case "West Bengal" :
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item , WestBengal);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                n.setAdapter(adapter);
                break; // optional



            default :
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
        }


    }





    public void setsubtype(String str) {
        switch (str) {
            case "Medical":
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Medical);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sub.setAdapter(adapter);
                break; // optional
            case "Travel":
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Travel);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sub.setAdapter(adapter);
                break; // optional
            case "Accomodation":
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Accomodation);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sub.setAdapter(adapter);
                break; // optional
            case "Dharmik":
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Dharmic);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sub.setAdapter(adapter);
                break; // optional
            case "Legal":
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Legal);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sub.setAdapter(adapter);
                break; // optional
            case "Government":
                adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Government);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sub.setAdapter(adapter);
                break; // optional
        }
    }
}