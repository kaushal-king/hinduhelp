package com.example.hinduhelp.apiinterface;



import com.example.hinduhelp.apiinterface.responce.helpresponce;
import com.example.hinduhelp.apiinterface.responce.loginresponce;
import com.example.hinduhelp.apiinterface.responce.prof_responce;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {

    @FormUrlEncoded
    @POST("RegistrationControllerJson.php")
    Call<CommanResponse> createUser(

            @Field("loginRegistration") String loginRegistration,
            @Field("fname") String fname,
            @Field("lname") String lname,
            @Field("mobileno") String mobileno,
            @Field("email") String email,
            @Field("address") String address,
            @Field("pincode") String pincode,
            @Field("state") String state,
            @Field("dist") String dist


    );

    @FormUrlEncoded
    @POST("help.php")
    Call<helpresponce> hcmp(

            @Field("helpdetail") String helpdetail,
            @Field("uid") String uid
    );

    @FormUrlEncoded
    @POST("help.php")
    Call<helpresponce> hpnd(

            @Field("helpdetailpnd") String helpdetailpnd,
            @Field("uid") String uid
    );


    @FormUrlEncoded
    @POST("loginapi.php")
    Call<loginresponce> login(

            @Field("loginuser") String loginuser,
            @Field("mobileno") String mobileno
    );

    @FormUrlEncoded
    @POST("help.php")
    Call<CommanResponse> addhelp(

            @Field("helpadd") String helpadd,
            @Field("fullname") String fullname,
            @Field("mobileno") String mobileno,
            @Field("email") String email,
            @Field("address") String address,
            @Field("pincode") String pincode,
            @Field("state") String state,
            @Field("dist") String dist,
            @Field("typehelp") String typehelp,
            @Field("helpmode") String helpmode,
            @Field("datehelp") String datehelp,
            @Field("status") String status,
            @Field("helper") String helper,
            @Field("hmob") String hmob,
            @Field("hdisc") String hdisc,
            @Field("uid") String uid,
            @Field("subhelp") String subhelp


    );



    @FormUrlEncoded
    @POST("prof.php")
    Call<loginresponce> personalupdate(

            @Field("profilepersonal") String profilepersonal,
            @Field("fname") String fname,
            @Field("lname") String lname,
            @Field("mobno") String mobno,
            @Field("email") String email,
            @Field("uid") String uid
    );








//    @FormUrlEncoded
//    @POST("noticeapi.php")
//    Call<notice_responce> noticedetail(
//            @Field("noticedetail") String noticedetail
//    );
//
//
//    @FormUrlEncoded
//    @POST("eventapi.php")
//    Call<event_responce> eventdetail(
//            @Field("eventdetail") String eventdetail
//    );
//
//
//    @FormUrlEncoded
//    @POST("resourceapi.php")
//    Call<resource_responce> resourcedetail(
//            @Field("resourcedetail") String resourcedetail
//    );
//
//    @FormUrlEncoded
//    @POST("GatekeeperVisiEntry.php")
//    Call<visidetail_responce> visidetail(
//            @Field("gatekvisidetail") String gatekvisidetail
//
//    );
//
//
//
//    @FormUrlEncoded
//    @POST("membersapi.php")
//    Call<member_responce> membersdetail(
//            @Field("membersdetail") String membersdetail,
//            @Field("blockno") String blockno
//    );
//
//
//    @FormUrlEncoded
//    @POST("forgrtpass.php")
//    Call<CommanResponse> changepass(
//            @Field("changepass") String changepass,
//            @Field("mobno") String mobno,
//            @Field("password") String password
//
//    );
//
//
//    @FormUrlEncoded
//    @POST("forgrtpass.php")
//    Call<CommanResponse> mobnoex(
//            @Field("passmobnoex") String passmobnoex,
//            @Field("mobno") String mobno
//
//    );
//
//
//    @FormUrlEncoded
//    @POST("resourseregister.php")
//    Call<res_book_responce> booklist(
//            @Field("resourcedetails") String resourcedetails,
//            @Field("res_name") String res_name
//
//    );
//
//
//    @FormUrlEncoded
//    @POST("resourseregister.php")
//    Call<CommanResponse> book_res(
//            @Field("resourceregi") String resourceregi,
//            @Field("res_name") String res_name,
//            @Field("date") String date,
//            @Field("time") String time,
//            @Field("bookname") String book_name
//
//    );
//
//    @FormUrlEncoded
//    @POST("resourseregister.php")
//    Call<CommanResponse> book_check(
//            @Field("resourcecheck") String resourcecheck,
//            @Field("res_name") String res_name,
//            @Field("date") String date
//    );
//
//
//    @FormUrlEncoded
//    @POST("generateChecksum.php")
//    Call<Checksum> getChecksum(
//            @Field("MID") String mId,
//            @Field("ORDER_ID") String orderId,
//            @Field("CUST_ID") String custId,
//            @Field("CHANNEL_ID") String channelId,
//            @Field("TXN_AMOUNT") String txnAmount,
//            @Field("WEBSITE") String website,
//            @Field("CALLBACK_URL") String callbackUrl,
//            @Field("INDUSTRY_TYPE_ID") String industryTypeId
//    );
//
//    @FormUrlEncoded
//    @POST("accountbill.php")
//    Call<bill_responce> accbilldetails(
//            @Field("billdetails") String billdetails
//
//    );
//
//
//    @FormUrlEncoded
//    @POST("accountbill.php")
//    Call<bill_child_responce> billchild(
//            @Field("billspntdetails") String billspntdetails,
//            @Field("bill_id") String bill_id
//
//
//    );
//    @FormUrlEncoded
//    @POST("accountbill.php")
//    Call<spnt_total_responce> spnttotal(
//            @Field("spenttotal") String spenttotal,
//            @Field("bill_id") String bill_id
//
//
//    );
//
//    @Multipart
//    @POST("complainapi.php")
//    Call<CommanResponse> complainentry(
//            @Part("complainentry") RequestBody complainentry,
//            @Part("ctitle") RequestBody bill_id,
//            @Part("discription") RequestBody discription,
//            @Part MultipartBody.Part document_file,
//            @Part("flatno") RequestBody flatno,
//            @Part("status") RequestBody status
//    );
//
//    @FormUrlEncoded
//    @POST("complainapi.php")
//    Call<cmp_responce> cmp_user_details(
//            @Field("complainuserdetail") String complainuserdetail,
//            @Field("flatno") String flatno
//    );
//
//    @FormUrlEncoded
//    @POST("documentapi.php")
//    Call<document_responce> documentdetailsl(
//            @Field("documentdetail") String documentdetail
//    );
//
//
//    @FormUrlEncoded
//    @POST("maintence.php")
//    Call<mainte_responce> main_details(
//            @Field("mainjdetail") String mainjdetail,
//            @Field("flatno") String flatno
//    );
//
//    @FormUrlEncoded
//    @POST("maintence.php")
//    Call<CommanResponse> mainpay_entry(
//            @Field("mainpayentry") String mainpayentry,
//            @Field("mainteid") String mainteid,
//            @Field("billname") String billname,
//            @Field("flatno") String flatno
//    );
//
//    @FormUrlEncoded
//    @POST("fcm_insert.php")
//    Call<CommanResponse> getFcm(
//            @Field("fcm_token") String fcm_token,
//            @Field("table") String table
//    );
//
//    @FormUrlEncoded
//    @POST("profileapi.php")
//    Call<loginresponce> personalupdate(
//
//            @Field("profilepersonal") String profilepersonal,
//            @Field("fname") String fname,
//            @Field("lname") String lname,
//            @Field("mobno") String mobno,
//            @Field("email") String email,
//            @Field("houseno") String houseno
//    );
//
//    @FormUrlEncoded
//    @POST("profileapi.php")
//    Call<prof_responce> profget(
//            @Field("profileprofget") String profileprofget,
//            @Field("houseno") String houseno
//    );
//
//    @FormUrlEncoded
//    @POST("profileapi.php")
//    Call<CommanResponse> profupdate(
//            @Field("profileprofupdate") String profileprofupdate,
//            @Field("emptype") String emptype,
//            @Field("proftype") String proftype,
//            @Field("cmpname") String cmpname,
//            @Field("desi") String desi,
//            @Field("conno") String conno,
//            @Field("houseno") String houseno
//    );
//
//    @FormUrlEncoded
//    @POST("profileapi.php")
//    Call<prof_responce> profpass(
//            @Field("profilepassupdate") String profilepassupdate,
//            @Field("mobno") String mobno,
//            @Field("oldpassword") String oldpassword,
//            @Field("newpassword") String newpassword
//    );

}
