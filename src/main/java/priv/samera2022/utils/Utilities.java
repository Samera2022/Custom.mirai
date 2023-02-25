package priv.samera2022.utils;

import priv.samera2022.utils.mixture.CheckNumberMixture;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Utilities {
    public static String CUSTOM_FOLDER_PATH = "";
    public static String PLAYER_DATA_PATH = "";

    /*
    方法已经被弃用！Utilities.getSubString(String target, String content)已经被content.split(target,2)[1]替代！
     */
    @Deprecated
    public static String getSubString(String target, String content) {
        return content.substring(content.indexOf(target) + target.length());
    }

    public static void switchMode(int targetCode) {
        if (targetCode == 0) {
            targetCode = 1;
        } else if (targetCode == 1) {
            targetCode = 0;
        }
    }

    public static CheckNumberMixture checkMessage(String content) {
        int code = -1;
        StringBuilder errorString = new StringBuilder();
        if (content.equals("")) {
            code = CheckNumberMixture.CODE_IS_NULL;
        } else {
            char[] arr = content.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char element = arr[i];
                if (!Character.isDigit(element)) {
                    errorString.append(" ").append(element);
                } else if (i == arr.length - 1) {
                    break;
                }
            }
            if (errorString.length() == 0) {
                code = CheckNumberMixture.CODE_IS_NUMBER;
            } else {
                code = CheckNumberMixture.CODE_CONTAINS_NON_NUMBER;
            }
        }
        return new CheckNumberMixture(code, errorString.toString());
    }

    public static String getCustomFolderPath() {
        CUSTOM_FOLDER_PATH = getMCLPath() + "config/priv.samera2022/";
        PLAYER_DATA_PATH = CUSTOM_FOLDER_PATH + "playerdata/";
        return CUSTOM_FOLDER_PATH;
    }

    public static String getMCLPath() {
        Utilities utils = new Utilities();
        String path = utils._getMCLPath();
        path = path.substring(0, path.length() - path.split("plugins", 2)[1].length() - "plugins".length());
        return path;
    }

    private String _getMCLPath() {
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        if (System.getProperty("os.name").contains("dows")) {
            path = path.substring(1, path.length());
        }
        if (path.contains("jar")) {
            path = path.substring(0, path.lastIndexOf("."));
            return path.substring(0, path.lastIndexOf("/"));
        }
        return path.replace("target/classes/", "");
    }

    public static String readFile(File folder, String fileName) {
        // 以utf-8编码读取文件：
        FileInputStream fis = null;
        InputStreamReader isr = null;
        String fileContent = "";

        try {
            fis = new FileInputStream(folder + "/" + fileName);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                fileContent += line;
                fileContent += "\r\n"; // 补上换行符
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileContent;
    }

    public static void appendContent(File folder, String fileName, String content) throws IOException {
        String output = Utilities.readFile(folder, fileName) + "\n" + content;
        File f = new File(folder.getPath() + "/" + fileName);//指定文件
        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
        bw.write(output);//使用bw写入一行文字，为字符串形式String
        bw.newLine();//换行
        bw.close();//关闭并保存
    }

    public static void write(File folder, String fileName, String content) throws IOException {
        File f = new File(folder.getPath() + "/" + fileName);//指定文件
        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
        bw.write(content);//使用bw写入一行文字，为字符串形式String
        bw.newLine();//换行
        bw.close();//关闭并保存
    }

    public static String GB2312ToUTF8(String str) {
        String urlEncode = "";
        try {
            urlEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlEncode;
    }

    public static String UTF8ToGB2312(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+':
                    sb.append(' ');
                    break;
                case '%':
                    try {
                        sb.append((char) Integer.parseInt(
                                str.substring(i + 1, i + 3), 16));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                    i += 2;
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        String result = sb.toString();
        String res = null;
        try {
            byte[] inputBytes = result.getBytes("8859_1");
            res = new String(inputBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static HashMap<String, Long> findDiff(String startdate, String enddate) throws ParseException {

        // SimpleDateFormat is used for converting the
        // string format into the date instance
        SimpleDateFormat sdf1
                = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");

        // parse method is used for parsing
        // the text from a string to
        // produce the date
        Date d0 = sdf1.parse(startdate);
        Date d1 = sdf1.parse(enddate);

        // Calculating the time difference
        // in milliseconds
        long Time_difference
                = d0.getTime() - d1.getTime();

        // Calculating the time difference in
        // terms of seconds, minutes, hours, years,
        // and days
        long Seconds_difference
                = (Time_difference
                / 1000)
                % 60;

        long Minutes_difference
                = (Time_difference
                / (1000 * 60))
                % 60;

        long Hours_difference
                = (Time_difference
                / (1000 * 60 * 60))
                % 24;

        long Years_difference
                = (Time_difference
                / (1000l * 60 * 60 * 24 * 365));

        long Days_difference
                = (Time_difference
                / (1000 * 60 * 60 * 24))
                % 365;

        // Printing the difference between the dates in terms of
        // years, in days, in hours, in
        // seconds, as well as in minutes

        System.out.print(
                "Difference "
                        + "between the two dates is: ");

        System.out.println(
                Years_difference
                        + " years, "
                        + Days_difference
                        + " days, "
                        + Hours_difference
                        + " hours, "
                        + Minutes_difference
                        + " minutes, "
                        + Seconds_difference
                        + " seconds");
        HashMap<String,Long> hashMap = new HashMap<>();
        hashMap.put("year",Years_difference);
        hashMap.put("day",Days_difference);
        hashMap.put("hour",Hours_difference);
        hashMap.put("minute",Minutes_difference);
        hashMap.put("second",Seconds_difference);
        return hashMap;
    }

}
