package TheDevineHospital.ParseFile.HospitalParser;

import TheDevineHospital.EntityClasses.Hospital;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/*
 *  Парсинг для титанических json-файлов
 * */
public class Jackson extends Parse {

    @Override
    public Hospital parse(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        Hospital hospital = null;
        try {
            hospital = objectMapper.readValue(new File(fileName), Hospital.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(hospital.toString());
        return hospital;
    }
}