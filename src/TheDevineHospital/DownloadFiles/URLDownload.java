package TheDevineHospital.DownloadFiles;


import TheDevineHospital.InputAndOutputText.HelpInput;
import TheDevineHospital.RegularExpressionsAndAnonumusClasses.FixLinkOnFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLDownload {
    public static final String LINK = "http://kiparo.ru/t/hospital.xml";
    public static final String LINK1 = "http://kiparo.ru/t/hospital.json";
    private static String hospitalXML = "hospital.xml";
    private static String hospitalJSON = "hospital.json";
    private static URLDownload urlDownload = new URLDownload();
    /*
     * @return Принимает ссылку на документ json\xml, проверяет её на соответствие шаблону регулярных выражений и анонимного класса и загружает её на локальный диск.
     * */

    public void downloadXml(String UrlAdress) {
        Pattern patternXML = Pattern.compile("^http://((.)+)\\.(xml)$");
        Matcher matcher = patternXML.matcher(UrlAdress);
        if (matcher.matches()) {
            System.out.println("Корректный формат ссылки xml");
            try {
                URL url = new URL(UrlAdress);
                FileUtils.copyURLToFile(url, new File(hospitalXML));
                System.out.println("xml-загружен.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Некорректный формат ссылки на файл");
            System.out.println("Попробуйте ввести ссылку вручную:");//************** Убрать или переделать? а может оставить************
            fixLinkOnFile(new FixLinkOnFile() {//своего рода зацикливание до тех пор, пока не будет передана корректная ссылка
                @Override
                public void fix() {
                    String gogoNewURL = HelpInput.inputString();
                    downloadXml(gogoNewURL);
                }
            });
        }


    }

    public void downloadJson(String UrlAdress) {
        Pattern patternJSON = Pattern.compile("^http://((.)+)\\.(json)$");
        Matcher matcher = patternJSON.matcher(UrlAdress);
        if (matcher.matches()) {
            System.out.println("Корректный формат ссылки json");
            try {
                URL url = new URL(UrlAdress);
                FileUtils.copyURLToFile(url, new File(hospitalJSON));
                System.out.println("json-загружен.");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Некорректный формат ссылки на файл");
            System.out.println("Попробуйте ввести ссылку вручную:");//************** Убрать или переделать? а может оставить************
            fixLinkOnFile(new FixLinkOnFile() {//своего рода зацикливание до тех пор, пока не будет передана корректная ссылка)))
                @Override
                public void fix() {
                    String gogoNewURL = HelpInput.inputString();
                    downloadXml(gogoNewURL);
                }
            });
        }
    }


    public static String getHospitalXML() {
        return hospitalXML;
    }

    public static void setHospitalXML(String hospitalXML) {
        URLDownload.hospitalXML = hospitalXML;
    }

    public static String getHospitalJSON() {
        return hospitalJSON;
    }

    public static void setHospitalJSON(String hospitalJSON) {
        URLDownload.hospitalJSON = hospitalJSON;
    }

    public static URLDownload getUrlDownload() {
        return urlDownload;
    }

    public static void setUrlDownload(URLDownload urlDownload) {
        URLDownload.urlDownload = urlDownload;
    }

    private static void fixLinkOnFile(FixLinkOnFile fixLinkOnFile) {
        fixLinkOnFile.fix();
    }




}
