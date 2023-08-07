package utlis;

import org.json.JSONObject;

public class APIPayloadConstants {


    //    it is a simple fucntion that returns u a playload in form string
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Borea\",\n" +
                "  \"emp_lastname\": \"Groza\",\n" +
                "  \"emp_middle_name\": \"MS\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1951-07-28\",\n" +
                "  \"emp_status\": \"Employed\",\n" +
                "  \"emp_job_title\": \"Plach Plach,Tansuy Tansuy\"\n" +
                "}";
        return createEmployeePayload;
    }


    //    create the paylaod in json format and return a string of payload
    public static String createEmployeeJsonPayload(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Borea");
        obj.put("emp_lastname","Groza");
        obj.put("emp_middle_name","MS");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2000-07-21");
        obj.put("emp_status","Employed");
        obj.put("emp_job_title","Plach Plach,Tansuy Tansuy");
        return obj.toString();
    }

    public static String createEmployeeJsonPayloadDynamic
            (String fn, String ln, String mn, String gender,
             String dob, String status, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", fn);
        obj.put("emp_lastname", ln);
        obj.put("emp_middle_name", mn);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }



    public static String updateEmployeePartiallyPayload(String empID,String key,String value){
        JSONObject obj = new JSONObject();
        obj.put("employee_id",empID);
        obj.put(key, value);
        return obj.toString();
    }


}